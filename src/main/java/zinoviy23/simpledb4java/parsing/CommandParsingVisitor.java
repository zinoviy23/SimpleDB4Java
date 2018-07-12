package zinoviy23.simpledb4java.parsing;

import zinoviy23.simpledb4java.antlr.SimpleDBGrammarBaseVisitor;
import zinoviy23.simpledb4java.antlr.SimpleDBGrammarListener;
import zinoviy23.simpledb4java.antlr.SimpleDBGrammarParser;
import zinoviy23.simpledb4java.codegeneration.Utils;

import java.util.Objects;
import java.util.stream.Collectors;

public class CommandParsingVisitor extends SimpleDBGrammarBaseVisitor<String> {

    private final String currentClass;

    private final String currentMethodType;

    public CommandParsingVisitor(String currentClass, String currentMethodType) {
        this.currentClass = currentClass;
        this.currentMethodType = currentMethodType;
    }

    @Override
    public String visitSimpleCommand(SimpleDBGrammarParser.SimpleCommandContext ctx) {
        if (ctx.RETURNKW() != null) {
            TypeCheckingTreeResult result = ctx.expression().accept(new ExpressionTypeCheckingVisitor(currentClass));

            TypeCheckingTreeResult.TypeCompareResult compareResult = TypeCheckingTreeResult.compareTypes(currentMethodType, result.type);

            if (compareResult == TypeCheckingTreeResult.TypeCompareResult.ERROR ||
                    compareResult == TypeCheckingTreeResult.TypeCompareResult.LESS)
                throw new RuntimeException(String.format("Can't cast %s to %s. In line %s", result.type, currentMethodType,
                        ctx.getStart().getLine()));

            return String.format("return %s;", result.value);
        }

        if (ctx.typeId() != null) {
            TypeCheckingTreeResult result = ctx.expression().accept(new ExpressionTypeCheckingVisitor(currentClass));

            TypeCheckingTreeResult.TypeCompareResult compareResult =
                    TypeCheckingTreeResult.compareTypes(ctx.typeId().getText(), result.type);

            if (compareResult == TypeCheckingTreeResult.TypeCompareResult.LESS ||
                    compareResult == TypeCheckingTreeResult.TypeCompareResult.ERROR)
                throw new RuntimeException(String.format("Can't cast %s to %s. In line %s", result.type, ctx.typeId().getText(),
                        ctx.getStart().getLine()));

            SimpleDBGrammarListenerImpl.addVariable(ctx.ID().getText(), ctx.typeId().getText());

            if (ctx.typeId().LSQBR() == null)
                return String.format("%s %s = %s;", ctx.typeId().getText(), ctx.ID().getText(), result.value);
            else
                return String.format("List<%s> %s = %s;", Utils.getWrappingTypeName(ctx.typeId().ID().getText()),
                    ctx.ID().getText(), result.value);
        }

        if (ctx.typeId() == null && (ctx.ASSIGN() != null || ctx.PLUSASSIGN() != null || ctx.MINUSASSIGM() != null)) {
            String name = ctx.ID().getText();
            String type = SimpleDBGrammarListenerImpl.findVariable(name);

            if (type == null) {
                if (!SimpleDBGrammarParser.fieldsSymbolTable.get(currentClass).containsKey(name)) {
                    throw new RuntimeException(String.format("Unknown %s in line %s", name, ctx.getStart().getLine()));
                }

                type = SimpleDBGrammarParser.fieldsSymbolTable.get(currentClass).get(name);
            }

            TypeCheckingTreeResult result = ctx.expression().accept(new ExpressionTypeCheckingVisitor(currentClass));
            TypeCheckingTreeResult.TypeCompareResult compareResult = TypeCheckingTreeResult.compareTypes(type, result.type);

            if (ctx.ASSIGN() != null) {
                if (compareResult == TypeCheckingTreeResult.TypeCompareResult.LESS ||
                        compareResult == TypeCheckingTreeResult.TypeCompareResult.ERROR)
                    throw new RuntimeException(String.format("Can't cast %s to %s in line %s", result.type, type,
                            ctx.getStart().getLine()));

                return String.format("%s = %s;", name, result.value);
            }

            if (!type.equals("int") && !type.equals("long") && !type.equals("float"))
                throw new RuntimeException(String.format("+=/-= allows only num type, but given %s. in line %s", type,
                        ctx.getStart().getLine()));

            if (compareResult == TypeCheckingTreeResult.TypeCompareResult.LESS ||
                    compareResult == TypeCheckingTreeResult.TypeCompareResult.ERROR)
                throw new RuntimeException(String.format("Can't cast %s to %s. In line %s", result.type, type,
                        ctx.getStart().getLine()));

            if (ctx.MINUSASSIGM() != null) {
                return String.format("%s -= %s;", name, result.value);
            }

            if (ctx.PLUSASSIGN() != null) {
                return String.format("%s += %s;", name, result.value);
            }
        }

        if (ctx.dottedId() != null) {
            TypeCheckingTreeResult result =
                    ctx.dottedId().accept(new DottedIdVisitor(currentClass, true, DottedIdVisitor.StaticStatus.STATIC));
            if (!result.value.endsWith(")"))
                throw new RuntimeException(String.format("Must be method call! But %s. In line %s", ctx.dottedId().getText(),
                        ctx.getStart().getLine()));

            return result.value + ";";
        }

        return null;
    }

    @Override
    public String visitForCycle(SimpleDBGrammarParser.ForCycleContext ctx) {
        TypeCheckingTreeResult result = ctx.expression().accept(new ExpressionTypeCheckingVisitor(currentClass));

        if (!result.type.endsWith("[]"))
            throw new RuntimeException("For needs array, but given " + result.type + "In line " + ctx.getStart().getLine());

        String type = result.type.replace("[]", "");

        TypeCheckingTreeResult.TypeCompareResult compareResult = TypeCheckingTreeResult.compareTypes(type, ctx.typeId().getText());
        if (compareResult == TypeCheckingTreeResult.TypeCompareResult.LESS ||
                compareResult == TypeCheckingTreeResult.TypeCompareResult.ERROR)
            throw new RuntimeException(String.format("Can't cast %s to %s. In line %s", result.type, ctx.typeId().getText(),
                    ctx.getStart().getLine()));

        SimpleDBGrammarListenerImpl.addBlock();
        SimpleDBGrammarListenerImpl.addVariable(ctx.ID().getText(), ctx.typeId().getText());
        String blockCode = ctx.block().accept(this);
        SimpleDBGrammarListenerImpl.popVariables();
        return String.format("for (%s %s : %s)\n%s\n", ctx.typeId().getText(), ctx.ID().getText(), result.value, blockCode);
    }

    @Override
    public String visitIfStatement(SimpleDBGrammarParser.IfStatementContext ctx) {
        TypeCheckingTreeResult result = ctx.expression().accept(new ExpressionTypeCheckingVisitor(currentClass));

        if (!result.type.equals("boolean")) {
            throw new RuntimeException("if statement must be boolean. In line " + ctx.getStart().getLine());
        }

        String blockCode = ctx.block().accept(this);
        String elseBlock = "";
        if (ctx.elseBlock() != null)
            elseBlock = ctx.elseBlock().accept(this);

        return String.format("if (%s)\n%s\n%s", result.value, blockCode, elseBlock);
    }

    @Override
    public String visitElseBlock(SimpleDBGrammarParser.ElseBlockContext ctx) {
        String blockCode = ctx.block().accept(this);
        return String.format("else\n%s\n", blockCode);
    }

    @Override
    public String visitCommand(SimpleDBGrammarParser.CommandContext ctx) {
        return (ctx.simpleCommand() != null) ? ctx.simpleCommand().accept(this) : ctx.blockCommand().accept(this);
    }

    @Override
    public String visitBlockCommand(SimpleDBGrammarParser.BlockCommandContext ctx) {
        return (ctx.ifStatement() != null) ? ctx.ifStatement().accept(this) : ctx.forCycle().accept(this);
    }

    @Override
    public String visitBlock(SimpleDBGrammarParser.BlockContext ctx) {
        String commands = String.join("\n",
                ctx.command().stream().map(commandContext -> commandContext.accept(this)).collect(Collectors.toList()));
        return String.format("{%s}", commands);
    }
}

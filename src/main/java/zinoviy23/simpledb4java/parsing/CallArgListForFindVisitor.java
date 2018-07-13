package zinoviy23.simpledb4java.parsing;

import org.jetbrains.annotations.Nullable;
import zinoviy23.simpledb4java.antlr.SimpleDBGrammarBaseVisitor;
import zinoviy23.simpledb4java.antlr.SimpleDBGrammarParser;

import java.util.LinkedList;
import java.util.List;

public class CallArgListForFindVisitor extends SimpleDBGrammarBaseVisitor<TypeCheckingTreeResult> {
    private final String className;

    public CallArgListForFindVisitor(String className) {
        this.className = className;
    }

    private final List<String> variables = new LinkedList<>();

    @Override
    public TypeCheckingTreeResult visitCallArgList(SimpleDBGrammarParser.CallArgListContext ctx) {
        if (ctx.expression().size() != 1)
            throw new RuntimeException(String.format("find methods allows only 1 argument. In class %s. In line %s", className,
                    ctx.getStart().getLine()));

        TypeCheckingTreeResult result = ctx.expression(0).accept(this);
        if (!result.type.equals("boolean"))
            throw new RuntimeException(String.format("Argument must be boolean. In expression %s. In line %s", ctx.getText(),
                    ctx.getStart().getLine()));

        return new TypeCheckingTreeResult("String", String.format("String.format(\"%s\" %s)", result.value,
                (variables.size() != 0) ? "," + String.join(",", variables) : ""));
    }

    @Override
    public TypeCheckingTreeResult visitExpression(SimpleDBGrammarParser.ExpressionContext ctx) {
        if (ctx.OR() != null) {
            TypeCheckingTreeResult result1 = ctx.expression(0).accept(this);
            TypeCheckingTreeResult result2 = ctx.expression(1).accept(this);

            if (!result1.type.equals("boolean") || !result2.type.equals("boolean")) {
                throw new RuntimeException(String.format("Operator || allows only boolean. In expression %s. In line %s",
                        ctx.getText(), ctx.getStart().getLine()));
            }

            return new TypeCheckingTreeResult("boolean", String.format("(%s) or (%s)", result1.value, result2.value));
        }

        if (ctx.AND() != null) {
            TypeCheckingTreeResult result1 = ctx.expression(0).accept(this);
            TypeCheckingTreeResult result2 = ctx.expression(1).accept(this);

            if (!result1.type.equals("boolean") || !result2.type.equals("boolean")) {
                throw new RuntimeException(String.format("Operator && allows only boolean. In expression %s. In line %s", ctx.getText(),
                        ctx.getStart().getLine()));
            }

            return new TypeCheckingTreeResult("boolean", String.format("(%s) and (%s)", result1.value, result2.value));
        }

        if (ctx.LE() != null) {
            TypeCheckingTreeResult result1 = ctx.expression(0).accept(this);
            TypeCheckingTreeResult result2 = ctx.expression(1).accept(this);

            return new TypeCheckingTreeResult("boolean", String.format("%s <= %s", result1.value, result2.value));
        }

        if (ctx.GE() != null) {
            TypeCheckingTreeResult result1 = ctx.expression(0).accept(this);
            TypeCheckingTreeResult result2 = ctx.expression(1).accept(this);

            return new TypeCheckingTreeResult("boolean", String.format("%s >= %s", result1.value, result2.value));
        }

        if (ctx.LS() != null) {
            TypeCheckingTreeResult result1 = ctx.expression(0).accept(this);
            TypeCheckingTreeResult result2 = ctx.expression(1).accept(this);

            return new TypeCheckingTreeResult("boolean", String.format("%s < %s", result1.value, result2.value));
        }

        if (ctx.GR() != null) {
            TypeCheckingTreeResult result1 = ctx.expression(0).accept(this);
            TypeCheckingTreeResult result2 = ctx.expression(1).accept(this);

            return new TypeCheckingTreeResult("boolean", String.format("%s > %s", result1.value, result2.value));
        }

        if (ctx.EQ() != null) {
            TypeCheckingTreeResult result1 = ctx.expression(0).accept(this);
            TypeCheckingTreeResult result2 = ctx.expression(1).accept(this);

            return new TypeCheckingTreeResult("boolean", String.format("%s = %s", result1.value, result2.value));
        }

        if (ctx.NOTEQ() != null) {
            TypeCheckingTreeResult result1 = ctx.expression(0).accept(this);
            TypeCheckingTreeResult result2 = ctx.expression(1).accept(this);

            return new TypeCheckingTreeResult("boolean", String.format("%s != %s", result1.value, result2.value));
        }

        if (ctx.constant() != null) {
            TypeCheckingTreeResult result = ctx.constant().accept(new ExpressionTypeCheckingVisitor(className));
            if (result.type.equals("String")) {
                return new TypeCheckingTreeResult(result.type,"'" + result.value.substring(1,
                        result.value.length() - 1) + "'");
            }
            return result;
        }

        if (ctx.dottedId() != null) {
            return ctx.dottedId().accept(this);
        }

        throw new RuntimeException(String.format("This operation is not expected. In expression %s. In line %s", ctx.getText(),
                ctx.getStart().getLine()));
    }

    @Override
    public TypeCheckingTreeResult visitDottedId(SimpleDBGrammarParser.DottedIdContext ctx) {
        if (ctx.LPAR() != null && ctx.DOT() != null)
            throw new RuntimeException(String.format("Allowed only fields name and variables names. In expression %s. In line %s",
                    ctx.getText(), ctx.getStart().getLine()));

        String name = ctx.ID().getText();
        String type = SimpleDBGrammarListenerImpl.findVariable(name);

        if (type != null) {
            switch (type) {
                case "int":
                case "long":
                case "String":
                case "float":
                    variables.add(name);
                    break;
                default:
                    variables.add(String.format("%s.getId()", name));
                    break;
            }
            return new TypeCheckingTreeResult(type, "'%s'");
        }

        if (!SimpleDBGrammarParser.fieldsSymbolTable.get(className).containsKey(name))
            throw new RuntimeException(String.format("Unknown indetificator (%s). In expression %s. In line %s", name, ctx.getText(),
                    ctx.getStart().getLine()));

        type = SimpleDBGrammarParser.fieldsSymbolTable.get(className).get(name);
        return new TypeCheckingTreeResult(type, name);
    }

}

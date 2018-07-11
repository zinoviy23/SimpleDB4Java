package zinoviy23.simpledb4java.parsing;

import org.jetbrains.annotations.Nullable;
import zinoviy23.simpledb4java.antlr.SimpleDBGrammarBaseVisitor;
import zinoviy23.simpledb4java.antlr.SimpleDBGrammarParser;

import java.util.List;
import java.util.stream.Collectors;

public class ExpressionTypeCheckingVisitor extends SimpleDBGrammarBaseVisitor<TypeCheckingTreeResult> {
    private final String currentClass;

    public ExpressionTypeCheckingVisitor(String currentClass) {
        this.currentClass = currentClass;
    }


    @Override
    public TypeCheckingTreeResult visitExpression(SimpleDBGrammarParser.ExpressionContext ctx) {
        System.out.println(ctx.getText() + " in expression");
        if (ctx.constant() != null)
            return ctx.constant().accept(this);

        if (ctx.unaryExpr() != null) {
            TypeCheckingTreeResult result = ctx.unaryExpr().expression().accept(this);
            if (result == null)
                return null;
            if (!result.type.equals("int") && !result.type.equals("float") && !result.type.equals("long")) {
                throw new RuntimeException(String.format("operator %s is incompatible with type %s", ctx.unaryExpr().unaryOp().getText(),
                        result.type));
            }
            return new TypeCheckingTreeResult(result.type,ctx.unaryExpr().unaryOp().getText() + result.value);
        }

        if (ctx.LPAR() != null) {
            TypeCheckingTreeResult result = ctx.expression(0).accept(this);
            return new TypeCheckingTreeResult(result.type, "(" + result.value + ")");
        }

        if (ctx.array() != null) {
            TypeCheckingTreeResult result = ctx.array().arrIndexList().accept(this);
            return new TypeCheckingTreeResult(result.type + "[]", "java.util.Arrays.asList(" + result.value + ")");
        }

        if (ctx.dottedId() != null) {
            return ctx.dottedId().accept(new DottedIdVisitor(currentClass, true, DottedIdVisitor.StaticStatus.CAN_BE_STATIC));
        }

        return null;
    }

    @Override
    public TypeCheckingTreeResult visitArrIndexList(SimpleDBGrammarParser.ArrIndexListContext ctx) {
        StringBuilder listSb = new StringBuilder("java.util.Arrays.asList(");

        List<TypeCheckingTreeResult> elements = ctx.expression().stream()
                .map(expressionContext -> expressionContext.accept(this)).collect(Collectors.toList());
        String type = null;
        for (TypeCheckingTreeResult result : elements) {
            if (type == null)
                type = result.type;

            TypeCheckingTreeResult.TypeCompareResult comp = TypeCheckingTreeResult.compareTypes(type, result.type);
            switch (comp) {
                case LESS:
                    type = result.type;
                    break;
                case GREAT:
                    break;
                case EQ:
                    break;
                case ERROR:
                    throw new RuntimeException(String.format("Bad array elements of type %s and %s", type, result.type));
            }
            listSb.append(result.value).append(", ");
        }

        listSb.delete(listSb.length() - 2, listSb.length());

        return new TypeCheckingTreeResult(type, listSb.toString());
    }

    @Override
    public TypeCheckingTreeResult visitCallArgList(SimpleDBGrammarParser.CallArgListContext ctx) {
        return super.visitCallArgList(ctx);
    }

    @Nullable
    @Override
    public TypeCheckingTreeResult visitConstant(SimpleDBGrammarParser.ConstantContext ctx) {
        System.out.println(ctx.getText() + " in constant ");
        if (ctx.BOOLEAN() != null)
            return new TypeCheckingTreeResult("boolean", ctx.getText());
        else if (ctx.FLOAT() != null)
            return new TypeCheckingTreeResult("float", ctx.getText());
        else if (ctx.INT() != null) {
            try {
                Integer.parseInt(ctx.getText());
                return new TypeCheckingTreeResult("int", ctx.getText());
            } catch (NumberFormatException ex) {
                try {
                    Long.parseLong(ctx.getText());
                    return new TypeCheckingTreeResult("long", ctx.getText());
                } catch (NumberFormatException ex1) {
                    throw new RuntimeException(String.format("%s is bad number literal!", ctx.getText()));
                }
            }
        } else if (ctx.STRING() != null) {
            return new TypeCheckingTreeResult("String", ctx.getText().substring(1, ctx.getText().length() - 1));
        } else if (ctx.NULL() != null) {
            return new TypeCheckingTreeResult("null", "null");
        }

        throw new RuntimeException("Unknown constant type");
    }




}

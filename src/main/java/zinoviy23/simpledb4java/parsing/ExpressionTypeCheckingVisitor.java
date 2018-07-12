package zinoviy23.simpledb4java.parsing;

import org.jetbrains.annotations.Nullable;
import zinoviy23.simpledb4java.antlr.SimpleDBGrammarBaseVisitor;
import zinoviy23.simpledb4java.antlr.SimpleDBGrammarParser;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Class for expression
 */
public class ExpressionTypeCheckingVisitor extends SimpleDBGrammarBaseVisitor<TypeCheckingTreeResult> {
    private final String currentClass;

    public ExpressionTypeCheckingVisitor(String currentClass) {
        this.currentClass = currentClass;
    }


    @Override
    public TypeCheckingTreeResult visitExpression(SimpleDBGrammarParser.ExpressionContext ctx) {
        //System.out.println(ctx.getText() + " in expression");
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

        if (ctx.arrayElementGetting() != null) {
            return ctx.arrayElementGetting().accept(this);
        }

        if (ctx.MULT() != null) {
            return getForOperators("*", ctx);
        }

        if (ctx.DIV() != null) {
            return getForOperators("/", ctx);
        }

        if (ctx.MINUS() != null) {
            return getForOperators("-", ctx);
        }

        if (ctx.PLUS() != null) {
            TypeCheckingTreeResult result1 = ctx.expression(0).accept(this);
            TypeCheckingTreeResult result2 = ctx.expression(1).accept(this);

            if (result1.type.equals("String") || result2.type.equals("String"))
                return new TypeCheckingTreeResult("String", String.format("%s + %s", result1.value, result2.value));

            if (!result1.type.equals("float") && !result1.type.equals("long") && !result1.type.equals("int")) {
                throw new RuntimeException(String.format("Operator + allows only numeric types. Actual %s", result1.type));
            }

            if (!result2.type.equals("float") && !result2.type.equals("long") && !result2.type.equals("int")) {
                throw new RuntimeException(String.format("Operator + allows only numeric types. Actual %s", result1.type));
            }

            TypeCheckingTreeResult.TypeCompareResult typeCompareResult =
                    TypeCheckingTreeResult.compareTypes(result1.type, result2.type);

            if (typeCompareResult == TypeCheckingTreeResult.TypeCompareResult.ERROR) {
                throw new RuntimeException(String.format("Bad types for +. Actual %s %s", result1.type, result2.type));
            }

            String resType =
                    (typeCompareResult == TypeCheckingTreeResult.TypeCompareResult.LESS ||
                            typeCompareResult == TypeCheckingTreeResult.TypeCompareResult.EQ) ? result2.type : result1.type;

            return new TypeCheckingTreeResult(resType, String.format("%s + %s", result1.value, result2.value));
        }

        if (ctx.LE() != null) {
            return getForCompOperators("<=", ctx);
        }

        if (ctx.GE() != null) {
            return getForCompOperators(">=", ctx);
        }

        if (ctx.LS() != null) {
            return getForCompOperators("<", ctx);
        }

        if (ctx.GR() != null) {
            return getForCompOperators(">", ctx);
        }

        if (ctx.EQ() != null) {
            return getForCompOperators("==", ctx);
        }

        if (ctx.NOTEQ() != null) {
            return getForCompOperators("!=", ctx);
        }

        return null;
    }

    private TypeCheckingTreeResult getForOperators(String operator, SimpleDBGrammarParser.ExpressionContext ctx) {
        TypeCheckingTreeResult result1 = ctx.expression(0).accept(this);
        TypeCheckingTreeResult result2 = ctx.expression(1).accept(this);

        if (!result1.type.equals("float") && !result1.type.equals("long") && !result1.type.equals("int")) {
            throw new RuntimeException(String.format("Operator %s allows only numeric types. Actual %s", operator, result1.type));
        }

        if (!result2.type.equals("float") && !result2.type.equals("long") && !result2.type.equals("int")) {
            throw new RuntimeException(String.format("Operator %s allows only numeric types. Actual %s", operator, result1.type));
        }

        TypeCheckingTreeResult.TypeCompareResult typeCompareResult =
                TypeCheckingTreeResult.compareTypes(result1.type, result2.type);

        if (typeCompareResult == TypeCheckingTreeResult.TypeCompareResult.ERROR) {
            throw new RuntimeException(String.format("Bad types for %s. Actual %s %s", operator,result1.type, result2.type));
        }

        String resType =
                (typeCompareResult == TypeCheckingTreeResult.TypeCompareResult.LESS ||
                        typeCompareResult == TypeCheckingTreeResult.TypeCompareResult.EQ) ? result2.type : result1.type;

        return new TypeCheckingTreeResult(resType, String.format("%s %s %s",result1.value, operator, result2.value));
    }

    private TypeCheckingTreeResult getForCompOperators(String operator, SimpleDBGrammarParser.ExpressionContext ctx) {
        TypeCheckingTreeResult result = getForOperators(operator, ctx);
        return new TypeCheckingTreeResult("boolean", result.value);
    }

    @Override
    public TypeCheckingTreeResult visitArrIndexList(SimpleDBGrammarParser.ArrIndexListContext ctx) {
        StringBuilder listSb = new StringBuilder();

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

    @Override
    public TypeCheckingTreeResult visitArrayElementGetting(SimpleDBGrammarParser.ArrayElementGettingContext ctx) {
        TypeCheckingTreeResult result = ctx.expression().accept(this);

        if (!result.type.equals("int"))
            throw new RuntimeException(String.format("Array index must be int. In expression %s", ctx.getText()));

        if (ctx.array() != null) {
            TypeCheckingTreeResult arrayResult = ctx.array().accept(this);
            return new TypeCheckingTreeResult(arrayResult.type.replace("[]", ""),
                    String.format("%s.get(%s)", arrayResult.value, result.value));
        }

        if (ctx.dottedId() != null) {
            TypeCheckingTreeResult idResult = ctx.dottedId().accept(new DottedIdVisitor(currentClass, true,
                    DottedIdVisitor.StaticStatus.CAN_BE_STATIC));

            if (!idResult.type.contains("[]"))
                throw new RuntimeException(String.format("[] can be applied only to arrays. But actual type is %s. In expression %s"
                        , idResult.type, ctx.getText()));

            return new TypeCheckingTreeResult(idResult.type.replace("[]", ""),
                    String.format("%s.get(%s)", idResult.value, result.value));
        }
        return null;
    }
}

package zinoviy23.simpledb4java.parsing;

import zinoviy23.simpledb4java.antlr.SimpleDBGrammarBaseVisitor;
import zinoviy23.simpledb4java.antlr.SimpleDBGrammarParser;
import zinoviy23.simpledb4java.codegeneration.Utils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Call arguments for min, max like (id, -age)
 */
public class CallArgListForMinMaxVisitor extends SimpleDBGrammarBaseVisitor<String> {
    private final String className;

    public CallArgListForMinMaxVisitor(String className) {
        this.className = className;
    }

    @Override
    public String visitCallArgList(SimpleDBGrammarParser.CallArgListContext ctx) {
        if (ctx.expression().size() == 0) {
            throw new RuntimeException(String.format("Error! Method needs at least one argument. In class %s. line %s", className, ctx.getStart().getLine()));
        }

        List<String> args = ctx.expression().stream()
                .map(expressionContext -> expressionContext.accept(this))
                .collect(Collectors.toList());

        return String.format("java.util.Comparator.comparing((%s kekekekek)->%s)",
                className ,String.join(String.format(").thenComparing((%s kekekekek)->", className), args));
    }

    @Override
    public String visitExpression(SimpleDBGrammarParser.ExpressionContext ctx) {
        if (ctx.dottedId() != null) {
            return String.format("%s.%s()", "kekekekek", "get" + Utils.getStringWithCapitalFirstChar(ctx.dottedId().accept(this)));
        }
        if (ctx.unaryExpr() != null) {
            return ctx.unaryExpr().accept(this);
        }
        throw new RuntimeException(String.format("This method allows only field names. In class %s. In line %s", className,
                ctx.getStart().getLine()));
    }

    @Override
    public String visitUnaryExpr(SimpleDBGrammarParser.UnaryExprContext ctx) {
        return String.format("%s%s", ctx.unaryOp().getText(), ctx.expression().accept(this));
    }

    @Override
    public String visitDottedId(SimpleDBGrammarParser.DottedIdContext ctx) {
        if (ctx.LPAR() != null || ctx.DOT() != null) {
            throw new RuntimeException(String.format("This method allows only field names. In class %s. In line %s",
                    className, ctx.getStart().getLine()));
        }

        if (!SimpleDBGrammarParser.fieldsSymbolTable.get(className).containsKey(ctx.getText()))
            throw new RuntimeException(String.format("Unknown field id (%s). In class %s. In line %s",
                    ctx.getText() ,className, ctx.getStart().getLine()));

        String type = SimpleDBGrammarParser.fieldsSymbolTable.get(className).get(ctx.getText());

        if (!type.equals("int") && !type.equals("float") && !type.equals("String") && !type.equals("long"))
            throw new RuntimeException(String.format("Type %s is not comparable. In line %s", className,
                    ctx.getStart().getLine()));

        return ctx.getText();
    }
}

package zinoviy23.simpledb4java.parsing;

import zinoviy23.simpledb4java.antlr.SimpleDBGrammarBaseVisitor;
import zinoviy23.simpledb4java.antlr.SimpleDBGrammarParser;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Class for callArgs
 */
public class CallListArgsVisitor extends SimpleDBGrammarBaseVisitor<List<TypeCheckingTreeResult>> {
    /**
     * Current class name
     */
    private final String currentClass;

    /**
     * Constructor
     * @param currentClass current class name
     */
    public CallListArgsVisitor(String currentClass) {
        this.currentClass = currentClass;
    }

    @Override
    public List<TypeCheckingTreeResult> visitCallArgList(SimpleDBGrammarParser.CallArgListContext ctx) {
        return ctx.expression().stream()
                .map(expressionContext -> expressionContext.accept(new ExpressionTypeCheckingVisitor(currentClass)))
                .collect(Collectors.toList());
    }
}

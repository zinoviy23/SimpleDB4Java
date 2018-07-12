package zinoviy23.simpledb4java.parsing;

import zinoviy23.simpledb4java.antlr.SimpleDBGrammarBaseVisitor;
import zinoviy23.simpledb4java.antlr.SimpleDBGrammarParser;

import java.util.LinkedHashMap;

/**
 * Class for getting method arguments
 */
public class FuncArgListVisitor extends SimpleDBGrammarBaseVisitor<LinkedHashMap<String, String>> {
    @Override
    public LinkedHashMap<String, String> visitFuncArgList(SimpleDBGrammarParser.FuncArgListContext ctx) {
        LinkedHashMap<String, String> result = new LinkedHashMap<>();
        for (int i = 0; i < ctx.typeId().size(); i++) {
            result.put(ctx.ID(i).getText(), ctx.typeId(i).getText());
        }

        return result;
    }
}

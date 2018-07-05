package zinoviy23.simpledb4java.parsing;

import zinoviy23.simpledb4java.antlr.SimpleDBGrammarBaseListener;
import zinoviy23.simpledb4java.antlr.SimpleDBGrammarParser;

/**
 * Class for tree recognizing
 * @author zinoviy23@gmal.com
 */
public class SimpleDBGrammarListenerImpl extends SimpleDBGrammarBaseListener {
    @Override
    public void enterFile(SimpleDBGrammarParser.FileContext ctx) {
        super.enterFile(ctx);
    }

    @Override
    public void enterFileHeader(SimpleDBGrammarParser.FileHeaderContext ctx) {
        super.enterFileHeader(ctx);
        System.out.println(ctx.ID());
    }

    @Override
    public void enterFieldDef(SimpleDBGrammarParser.FieldDefContext ctx) {
        super.enterFieldDef(ctx);
        System.out.println(ctx.ID(0) + " " + ctx.ID(1));
    }

    @Override
    public void enterClassDef(SimpleDBGrammarParser.ClassDefContext ctx) {
        super.enterClassDef(ctx);
        System.out.println(ctx.ID());
    }

    @Override
    public void enterQueryDef(SimpleDBGrammarParser.QueryDefContext ctx) {
        super.enterQueryDef(ctx);
    }
}

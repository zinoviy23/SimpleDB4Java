package zinoviy23.simpledb4java.parsing;

import zinoviy23.simpledb4java.antlr.SimpleDBGrammarBaseListener;
import zinoviy23.simpledb4java.antlr.SimpleDBGrammarParser;
import zinoviy23.simpledb4java.dbinfo.DBArrayTableInfo;
import zinoviy23.simpledb4java.dbinfo.DBInformation;
import zinoviy23.simpledb4java.dbinfo.TableInformation;

/**
 * Class for tree recognizing
 * @author zinoviy23@gmal.com
 */
public class SimpleDBGrammarListenerImpl extends SimpleDBGrammarBaseListener {
    private TableInformation currentTable;

    @Override
    public void enterFileHeader(SimpleDBGrammarParser.FileHeaderContext ctx) {
        DBInformation.getInstance().setDbName(ctx.ID().getSymbol().getText());
    }

    @Override
    public void enterFieldDef(SimpleDBGrammarParser.FieldDefContext ctx) {
        if (ctx.LSQBR() == null) {
            currentTable.add(new TableInformation.ColumnInfo(ctx.ID(0).getSymbol().getText(),
                    TableInformation.ColumnType.fromString(ctx.ID(0).getSymbol().getText())));
        } else {
            DBInformation.getInstance().addArrayTable(new DBArrayTableInfo(currentTable.getName(),
                    ctx.ID(0).getSymbol().getText(),
                    ctx.ID(1).getSymbol().getText()));
        }
    }

    @Override
    public void enterClassDef(SimpleDBGrammarParser.ClassDefContext ctx) {
        currentTable = new TableInformation(ctx.ID().getSymbol().getText());
    }

    @Override
    public void exitClassDef(SimpleDBGrammarParser.ClassDefContext ctx) {
        DBInformation.getInstance().putTable(currentTable.getName(), currentTable);
        currentTable = null;
    }
}

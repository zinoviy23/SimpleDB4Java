package zinoviy23.simpledb4java.parsing;

import org.jetbrains.annotations.NotNull;
import zinoviy23.simpledb4java.antlr.SimpleDBGrammarBaseListener;
import zinoviy23.simpledb4java.antlr.SimpleDBGrammarParser;
import zinoviy23.simpledb4java.codegeneration.GeneratedClass;
import zinoviy23.simpledb4java.codegeneration.SimpleFieldWithSimpleType;
import zinoviy23.simpledb4java.dbinfo.DBArrayTableInfo;
import zinoviy23.simpledb4java.dbinfo.DBInformation;
import zinoviy23.simpledb4java.dbinfo.TableInformation;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Class for tree recognizing
 */
public class SimpleDBGrammarListenerImpl extends SimpleDBGrammarBaseListener {
    private TableInformation currentTable;

    private LinkedList<GeneratedClass> generatedClasses;

    public SimpleDBGrammarListenerImpl(@NotNull LinkedList<GeneratedClass> generatedClasses) {
        this.generatedClasses = generatedClasses;
    }

    public SimpleDBGrammarListenerImpl() {
        generatedClasses = new LinkedList<>();
    }

    @Override
    public void enterFileHeader(SimpleDBGrammarParser.FileHeaderContext ctx) {
        DBInformation.getInstance().setDbName(ctx.ID().getSymbol().getText());
    }

    @Override
    public void enterFieldDef(SimpleDBGrammarParser.FieldDefContext ctx) {
        if (ctx.LSQBR() == null) {
            currentTable.add(new TableInformation.ColumnInfo(ctx.ID(1).getSymbol().getText(),
                    TableInformation.ColumnType.fromString(ctx.ID(0).getSymbol().getText())));
            generatedClasses.getLast().addSimpleField(new SimpleFieldWithSimpleType(ctx.ID(0).getSymbol().getText(),
                    ctx.ID(1).getSymbol().getText()));
        } else {
            DBInformation.getInstance().addArrayTable(new DBArrayTableInfo(currentTable.getName(),
                    ctx.ID(0).getSymbol().getText(),
                    ctx.ID(1).getSymbol().getText()));
        }
    }

    @Override
    public void enterClassDef(SimpleDBGrammarParser.ClassDefContext ctx) {
        currentTable = new TableInformation(ctx.ID().getSymbol().getText());
        generatedClasses.add(new GeneratedClass(ctx.ID().getSymbol().getText()));
    }

    @Override
    public void exitClassDef(SimpleDBGrammarParser.ClassDefContext ctx) {
        DBInformation.getInstance().putTable(currentTable.getName(), currentTable);
        currentTable = null;
    }


    public List<GeneratedClass> getGeneratedClassesArray() {
        return Collections.unmodifiableList(generatedClasses);
    }
}

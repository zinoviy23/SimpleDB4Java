package zinoviy23.simpledb4java.parsing;

import org.jetbrains.annotations.NotNull;
import zinoviy23.simpledb4java.antlr.SimpleDBGrammarBaseListener;
import zinoviy23.simpledb4java.antlr.SimpleDBGrammarParser;
import zinoviy23.simpledb4java.codegeneration.*;
import zinoviy23.simpledb4java.dbinfo.DBArrayTableInfo;
import zinoviy23.simpledb4java.dbinfo.DBInformation;
import zinoviy23.simpledb4java.dbinfo.TableInformation;

import java.util.*;

/**
 * Class for tree recognizing
 */
public class SimpleDBGrammarListenerImpl extends SimpleDBGrammarBaseListener {
    private TableInformation currentTable;

    private LinkedList<GeneratedClass> generatedClasses;

    private final static Set<String> simpleTypes = new HashSet<>(Arrays.asList("int", "long", "String", "float"));

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
        GeneratedField field = null;
        if (ctx.LSQBR() == null) {
            currentTable.add(new TableInformation.ColumnInfo(ctx.ID(1).getSymbol().getText(),
                    TableInformation.ColumnType.fromString(ctx.ID(0).getSymbol().getText())));

            if (simpleTypes.contains(ctx.ID(0).getSymbol().getText()))
                field = new SimpleFieldWithSimpleType(ctx.ID(0).getSymbol().getText(), ctx.ID(1).getSymbol().getText());
            else
                field = new SimpleFieldWithComplexType(ctx.ID(0).getSymbol().getText(), ctx.ID(1).getSymbol().getText());

        } else {
            DBArrayTableInfo tableInfo = new DBArrayTableInfo(currentTable.getName(),
                    ctx.ID(0).getSymbol().getText(),
                    ctx.ID(1).getSymbol().getText());

            DBInformation.getInstance().addArrayTable(tableInfo);

            if (simpleTypes.contains(ctx.ID(0).getSymbol().getText()))
                field = new ArrayFieldWithSimpleType(ctx.ID(0).getSymbol().getText(), ctx.ID(1).getSymbol().getText(),
                        tableInfo.getTableName());
            else
                field = new ArrayFieldWithComplexType(ctx.ID(0).getSymbol().getText(), ctx.ID(1).getSymbol().getText(),
                        tableInfo.getTableName());
        }
        generatedClasses.getLast().addField(field);
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

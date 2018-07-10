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

    private static final String PACKAGE_NAME = "db";

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

        SimpleDBGrammarParser.classesSymbolTable.forEach(System.out::println);

        SimpleDBGrammarParser.fieldsSymbolTable.forEach((key, value) -> {
            System.out.print(key + " : ");
            value.forEach((name, type) -> System.out.print(name + " " + type + "; "));
            System.out.println();
        });
    }

    @Override
    public void enterFieldDef(SimpleDBGrammarParser.FieldDefContext ctx) {
        GeneratedField field = null;
        if (ctx.typeId().LSQBR() == null) {
            currentTable.add(new TableInformation.ColumnInfo(ctx.ID().getSymbol().getText(),
                    TableInformation.ColumnType.fromString(ctx.typeId().ID().getSymbol().getText())));

            if (simpleTypes.contains(ctx.typeId().ID().getSymbol().getText()))
                field = new SimpleFieldWithSimpleType(ctx.typeId().ID().getSymbol().getText(), ctx.ID().getSymbol().getText());
            else
                field = new SimpleFieldWithComplexType(ctx.typeId().ID().getSymbol().getText(), ctx.ID().getSymbol().getText());

        } else {
            DBArrayTableInfo tableInfo = new DBArrayTableInfo(currentTable.getName(),
                    ctx.typeId().ID().getSymbol().getText(),
                    ctx.ID().getSymbol().getText());

            DBInformation.getInstance().addArrayTable(tableInfo);

            if (simpleTypes.contains(ctx.typeId().ID().getSymbol().getText()))
                field = new ArrayFieldWithSimpleType(ctx.typeId().ID().getSymbol().getText(), ctx.ID().getSymbol().getText(),
                        tableInfo.getTableName());
            else
                field = new ArrayFieldWithComplexType(ctx.typeId().ID().getSymbol().getText(), ctx.ID().getSymbol().getText(),
                        tableInfo.getTableName());
        }
        generatedClasses.getLast().addField(field);
    }

    @Override
    public void enterClassDef(SimpleDBGrammarParser.ClassDefContext ctx) {
        currentTable = new TableInformation(ctx.ID().getSymbol().getText());
        generatedClasses.add(new GeneratedClass(ctx.ID().getSymbol().getText(), PACKAGE_NAME));
        currentTable.add(new TableInformation.ColumnInfo("id", TableInformation.ColumnType.ID));
    }

    @Override
    public void exitClassDef(SimpleDBGrammarParser.ClassDefContext ctx) {
        DBInformation.getInstance().putTable(currentTable.getName(), currentTable);
        currentTable = null;
    }

    @Override
    public void enterQueryDef(SimpleDBGrammarParser.QueryDefContext ctx) {
    }

    public List<GeneratedClass> getGeneratedClassesArray() {
        return Collections.unmodifiableList(generatedClasses);
    }
}

package zinoviy23.simpledb4java.parsing;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
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

    private final static LinkedList<Map<String, String>> variables = new LinkedList<>();

    /**
     * Finds variable
     * @param name variable name
     * @return variable type or null
     */
    @Nullable
    public static String findVariable(String name) {
        ListIterator<Map<String, String>> it = variables.listIterator(variables.size());
        while (it.hasPrevious()) {
            Map<String, String> map = it.previous();
            if (map.containsKey(name))
                return map.get(name);
        }
        return null;
    }

    /**
     * Adds variable
     * @param name variable name
     * @param type variable type
     */
    public static void addVariable(String name, String type) {
        if (findVariable(name) != null)
            throw new RuntimeException(String.format("This variable already exists (%s)", name));

        variables.getLast().put(name, type);
    }

    /**
     * Deletes block variables
     */
    public static void popVariables() {
        if (variables.size() != 0)
            variables.pollLast();
    }

    /**
     * Adds block
     */
    public static void addBlock() {
        variables.add(new HashMap<>());
    }

    public static void clear() {
        variables.clear();
    }

    public SimpleDBGrammarListenerImpl(@NotNull LinkedList<GeneratedClass> generatedClasses) {
        this.generatedClasses = generatedClasses;
    }

    public SimpleDBGrammarListenerImpl() {
        generatedClasses = new LinkedList<>();
    }

    @Override
    public void enterFile(SimpleDBGrammarParser.FileContext ctx) {
        addGettersSettersForFieldsToClassMethodsSymbolTable();
        addIdGetterAndField();
        addStandardClassMethods();
    }

    @Override
    public void enterFileHeader(SimpleDBGrammarParser.FileHeaderContext ctx) {
        DBInformation.getInstance().setDbName(ctx.ID().getSymbol().getText());
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
    public void enterBlock(SimpleDBGrammarParser.BlockContext ctx) {
    }

    @Override
    public void enterQueryDef(SimpleDBGrammarParser.QueryDefContext ctx) {
    }

    @Override
    public void enterExpression(SimpleDBGrammarParser.ExpressionContext ctx) {
        try {
            System.out.println(ctx.accept(new ExpressionTypeCheckingVisitor(generatedClasses.getLast().getName())));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public List<GeneratedClass> getGeneratedClassesArray() {
        return Collections.unmodifiableList(generatedClasses);
    }

    /**
     * Adds getters and setters for fields to methods symbol table
     */
    private static void addGettersSettersForFieldsToClassMethodsSymbolTable() {
        for (final String className: SimpleDBGrammarParser.classesSymbolTable) {
            if (!SimpleDBGrammarParser.fieldsSymbolTable.containsKey(className))
                throw new RuntimeException(String.format("Class %s has not fields!", className));

            SimpleDBGrammarParser.fieldsSymbolTable.get(className).forEach((name, type) -> {
                SimpleDBGrammarParser.MethodInfo[] methods;
                LinkedHashMap<String, String> arguments = new LinkedHashMap<>();
                arguments.put(name, type);
                if (!type.contains("[")) {
                    methods = new SimpleDBGrammarParser.MethodInfo[] {
                            new SimpleDBGrammarParser.MethodInfo(type, "get" + Utils.getStringWithCapitalFirstChar(name),
                                    false, new LinkedHashMap<>()),
                            new SimpleDBGrammarParser.MethodInfo("void",
                                    "set" + Utils.getStringWithCapitalFirstChar(name), false, arguments)
                    };
                }
                else {
                    methods = new SimpleDBGrammarParser.MethodInfo[] {
                            new SimpleDBGrammarParser.MethodInfo(type, "get" + Utils.getStringWithCapitalFirstChar(name),
                                    false, new LinkedHashMap<>()),
                            new SimpleDBGrammarParser.MethodInfo("void",
                                    "add" + Utils.getStringWithCapitalFirstChar(name), false, arguments),
                            new SimpleDBGrammarParser.MethodInfo("void",
                                    "remove" + Utils.getStringWithCapitalFirstChar(name), false, arguments)
                    };
                }

                for (SimpleDBGrammarParser.MethodInfo methodInfo: methods) {
                    if (!SimpleDBGrammarParser.methodsSymbolTable.containsKey(className))
                        SimpleDBGrammarParser.methodsSymbolTable.put(className, new HashMap<>());

                    if (SimpleDBGrammarParser.methodsSymbolTable.get(className).containsKey(methodInfo.name))
                        throw new RuntimeException(String.format("Methods with to same indentificators (%s) in class %s",
                                methodInfo.name, className));

                    SimpleDBGrammarParser.methodsSymbolTable.get(className).put(methodInfo.name, methodInfo);
                }
            });
        }
    }

    /**
     * Adds id for all classes
     */
    private static void addIdGetterAndField() {
        for (String className : SimpleDBGrammarParser.classesSymbolTable) {
            if (!SimpleDBGrammarParser.fieldsSymbolTable.containsKey(className))
                throw new RuntimeException(String.format("Class %s has not fields!", className));

            if (SimpleDBGrammarParser.fieldsSymbolTable.get(className).containsKey("id"))
                throw new RuntimeException(String.format("Fields with to same indentificators (%s) in class %s",
                        "id", className));

            SimpleDBGrammarParser.fieldsSymbolTable.get(className).put("id", "long");

            if (!SimpleDBGrammarParser.methodsSymbolTable.containsKey(className))
                SimpleDBGrammarParser.methodsSymbolTable.put(className, new HashMap<>());

            if (SimpleDBGrammarParser.methodsSymbolTable.get(className).containsKey("getId"))
                throw new RuntimeException(String.format("Methods with to same indentificators (%s) in class %s",
                        "getId", className));

            SimpleDBGrammarParser.methodsSymbolTable.get(className).put("getId",
                    new SimpleDBGrammarParser.MethodInfo("long", "getId", false, new LinkedHashMap<>()));
        }
    }

    /**
     * Adds standard methods for classes
     */
    private static void addStandardClassMethods() {
        for (String className : SimpleDBGrammarParser.classesSymbolTable) {
            LinkedHashMap<String, String> idArgs = new LinkedHashMap<>();
            idArgs.put("id", "long");

            List<SimpleDBGrammarParser.MethodInfo> standardMethods = new LinkedList<>();
            standardMethods.add(new SimpleDBGrammarParser.MethodInfo(className, "find", true, null));
            standardMethods.add(new SimpleDBGrammarParser.MethodInfo(className + "[]", "findAll", true,
                    null));
            standardMethods.add(new SimpleDBGrammarParser.MethodInfo(className, "min", true, null));
            standardMethods.add(new SimpleDBGrammarParser.MethodInfo(className, "max", true, null));
            standardMethods.add(new SimpleDBGrammarParser.MethodInfo(className + "[]", "all", true,
                    new LinkedHashMap<>()));
            standardMethods.add(new SimpleDBGrammarParser.MethodInfo(className, "getById", true, idArgs));
            standardMethods.add(new SimpleDBGrammarParser.MethodInfo("void", "removeById", true, idArgs));

            if (!SimpleDBGrammarParser.methodsSymbolTable.containsKey(className))
                SimpleDBGrammarParser.methodsSymbolTable.put(className, new HashMap<>());

            for (SimpleDBGrammarParser.MethodInfo method : standardMethods) {
                if (SimpleDBGrammarParser.methodsSymbolTable.get(className).containsKey(method.name))
                    throw new RuntimeException(String.format("Methods with to same indentificators (%s) in class %s",
                            method.name, className));

                SimpleDBGrammarParser.methodsSymbolTable.get(className).put(method.name, method);
            }
        }
    }
}

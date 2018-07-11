grammar SimpleDBGrammar;

@parser::members
{
// table for classes
public static final java.util.Set<String> classesSymbolTable = new java.util.HashSet<>();

// table for fields
public static final java.util.Map<String, java.util.Map<String, String>> fieldsSymbolTable = new java.util.HashMap<>();

// table for fields name with first lower case latter
public static final java.util.Map<String, java.util.Set<String>> lowerCaseFieldsSymbolTable = new java.util.HashMap<>();

public static String firstLatterToLowerCase(String str) {
    return Character.toLowerCase(str.charAt(0)) + str.substring(1);
}

// class for methods
public static class MethodInfo {
    public final String type;

    public final String name;

    public final boolean isStatic;

    public final java.util.LinkedHashMap<String, String> arguments;

    public MethodInfo(String type, String name, boolean isStatic, java.util.LinkedHashMap<String, String> arguments) {
        this.name = name;
        this.type = type;
        this.arguments = arguments;
        this.isStatic = isStatic;
    }

    @Override
    public String toString() {
        return "{type=" + type + ", name=" + name + ", isStatic=" + isStatic + ", arguments=" + arguments +"}";
    }
}

// table for methods
public static final java.util.Map<String, java.util.Map<String, MethodInfo>> methodsSymbolTable = new java.util.HashMap<>();

// clears tables
public static void clearSymbolTables() {
    classesSymbolTable.clear();
    fieldsSymbolTable.clear();
    lowerCaseFieldsSymbolTable.clear();
    methodsSymbolTable.clear();
}
}

file : fileHeader (classDef)*; // root node
fileHeader : DATABASEKW ID CMDEND; // file header
typeId : ID(LSQBR RSQBR)?; // type inditificator
fieldDef[String className] : typeId a=ID CMDEND
{
if (!fieldsSymbolTable.containsKey($className))
    fieldsSymbolTable.put($className, new java.util.LinkedHashMap<>());
if (fieldsSymbolTable.get($className).containsKey($a.text)) {
    throw new RuntimeException(String.format("Two fields with same inditificators (%s) in class %s. Line %d",
        $a.text, $className, $a.line));
}
fieldsSymbolTable.get($className).put($a.text, $typeId.text);

if (!lowerCaseFieldsSymbolTable.containsKey($className))
    lowerCaseFieldsSymbolTable.put($className, new java.util.LinkedHashSet<>());

if (lowerCaseFieldsSymbolTable.get($className).contains(firstLatterToLowerCase($a.text))) {
    throw new RuntimeException(String.format("Two fields with same inditificators with first latter in lower case (%s) in class %s. Line %d",
            firstLatterToLowerCase($a.text), $className, $a.line));
}
lowerCaseFieldsSymbolTable.get($className).add(firstLatterToLowerCase($a.text));
}; // field definition
classDef : CLASSKW ID LBRACE (fieldDef[$ID.text]|queryDef[$ID.text])* RBRACE {classesSymbolTable.add($ID.text);}; // class definition
dottedId : ID (LPAR callArgList RPAR)? (DOT ID (LPAR callArgList RPAR)?)*; // doted name like System.out.println
expression : ('-'|'+'|'++'|'--') expression | // expression
    expression LSQBR arrIndexList RSQBR |
    expression ('++'|'--') |
    expression ('*'|'/') expression |
    expression ('+'|'-') expression |
    expression ('<'|'>'|'<='|'>=') expression |
    expression ('=='|'!=') expression | dottedId | CONSTANT | array |
    LPAR expression RPAR;
arrIndexList : expression (COMMA expression)*; // for arrays
callArgList : | expression (COMMA expression)*; // call arguments
simpleCommand : RETURNKW expression CMDEND | ID(LSQBR RSQBR)? ID '=' expression CMDEND | ID  ('='|'+='|'-=') expression CMDEND |
    dottedId CMDEND| forCycle | ifStatement; // simple command
queryDef[String className] : typeId ID LPAR funcArgList RPAR (LEFTARROW expression CMDEND
|
    LBRACE simpleCommand* RBRACE)
{
java.util.LinkedHashMap<String, String> arguments = new java.util.LinkedHashMap<>();
for (int i = 0; i < $funcArgList.ctx.ID().size(); i++) {
    if (arguments.containsKey($funcArgList.ctx.ID(i).getText()))
        throw new RuntimeException(String.format("Two arguments with same inditificators (%s) in class %s in method %s. Line %d",
                $funcArgList.ctx.ID(i).getText(), $className, $ID.text, $ID.line));

    arguments.put($funcArgList.ctx.ID(i).getText(), $funcArgList.ctx.typeId(i).getText());
}

if (!methodsSymbolTable.containsKey($className))
    methodsSymbolTable.put($className, new java.util.HashMap<>());

if (methodsSymbolTable.get($className).containsKey($ID.text))
    throw new RuntimeException(String.format("Two methods with same inditificators (%s) in class %s. Line %d",
                    $ID.text, $className, $ID.line));

methodsSymbolTable.get($className).put($ID.text, new MethodInfo($typeId.text, $ID.text, true, arguments));
}; // definition of query method
funcArgList : | typeId ID (COMMA typeId ID)*; // arguments
block :  simpleCommand | LBRACE (simpleCommand)* RBRACE; // block {}
forCycle : FORKW LPAR ID(LSQBR RSQBR)? ID DOUBLEDOT expression RPAR block; // for cycle
ifStatement : IFKW LPAR expression RPAR block (elseBlock)?; // if-else
elseBlock : ELSEKW block; // else block
array : LBRACE arrIndexList RBRACE; // array constant

CMDEND : ';';
DATABASEKW : 'database';
CLASSKW : 'class';
RETURNKW : 'return';
FORKW : 'for';
IFKW: 'if';
ELSEKW : 'else';
LBRACE : '{';
RBRACE : '}';
LPAR : '(';
RPAR : ')';
LSQBR : '[';
RSQBR : ']';
DOT : '.';
COMMA : ',';
DOUBLEDOT : ':';
LEFTARROW: '->';
CONSTANT : (INT|FLOAT|NULL|BOOLEAN|STRING);
ID : [a-zA-Z_][a-zA-Z_0-9]*;
SKIP_ : (WS | COMMENT) -> skip;

fragment BOOLEAN : ('true'|'false');
fragment NULL : 'null';
fragment INT : ('+'|'-')?([1-9][0-9]*|'0');
fragment FLOAT : ('+'|'-')?([1-9][0-9]*|'0')?'.'[0-9]+;
fragment STRING : '"'~["\n\r]*'"';
fragment COMMENT : '//'~[\r\n\f]*;
fragment WS : [ \n\r\t]+;

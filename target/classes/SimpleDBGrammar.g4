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
unaryExpr : unaryOp expression;
dottedId : ID (LPAR callArgList RPAR)? (DOT dottedId)?; // doted name like System.out.println
arrayElementGetting: (dottedId | array) LSQBR expression RSQBR;
expression :  unaryExpr | // expression
    arrayElementGetting |
    expression (MULT|DIV) expression |
    expression (PLUS|MINUS) expression |
    expression (LS|GR|LE|GE) expression |
    expression (EQ|NOTEQ) expression |
    expression AND expression | expression OR expression | dottedId  | constant | array  |
    LPAR expression RPAR;

arrIndexList: expression (COMMA expression)*;
unaryOp: (MINUS|PLUS);
callArgList : | expression (COMMA expression)*; // call arguments
simpleCommand : RETURNKW expression CMDEND | typeId ID ASSIGN expression CMDEND |
    ID  (ASSIGN|PLUSASSIGN|MINUSASSIGM) expression CMDEND |
    dottedId CMDEND; // simple command
blockCommand : forCycle | ifStatement;
command: simpleCommand | blockCommand;
queryDef[String className] : typeId ID LPAR funcArgList RPAR (LEFTARROW expression CMDEND
|
    LBRACE command* RBRACE)
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
block :  command | LBRACE (command)* RBRACE; // block {}
forCycle : FORKW LPAR typeId ID DOUBLEDOT expression RPAR block; // for cycle
ifStatement : IFKW LPAR expression RPAR block (elseBlock)?; // if-else
elseBlock : ELSEKW block; // else block
array : LBRACE arrIndexList RBRACE; // array constant
constant: (BOOLEAN | INT | FLOAT | STRING | NULL);

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
PLUS: '+';
PLUSPLUS: '++';
MINUS: '-';
MINUSMINUS: '--';
MULT: '*';
DIV: '/';
LS: '<';
GR: '>';
LE: '<=';
GE: '>=';
EQ: '==';
NOTEQ: '!=';
ASSIGN: '=';
PLUSASSIGN: '+=';
MINUSASSIGM: '-=';
OR: '||';
AND: '&&';
COMMA : ',';
DOUBLEDOT : ':';
LEFTARROW: '->';
BOOLEAN : ('true'|'false');
NULL : 'null';
INT : ('+'|'-')?([1-9][0-9]*|'0');
FLOAT : ('+'|'-')?([1-9][0-9]*|'0')?'.'[0-9]+;
STRING : '"'~["\n\r]*'"';
ID : [a-zA-Z_][a-zA-Z_0-9]*;
SKIP_ : (WS | COMMENT) -> skip;

fragment COMMENT : '//'~[\r\n\f]*;
fragment WS : [ \n\r\t]+;

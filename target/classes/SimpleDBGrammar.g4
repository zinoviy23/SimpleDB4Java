grammar SimpleDBGrammar;

@parser::members
{
// table for classes
public static final java.util.Set<String> classesSymbolTable = new java.util.HashSet<>();

// table for fields
public static final java.util.Map<String, java.util.Map<String, String>> fieldsSymbolTable = new java.util.HashMap<>();

// table for methods
public static final java.util.Map<String, java.util.Map<String, String>> methodsSymbolTable = new java.util.HashMap<>();
}

file : fileHeader (classDef)*; // root node
fileHeader : DATABASEKW ID CMDEND; // file header
typeId : ID(LSQBR RSQBR)?; // type inditificator
fieldDef[String className] : typeId a=ID CMDEND
{
if (!fieldsSymbolTable.containsKey($className))
    fieldsSymbolTable.put($className, new java.util.HashMap<>());
if (fieldsSymbolTable.get($className).containsKey($a.text)) {
    throw new RuntimeException(String.format("Two fields with same inditificators (%s) in class %s. Line %d",
        $a.text, $className, $a.line));
}
fieldsSymbolTable.get($className).put($a.text, $typeId.text);
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
queryDef[String className] : typeId ID LPAR funcArgList RPAR (DOUBLEDOT expression CMDEND
{
for (int i = 0; i < $funcArgList.ctx.ID().size(); i++)
    System.out.println($funcArgList.ctx.ID(i).getText());
} |
    LBRACE simpleCommand* RBRACE); // definition of query method
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

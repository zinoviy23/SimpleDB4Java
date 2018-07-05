grammar SimpleDBGrammar;

file : fileHeader (classDef)*; // root node
fileHeader : DATABASEKW ID CMDEND; // file header
fieldDef : ID ID CMDEND; // field definition
classDef : CLASSKW ID LBRACE (fieldDef|queryDef)* RBRACE; // class definition
dottedId : ID (DOT ID)*; // doted name like System.out.println
expression : ('-'|'+'|'++'|'--') expression | // expression
    expression LPAR callArgList RPAR |
    expression LSQBR arrIndexList RSQBR |
    expression DOT ID|
    expression ('++'|'--') |
    expression ('*'|'/') expression |
    expression ('+'|'-') expression |
    expression ('<'|'>'|'<='|'>=') expression |
    expression ('=='|'!=') expression | dottedId | CONSTANT | array |
    LPAR expression RPAR;
arrIndexList : expression (COMMA expression)*; // for arrays
callArgList : | expression (COMMA expression)*; // call arguments
simpleCommand : RETURNKW expression CMDEND | ID(LSQBR RSQBR)? ID '=' expression CMDEND | ID  ('='|'+='|'-=') expression CMDEND |
    expression CMDEND| forCycle | ifStatement; // simple command
queryDef : QUERYKW ID(LSQBR RSQBR)? ID LPAR funcArgList RPAR (DOUBLEDOT expression CMDEND | LBRACE simpleCommand* RBRACE); // definition of query method
funcArgList : | ID ID (COMMA ID ID)*; // arguments
block :  simpleCommand | LBRACE (simpleCommand)* RBRACE; // block {}
forCycle : FORKW LPAR ID(LSQBR RSQBR)? ID DOUBLEDOT expression RPAR block; // for cycle
ifStatement : IFKW LPAR expression RPAR block (elseBlock)?; // if-else
elseBlock : ELSEKW block; // else block
array : LBRACE arrIndexList RBRACE; // array constant

CMDEND : ';';
QUERYKW : 'query';
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

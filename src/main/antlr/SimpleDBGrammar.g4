grammar SimpleDBGrammar;

file : fileHeader (classDef)*;
fileHeader : DATABASEKW ID CMDEND; // file header
fieldDef : ID ID CMDEND; // field definition
classDef : CLASSKW ID LBRACE (fieldDef|queryDef)* RBRACE; // class definition
dottedId : ID (DOT ID)*; // doted name like System.out.println
expression : ('-'|'+'|'++'|'--') expression | // expression
    expression LPAR callArgList RPAR|
    expression DOT ID|
    expression ('++'|'--') |
    expression ('*'|'/') expression |
    expression ('+'|'-') expression |
    expression ('=='|'!=') expression | dottedId | CONSTANT |
    LPAR expression RPAR;
callArgList : | expression (COMMA expression)*;
simpleCommand : RETURNKW expression CMDEND | ID ID '=' expression CMDEND | ID  ('='|'+='|'-=') expression CMDEND | expression LPAR callArgList RPAR CMDEND | forCycle;
queryDef : QUERYKW ID ID LPAR funcArgList RPAR (DOUBLEDOT expression CMDEND | LBRACE simpleCommand* RBRACE);
funcArgList : | ID ID (COMMA ID ID)*;
forCycle : FORKW LPAR ID ID DOUBLEDOT expression RPAR (simpleCommand | LBRACE simpleCommand* RBRACE);

CMDEND : ';';
QUERYKW : 'query';
DATABASEKW : 'database';
CLASSKW : 'class';
RETURNKW : 'return';
FORKW : 'for';
LBRACE : '{';
RBRACE : '}';
LPAR : '(';
RPAR : ')';
DOT : '.';
COMMA : ',';
DOUBLEDOT : ':';
CONSTANT : (INT|FLOAT|NULL|BOOLEAN);
ID : [a-zA-Z_][a-zA-Z_0-9]*;
SKIP_ : (WS | COMMENT) -> skip;

fragment BOOLEAN : ('true'|'false');
fragment NULL : 'null';
fragment INT : ('+'|'-')?([1-9][0-9]*|'0');
fragment FLOAT : ('+'|'-')?([1-9][0-9]*|'0')?'.'[0-9]+;
fragment COMMENT : '//'~[\r\n\f]*;
fragment WS : [ \n\r\t]+;

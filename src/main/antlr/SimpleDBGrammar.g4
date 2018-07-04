grammar SimpleDBGrammar;

fileHeader : DATABASEKW ID CMDEND;
fieldDef : ID ID CMDEND;
classDef : CLASSKW ID LBRACE (fieldDef)* RBRACE;
dotedId : ID (DOT ID)*;



CMDEND : ';';
QUERYKW : 'query';
DATABASEKW : 'database';
CLASSKW : 'class';
LBRACE : '{';
RBRACE : '}';
DOT : '.';
ID : [a-zA-Z_][a-zA-Z_0-9]*;
WS : [ \n\r\t]+ -> skip;
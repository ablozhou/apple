grammar Apple;	
// Author: Andy zhou <ablozhou@gmail.com>
// Date 2019.8.15

@header {package com.abloz.antlr;}
prog:   (stmt)*;
stmt:	expr ((NEWLINE|';'))*      # express
        | NEWLINE                  # newLine
        ;

expr:	expr op=(MUL|DIV) expr  # MulDiv
    |	expr op=(ADD|SUB) expr  # AddSub
    |	INT                  # int
    |	ID                   # id
    |	ID '=' expr          # assign
    |	'(' expr ')'         # parens
    ;
NEWLINE : [\r\n]+ ;
INT     : [0-9]+ ;

MUL : '*' ;
DIV : '/' ;
ADD : '+' ;
SUB : '-' ;
ID : [_a-zA-Z0-9]+ ;             // match alpha,digital,_ identifiers
WS : [ \t\r\n]+ -> skip ; // skip spaces, tabs, newlines

SPACES
: [ \t]+
;
COMMENT
 : '//' ~[\r\n\f]*
 ;
BLOCK_COMMENT
:  '/*' .*? '*/'
;

LINE_JOINING
 : '\\' SPACES? ( '\r'? '\n' | '\r' | '\f')
 ;
SKIPS: (WS|COMMENT|BLOCK_COMMENT|LINE_JOINING)+ -> skip;



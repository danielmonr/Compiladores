%{
#include "miniparser.tab.hpp"
#include <iostream>
using namespace std;
%}

%option noyywrap

DIGIT [0-9]
ID [a-z][a-z0-9]*

%%

program  { return PROG; }
if       { return IF; }
then     { return THEN; }
else     { return ELSE; }
int      { return INT; }
float    { return FLOAT; }
{ID}                  { return ID; }
{DIGIT}+              { return ENTERO; }
{DIGIT}+"."{DIGIT}+   { return REAL; }
"+"     { return MAS; }
"="     { return IGUAL; }
"{"      { return LA; }
"}"      { return LC; }
"<"      { return MEQ; }
">"      { return MAQ; }
";"      { return PC; }
<<EOF>>  { return 0; }
[ \t\n]+ { }
.        { cerr << "Unrecognized token!" << endl; exit(1); }
%%

main( int argc, char **argv )
{
    ++argv, --argc;	/* skip over program name */
    if ( argc > 0 )
       yyin = fopen( argv[0], "r" );
    else
       yyin = stdin;
       yylex();
}
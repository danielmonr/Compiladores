%{
#include "seman.tab.hpp"
#include <iostream>
using namespace std;
%}

%option noyywrap

DIGIT [0-9]
ID [a-z][a-z0-9]*

%%

int      { return INT; }
float    { return FLOAT; }
{ID}                  { yylval.lexema = strdup(yytext); return ID; }
{DIGIT}+              { return ENTERO; }
{DIGIT}+"."{DIGIT}+   { return REAL; }
"+"     { return MAS; }
"="     { return IGUAL; }
";"      { return PC; }
<<EOF>>  { return 0; }
[ \t\n]+ { }
.        { cerr << "Unrecognized token!" << endl; exit(1); }
%%

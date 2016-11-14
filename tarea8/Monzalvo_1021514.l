%{
#include "Monzalvo_1021514.tab.hpp"
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
{ID}                  { yylval.lexema = strdup(yytext); return ID; }
{DIGIT}+              { yylval.lexema = strdup(yytext); return ENTERO; }
{DIGIT}+"."{DIGIT}+   { yylval.lexema = strdup(yytext); return REAL; }
"+"     { yylval.sym = yytext[0]; return MAS; }
"="     { yylval.sym = yytext[0]; return IGUAL; }
"{"      { yylval.sym = yytext[0]; return LA; }
"}"      { yylval.sym = yytext[0]; return LC; }
"<"      { yylval.sym = yytext[0]; return MEQ; }
">"      { yylval.sym = yytext[0]; return MAQ; }
";"      { yylval.sym = yytext[0]; return PC; }
<<EOF>>  { return 0; }
[ \t\n]+ { }
.        { cerr << "Unrecognized token!" << endl; exit(1); }
%%

%{
#include "genCodigo.tab.hpp"
#include <iostream>
using namespace std;
%}

%option noyywrap


%%
[a-z]+     { yylval.lexema = strdup(yytext); return ID;}
"+"      { yylval.sym = yytext[0]; return OPA; }
"-"      { yylval.sym = yytext[0]; return MI; }
"*"      { yylval.sym = yytext[0]; return OPM; }
"("      { yylval.sym = yytext[0]; return LP; }
")"      { yylval.sym = yytext[0]; return RP; }
"="      { yylval.sym = yytext[0]; return EQ; }
";"      { yylval.sym = yytext[0]; return STOP; }
<<EOF>>  { return 0; }
[ \t\n]+ { }
.        { cerr << "Unrecognized token!" << endl; exit(1); }
%%

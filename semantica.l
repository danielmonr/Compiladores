%{
#include "semantica.tab.hpp"
#include <iostream>
using namespace std;
%}

%option noyywrap

NUM [0-9]+

%%

{NUM}    { yylval.val = atoi(yytext); return NUM; }
"+"     { return MAS; }
"*"     { return POR; }
"("      { return PA; }
")"      { return PC; }
";"      { return STOP; }
<<EOF>>  { return 0; }
[ \t\n]+ { }
.        { cerr << "Unrecognized token!" << endl; exit(1); }
%%

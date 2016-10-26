%{
#include "gramatica.tab.hpp"
#include <iostream>
using namespace std;
%}

%option noyywrap

ID [a-z][a-z0-9]*

%%

{ID}                  { return ID; }
"+"     { return MAS; }
"*"     { return POR; }
"("      { return LA; }
")"      { return LC; }
<<EOF>>  { return 0; }
[ \t\n]+ { }
.        { cerr << "Unrecognized token!" << endl; exit(1); }
%%

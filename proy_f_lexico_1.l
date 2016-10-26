%{
#include <iostream>
using namespace std;
%}

%option noyywrap

DIGIT [0-9]
ID [a-z][a-z0-9]*

%%

"|#physics_start"  { cout << "Inicio de programa\n"; }
"#end" 	{ cout << "Fin del programa\n" ;}
pos		{ cout <<  "POS\n"; }
tiempo	{ cout <<  "TMP\n"; }
obj		{ cout <<  "OBJ\n"; }
if       { cout <<  "IF\n"; }
else     { cout <<  "ELSE\n"; }
":"		 { cout <<  "DP\n"; }
done	 { cout <<  "DONE\n"; }
for		 { cout <<  "FOR\n"; }
to 		 { cout <<  "TO\n"; }
int      { cout <<  "INT\n"; }
{ID}                  { cout <<  "ID\n"; }
{DIGIT}+              { cout <<  "ENTERO\n"; }
"+"     { cout <<  "MAS\n"; }
"="     { cout <<  "IGUAL\n"; }
"("      { cout <<  "PA\n"; }
")"      { cout <<  "PC\n"; }
"<"      { cout <<  "MEQ\n"; }
">"      { cout <<  "MAQ\n"; }
";"      { cout <<  "PC\n"; }
"."		 { cout <<  "PT\n"; }

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
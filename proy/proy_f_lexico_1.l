%{
#include <iostream>
using namespace std;
%}

%option noyywrap

DIGIT [0-9]
ID [a-z][a-z0-9]*
CA \"[a-z0-9]*\"

%%

"|#physics_start"  { return INI; }
"#end" 	{ return END;}
"pos"		{ return POS; }
"tiempo"	{ return TMP; }
"obj"		{ return OBJ; }
"if"       { return IFT; }
"else"     { return ELSE; }
":"		 { return DP; }
"done"	 { return DONE; }
"to" 		 { return TO; }
"int"      { return INT; }
{ID}                  { return ID; }
{DIGIT}+              { return ENT; }
{CA}				{ return CADENA;}
"+"     { return MAS; }
"-"		{ return MENOS; }
"*"		{ return POR; }
"/"		{ return DIV; }
"="     { return IG; }
"("      { return AP; }
")"      { return CP; }
"["      { return AC; }
"]"      { return CC; }
"<"      { return MINQ; }
">"      { return MAX; }
";"      { return PC; }
"."		 { return PT; }
","		 { return CO; }
"movimiento_horizontal"		{ return MH; }
"tiro_parabolico"			{ return TIRO; }
"x"							{ return X; }
"y"							{ return Y; }
"imprimir"					{ return IMPT; }



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

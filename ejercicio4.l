%{
#include <math.h>

int p,r,c;
p = r = c = 0;
}%

PALABRA [A-Za-z]+
RENGLON \n
CHAR .

%%

{PALABRA} {
	c += strlen(yytext);
	++p;
}

{RENGLON} {
	++r;
}

{CHAR} {
	++c;
}

%%

main(int argc, char **argv )
{
	++argv, --argc;
	if(argc > 0 ){
		yyin = fopen(argv[0], "r");
	}
	else {
		printf("Inserte un archivo de param\n");
		return 1;
	}
	yylex();
	printf("palabras: %d\nrenglones: %d\ncaracteres: %d\n", p,r,c);
}

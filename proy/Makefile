ALL: proy
.PHONY=clean

clean:
	\rm -f proy *.yy.c *.tab.cpp *.tab.hpp

lexico.yy.c: proy_f_lexico_1.l
	flex -o lexico.yy.c proy_f_lexico_1.l

gramatica.tab.cpp: gramatica.ypp
	bison -d gramatica.ypp

proy: lexico.yy.c gramatica.tab.cpp
	g++ -o proy gramatica.tab.cpp lexico.yy.c

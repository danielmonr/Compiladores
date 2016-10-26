ALL: parser
.PHONY=clean gram if_else semantica

clean:
	\rm -f parser gram *.yy.c if_else semantica *.tab.cpp *.tab.hpp

gram: gramatica.tab.cpp lex.yy.c
	g++ -o gram gramatica.tab.cpp lex.yy.c

gramatica.tab.cpp: gramatica.ypp
	bison -d gramatica.ypp

lex.yy.c: gramatica.l
	flex gramatica.l

parser: tarea2.c
	gcc tarea2.c -o parser

if_else.yy.c: miniparser.l
	flex -o if_else.yy.c miniparser.l

miniparser.tab.cpp: miniparser.ypp
	bison -d miniparser.ypp

if_else: miniparser.tab.cpp if_else.yy.c
	g++ -o if_else miniparser.tab.cpp if_else.yy.c

semantica.tab.cpp: semantica.ypp
	bison -d semantica.ypp

semantica.yy.c: semantica.l
	flex -o semantica.yy.c semantica.l

semantica: semantica.tab.cpp semantica.yy.c
	g++ -o semantica semantica.tab.cpp semantica.yy.c
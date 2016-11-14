ALL: tarea
.PHONY=clean

clean:
	\rm -f tarea *.yy.c *.tab.cpp *.tab.hpp

lexico.yy.c: Monzalvo_1021514.l
	flex -o lexico.yy.c Monzalvo_1021514.l

Monzalvo_1021514.tab.cpp: Monzalvo_1021514.ypp
	bison -d Monzalvo_1021514.ypp

tarea: lexico.yy.c Monzalvo_1021514.tab.cpp
	g++ -o tarea Monzalvo_1021514.tab.cpp lexico.yy.c

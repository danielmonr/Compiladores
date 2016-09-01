ALL: parser
.PHONY=clean

clean:
	\rm -f parser

parser: tarea2.c
	gcc tarea2.c -o parser

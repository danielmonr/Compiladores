#include <stdlib.h>
#include <stdio.h>
#include <unistd.h>
#include <string.h>


char terminales[] = {'i', 'e', 't', 'p', 'n', 'f', 'm', 'r', 'd', '<', '>', '=', '+', ';', 'v', '{', '}'};
char no_terminales[] = {'P', 'D', 'C', 'U', 'T', 'E', 'I', 'S', 'M', 'Q'};

enum Bool {false, true};
typedef enum Bool bool;

// EMPIEZA IMPLEMENTACION COLA //

struct Nodo
{
	char valor;
	struct Nodo* siguiente;
};

typedef struct Nodo nodo_t;

struct Cola
{
	nodo_t* primero;
	int tamano;
};

typedef struct Cola cola_t;

int vaciarCola(cola_t* q);
nodo_t* nuevoNodo(char c);
int meter(cola_t* q, char c);
char sacar(cola_t* q);
bool vacia(cola_t* q);
int eliminarNodo(nodo_t* n);
int imprimirCola(cola_t* q);
int imprimirNodo(nodo_t* n);

// FIN IMPLEMENTACION COLA //

// FUNCIONES DE NODOS NO TERMINALES //
bool P(cola_t* q);
bool D(cola_t* q);
bool C(cola_t* q);
bool U(cola_t* q);
bool T(cola_t* q);
bool E(cola_t* q);
bool I(cola_t* q);
bool S(cola_t* q);
bool M(cola_t* q);
bool Q(cola_t* q);

typedef bool (*rutina)();

int main(int argc, char* argv[]){
	if(argc < 2){
		printf("Porfavor ponga la cadena a revisar como parametro y sin espacios.\n");
		return 0;
	}
	else if(argc > 2){
		printf("Error! Numero de parametros incorrecto.\n");
	}

	//char* cadena = argv[1];
	
	cola_t* queue = (cola_t*)malloc(sizeof(cola_t));
	queue->tamano = 0;
	queue->primero = NULL;

	int i;
	for(i = strlen(argv[1]); i > 0; --i){
		meter(queue, *(argv[1] +i -1));
	}

	if(vacia(queue)){
		printf("vacia\n");
		return 0;
	}

	//imprimirCola(queue);

	if(P(queue)){
		printf("Correcto\n");
	}
	else{
		printf("Error en la gramatica.\n");
	}

/*
	meter(queue, 'a');
	meter(queue, 'b');

	if(vacia(queue))
		printf("vacia\n");
	else
		imprimirCola(queue);
*/
	vaciarCola(queue);
	free(queue);



	return 0;
}

// FUNCIONES DE RUTINAS //

bool P(cola_t* q){
	//printf("entro\n");
	char c;
	c = sacar(q);
	if(c != 'p'){
		meter(q, c);
		return false;
	}
	c = sacar(q);
	if(c != 'd'){
		meter(q, c);
		return false;
	}
	c = sacar(q);
	if(c != '{'){
		meter(q, c);
		return false;
	}

	if(!D(q))
		return false;
	//printf("paso D\n");
	if(!C(q))
		return false;
	//printf("paso C\n");
	c = sacar(q);
	if(c != '}'){
		meter(q, c);
		return false;
	}

	if(vacia(q))
		return true;
	printf("Caracteres de mas.\n");
	return false;
}
bool D(cola_t* q){
	char c;
	c = sacar(q);
	if(c != 'v'){
		meter(q, c);
		if(!U(q))
			return false;
		if(!D(q))
			return false;
	}

	return true;
}
bool C(cola_t* q){
	char c;
	c = sacar(q);
	if(c != 'v'){
		//printf("paso v\n");
		meter(q, c);
		if(!E(q))
			return false;
		//printf("paso E\n");
		if(!C(q))
			return false;
	}

	return true;
}
bool U(cola_t* q){
	if(!T(q))
		return false;
	char c = sacar(q);
	if(c != 'd'){
		meter(q, c);
		return false;
	}
	char pc = sacar(q);
	if(pc != ';'){
		meter(q,pc);
		meter(q,c);
		return false;
	}
	return true;
}
bool T(cola_t* q){
	char c;
	c = sacar(q);
	if(c != 'n' && c != 'f'){
		meter(q, c);
		return false;
	}
	return true;
}
bool E(cola_t* q){
	if(!S(q)){
		//printf("paso S\n");
		if(!I(q))
			return false;
	}
	//printf("paso S\n");

	return true;
}
bool I(cola_t* q){
	if(sacar(q) != 'i')
		return false;
	if(!M(q))
		return false;
	if(sacar(q) != 't')
		return false;
	if(!E(q))
		return false;
	if(sacar(q) != 'e')
		return false;
	if(!E(q))
		return false;
	return true;
}
bool S(cola_t* q){
	//printf("S\n");
	cola_t* buff = (cola_t*) malloc (sizeof(cola_t));
	buff->tamano = 0;
	//printf("paso alloc\n");
	char c = sacar(q);
	if(c != 'd'){
		meter(q, c);
		return false;
	}
	meter(buff, c);
	c = sacar(q);
	if(c != '='){
		meter(q, c);
		while(!vacia(buff)){
			meter(q, sacar(buff));
		}
		return false;
	}
	//printf("paso 1\n");
	meter(buff, c);
	c = sacar(q);
	if(c != 'd'){
		meter(q, c);
		while(!vacia(buff)){
			meter(q, sacar(buff));
		}
		return false;
	}
	meter(buff, c);
	c = sacar(q);
	if(c != '+'){
		meter(q, c);
		while(!vacia(buff)){
			meter(q, sacar(buff));
		}
		return false;
	}
	//printf("paso 2\n");
	meter(buff, c);
	c = sacar(q);
	if(c != 'r'){
		meter(q, c);
		while(!vacia(buff)){
			meter(q, sacar(buff));
		}
		return false;
	}
	meter(buff, c);
	c = sacar(q);
	if(c != ';'){
		meter(q, c);
		while(!vacia(buff)){
			meter(q, sacar(buff));
		}
		return false;
	}
	//printf("paso 3\n");

	//vaciarCola(buff);
	//printf("paso 4\n");
	free(buff);
	return true;
}
bool M(cola_t* q){
	printf("M\n");
	if(sacar(q) != 'd')
		return false;
	if(!Q(q))
		return false;
	if(sacar(q) != 'm')
		return false;
	return true;
}
bool Q(cola_t* q){
	char c = sacar(q);
	if(c != '<' && c != '>')
		return false;
	return true;
}


// FUNCIONES DE LA COLA

int vaciarCola(cola_t* q){
	if(vacia(q))
		return 0;
	eliminarNodo(q->primero);
	q->tamano = 0;

	return 1;
}

int eliminarNodo(nodo_t* n){
	if(n->siguiente != NULL){
		eliminarNodo(n->siguiente);
	}
	free(n);
	return 1;
}

nodo_t* nuevoNodo(char c){
	nodo_t* n = (nodo_t*)malloc(sizeof(nodo_t));
	n->valor = c;
	n->siguiente = NULL;
	return n;
}

int meter(cola_t* q, char c){
	nodo_t* n = nuevoNodo(c);
	n->siguiente = q->primero;
	q->primero = n;
	q->tamano++;

	return 1;
}

char sacar(cola_t* q){
	if(vacia(q))
		return 0;
	char c;

	nodo_t* n = q->primero;
	q->primero = n->siguiente;
	q->tamano--;
	c = n->valor;
	free(n);
	return c;
}

bool vacia(cola_t* q){
	if(q->tamano == 0)
		return true;
	return false;

}

int imprimirCola(cola_t* q){
	if(vacia)
		printf("Cola vacia\n");
	nodo_t* temp = q->primero;
	while(temp != NULL){
		imprimirNodo(temp);
		temp = temp->siguiente;
	}
	printf("\n");
	return 1;
}
int imprimirNodo(nodo_t* n){
	printf("%c ", n->valor);
	return 1;
}
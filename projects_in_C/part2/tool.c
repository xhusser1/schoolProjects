// Implement your cycle count tool here.
// compile with: gcc tool.c -o tool
// run with: ./tool

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>
int main(int argc, char* argv[]){

	
	FILE* myFile;

	myFile = fopen(argv[1], "r");

	
	if (NULL == myFile){
		fprintf(stderr, "barebones.s not found\n");
		fprintf(stderr, "Program terminating now...\n");
		exit(1);
	}
	

	char buffer[255];
	int addCount = 0;
	int movCount = 0;
	int mulCount = 0;
	int subCount = 0;
	int divCount = 0;
	int leaCount = 0;
	int pushCount = 0;
	int popCount = 0;
	int retCount = 0;
	
	while(fscanf(myFile, "%s", buffer) != EOF){
		int i = 0;
		for (i = 0; i < buffer[i]; i++) {
			tolower(buffer[i]);
		}	
		if (strcmp(buffer, "add") == 0 || strcmp(buffer, "addq") == 0 
		|| strcmp(buffer, "addl") == 0 ){
			addCount++;
		}
		if (strcmp(buffer,"mov") == 0 || strcmp(buffer, "movq") == 0
		|| strcmp(buffer, "movl") == 0){
			movCount++;
		}
		if (strcmp(buffer, "mul") == 0 || strcmp(buffer, "mulq") == 0
		|| strcmp(buffer, "mull") == 0){
			mulCount++;
		}
		if (strcmp(buffer, "div") == 0 || strcmp(buffer, "divq") == 0
                || strcmp(buffer, "divl") == 0){
                        divCount++;
                }
		if (strcmp(buffer, "sub") == 0 || strcmp(buffer, "subq") == 0
                || strcmp(buffer, "subl") == 0){
                        subCount++;
                }
		if (strcmp(buffer, "lea") == 0 || strcmp(buffer, "leaq") == 0
                || strcmp(buffer, "leal") == 0){
                        leaCount++;
                }
		if (strcmp(buffer, "push") == 0 || strcmp(buffer, "pushq") == 0
                || strcmp(buffer, "pushl") == 0){
                        pushCount++;
                }
		if (strcmp(buffer, "pop") == 0 || strcmp(buffer, "popq") == 0
                || strcmp(buffer, "popl") == 0){
                        popCount++;
                }
		if (strcmp(buffer, "ret") == 0 || strcmp(buffer, "retq") == 0
                || strcmp(buffer, "retl") == 0){
                        retCount++;
                }
	}
	
	printf("ADD count: %d\n", addCount);
	printf("SUB count: %d\n", subCount);
	printf("MUL count: %d\n", mulCount);
	printf("DIV count: %d\n", divCount);
	printf("MOV count: %d\n", movCount);
	printf("LEA count: %d\n", leaCount);
	printf("PUSH count: %d\n", pushCount);
	printf("POP count: %d\n", popCount);
	printf("RET count: %d\n", retCount);

	int totalCount = addCount + subCount + mulCount + divCount + movCount + leaCount
	+ pushCount + popCount + retCount;

	int totalCycle = addCount*1 + subCount*1 + mulCount*2 + divCount*83 + movCount*1 
	+ leaCount*1 + pushCount*1 + popCount*3 + retCount*2;

	printf("Total instuctions = %d\n", totalCount);
	printf("Total cycles = %d\n", totalCycle);

	
	fclose(myFile);
	
	return 0;
}


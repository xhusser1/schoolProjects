// Write a C program that swaps two integers(in the main body of code).
#include <stdio.h>

int main(){
	int a = 10;
	int b = 20;
	printf("initial value of a is %d\n", a);
	printf("initial value of b is %d\n", b);
	int temp = a;
	a = b; 
	b = temp;
	printf("new value of a is %d\n", a);
	printf("new value of b is %d\n", b);
	return 0;
}


	

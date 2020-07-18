// Write a C program that swaps two integers in a function.
#include <stdio.h>
void swap(int *a, int *b){
	int temp = *b;
	*a = *b;
	*b = temp;
}
int main() {
	int a = 10;
	int b = 20;
	printf("initial value of a is %d\n", a);
	printf("initial value of b is %d\n", b);
	swap(&a, &b);
	printf("new value of a is %d\n", a);
	printf("new value of a is %d\n", b);
	return 0;
}



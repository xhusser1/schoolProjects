// Write a C program called array.c that has an array of 400 integers in the function of main.
#include <stdio.h>
int main() {
	int array[400];
	array[0] = 72;
	array[70] = 56;
	printf("Element at index 70 is %d\n", array[70]);
	printf("Element at index 0 is %d\n", array[0]);
	return 0;
}

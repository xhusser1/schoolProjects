// Write a C program called array2.c that has an array of 400 integers in the function of main that is dynamically allocated.
#include <stdio.h>
int main(){
	int myArray[400];
	myArray[66] = 712;
	myArray[70] = 536; 
	printf("Element at index 66 is %d\n", myArray[66]);
	printf("Element at index 70 is %d\n", myArray[70]);
	return 0;
}

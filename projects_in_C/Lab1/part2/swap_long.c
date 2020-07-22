// Now modify your program to swap two long's.
#include <stdio.h>

int main(){
	long a = 10;
	long b = 20;
	printf("initial value of a is %ld\n", a);
	printf("initial value of b is %ld\n", b);
	long temp = a;
	a = b; 
	b = temp;
	printf("new value of a is %ld\n", a);
	printf("new value of b is %ld\n", b);
	return 0;
}

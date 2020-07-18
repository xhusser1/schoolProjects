// Write a C program that calls an add function(long add(long a, long b).
#include <stdio.h>
long addFunction(long a, long b){
	long result;
	result = a + b;
	return result;
}

int main(){
	long n1 = 10;
	long n2 = 20;
	long sum = addFunction(n1, n2);
	printf("The sum is %ld\n", sum);
	return 0;
} 

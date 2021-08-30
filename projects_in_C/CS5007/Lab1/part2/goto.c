// Write a C program using the goto command and a label.
#include <stdio.h>

void checkEvenOrOdd(int num){
	if (num % 2 == 0){
		goto even;
	}
	else {
		goto odd;
even:
	printf("%d is even", num);
	return;
odd:
	printf("%d is odd", num);
	}
}

int main(){
	int num = 26;
	checkEvenOrOdd(num);
	return 0;
} 

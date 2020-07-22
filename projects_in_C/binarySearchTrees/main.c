// Compile this assignment with: gcc main.c -o main
//
// Include parts of the C Standard Library
// These have been written by some other really
// smart engineers.
#include <stdio.h>  // For IO operations
#include <stdlib.h> // for malloc/free

// Our library that we have written.
// Also, by a really smart engineer!
#include "my_bst.h"
// Note that we are locating this file
// within the same directory, so we use quotations
// and provide the path to this file which is within
// our current directory.

// ====================================================
// ================== Program Entry ===================
// ====================================================
int main(){
	bst_t * testBST = create_bst();
	bst_empty(testBST);
    	bst_add(testBST, 7);
    	bst_add(testBST, 8);
	bst_add(testBST, 9);
    	bst_size(testBST);
    	bst_print(testBST, 0);
	bst_print(testBST, 1);
    	sum(testBST);
    	find(testBST,7);
    	free_bst(testBST);
	return 0;
}

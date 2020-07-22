// =================== Support Code =================
// // Binary Search Tree ( BST ).
// //
// //
// //
// // - Implement each of the functions to create a working BST.
// // - Do not change any of the function declarations
// //   - (i.e. bst_t* create_bst() should not have additional arguments)
// // - You should not have any 'printf' statements in your BST functions. 
// //   - (You may consider using these printf statements to debug, but they should be removed from your final version)
// // ==================================================
#ifndef MYBST_H
#define MYBST_H

// Create a node data structure to store data within
// // our BST. In our case, we will stores 'integers'.
typedef struct node{
	int data;
	struct node* rightChild;
  	struct node* leftChild;
}node_t;

// Create a BST data structure
// // Our BST holds a pointer to the root node in our BST called root.
typedef struct BST{
    int count;		// count keeps track of how many items are in the BST.
    node_t* root;		// root points to the root node in our BST.
}bst_t;

// Creates a BST
// // Returns a pointer to a newly created BST.
// // The BST should be initialized with data on the heap.
// // The BST fields should also be initialized to default values.
bst_t* create_bst(){
    // Modify the body of this function as needed.
    bst_t* myBST= malloc(sizeof(bst_t));
	if (myBST != NULL){
		myBST->count = 0;
                myBST->root = NULL;
        }   
        return myBST;
}

node_t* create_node(int data){
    node_t* newNode = malloc(sizeof(node_t));
    if (newNode != NULL){
        newNode->data = data;
        newNode->leftChild= NULL;
        newNode->rightChild;
    }
}


// BST Empty
// // Check if the BST is empty
// // Returns 1 if true (The BST is completely empty)
// // Returns 0 if false (the BST has at least one element enqueued)
int bst_empty(bst_t* t){
    if (t->count == 0){
        return 1;
    }
    else {
        return 0;

    }
}

void addHelper(node_t* node, node_t* newNode){
    if (node == NULL){
        return;
    }
    if (newNode->data < node->data) {
        if (node->leftChild == NULL) {
            node->leftChild = newNode;
        } else if (node->leftChild != NULL) {
            addHelper(node->leftChild, newNode);
        }
    }
    else {
        if (node->rightChild == NULL) {
            node->rightChild = newNode;
        }
        else{
            addHelper(node->rightChild, newNode);
        }
     }
}

// Adds a new node containing item in the correct place of the BST.
// // If the data is less then the current node we go right, otherwise we go left.
// // Same as described in the README.md file.
// // Returns a -1 if the operation fails (otherwise returns 0 on success).
// // (i.e. the memory allocation for a new node failed).
// // It should run in O(log(n)) time.
int bst_add(bst_t* t, int item){
    node_t* newNode = create_node(item);
    newNode->data = item;
    newNode->rightChild = NULL;
    newNode->leftChild = NULL;


    if (t->root == NULL) {
        t->root = newNode;
        t->count++;
        return 0;
    }
    else if (t->root != NULL){
        addHelper(t->root, newNode);
        t->count++;
        return 0;
    }
    else {
        return -1;
    }
}

void printHelperAscending(node_t* node, int order){
    
    if (node == NULL){
        return;
    }
    if(order == 0) {
        printf("%d\n", node->data);
        printHelperAscending(node->leftChild, order);
        printHelperAscending(node->rightChild, order);
    }

}

void printHelperDescending(node_t* node, int order){
    if (node == NULL){
        return;
    }
    if (order != 0) {
        printHelperDescending(node->leftChild, order);
        printHelperDescending(node->rightChild, order);
        printf("%d\n", node->data);
    }
}
// Prints the tree in ascending order if order = 0, otherwise prints in descending order.
// // For NULL tree it should print nothing.
// // It should run in O(n) time.
void bst_print(bst_t*t, int order){
    if(bst_empty(t) == 1){
        return;
    }
    if (order == 0){
        printHelperAscending(t->root, order);
    }
    else {
        printHelperDescending(t->root, order);
    }
}

int sumHelper(node_t * node){
    if (node != NULL){
       return  node->data + sumHelper(node->rightChild) + sumHelper(node->leftChild);
    }
    else {
        return 0;
    }
}

// Returns the sum of all the nodes in the tree.
// exits the program for a NULL tree.
// It should run in O(n) time.
int sum(bst_t *t){
    if (bst_empty(t) == 1){
        return 0;
    }
    int result = sumHelper(t->root);
    printf("sum is %d\n", result);
    return result;
}

int findHelper(node_t* node, int value){
    if (node != NULL){
        if (node->data == value){
            return value;
        }
        else{
            findHelper(node->leftChild, value);
            findHelper(node->rightChild, value);
        }
    }
    return 0;
}

// Returns 1 if value is found in the tree, 0 otherwise.
// For NULL tree it exists the program.
// It should run in O(log(n)) time.
int find(bst_t * t, int value){
    if (bst_empty(t) == 1){
        return -1;
    }
    int resultFind = findHelper(t->root, value);
    printf("value is %d\n", resultFind);
    return resultFind;
}

// BST Size
// Queries the current size of the BST
// A BST that has not been previously created will crash the program.
// (i.e. A NULL BST cannot return the size)
unsigned int bst_size(bst_t* t){
    if (t == NULL){
        return -1;
    }
    else {
        printf("size is %d\n", t->count);
        return t->count;
    }
}

void freeHelper(node_t* node){
    if (node == NULL){
        return;
    }
    freeHelper(node->leftChild);
    freeHelper(node->rightChild);
    free(node);
}

// Free BST
// Removes a BST and ALL of its elements from memory.
// This should be called before the program terminates.
void free_bst(bst_t* t){
    if (t == NULL){
        return;
    }
    	freeHelper(t->root);
	free(t);
}

#endif

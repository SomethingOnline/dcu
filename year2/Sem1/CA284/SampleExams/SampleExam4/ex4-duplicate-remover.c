#include <stdio.h>
#include <stdlib.h>

typedef struct Node Node;
struct Node {
    int value;
    Node *next;
};

Node* populateLinkedList(int *n, char *argv[]);
void printList(Node *start);
Node* duplicateRemoval(Node* start);
void freeList(Node* start);
int main(int argc, char *argv[])
{
    Node *start = NULL;
    int n = argc - 1;
    // Populate the linked list
    start = populateLinkedList(&n, argv);
    // Remove duplicates
    start = duplicateRemoval(start);
    // Print the updated linked list
    printList(start);
    // Free allocated memory
    freeList(start);
    return 0;
}

Node* populateLinkedList(int *n, char *argv[]) 
{
    Node *current, *first;
    first = (Node*)calloc(1, sizeof(Node));
    if (!first) 
    {
        printf("Allocation failed");
        return NULL;
    }
    current = first;
    current->value = atoi(argv[1]);
    for (int i = 1; i < *n; ++i) 
    {
        current->next = (Node*)calloc(1, sizeof(Node));
        if (!current->next) 
        {
            printf("Allocation failed");
            freeList(first);
            return NULL;
        }
        current = current->next;
        current->value = atoi(argv[i + 1]);
    }
    current->next = NULL;
    return first;
}

void printList(Node *start) 
{
    Node *p = NULL;
    for (p = start; p != NULL; p = p->next) 
    {
        printf("%d\n", p->value);
    }
}
Node* duplicateRemoval(Node* start) 
{
    Node* p = start;
    Node* prev = NULL;

    while (p != NULL) 
    {
        int currentValue = p->value;
        int hasDuplicate = 0;
        Node* q = p->next;
        Node* qPrev = p;
        // Check for duplicates and remove both nodes
        while (q != NULL) {
            if (q->value == currentValue) 
            {
                hasDuplicate = 1;
                // Remove the duplicated node
                Node* temp = q;
                q = q->next;
                qPrev->next = q;
                free(temp);
            } 
            else 
            {
                qPrev = q;
                q = q->next;
            }
        }
        // If a duplicate was found, remove the original node as well
        if (hasDuplicate) 
        {
            if (prev != NULL) 
            {
                // The original node is not the first node
                prev->next = p->next;
                free(p);
                p = prev->next;
            } 
            else 
            {
                // The original node is the first node
                start = p->next;
                free(p);
                p = start;
            }
        } 
        else 
        {
            // Move to the next node
            prev = p;
            p = p->next;
        }
    }
    return start;
}
void freeList(Node* start) 
{
    Node* current = start;
    while (current != NULL) 
    {
        Node* next = current->next;
        free(current);
        current = next;
    }
}
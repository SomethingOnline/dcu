#include<stdio.h>
#include<stdlib.h>

typedef struct Node Node;
struct Node{
    int value;
    Node *prev;
    Node *next;
};

Node* populateList(int *array);
void printList(Node* start);
Node* add_element(Node* start, int match, int element);

int main(int argc, char*argv[])
{
    int array[10] = {8, 7, 3, 4, 5, 6, 9, 2, 14, 12};
    Node* start = NULL;
    start = (Node*)calloc(1, sizeof(Node));
    start = populateList(array);
    add_element(start, atoi(argv[1]), atoi(argv[2]));
    printList(start);
    return 0;
}

Node* populateList(int *array)
{
    Node *curr, *first, *prev;
    first = (Node*)calloc(1, sizeof(Node));
    curr = first;
    curr->value = array[0];
    curr->prev = NULL;
    for (int i = 1; i < 10; ++i)
    {
        curr->next = (Node*)calloc(1, sizeof(Node));
        prev = curr;
        curr = curr->next;
        curr->value = array[i];
        curr->prev = prev;    
    }

    curr->next = NULL;
    return first;
}
void printList(Node* start)
{
    Node* p = NULL;
    for (p = start; p != NULL; p = p->next)
    {
        printf("%d\n", p->value);
    }
}
Node* add_element(Node* start, int match, int element)
{
    Node* p = NULL;
    Node *curr, *prev, *newNode;
    for (p = start; p != NULL; p = p->next)
    {
        if (p->value == match)
        {
            newNode = (Node*)calloc(1, sizeof(Node));
            newNode->value = element;
            newNode->prev = p;
            newNode->next = p->next;
            if (p->next != NULL)
            {
                p->next->prev = newNode;
            }
            p->next = newNode;


        }
    }
    return start;
}


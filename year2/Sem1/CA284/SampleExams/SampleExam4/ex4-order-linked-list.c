#include <stdio.h>
#include <stdlib.h>

typedef struct Node Node;
struct Node{
    int value;
    Node *next;
    Node *prev;
};

Node* populateLinkedList(int *n, char *argv[]);
void checkDescending(Node *last, int *status);
int main(int argc, char *argv[])
{
    Node *last = NULL;
    int n = argc - 1;
    int status = 0;
    last = populateLinkedList(&n, argv);
    checkDescending(last, &status);
    printf("%d\n", status);

}
Node* populateLinkedList(int *n, char *argv[])
{
    Node *current, *first, *prev;
    first = (Node*)calloc(1, sizeof(Node*));
    if (!first)
    {
        printf("Allocation failed");
        return 0;
    }
    current = first;
    current->prev = NULL;
    current->value = atoi(argv[1]);
    for (int i = 1; i < *n; ++i)
    {
        current->next = (Node*)calloc(1, sizeof(Node*));
        prev = current;
        current = current->next;
        current->prev = prev;
        current->value = atoi(argv[i + 1]);
    }
    current->next = NULL;
    return current;
}
void checkDescending(Node *last, int *status)
{
    Node *p = NULL;
    for (p = last; p != NULL; p = p->prev)
    {
        if (p->prev != NULL)
        {
            if ((p->value) > (p->prev->value))
            {
                *status = 0;
                break;
            }
            *status = 1;
        }
    }
}

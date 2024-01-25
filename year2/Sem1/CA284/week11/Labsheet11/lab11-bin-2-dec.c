#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <math.h>

/*Type definitions*/
typedef struct Node Node;

/* Structure definitions*/
struct Node
{
    int data;
    Node *next;
};

/*Function prototypes*/
Node *linked_list(int *length, char *argv[]);
Node *new_node();
void bin_to_dec(Node *head, int *dec_val, int *length);

/*Main driver function*/
int main(int argc, char *argv[])
{
    int length = argc - 1;
    Node *head = NULL;
    int *dec_val = (int *)calloc(1, sizeof(int *));

    head = linked_list(&length, argv);
    bin_to_dec(head, dec_val, &length);

    printf("%d\n", *(dec_val));
    free(dec_val);
    dec_val = NULL;

    return 0;
}

Node *linked_list(int *length, char *argv[])
{
    Node *head, *current;
    head = new_node();
    current = head;
    for (int i = 0; i < *length; ++i)
    {

        if (8 <= i)
        {
            printf("Too many binary digits entered.\n");
            exit(0);
        }

        else if (strcmp(argv[i + 1], "1") == 0 || strcmp(argv[i + 1], "0") == 0)
        {
            current->data = atoi(argv[i + 1]);

            current->next = new_node();

            current = current->next;
        }
        else
        {
            printf("Only digits 1 and 0 are permitted.\n");
            exit(0);
        }
    }
    current->next = NULL;
    return head;
}

Node *new_node()
{
    Node *node = (Node *)calloc(1, sizeof(Node *));
    if (!node)
    {
        printf("Error making new node!");
        exit(1);
    }
    return node;
}

void bin_to_dec(Node *head, int *dec_val, int *length)
{
    Node *current;
    current = head;

    for (int i = 0; current->next; ++i)
    {
        *(dec_val) += current->data * pow(2, (*length - i - 1));

        current = current->next;
    }
}
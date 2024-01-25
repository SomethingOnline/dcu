#include <stdio.h>
#include <stdlib.h>
#include <string.h>


int sym(char string[], int len);

int main(int argc, char* argv[])
{
    int result;
    char string[50];
    strcpy(string, argv[1]);
    int len = strlen(string);
    result = sym(string, len);
    if (result == 1)
    {
        printf("yes");
    }
    else
    {
        printf("no");
    }
    return 0;
}

int sym(char string[], int len)
{
    char t[50];
    strcpy(t, string);
    int i;
    for (i = 0; i < len; i++)
    {
        t[i] = string[len - i - 1];
    }
    // printf("%s\n", string);
    // printf("%s\n", t);
    if (strcmp(string, t) == 0)
    {
        return 1;
    }
    else
    {
        return 0;
    }
}
// int main(int argc, char* argv[])
// {
//     char myString[50];
//     // strcpy(myString, argv[1]);
//     int length = strlen(argv[1]);
//     char t[50];
//     strcpy(t, myString);
//     for (int i = 0; i < length; i++)
//     {
//         t[i] = myString[length - i - 1];
//     }
//     printf("%s\n", myString);
//     printf("%s\n", t);
//     if (strcmp(myString, t) == 0)
//     {
//         printf("yes\n");
//     }
//     else
//     {
//         printf("no\n");
//     }
// }
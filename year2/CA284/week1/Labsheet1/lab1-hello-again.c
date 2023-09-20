/*
Program: lab1-hello_again.c
Author: Jack Egan
Input: Jack
Output: Print out the given name
*/

/* includes */
#include <stdio.h>
#include <stdlib.h> /* a header file with a function we might need */

int main(int argc, char * argv[])
{
    printf("Hello %s\n", argv[1]);
    return (0);
}

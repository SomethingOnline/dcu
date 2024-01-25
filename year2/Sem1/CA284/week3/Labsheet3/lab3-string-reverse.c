#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main(int argc, char*argv[])
{
    char myString[50];

    strcpy(myString, argv[1]);
    int len = strlen(myString);
    int temp;
    int array[50]; 
    for (int i = 0; i < len/2; i++)  
    {  
        temp = myString[i];  
        myString[i] = myString[len - i - 1];  
        myString[len - i - 1] = temp;  
    }  
    printf("%s\n", myString);
}

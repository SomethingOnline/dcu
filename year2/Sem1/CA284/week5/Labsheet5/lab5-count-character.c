#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>

int main(int argc, char*argv[])
{

    char *search = argv[1];         // a
    char *str = argv[2];            // "abcxyza"

    char *pGot_char = str;         // pGot_char pointing to *str therefore taking str Value[0]
    int count = 0;
    // printf("%s\n", search);      // string value of a

    char searchChar = *search;
    // printf("%d", searchChar);        / int value of a


    while (pGot_char = strchr(pGot_char, searchChar))
    {
        ++count;
        ++pGot_char;
    }
    if (count == 0)
    {
        printf("0");
    }
    else
    {
        printf("%d\n", count);
    }
    return 0;   
}
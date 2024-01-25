#include <stdio.h>
#include <stdlib.h>
#include <string.h>



int main(int argc, char*argv[])
{
    int matrix[3][3] = {
                   {10,20,30},
                   {40,50,60},
                   {70,80,90}
                 };

    // printf("matrix[1][2]: %d\n", matrix[1][2]); /* the normal way */
    printf("%d", *(matrix[0] + 3));
    // printf("*(matrix[1]+2): %d\n", *(matrix[1]+2)); /* pointer and array */
    // printf("*(*(matrix + 1)+2): %d\n", *(*(matrix + 2)+1)); /* using pointer only */
    // printf("*(*matrix + 5): %d\n", *(*matrix + 7)); /* using pointer only */
    // char str[] = "Peter piper picked a peck of pickled pepper.";
    // char ch = 'p';
    // char *pGot_char = str;
    // printf("%c\n", *pGot_char);

//     char str[] = "Peter piper picked a peck of pickled pepper.";    // The string to be searched
//     char ch = 'p';                             // The character we are looking for
//     char *pGot_char = str;                     // Pointer initialized to string start
//     int count = 0;                             // Number of times found
//     while(pGot_char = strchr(pGot_char, ch))   // As long as NULL is not returned...
//     {                                          // ...continue the loop.
//         ++count;                                 // Increment the count
//         ++pGot_char;                             // Move to next character address
//     }

//     printf("The character '%c' was found %d times in the following string:\n\"%s\"\n", ch, count, str);


//     return 0;
}
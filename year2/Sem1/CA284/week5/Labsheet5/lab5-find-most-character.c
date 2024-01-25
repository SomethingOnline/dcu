#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main(int argc, char *argv[]) 
{
    char *string = argv[1];

    char mostFreq = ' ';
    int maxCount = 0;

    while (*string) {
        if (*string != ' ') {  // skip whitespace
            char currChar = *string;
            int count = 0;

            char *temp = string;

            while (*temp) {
                if (*temp != ' ' && *temp == currChar) {  // compare
                    ++count;
                }
                ++temp;
            }

            if (count > maxCount) {
                maxCount = count;
                mostFreq = currChar;
            }
        }
        ++string;
    }
    printf("%c\n", mostFreq);

    return 0;
}
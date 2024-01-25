#include <stdio.h>

//function to find longets word ietarte through list stopping when a space or end of string is encountered
// then it checks if the current word is greater than the word with max length, if not it updates max lenm start and
// end. Once the loop is done another loop iterates from start to end to print the word with max length.
void longestWord(char arr[], int len){
    int i, j = 0, start = 0, end = 0, maxlen = 0;

    for (i = 0; i < len + 1; i++){
        if (arr[i] == ' ' || arr[i] == '\0') {
            if (i - j > maxlen){
                maxlen = i - j;
                start = j;
                end = i;
            }
            j = i + 1;
        }
    }

    for (int i = start; i < end; i++) {
        printf("%c", arr[i]);
    }
    printf("\n");

}
#include <stdio.h>
#include <string.h>
#include <stdlib.h>

/*Function prototypes*/
void get_text();
void print_longest(int *length, char *longest_line);

#define MAX_LINE_LENGTH 250

/*Main driver function*/
int main()
{
    get_text();
    return 0;
}

void get_text()
{
    FILE *pfile = NULL;
    char *filename = "paragraph.txt";

    pfile = fopen(filename, "r");
    if (!pfile)
    {
        printf("Error opening %s for reading. Program terminated.\n", filename);
        exit(1);
    }

    int length = 0;
    char *line = (char *)calloc(1, MAX_LINE_LENGTH);
    char *longest_line = (char *)calloc(1, MAX_LINE_LENGTH);

    while (fgets(line, MAX_LINE_LENGTH, pfile))
    {
        if (strlen(line) > length)
        {
            length = strlen(line);
            strcpy(longest_line, line);
        }
    }

    print_longest(&length, longest_line);
    fclose(pfile);
}

void print_longest(int *length, char *longest_line)
{
    printf("%d\n%s\n", *length, longest_line);
}
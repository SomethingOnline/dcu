#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>

// Define a function pointer type for comparison functions
typedef int (*CompareFunction)(int, int);

// Define a structure to represent a sentence in a linked list
struct Sentence {
    char* content;         // Content of the sentence
    int length;            // Length of the sentence
    struct Sentence* next; // Pointer to the next sentence in the linked list
};

// Function to add a new sentence to the linked list
void addSentence(struct Sentence** head, char* content, int length);

// Function to process a paragraph and create a linked list of sentences
struct Sentence* processParagraph(char* paragraph);

// Function to determine and print the result based on the specified comparison function
void determineAndPrintResult(struct Sentence* sentenceList, CompareFunction compare);

// Comparison functions for determining the longest and shortest sentences
int compareLongest(int a, int b);
int compareShortest(int a, int b);

// Function to get the appropriate comparison function based on user selection
CompareFunction getComparisonFunction(char* selection);

// Function to free the memory allocated for the linked list
void freeList(struct Sentence* head);

// Main function
int main(int argc, char* argv[]) {
    // Get paragraph and selection from command line arguments
    char* paragraph = argv[1];
    char* selection = argv[2];

    // Check if the selection is valid
    if (strcmp(selection, "shortest") != 0 && strcmp(selection, "longest") != 0) {
        printf("Not valid!\n");
        return 0;
    }

    // Process the paragraph and create a linked list of sentences
    struct Sentence* sentenceList = processParagraph(paragraph);

    // Get the appropriate comparison function based on the user's selection
    CompareFunction compareFunction = getComparisonFunction(selection);

    // Determine and print the result based on the selected comparison function
    determineAndPrintResult(sentenceList, compareFunction);

    // Free the memory allocated for the linked list
    freeList(sentenceList);

    return 0;
}

// Function to add a new sentence to the linked list
void addSentence(struct Sentence** head, char* content, int length) {
    // Allocate memory for a new sentence node
    struct Sentence* newSentence = (struct Sentence*)malloc(sizeof(struct Sentence));
    if (!newSentence) {
        printf("Allocation failed\n");
    }

    // Allocate memory for the content of the sentence
    newSentence->content = (char*)malloc(length + 1);
    if (!newSentence->content) {
        printf("Allocation failed\n");
    }

    // Copy the content and set other attributes of the new sentence
    strcpy(newSentence->content, content);
    newSentence->length = length;
    newSentence->next = *head;

    // Update the head of the linked list to point to the new sentence
    *head = newSentence;
}

// Function to process a paragraph and create a linked list of sentences
struct Sentence* processParagraph(char* paragraph) {
    // Initialize the linked list to be empty
    struct Sentence* sentenceList = NULL;

    // Loop through the characters in the paragraph
    int i = 0;
    while (paragraph[i] != '\0') {
        // Skip leading white spaces
        while (isspace(paragraph[i])) {
            ++i;
        }

        // Record the start of a sentence
        int sentenceStart = i;
        int inSingleQuotes = 0;

        // Loop until the end of the paragraph or the end of the sentence
        while (paragraph[i] != '\0') {
            // Handle single quotes to ignore sentence-ending punctuation within quotes
            if (paragraph[i] == '\'') {
                inSingleQuotes = !inSingleQuotes;
            }

            // Check for sentence-ending punctuation outside of quotes
            if (!inSingleQuotes && (paragraph[i] == '.' || paragraph[i] == '?' || paragraph[i] == '!')) {
                ++i; // Include the sentence-ending punctuation

                // Skip any trailing spaces or newline characters
                while (isspace(paragraph[i])) {
                    ++i;
                }
                break;
            }
            ++i;
        }

        // Calculate the length of the sentence
        int sentenceLength = i - sentenceStart - 1;

        // Ignore sentences longer than 200 characters
        if (sentenceLength <= 200) {
            // Allocate memory for the content of the sentence and add it to the linked list
            char* sentenceContent = (char*)malloc(sentenceLength + 1);
            strncpy(sentenceContent, paragraph + sentenceStart, sentenceLength);
            sentenceContent[sentenceLength] = '\0';
            addSentence(&sentenceList, sentenceContent, sentenceLength);
        }
    }

    // Return the linked list of sentences
    return sentenceList;
}

// Function to determine and print the result based on the specified comparison function
void determineAndPrintResult(struct Sentence* sentenceList, CompareFunction compare) {
    // Initialize pointers to iterate through the linked list
    struct Sentence* currentSentence = sentenceList;
    struct Sentence* resultSentence = currentSentence;

    // Loop through the linked list to find the sentence with the desired property
    while (currentSentence != NULL) {
        if (compare(currentSentence->length, resultSentence->length)) {
            resultSentence = currentSentence;
        }
        currentSentence = currentSentence->next;
    }

    // Print the length and content of the result sentence
    printf("%d\n", resultSentence->length);
    printf("%s\n", resultSentence->content);
}

// Comparison function to determine the longest sentence
int compareLongest(int a, int b) {
    return a > b;
}

// Comparison function to determine the shortest sentence
int compareShortest(int a, int b) {
    return a < b;
}

// Function to get the appropriate comparison function based on user selection
CompareFunction getComparisonFunction(char* selection) {
    if (strcmp(selection, "longest") == 0) {
        return compareLongest;
    } else if (strcmp(selection, "shortest") == 0) {
        return compareShortest;
    }
}

// Function to free the memory allocated for the linked list
void freeList(struct Sentence* head) {
    while (head != NULL) {
        // Temporarily store the current node
        struct Sentence* temp = head;

        // Move to the next node
        head = head->next;

        // Free the content and the node itself
        free(temp->content);
        free(temp);
    }
}

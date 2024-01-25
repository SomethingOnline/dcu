#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>


typedef struct Student Student;
struct Student
{
    char name[20];
    char programme[20];
    float grade;
};

void addStruct(Student *student, char *argv[], int numStudents);
void printStruct(Student *student, int numStudents);

int main(int argc, char * argv[])
{
    int numStudents = (argc - 1) / 3;
    Student *StudentArray = calloc(2, sizeof(Student));

    if (StudentArray == NULL) 
    {
        printf("Memory failed\n");
        return 1;
    }
    if (numStudents > 2)
    {
        Student *NewStudentArray = realloc(StudentArray, numStudents * sizeof(Student));
        if (NewStudentArray == NULL)
        {
            printf("Memory failed\n");
            free(StudentArray);
            return 0;
        }
        StudentArray = NewStudentArray;
        free(NewStudentArray);
        NewStudentArray = NULL;
    }

    addStruct(StudentArray, argv, numStudents);
    printStruct(StudentArray, numStudents);


}

void addStruct(Student *student, char *argv[], int numStudents)
{
    int index = 1;
    for (int i = 0; i < numStudents; ++i)
    {
        strcpy(student[i].name, argv[index]);
        strcpy(student[i].programme, argv[index + 1]);
        student[i].grade = atof(argv[index + 2]);
        index += 3;
    }
}
void printStruct(Student *student, int numStudents)
{
    for (int i = 0; i < numStudents; ++i)
    {
        printf("%s, ", student[i].name);
        printf("%s, ", student[i].programme);
        printf("%.2f\n", student[i].grade);
    }
}
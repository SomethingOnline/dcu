#include <stdio.h>
#include <string.h>
#include <stdlib.h>


typedef struct Student Student;

struct Student
{
    char name[100];
    char college[100];
    int age;
    float grade;
};

/*Function prototypes*/
Student *get_student();
void print_student(Student *student);

/*Main driver function*/
int main()
{
    Student *student = get_student();
    print_student(student);
    return 0;
}

Student *get_student()
{
    FILE *pfile = NULL;
    Student *student = (Student *)calloc(1, sizeof(Student *));

    int name_len;
    int college_len;

    char *filename = "studentBinary.bin";

    pfile = fopen(filename, "rb");
    if (!pfile)
    {
        printf("Error opening %s for writing. Program terminated.\n", filename);
        exit(1);
    }

    fread(&name_len, sizeof(int), 1, pfile);
    fread(student->name, sizeof(char), name_len, pfile);

    fread(&college_len, sizeof(int), 1, pfile);
    fread(student->college, sizeof(char), college_len, pfile);

    fread(&student->age, sizeof(int), 1, pfile);

    fread(&student->grade, sizeof(float), 1, pfile);

    return student;
}
void print_student(Student *student)
{
    printf("Name: %s\nCollege: %s\nAge: %d\nGrade: %.2f\n", 
    student->name, student->college, student->age, student->grade);
    
}
#include<stdio.h>
#include<stdlib.h>

/*Declare a structure of Student */
typedef struct Student Student;

struct Student {
	char name[20];
	char programme[20];
	float grade;
	Student *next;
	Student *prev;
};

/*Functional prototype */
Student* get_students(); /* You may notice that the function get_students return the type Student*, implying that the function will return a pointer that points to a Student */
void printStudentListInReverse(Student *last); /*to print the student list */

int main()
{
	Student *start = NULL;
	start = get_students();
	printStudentListInReverse(start);
	return 0;
}

Student* get_students() /* This mean that the function will return a pointer that points to the structure Student */
{
	Student *current, *first, *prev; /*declare three pointers */
	int selection; /* to ask if the user keep entering new student data or stop */

    // starter node
	first = (Student*)calloc(1,sizeof(Student)); /*create the first node */
	current = first; /*Now the current node is also the first node */

	/*fill data for the first node */
	printf("Student name: \n");
	scanf("%s", current->name);
	printf("Programme: \n");
	scanf("%s", current->programme);
	printf("Grade: \n");
	scanf("%f",  &current->grade);
    // set the pointer to the previous node to NULL as it is the first node
	current->prev = NULL;

	printf("Add more student? (1=Y, 0 = N): \n");
	scanf("%d", &selection);

	/*create the following nodes until the user select No */
	while(selection) //while selection is 1 (Yes)
	{
		/* allocate the new node */
        // point current.next to a new node which you have allocated memory for
		current->next = (Student*)calloc(1, sizeof(Student));

        // then set previous to the current node you are working on
        // this is done before you update current to the new node
        // so current in this case is actually pointing to the old node
		prev = current;

		/* move the current pointer to the next node */
        // update current now to be the new node
		current = current->next;

		/*fill the new node */
		printf("Student name: \n");
		scanf("%s", current->name);
		printf("Programme: \n");
		scanf("%s", current->programme);
		printf("Grade: \n");
		scanf("%f",  &current->grade);
        // set the current node which has been updated
        // now set this node-> prev to point to the previous node in the list.
		current->prev = prev;

		printf("Add more student? (1=Y, 0 = N): \n");
		scanf("%d", &selection);
	}

    // end of the linked list
	current->next = NULL; /* in case the last node */
    // return the last node
	return current; /* return the address of the last node */
}

// pass the last node of the function to the function and it will print each node 
// in the list in reverse.
void printStudentListInReverse(Student *last)
{
	int count = 0;
	Student* p = NULL;
    // set p to last, check if previous exists, if it does then go back
    // and execute the for loop
    // if it doesnt then you have reached the start of the doubly linked list
	for(p = last; p != NULL; p = p->prev)
	{
		++count;
		printf("Student #%d: ", count);
		printf("%s, %s, %.2f\n", p->name, p->programme, p->grade);
	}
}
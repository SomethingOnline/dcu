
// this function will only work with doubly linked lists as we need to check
// the previous and next values.
// it is possible to do it in singly linked lists too:
// you would need to find target and target index, then set target index -1.next to be 
// targetindex + 1
void deleteStudentByName(char* name, Student *first)
{
    // create nodeas first in doubly linked list
	Student* p = first;
    // temp value = NULL
	Student *temp = NULL;

    // iterate through the doubly linked list using p.next, stop when reach end
	for(p = first; p != NULL; p = p->next)
	{
        // check each item by the student name - search item
		printf("Check %s ...\n", p->name );
        // if we reach target name
		if(strcmp(p->name,name) == 0)
		{
			/* link the previous item with the next item */
            // set the value of the previous structs next item to be current.next
			p->prev->next = p->next;
            // set the value of the next structs prev item to be current.prev
			p->next->prev = p->prev;
            // this is used to store the new position of P
			temp = p->prev; /* this is used for marking the new position of p after delete the found item */
            // release the item from memory - delete item in list
			free(p); /*delete the item */
            // update p to have the old position of the deleted item
			p = temp; /* new position of p */
		}
		/* then p will move to the next node from here before starting a new cycle */
	}

}
Collections:

Most if not all modern programming languages provide high level data structures
that are commonly required. 
For example, lists and dictionaries and the methods to operate on them.
Java provides these through the collections framework.

The collection interface is the parent of all data structures provided 
within the java.util package
It defines methods related to navigation and manipulations of collections (such as
lists, queues, maps, stacks etc).
In addition, it extends the iterable interface which represents things can be 
iterated upon ie something that can be dealt with in a repeated way.

Of note is how the collection framework uses generics to enable any type to
be used with the implementations of collections.
Therefore in java, there are 2 types of definitions - interfaces that define
methods representing specific data structures such as lists and classes 
that implement these interfaces using specific algorithms such as lists with Arrays
as storage and linked lists.
The below figure summarises some of the notable classes (pink rectangle) and interfaces
(yellow ellipses).

iterable -> collection -> (list, queue, set) -> (deque, sortedSet)
                        -> all the differet data structures

The three broad higher interfaces list, set and queue are extended by 
several other interfaces and implementing classes.

List:
the list interface represents a simple list, a data structure for holding elements
of the specified type.
Notice how the variable type is List, while the value is an instance of ArrayList
this is because we cannot directly create instances of the list interface.
We must write a new class implementing it or pick from javas provided ones.

import java.util.List;

List<String> list = new ArrayList<String>();
// add 1 - 10
for (int i = 0; i < 1; ++i){ list.add("n" + i)};
list.remove(0); // remove first element
// remove odd nums from list
for (int i = 0; i < 5; ++i){ if (i % 2 == 1){ list.remove(i) }};
// get last element
list.get(list.size() - 1);

// List contains the methods add to add an element at the end or at a specified 
// position
// clear to remove all elements
// contains to check if an object is present in the list
// get to get the element at a certain position
// indexOf to get the first occurence of an element 


// In this an arraylist represents the list implementation by creating arrays
// that increase in length as more elements are added
// A special implementation of the list interface is the stack 
// Which implements LIFO (last in first out) for elements
// Note that sometimes duplicate methods do the same things
// empty() and isEmpty() in stack code.
import java.util.List;
import java.util.Stack;

List<Integer> list = new Stack<Integer>();
for (int i = 0; i <= 10; i++){ list.push(i)};

for (int i = 0; i <= 10; i++){ list.pop(i)};
// if we dont know the size we can use a while loop

while(!list.empty()){
    list.pop();
}

By convention lists are printed as [e1, e2] which is defined in its toString


Set:
the set interface represents a simple set, a data struct for holding unique
elements of the specified type such that there are no dupes

import java.util.Set;
Set<String> set = new HashSet<String>();
set.add("one");
set.add("two");
set.add("one"); // not added cus dupe
set.remove("one");
set.isEmpty() // returns true or false

In this hashSet implements a set using has tables, other implements include
EnumSet and TreeSet
Sets also contain the methods:
add to add an element without a position
clear to remove all elements
size to find size
and many others
By convention sets are printed [e1, e2] whcih is implemented in its toString



Queue:
The queue interface represents a simple queue, a data struct for holding elements
of the specified type such that elements are added at the end and removed
at the front (FIFO)

import java.util.Queue;
Queue<String> queue = new LinkedList<String>();
queue.add("one");
queue.add("two");
queue.remove(); // removes one
queue.remove(); // removes two
queue.poll() // returns null if queue empty, else head
queue.peek() // retrieves head but doesnt remove it - returns null
queue.element() // retrieves head but doesnt remove - returns false
queue.isEmpty() // returns true false if queue empty

In this LinkedList implements queue and also the list interface.
A Deque is another interface that extends Queue and represnts a "double ended 
queue" i.e remove and add from front and back.


Map:
The map interface represents a simple map or dictionary that stores key value pairs
It is not a true collection since it doesnt extend the collection interface and nor is it
compatible with its implementation in terms of having the same methods.
Instead a map provides its keys or values or both in the form of lists or other
data structures.

import java.util.Map;
Map<String, Integer> map = new HashMap<String, Integer>();
map.put("one", 1);
map.put("two", 2);

Set <String> keys = map.keySet() // returns a set of the maps keys
for (String key: keys){
    // iterate through
}
map.putIfAbsent("one", 100); // fails because 1 is present
map.put("zero", null);
map.putIfAbsent("zero", 0); // works because null is not considered a value

map.remove("zero"); // removes the zero key value pair
map.remove("one", 100) // doesnt remove anything cus one isnt mapped to 100
// replace (key, value) replaces the value
// replace (key, old value, new, value) replaces the value
// only if key has the old value



// Exam 2018/2019
import java.util.Map;
import java.util.Scanner;
import java.util.HashMap;

// take a line of input from scanner and keep track of the count of each word 
// that is present
Map<String, Integer> map = new HashMap<String, Integer>();
while(scan.hasNext()){
    String key = next.scan();
    if (map.containsKey(key)){
        map.put(key, map.get(key) + 1);
    }
    else{
        map.put(key, 1);
    }
}


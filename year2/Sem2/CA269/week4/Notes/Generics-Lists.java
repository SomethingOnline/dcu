Generics In collections:

Generics provide more type safety and reduce writing repetitive code.
We will see how java uses generics internally to provide convenient 
data structures that can be used with an object or type

Javas data structures such as Lists, sets, queues etc are situated in a module
called collections framework.
The collections framework consists of 4 interfaces Set, List, Map, Deque
and their various implementations.
Were going to analyse the implementation of list and its methods in particular
in the use of generics.

Generics in lists:
List is an interface with the generic parameter <E> where E is the type 
of elements in the list.
Example on how list interface is used:

import java.util.ArrayList;
import java.util.List;

class GenericList{
    public static void main(String[] args){
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        System.out.prinln(list);
    }
}

The syntax of collections including lists uses generics to specify what 
kind of objects are to be stored in the list.
Here we specify Integer to indicate the list will store instance of the class
Integer which is a class for storing int values.

As we have seen with classes and interfaces before, the variable list is of
type List(an interface) and can hold any object that implements it - which is
what an ArrayList does.
The list then adds the number 1 using the add() method and internally this is
converted to be an instance of the Integer class.

List implementation:
Internally this means theres a list interface defined somewhere that looks
somewhat like this and uses generics to define a template for a list 
that adds items:
interface List<E> {
    // append item to list
    // optional operation
    boolean add(E e);
}

The names of generic parameters can be different between the parent and child but
must be the same within the declaration of the child:
interface Collection<E> {  } // E
interface List<X> extends Collection<X> { } // X insted of E - okay
interface List<X> extends Collection<E> { } // not okay - 2 types X and E

Compatibility of generics:

Lets pause and note that Integer is a type of Number or that ArrayList is an 
implementation of List. This allows us to create variables of type number
and List to hold instances of type Integer and ArrayList.
However the same is not true for generics:

List<Number> list = ArrayList<Integer>(); // ERROR

The generic parameter cannot be substituted for its subclasses or implementing 
classes.
Thats why the above statement will return an error "cannot convert between types"

Generic parameters are matched based on their class rather than the instance.
So when the compiler sees a generic parameter of type T it expects an exact
match with T.

Wildcards:

If we dont care about hierarchies and only want to deal with the parent class
or interface, we can use wildcards(?) to indicate there are no parameters, but
theres a class or interface we want to use in the implementation.

In the below code we use ? with Number to specify that we dont care
about the type as long as its subclassed or implements Number (based on whether Number
is a class or an interface) and in our code we are assured that the type will be 
compatitible with Number.
This is more flexible than using Number and having the compiler convert types.

interface MyList<E> extends List<E> { }
void printAll(MyList<? extends Number> list){
    for (Number num: list){
        System.out.println(num);
    }
}

The use of wildcards is called upper bound because it puts a restriction on 
the upper hierarchy by establishing something should be a subclass or 
implementing class.
Similarly there is a lower bound that can be used to indicate something must
be a subclass of the specified class by using the SUPER keyword.
In the below code, any class that is a superclass of Integer can be used - this includes
Integer, Number and Object classes.

interface MyList<E> extends List<E> { }
void printAll(MyList<? super Number> list){
    for (Object num: list){
        System.out.println(num);
    }
}


Inheriting generics:
We saw we cannot use type inheritance to create a list of Number and store
an array list of Integer because the types have to be explicit and exact
matches. 
To use such hierarchies of classes and interfaces within generics, we
need to use inheritance and wildcards which introduce some relaxed rules
that permit compatible classes to be used with generics.

For example, in the below code, List uses the wildcard to specify that it
takes any type aslong as it extends Number, or later aslong as it is a
superclass of Integer.
Using the same syntax, we can also create instances with the same relaxed rules
that specify the variable can hold any implementation aslong as it satisfies
the condition.
// subclass
List<? extends Number> numList = new ArrayList<Integer>();
// superclass
List<? super Integer> intList = new ArrayList<Number>();


Back to lists:
Coming back to lists we now have all the tools and knowledge to create
our own implementation of the list interface in Java.
For starting lets consider a list is an interface that can do the following:
1. add elements at a specified position - if none provided then at the end 
2. remove and return at a specified position - if none provided then at the end
3. clear to remove all elements
4. size to check size of list
5. contains to check if element is in list and if yes return position else return -1

We declare our own MyList interface as:
interface MyList<E>{
    void add(E e);
    void add(E e, int position);
    E remove();
    E remove(int position);
    void clear();
    void size();
    void contains(E e);
}

We consider an ArrayList class which stores the list in an array of a fixed
size and replaces the array size with a new one once the list is full.
For our purposes, we will create a big enough array at the start so as to not
implement this behaviour
Below is the add() method implementation 

class MyArrayList<E> implements MyList<E>{
    // init array
    private E[] array = (E []) new Object[100]; // dangerous
    // init size
    private int size = 0;
    public void add(E e){
        this.array[size] = e;
        size += 1;
    }
    public void add(E e, int position){
        this.array[position] = e;
        size += 1;
    }
    public void clear(){
        this.array.clear();
    }
    public void size(){
        return this.array.size();
    }
    public void contains(E e){
        for (Object one: array){
            if (one.equals(e)){
                return true;
            }
            return false;
        }
    }
    public String toString(){
        String output = "[";
        for (int i = 0; i < size; i++){
            output += array[i] + ",";
        }
        return output + "]";
    }
}
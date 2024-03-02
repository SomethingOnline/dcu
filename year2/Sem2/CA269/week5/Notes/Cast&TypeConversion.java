
// Casting is explicitly telling the compiler to convert an object or value from one
// type to another. Casting can only be done between compatible types.
// Casting means asking the compiler to treat the variable as if it were
// of the casted type instead of the original type

// It is useful when we want to convert between different types of compatible values
// e.g int to long, or from CHILD CLASS to PARENT CLASS
// Whenever there could be a loss of information, casting is not allowed
// e.g long to int cannot be done because as int is smaller than long and could lose some information
// Similarly casting a parent class to a child class is not allowed since the child 
// class may have more data and methods than the parent class which might not be
// available if that object isnt actually of the child class type.

// good casting
int x = 0
long y = (long) x;
// this is okay because long is big enough to store an int

int z = (long) y;
// not allowed since int is smaller

// casting between subclasses and interfaces 
class Animal(){
    Animal(){ }
}
interface Moves{ }

class Bat extends Animal implemenets Moves{
    Bat() { }
}

// testing:
Animal a = (Animal) new Bat();
// create new instance of bat and cast to animal
// this is okay since bat extends animal
Bat b = (Bat) new Animal();
// not okay, because Bat is the child class and you cant cast a parent to child

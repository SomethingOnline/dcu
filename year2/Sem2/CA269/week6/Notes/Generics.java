
// GENERICS
// Weve seen how classes and interfaces permit casting or specifying type of a variable
// doing this repeatedly gets tedious, and also makes code difficult 

Duck recogniseDuck(Object 0){
    if (0 instanceof Duck){
        Duck d = (Duck) 0;
    }
    return null;
}
void callingMethod(Object X){
    Duck d = recogniseDuck(X); // no guarantee were getting back a duck (IF IT IS THEN CAST)
}

// Singleton pattern
// we can use factories to design and create classes,
// in this strict class usage by preventing multiple instances from being created,
// or more accurately by ensuring that only one instance is "alive" at a time.
// in factory we hardcode or explicitly specify the kind of class whos instance is created
// and example we used was DUCK, theres another design called Singleton
// that re
// For duck it would look like this:
class DUCK { }
class DuckSingleton{
    private Duck duck;
    DuckSingleton(Duck duck){
        this.duck = duck; //set the single duck at creation time
    }
    public Duck getItem(){
        return this.duck // always return the same Duck
    }
}

// Applying this to all classes would be tedious, this is where generics come into play
// the term generic means lacking speciality or specificty it can be used for anyting and everything

// To use generics we need to specify a parameter that is then replaced by the compiler
// and run time to whatever class or interface or type we want to specify without
// having to write the code, in the example below the generic class with parameter
// <T> is declared:
// Note the syntax:

class Generic<T> {          // defines generic type T to be replaced
    T genericvariable;      // variable of T
    T somemethod(T variable){       // T as argument and return type
        this.genericVariable = variable;
    }
}

// this represents a template for code to be produced where T is replaced by whatever type is specified

Generic<String> G = new Generic<String>(); // generates code equivalent to:
class Generic {
    String genericVariable;
    String someMethod(String variable) {
        this.genericVariable = variable;
    }
}

Generic<Duck> G = new Generic<Duck>();
// generates code equivalent to:
class Generic{
    Duck genericVariable;
    Duck somemethod(Duck variable){
        this.genericVariable = variable;
    }
}
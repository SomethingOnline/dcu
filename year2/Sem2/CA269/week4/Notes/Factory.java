// Ducks
// A company has a duck class that has the fly() method.
// At some point a person creates a WoodenDuck subclass which also inherits fly(),
// WoodenDucks should not be able to fly
// This represents a common OOP problem - how to create classes so they dont run into the same problem

// Flying ducks:
// The first approach is deciding what type the object is going to be
// In this case Duck and WoodenDuck are specific types that people require.
// However, both have been strongly coupled into a parent child or subclass relationship
// This makes it difficult to change implementations or fix issues such as the wooden ducks being able to fly

// To start with - there are 2 kinds of duck - those who fly and those who dont
// only the ducks who can fly should have the fly method.
// so we create 2 subclasses flyingduck and nonflyingduck,
// implement fly in the correct one and have woodenduck extend one of these.
// this solution assumes we have control over both duck and woodenduck.

// Swimming ducks:
// what if there was another method swim(), metal ducks dont swim - they sink
// we cannot create a subclass for every possible outcome - this is too tedious

// A better solution is to have interfaces for each of the different things that a class may
// or may not implemenet, this enables the subclass to choose things it wants to implemenet
// while the common parent class is not responsible for the common data and methods.
// This approach also allows for future changes to be implemented.
// For example a rubber duck that swims can implement the swims interface

abstract class Duck{
    String shape = "duck-like";
    String getEtymology(){
        return "The word duck comes from old english duce 'diver'";
    }
}
interface Fly{
    void fly();
}
interface Swim{
    void swim();
}
interface Quack{
    void quack();
}
class WoodenDuck extends Duck{ }
class RealDuck extends Duck implements Fly, Swim, Quack { }
class RubberDuck extends Duck implements Swim { }


// DuckFactory:
// while the rubberduck creating factory is happy their ducks wont misbehave and can now swim
// they are still worried that anyone can create any amount of ducks anywhere and they might run out of
// business, they want control over how the ducks are created and how many are created.

// Such use cases are common in java and solved by using design patterns called a Factory
// A factory is a class responsible for creating another class, possibly with any customisation needed,
// and returning an instance of that class.
// This does 2 things:
// 1. it abstracts the code of the class from the users so that if some detail changes in the next version
// the old code using factory wont have to change
// 2. It allows control over the creation of the class such as how many instances are created which isnt 
// possible using a constructor, a good analogy is to think of a factory as an API for creating an instance
// of a class.

class Duck { }
public class DuckFactory{
    private static int counter;
    private static final int max_ducks = 100;
    public static Duck getNewDuck(){
        counter++;
        if (count < max_ducks){
            return new Duck();
        }
        return null;
    }
}

// This factory class provides a new method getNewDuck that returns an instance of the duck class.
// it keeps a counter for keeping track of how many objects have been created
// and increments the counter everytime the method is called.
// max_ducks is declared final so that no other code should be able to change the number once the code
// is running, if this calue was coming from some other behaviour, such as a function that returns
// a number based on currently available material then it would not have been final and the comparison
// with counter would have called a method something like getCurrentMaxCapacity.

// The factory variables and the method are static so that there is no need to create an instance or
// copy of the factory and new ducks can be obtained directly from the factory class,
// Even if new instances were created the number in counter would not change because it has been 
// declared as static and is therefore shared across instances.

// Flavoured factories:
// If there are to be multiple factories, for example those producing different kinds of ducks,
// then the variables and methods cannot be static anymore because now their value is tied to instances,
// which can be multiple.
// In the below code we modify the factory class so that each instance has an independent counter 
// and different max capacity as well as the ability to produce ducks of different colours.
// It also prints each duck with a unique identifier that shows the factory and batch it came from

class Duck{
    String colour;
    String id;
    Duck(String colour, String id){
        this.colour = colour;
        this.id = id;
    }
    String toString(){
        return "Duck #" + id;
    }
}

public class DuckFactory{
    private int counter = 0;
    public final int max_ducks;
    public final String colour;
    DuckFactory(int max_ducks, String colour){
        this.max_ducks = max_ducks;
        this.colour = colour;
    }
    public Duck getNewDuck(){
        counter += 1;
        if (counter < max_ducks){
            return new Duck(colour, colour + "#" + id);
        }
        return null;
    }
    public static void main(String [] args){
        DuckFactory dfRed = new DuckFactory(100, "Red");
        Duck d1 = dfRed.getNewDuck();
        System.out.println(d1);
        // skip to duck 100
        for (int i = 0; i < 100; i++){
            dfRed.getNewDuck();
        }
        d1 = dfRed.getNewDuck();
        System.out.prinln(d1);

        DuckFactory dfGreen = new DuckFactory(0, "Green");
        d1 = dfGreen.getNewDuck();
        System.out.println(d1);     // error because the max ducks is set to 0
        // so it will just return null
    }
}

There may be a case where the duck class is abstract or cannot be changed because it is not under
the factories control, or other classes depend on the duck class or etc.
In this case, the factory can create its own subclass of Duck, and use that to produce the ducks,
While it can share this new class (lets call it ProprietaryDuck) with everyone else it doesnt
want to do so and instead wants to keep its implementations a secret;
Therefore it uses private classes which are situated inside the factory class - this means nobody 
outside the factory can access it.
Then instead of returning a duck it returns instances of ProprietaryDuck.
The receiving code still sees it as a duck instance because thats what its thinking that object type is.

public class DuckFactory{
    static private class ProprietaryDuck extends Duck{
        // custom secret data and methods
    }
    public static Duck getNewDuck(){
        counter += 1;
        if (counter < max_ducks){
            return new ProprietaryDuck();
        }
        return null;
    }
}
// code in another class method in a package far far away
// thinks it has received a duck, but in reality it has received a ProprietaryDuck
// but because the varaible d type is Duck, the compiler casts it to duck
Duck d = new DuckFactory.getNewDuck();

// The class is nested and is static which just means that its placed inside the DuckFactory class
// and thats it. If it wasnt static, then it can access other member of the enclosing ie factory
// class within its functions.

Duck typing:
Ducking typing is a funny way of describing OOP concept that if an object is capable of expressing or running
some methods typically associated with a class or an interface then it may as well be assumed to be 
an instance of that class or interface.
It also exposes the problematic consequences of assumptions - which we saw in the duck example above
If we assume all ducks can fly, or that everything that can fly is a duck then problems arise when we 
get to woodenducks.

In java, it is often desirable to check whether an object is of a given type e.g is it an instance of a 
class or is it an instance of a class that has been derived from a specific class or interface.
To do this java provides 3 different ways, one of which is to use the instanceof operator.
The other two are the methods getClass() called on an instance and isInstance() called on a class.

// given these classes:
class A { }
class B extends A{ }
// these are the ways to check if an object is an instance of a class
// (1) instance of:
A x = new B();
B y = new B();

y instanceof A // true
y instanceof B // true
x instanceof A // true
x instanceof B // true
// (2) getClass
x.getClass().equals(A) // false
x.getClass().equals(B) // true

// (3) isInstance
A.isInstance(X) // true
B.isInstance(Y) // true


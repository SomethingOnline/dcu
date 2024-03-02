// public interface Order {
//     // this method must be implemented in any class than extends order
//     // other is used for any other class that has type Order
//     public boolean lessThan(Order other);
// }

// public interface Comparable extends Order{
//     public int compareTo(Object other);
// }

// point implemenets order - must create lessThan method
public class Point implements Comparable{
    // init variables
    private double x, y;
    // constructor takes 2 ints - will become x and y
    public Point(double newX, double newY) {
        x = newX;
        y = newY;
    }
    // we use getters to get X and Y because we will need this method
    // to access attributes from other classes that havent been made yet
    public double getX(){
        return x;
    }
    public double getY(){
        return y;
    }
    // this checks if they are both the same object
    // can only be called on object class
    // Other for example would be 01,02 in this case
    private boolean checkType(Object object){
        // returns true if instance of Point, which inherits order
        // we can use this function to check if this returns true or not
        // only if it returns true should we continue
        return object instanceof Point; 
    }

    // this method checks if the Point instance and the current Point
    // are equal to each other
    // Point point makes it comparable between 2 classes

    public boolean equals(Point point){
        // we use this.var for our current class and point.var for another one
        // this.var is initialised in the constructor, then point is being passed
        // to as a new class, but also in the constructor, but a seperate class
        if (this.x == point.x && this.y == point.y){
            return true;
        // not equals
        } else{
            return false;
        }
    }

    // this methods checks if object vars are less than each other
    public boolean lessThan(Point other){
        // check if theyre equal first, if so then false
        if (this.equals(other)){
            return false;
        // check if greater
        } else if (this.x > other.getX() || this.x == other.getX() && this.y > other.getY()){
            return false;
        }
        // else return false
        return true;
    }
    // this class ensures that other is guaranteed to be of point class
    // this means that we will be able to compare them
    // this uses the Order interface as type.
    // if check passes, then cast other to point and then call method.
    public boolean lessThan(Order other){
        // if it not an instance of the point class return false
        // they cannot be compared
        if (!checkType(other)){
            return false;
        }
        // else we cast the type of Point to the other object
        // this part also calls the above function, which will
        // return true or false.
        return lessThan((Point) other);
    }

    public int compareTo(Object other){
        if (!checkType(other)){
            return 0;
        }
        Point object = (Point) other;
        if (this.lessThan(object)){
            return -1;
        }
        if (object.lessThan(this)){
            return 1;
        }
        return 0;
    }

    public String toString() {
        return "(" + x + ", " + y + ")";
    }



    public static void main(String [] args){
        Order O1 = new Point(0, 0);
        Order O2 = new Point(1, 1);
        Order O3 = new Point(0, 1);

        System.out.println("O1 less than O2: " + O1.lessThan(O2)); // true
        System.out.println("O1 less than O3: " + O1.lessThan(O3)); // true
        System.out.println("O2 less than O3: " + O2.lessThan(O3)); // false
        System.out.println("O3 less than O3: " + O3.lessThan(O3)); // false
        
        Comparable C1 = new Point(0, 0);
        Comparable C2 = new Point(1, 1);
        Comparable C3 = new Point(0, 1);

        System.out.println("C1 less than C2: " + C1.compareTo(C2)); // -1
        System.out.println("C1 less than C3: " + C1.compareTo(C3)); // -1
        System.out.println("C2 less than C3: " + C2.compareTo(C3)); // 1
        System.out.println("C3 less than C3: " + C3.compareTo(C3)); // 0
    }
}

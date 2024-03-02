interface Order {
    public boolean lessThan(Order other);
}

interface Comparable extends Order{
    public int compareTo(Object object);
}

public class Point2 implements Comparable{
    private double x, y;

    public Point2(double newX, double newY) {
        x = newX;
        y = newY;
    }

    public double getX(){
        return x;
    }

    public double getY(){
        return y;
    }

    public boolean Checktype(Object object){
        return object instanceof Point2;
    }

    public boolean equals(Point2 point){
        if (this.x == point.getX() && this.y == point.getY()){
                return true;
        } else {
            return false;
        }
    }

    public boolean lessThan(Order other){
        if (!Checktype(other)){
            return false;
        }
        return lessThan((Point2) other);
    }

    public boolean lessThan(Point2 other){
        if (this.equals(other)){
            return false;
        } else if (this.x > other.getX() || this.x == other.getX() && this.y > other.getY()){
            return false;
        }
        return true;
    }

    public int compareTo(Object other){
        if (!Checktype(other)){
            return 0;
        }
        Point2 object = (Point2) other;
        if (this.lessThan(object)){
            return -1;
        } else if (object.lessThan(this)){
            return 1;
        } else{
            return 0;
        }

    }


    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    public static void main(String[] args){
    Order O1 = new Point2(0, 0);
    Order O2 = new Point2(1, 1);
    Order O3 = new Point2(0, 1);

    System.out.println("O1 less than O2: " + O1.lessThan(O2)); // true
    System.out.println("O1 less than O3: " + O1.lessThan(O3)); // true
    System.out.println("O2 less than O3: " + O2.lessThan(O3)); // false
    System.out.println("O3 less than O3: " + O3.lessThan(O3)); // false
    Comparable P1 = new Point(0, 0);
    Comparable P2 = new Point(1, 1);
    Comparable P3 = new Point(0, 1);

    System.out.println("P1 less than P2: " + P1.compareTo(P2)); // -1
    System.out.println("P1 less than P3: " + P1.compareTo(P3)); // -1
    System.out.println("P2 less than P3: " + P2.compareTo(P3)); // 1
    System.out.println("P3 less than P3: " + P3.compareTo(P3)); // 0
    } 
}
/*
Author: Jack Egan - 22404362
Date: 06/02/2024

Description:
The goal of the program is to incorporate inheritance and encapsulation,
in order to be able to take 2 values - an x and y and return which quadrant the point is in, 
then in turn be able to compare two points and see if they are in the same quadrant.
*/

class Point implements GridQuadrant, CompareQuadrant{
    private double x, y;
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
    // getters
    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }
    // determine which quadrant the point is in
    public Quadrant getQuadrant(){
        if (x == 0 && y == 0){
            return null;
        } else if (x > 0 && y > 0){
            return Quadrant.Q1;
        } else if (x < 0 && y > 0){
            return Quadrant.Q2;
        } else if (x < 0 && y < 0){
            return Quadrant.Q3;
        } else{
            return Quadrant.Q4;
        }
    } 
    // compare two objects to see if in same quadrant
    public boolean isInSameQuadrant(Point newpoint){
        // if (this.getQuadrant() == newpoint.getQuadrant()){
        //     return true
        // } else{
        //     return false;
        // }
        return this.getQuadrant() == newpoint.getQuadrant();
    }

    // test cases
    public static void main(String[] args){
        // Point P1 = new Point(1, 1);
        // System.out.println(P1.getQuadrant());
        // Point P2 = new Point(-1, 1);
        // System.out.println(P2.getQuadrant());
        // Point P3 = new Point(2, 2);
        // System.out.println(P1.isInSameQuadrant(P3));
        // System.out.println(P1.isInSameQuadrant(P2));
    }
}

enum Quadrant {
    Q1, // x +ve, y +ve
    Q2, // x -ve, y +ve
    Q3, // x -ve, y -ve
    Q4; // x +ve, y -ve
}

interface GridQuadrant {
    Quadrant getQuadrant();
}

interface CompareQuadrant {
    boolean isInSameQuadrant(Point newpoint);
}

interface PointMaker {
    Point makePoint(double x, double y);
    int countPointsCreated();
}

public class PointFactory implements PointMaker{

    private static int counter;
    // increment counter with each instance created
    public Point makePoint(double x, double y){
        counter += 1;
        return new Point(x, y);
    }

    public int countPointsCreated(){
        return counter;
    }
    // test cases
    public static void main(String[] args){
        // PointFactory factory = new PointFactory();
        // Point p1 = factory.makePoint(3.0, 4.0);
        // Point p2 = factory.makePoint(-3.0, 4.0);
        // Point p3 = factory.makePoint(-3.0, -4.0);
        // Point p4 = factory.makePoint(3.0, -4.0);

        // System.out.println("Number of points created: " + factory.countPointsCreated());

        // System.out.println("p1 Quadrant: " + p1.getQuadrant());
        // System.out.println("p2 Quadrant: " + p2.getQuadrant());
        // System.out.println("p3 Quadrant: " + p3.getQuadrant());
        // System.out.println("p4 Quadrant: " + p4.getQuadrant());

        // System.out.println("Are p1 and p2 in the same quadrant? " + p1.isInSameQuadrant(p2));

    }

}
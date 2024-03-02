// interface Interface {
//     String communicate();
//     int addnums(int x, int y);
// }

// class Test implements Interface {
//     public String communicate() {
//         return "Hello, World!";
//     }
//     // must add addnums since it is in the interface
//     public int addnums(int x, int y){
//         return x + y;
//     }

//     public static void main(String[] args) {
//         Test t1 = new Test();
//         System.out.println(t1.communicate());

//         int result = t1.addnums(2, 4);
//         System.out.println(result);
//     }
// }

// (1) Interface

interface CarTemplate {
    String getMake();
}

class Car_Int implements CarTemplate {
    String make = "Mach 5";
    public String getMake() {  // <--- implemented method
        return make;
    }

    public static void main(String[] args) {
        CarTemplate car = new Car_Int();
        System.out.println(car.getMake());
        // String make = car.getMake();
        // System.out.println(make);
    }
}

// (2) Abstract Class

abstract class Car {
    String make;
    abstract String getMake();
}

class Car_Abs extends Car {
    String make = "Mach 5";
    public String getMake() {  // <--- implemented method
        return make;
    }

    public static void main(String[] args) {
        Car car = new Car_Abs();
        
    }
}
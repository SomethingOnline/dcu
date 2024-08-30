// Interface for car parts
interface CarPart { }

// Engine class that implements CarPart interface
class Engine implements CarPart { }

// Car class with Engine as a private attribute
class Car {
    private Engine engine;
    // Method to set the engine of the car
    public void setEngine(Engine engine) { this.engine = engine; }
}

// Sedan class that extends Car
class Sedan extends Car {}

// Van class that extends Car
class Van extends Car {}

// SedanBuilder class for building Sedan cars
class SedanBuilder {
    private Engine engine;
    private Sedan car;
    // Method to set the Sedan car
    public void setCar(Sedan Car) { this.car = car; }
    // Method to set the engine of the Sedan car
    public void setEngine(Engine engine) { this.car.setEngine(engine); }

    // Method to get the built Sedan car
    public Sedan getCar() {
        return car;
    }
}

// VanBuilder class for building Van cars
class VanBuilder {
    private Engine engine;
    private Van car;
    // Method to set the Van car
    public void setCar(Van Car) { this.car = car; }
    // Method to set the engine of the Van car
    public void setEngine(Engine engine) { this.car.setEngine(engine); }

    // Method to get the built Van car
    public Van getCar() {
        return car;
    }
}

// Generic Builder class for building any type of car that extends Car
class Buidler<CarType extends Car>{
    private Engine engine;
    private CarType car;

    // Method to set the engine of the car
    public void setEngine(Engine engine) throws EngineNotFoundException{
        this.car.setEngine = engine;
    }
    // Method to get the built car, throws exception if car or engine is not set
    public void getCar() throws CarBuildNotReadyException{
        if (!engine = null | !car = null){
            return car;
        }
    }
    // Method to set the car
    public void setCar(CarType car){
        this.car = car;
    }
}

// Custom exception for when the engine is not found
class EngineNotFoundException extends Exception{}

// Custom exception for when the car build is not ready
class CarBuildNotReadyException extends Exception{}

// CarFactory class for checking the status of the car builder
class CarFactory{
    // Method to check the status of the car builder, returns false if an exception is thrown
    boolean checkCarBuilderStatus(Buidler builder){
        try{
            Car car = builder.getCar();
        }
        catch(Exception E){
            return false;
        }
        return true;
    }
}
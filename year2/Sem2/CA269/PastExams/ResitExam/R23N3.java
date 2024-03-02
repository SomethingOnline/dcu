
interface CarPart { }
class Engine implements CarPart { }

class Car {
    private Engine engine;
    public void setEngine(Engine engine) { this.engine = engine; }
}

class Sedan extends Car {}
class Van extends Car {}

// Builders

class SedanBuilder {
    private Engine engine;
    private Sedan car;
    public void setCar(Sedan Car) { this.car = car; }
    public void setEngine(Engine engine) { this.car.setEngine(engine); }

    public Sedan getCar() {
        return car;
    }
}

class VanBuilder {
    private Engine engine;
    private Van car;
    public void setCar(Van Car) { this.car = car; }
    public void setEngine(Engine engine) { this.car.setEngine(engine); }

    public Van getCar() {
        return car;
    }
}

// TODO: class Builder
class Buidler<CarType extends Car>{
    private Engine engine;
    private CarType car;

    public void setEngine(Engine engine) throws EngineNotFoundException{
        this.car.setEngine = engine;
    }
    public void getCar() throws CarBuildNotReadyException{
        if (!engine = null | !car = null){
            return car;
        }
    }
    public void setCar(CarType car){
        this.car = car;
    }
}

class EngineNotFoundException extends Exception{}
class CarBuildNotReadyException extends Exception{}

class CarFactory{
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
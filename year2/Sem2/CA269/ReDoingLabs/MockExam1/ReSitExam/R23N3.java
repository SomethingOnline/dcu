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

class Builder<T extends Car>{
	private Engine engine;
	private T car;
	public void setCar(T car){
		this.car = car;
	}

	public T getCar() throws CarBuildFailedException{
		if(engine == null || car == null){
			throw new CarBuildFailedException("Car or engine not set");
		} else{
			return car;
		}
	}
	public void setEngine(Engine engine) throws EngineNotFoundException{
		if(engine == null){
			throw new EngineNotFoundException("Engine not set");
		} else{
			this.engine = engine;
			this.car.setEngine(engine);
		}
	}
}

class EngineNotFoundException extends Exception{
	EngineNotFoundException(){
		super();
	}
	EngineNotFoundException(String message){
		super(message);
	}
}

class CarBuildFailedException extends Exception{
	CarBuildFailedException(){
		super();
	}
	CarBuildFailedException(String message){
		super(message);
	}
}

class CarFactory{

	public boolean checkCarBuilderStatus(Builder<?> builder){
		try{
			builder.getCar();
			return true;
		} catch(CarBuildFailedException exception){
			return false;
		}
	}
}
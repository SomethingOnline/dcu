
enum Size{
	small, medium, large;
}

class Duck {
    private String colour;
    private Size size;
    private double cost;
    private String manufacturer_sign;

    Duck(String colour, Size size, double cost, String manufacturer_sign) {
        this.colour = colour;
        this.size = size;
        this.cost = cost;
        this.manufacturer_sign = manufacturer_sign;
    }

    public String getColour() {
        return colour;
    }
    public Size getSize() {
        return size;
    }
    public double getCost() {
        return cost;
    }
    public String getManufacturer_sign() {
        return manufacturer_sign;
    }

	public void setColour(String colour){
		this.colour = colour;
	}
	public void setSize(Size size){
		this.size = size;
	}
	public void setCost(double cost){
		this.cost = cost;
	}
	public void setManufacturer_sign(String manufacturer_sign){
		this.manufacturer_sign = manufacturer_sign;
	}
}

public class DuckFactory extends Duck{

	private String name;
	private Duck duckModel;
	public int max_ducks;
	public int ducksProduced;
	public int batchNo;

	public String getName(){
		return name;
	}

	public DuckFactory(String name, String colour, Size size, double cost, String manufacturer_sign){
		this.name = name;
		this.max_ducks = max_ducks;
		this.ducksProduced = 0;
		this.batchNo = 1;
		this.duckModel = new Duck(colour, size, cost, manufacturer_sign);
	}
	public Duck getNewDuck(){
		if (ducksProduced < max_ducks){
			ducksProduced +=1;
			return New Duck(duckModel.getColour(), duckModel.getSize(), duckModel.getCost(), duckModel.getManufacturer_sign());
		}
	}
}

class GenericDuckFactory<T extends Duck>(){
	public T createDuck(T item){
		if (item instanceof Duck){
			return item;
		}
		return null;
	}
}
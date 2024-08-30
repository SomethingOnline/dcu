
enum Size{
    SMALL, MEDIUM, LARGE;
}

class Duck { 
    private String colour;
    private Size size;
    private double cost;
    private String manufacturer_sign;

    Duck(String colour, Size size, double cost, String manufacturer_sign){
        this.colour = colour;
        this.size = size;
        this.cost = cost;
        this.manufacturer_sign = manufacturer_sign;
    }

    public String getColour(){
        return this.colour;
    }
    public Size getSize(){
        return this.size;
    }
    public double getCost(){
        return this.cost;
    }
    public String getManufacturer_sign(){
        return this.manufacturer_sign;
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

class DuckFactory extends Duck(){

    public static Duck getNewDuck(){
        return new Duck(); // insert attributes
    }
}
class ProprietaryDuckExample extends Duck(){
    private static ProprietaryDuck getNewDuck(){
        return new ProprietaryDuck();
    }
    return null;
}

class GenericDuckFactory<T extends Duck>(){
    public T createDuck(T item){
        if(item.instanceof Duck){
            return item;
        }
        return null;
    }
}
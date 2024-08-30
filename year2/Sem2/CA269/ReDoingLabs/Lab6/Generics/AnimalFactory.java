
interface SafetyRegulation{
	int getMaxItemsPermitted();
}

abstract class Item implements SafetyRegulation{

	private int MaxItemsPermitted;
	public int getMaxItemsPermitted(){
		return MaxItemsPermitted;
	}
	public void setMaxItemsPermitted(int MaxItemsPermitted){
		this.MaxItemsPermitted = MaxItemsPermitted;
	}
	public abstract String getItemType();

}

class Duck extends Item{
	Duck(){
		setMaxItemsPermitted(5);
	}

	public String getItemType(){
		return "Duck";
	}
}
class Swan extends Item{
	Swan(){
		setMaxItemsPermitted(2);
	}
	public String getItemType(){
		return "Swan";
	}
}
class Flamingo extends Item{
	Flamingo(){
		setMaxItemsPermitted(3);
	}
	public String getItemType(){
		return "Flamingo";
	}
}
class Dog extends Item{
	Dog(){
		setMaxItemsPermitted(20);
	}
	public String getItemType(){
		return "Dog";
	}
}
class Cat extends Item{
	Cat(){
		setMaxItemsPermitted(20);
	}
	public String getItemType(){
		return "Cat";
	}
}


public class AnimalFactory<T extends Item & SafetyRegulation>{
	public int unitsProduced = 0;


	public T continueProduction(T item){
		if (unitsProduced < item.getMaxItemsPermitted()){
			unitsProduced++;
			return item;
		} else{
			return null;
		}
	}

	public int getCount(){
		return unitsProduced;
	}

	public static void main(String[] args){
		// main() for testing:
		AnimalFactory<Duck> AF_D = new AnimalFactory<>();
		while(AF_D.continueProduction(new Duck()) != null);
		System.out.println("Total Ducks produced: " + AF_D.getCount());

		AnimalFactory<Swan> AF_S = new AnimalFactory<>();
		while(AF_S.continueProduction(new Swan()) != null);
		System.out.println("Total Swans produced: " + AF_S.getCount());

		AnimalFactory<Flamingo> AF_F = new AnimalFactory<>();
		while(AF_F.continueProduction(new Flamingo()) != null);
		System.out.println("Total Flamingos produced: " + AF_F.getCount());

		AnimalFactory<Dog> AF_G = new AnimalFactory<>();
		while(AF_G.continueProduction(new Dog()) != null);
		System.out.println("Total Dogs produced: " + AF_G.getCount());

		AnimalFactory<Cat> AF_C = new AnimalFactory<>();
		while(AF_C.continueProduction(new Cat()) != null);
		System.out.println("Total Cats produced: " + AF_C.getCount());

		// which produces the output
		// Total Ducks produced: 5
		// Total Swans produced: 2
		// Total Flamingos produced: 3
		// Total Dogs produced: 20
		// Total Cats produced: 20
	}
}
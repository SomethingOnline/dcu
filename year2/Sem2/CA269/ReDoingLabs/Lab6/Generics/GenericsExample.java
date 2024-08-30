
class Generic<T>{
	T genericVar;
	T someMethod(T variable){
		this.genericVar = variable;
	}
}

// using string
Generic<String> G = new Generic<String>();
// which generates this code in the factory
class Generic{
	String genericVar;
	String someMethod(String variable){
		this.genericVar = variable;
	}
}

// also with duck
Generic<Duck> G = new Generic<Duck>();
// generates:
class Generic{
	Duck genericVar;
	Duck someMethod(Duck var){
		this.genericVar = var;
	}
}
// there are no dupes and no clashes - because the compiler will take care of it for us

// we can write common code using factories like this

class Duck{}
class Swan{}

public class GenericFactory<T>{
	private T singleton;
	public T getNewItem(){
		return singleton;
	}
	GenericFactory(T singleton){
		this.singleton = singleton;
	}
	public static void main(String[] args) {
        // creating factories: note the specifying of Ducks and Swans
        GenericFactory<Duck> DuckFactory = new GenericFactory<Duck>(new Duck());
        GenericFactory<Swan> SwanFactory = new GenericFactory<Swan>(new Swan());
        // using factories
		// will return singletons for both duck type and swan type
        System.out.println(DuckFactory.getNewItem());
        System.out.println(SwanFactory.getNewItem());
    }

}

// bound types rstrict the types used in generics to specific classes or interfaces
// we want to write generic code to handle all items which should only work
// on classes that are item or extend item
class ShoppingBasket<T extends Item>{
	// do something with assumption T is subclass of item
}

// if using interfaces in this we replace implements with ampersand
class ShoppingBasket<T extends Item & StorageCondition>{
	// T subclass of item and T implements storagecondition
}

// generics using a map - multiple generics
public interface Pair<K, V>{
	public K getKey();
	public V getValue();
}

public class OrderedPair<K, V> implements Pair<K, V>{
	private K key;
	private V value;

	public OrderedPair(K key, V value){
		this.key = key;
		this.value = value;
	}

	public K getKey(){ return key; }
	public V getValue(){ return value; }
}

// Usage
Pair<String, Integer> p1 = new OrderedPair<String, Integer>("even", 8);
Pair<String, String> p2 = new OrderedPair<String, String>("hello", "world");

// usage using inferred types - using <> for the new one
OrderedPair<String, Integer> p1 = new OrderedPair<>("even", 8);
OrderedPair<String, String> p2 = new OrderedPair<>("hello", "world");

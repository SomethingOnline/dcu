import java.util.*;
// for set hash set 
// for list, arraylist
// for map hashmap
// for queue, linkedlist
// for deque, arraydeque


class Item{
	private final String name;
	private final double price;
	
	Item(String name, double price){
		this.name = name;
		this.price = price;
	}

	public String getName(){
		return name;
	}
	public double getPrice(){
		return price;
	}
	public String toString(){
		return this.name + " " + this.price;
	}
}

// basket using stack
class Basket {
    private final Stack<Item> basket;

    Basket() {
        // TODO - create new stack for basket
		this.basket = new Stack<Item>();
    }

    public void addItem(Item item) {
        this.basket.push(item);
    }

    public Item removeItem() {
        // TODO - remove item from stack basket
        // don't gorget to check if its empty first!
		if (!this.basket.empty()){
			return this.basket.pop();
		} else{
			return null;
		}
    }

    public String toString() {
        return "basket:" + this.basket.toString();
    }

	public boolean isEmpty(){
		if(!this.basket.empty()){
			return true;
		} else{
			return false;
		}
	}
}

// checkout using queue - taken off at the front
class Checkout {
    private final Queue<Item> checkout;

    Checkout(Basket basket) {
        // TODO - create the queue, add items from basket by using addItem()
        // first, create a new queue for the checkout
        // remember - Queue is an interface, so you need to choose a suitable
        // implementation like LinkedList
        // second, go through the basket, remove each item out of the basket
        // and add it to the checkout
		this.checkout = new LinkedList<Item>();
		while(!basket.isEmpty()){
			Item e = basket.removeItem();
			addItem(e);
		}

    }

    public void addItem(Item item) {
		this.checkout.add(item);
    }

    public Item removeItem() {
		if (!this.checkout.isEmpty()){
			return this.checkout.remove();
		} else{
			return null;
		}
        // TODO - remove item from the checkout queue
        // don't forget to check if its empty first!
    }

	public boolean empty(){
		if(!this.checkout.isEmpty()){
			return true;
		} else{
			return false;
		}
	}

    public String toString() {
        return "checkout:" + this.checkout.toString();
    }
}

// bill - a list of items with their quantities and the total price 
// also shows the list of items purchased - map
class Bill {
    private final LinkedHashMap<String,Integer> basket;
    private double price;

    Bill(Checkout checkout) {
        // TODO - initialise Map, set price, bill items from checkout
        // first, create the Map for the basket - just like Queue,
        // you must select an implementation such as LinkedHashMap
        // second, our starting price is zero - there are no items yet
        // third, iterate through the checkout items -
        // take an item out of the checkout, and bill it
		this.basket = new LinkedHashMap<String, Integer>();
		while (!checkout.empty()){
			billItem(checkout.removeItem());
		}
    }

    public void billItem(Item item) {
        // TODO - put item in map, keep count of same items being billed
        // Note that the Map is from key String to value Integer
        // Items have names as Strings and count of items is an integer
        // first, check if the Item already exists in the Map -
        // the Item name is what we use as the key
        // If it exists - we need to increment its counter by 1
        // If not - we need to create a new key with the item name and value 1
        // second, add the item's price to the bill total price
		int count = 1;
		String name = item.getName();
		if (this.basket.containsKey(name)){
			this.basket.put(name, this.basket.get(name) + 1);
			this.price += item.getPrice();
		} else{
			this.basket.put(name, count);
			this.price += item.getPrice();
		}

    }

    public double getTotal() {
        return this.price;
    }

    public String toString() {
        String output = "";
        for(String item: this.basket.keySet()) {
            output += item + " (" + this.basket.get(item) + "nos)\n";
        }
        return output + "total: " + this.price;
    }
}


public class ShopInventory2{

    public static void main(String[] args) {
        Basket basket = new Basket();
        loadBasket(basket);
        // System.out.println(basket); // for DEBUG
        Checkout checkout = new Checkout(basket);
        // System.out.println(checkout); // for DEBUG
        Bill bill = new Bill(checkout);
        System.out.println(bill);
    }

    static void loadBasket(Basket basket) {
        basket.addItem(new Item("Twinings Earl Grey Tea", 4.50));
        basket.addItem(new Item("Folans Orange Marmalade", 4.00));
        basket.addItem(new Item("Free-range Eggs", 3.35));
        basket.addItem(new Item("Brennan's Bread", 2.15));
        basket.addItem(new Item("Ferrero Rocher", 7.00));
        basket.addItem(new Item("Ferrero Rocher", 7.00));
    }
}
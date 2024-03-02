import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedHashMap;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Class Item
 * Represents Food Items
 * has name, weight, price
 */
class Item {
    private final String name;
    private final double price;
    /**
     * Creates an Item
     * @param name of item
     * @param price of item
     */
    Item(String name, double price) {
        this.name = name;
        this.price = price;
    }
    // final variables so no need for setters
    public String getName() {
        return this.name;
    }
    public double getPrice() {
        return this.price;
    }

    public String toString() {
        return this.name + " " + this.price;
    }
}

class Basket {
    private final Stack<Item> basket;

    Basket() {
        this.basket = new Stack<Item>();
    }

    public void addItem(Item item) {
        this.basket.push(item);
    }

    public Item removeItem() {
        if (this.basket.isEmpty()){
            return null;
        } else{
            return this.basket.pop();
        }
    }
    public boolean empty(){
        return this.basket.isEmpty();
    }

    public String toString() {
        return "basket:" + this.basket.toString();
    }
}

class Checkout {
    private final Queue<Item> checkout;

    Checkout(Basket basket) {
        this.checkout = new LinkedList<Item>();
        while(!basket.empty()){
            Item item = basket.removeItem();
            addItem(item);
        }
    }

    public void addItem(Item item) {
        this.checkout.add(item);
    }

    public Item removeItem() {
        if (this.checkout.isEmpty()){
            return null;
        } else{
            return this.checkout.poll();
        }
    }
    public boolean empty(){
        return this.checkout.isEmpty();
    }

    public String toString() {
        return "checkout:" + this.checkout.toString();
    }
}
class Bill {
    private final LinkedHashMap<String,Integer> basket;
    private double price;

    Bill(Checkout checkout) {
        // take an item out of the checkout, and bill it
        this.basket = new LinkedHashMap<String, Integer>();
        while (!checkout.empty()){
            billItem(checkout.removeItem());
        }

    }

    public void billItem(Item item) {
        String name = item.getName();
        int count = 1;
        if(this.basket.containsKey(name)){
            // count++;
            // this.basket.put(name, count);
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
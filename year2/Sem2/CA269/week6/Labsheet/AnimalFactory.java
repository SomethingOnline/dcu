
interface SafetyRegulation{
    public int getMaxItemsPermitted();
}
abstract class Item implements SafetyRegulation{
    private int MaxItemsPermitted;

    public int getMaxItemsPermitted(){
        return this.MaxItemsPermitted;
    }
    public void setMaxItemsPermitted(int MaxItemsPermitted){
        this.MaxItemsPermitted = MaxItemsPermitted;
    }
}

class Duck extends Item{
    public Duck(){
        setMaxItemsPermitted(5);
    }
}
class Swan extends Item{
    public Swan(){
        setMaxItemsPermitted(2);
    }
}
class Flamingo extends Item{
    public Flamingo(){
        setMaxItemsPermitted(3);
    }
}
class Dog extends Item{
    public Dog(){
        setMaxItemsPermitted(20);
    }
}
class Cat extends Item{
    public Cat(){
        setMaxItemsPermitted(20);
    }
}

class AnimalFactory<T extends Item & SafetyRegulation>{
    private int unitsProduced = 0;
    // public T createItem(){
    //     if (isSafe(T item)){
    //         return item;
    //     }
    // }
    // public boolean isSafe(T item){
    //     return(item instanceof AnimalFactory);
    // }

    public T continueProduction(T item){
        if(unitsProduced < item.getMaxItemsPermitted()){
            unitsProduced++;
            return item;
        }
        return null;
    }

    public int getCount(){
        return unitsProduced;
    }

    
    public static void main(String [] args){
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


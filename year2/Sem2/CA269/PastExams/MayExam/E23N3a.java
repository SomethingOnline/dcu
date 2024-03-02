class Resource { } // represents an in-game resource
// types of resources
class Stone extends Resource { }
class Wood extends Resource { }
class Water extends Resource { }


interface Item { }

class Factory {
    private static class ProprietaryItem implements Item { 
        String batch;
        ProprietaryItem(){
            batch = "FID#" + countProduced;
        }
        public string toString(){
            return batch;
        }
    }
    private int countProduced = 100;

    public static Item getItem() throws FactoryNotReadyException{ 
        if (allowInit()){
            Item item = new ProprietaryItem();
            countProduced += 1;
            return item
        }
        throw FactoryNotReadyException
    }
    private static boolean allowInit = false;

    public void startInit(boolean allowInit){
        this.allowInit = true;
    }
    public void stopInit(boolean allowInit){
        this.allowInit = false;
    }

    public static boolean isItemAuthentic(Item item) { 
        return (item instanceof ProprietaryItem);
    }
}

class FactoryNotReadyException { }

class ResourceFactory<R> extends Factory{
    R item;
    public R getItem(){
        return this.item;
    }
    public void setItem(R item){
        this.item = item;
    }
}

class StoneFactory extends ResourceFactory<Stone>{ }
class WoodFactory extends ResourceFactory<Wood>{ }
class WaterFactory extends ResourceFactory<Water> { }

class DualResourceFactory<A, B> extends Factory{
    A resourceA;
    B resourceB;
    public A getResourceA(){
        return this.resourceA;
    }
    public void setResourceA(A resourceA){
        this.resourceA = resourceA
    }

    public B getResourceB(){
        return this.resourceB;
    }
    public void setResourceB(B resourceB){
        this.resourceB = resourceB;
    }

}

class StoneWoodFactory extends DualResourceFactory<Stone, Wood>{ }
class WoodWaterFactory extends DualResourceFactory<Wood, Water>{ }
class WaterStoneFactory extends DualResourceFactory<Water, Stone> { }

class FactoryNotReadyException extends Exception{ }
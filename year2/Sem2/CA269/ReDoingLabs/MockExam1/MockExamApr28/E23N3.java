class Resource { } // represents an in-game resource
interface Item { 
	String getBatchNumber();
}

class Factory {

	private static boolean allowInit;
	private int countProduced = 100;

	public void startInit(boolean allowInit){
		this.allowInit = true;
	}
	public void stopInit(boolean allowInit){
		this.allowInit = false;
	}
    private static class ProprietaryItem implements Item {
		private final String batchNumber;
		ProprietaryItem(String batchNumber){
			this.batchNumber = batchNumber;
		}
		@Override
		public String getBatchNumber(){
			return batchNumber;
		}
	}

	public String getBatchNumber(){
		return "FID#" + countProduced;
	}

    private static Item getItem() throws FactoryNotReadyException { 
		if (!allowInit){
			throw new FactoryNotReadyException();
		} else{
			String batchNumber = "FID#" + countProduced++;
			return new ProprietaryItem(batchNumber);
		}
	}

    private static boolean isItemAuthentic(Item item) {
		if (item instanceof ProprietaryItem){
			return true;
		} else{
			return false;
		}

	}
}

class FactoryNotReadyException extends Exception{
	FactoryNotReadyException(){
		return super();
	}
	FactoryNotReadyException(String message){
		return super(message);
	}
}
// types of resources
class Stone extends Resource { }
class Wood extends Resource { }
class Water extends Resource { }

class StoneFactory extends Factory {
    Stone item;
    public Stone getItem() { return this.item; }
    public void setItem(Stone item) { this.item = item; }
}

class WoodFactory extends Factory {
    Wood item;
    public Wood getItem() { return this.item; }
    public void setItem(Wood item) { this.item = item; }
}

class WaterFactory extends Factory {
    Water item;
    public Water getItem() { return this.item; }
    public void setItem(Water item) { this.item = item; }
}

class StoneWoodFactory {
    StoneFactory stones;
    WoodFactory woods;
    public StoneFactory getResourceA() { return stones; }
    public void setResourceA(StoneFactory stones) { this.stones = stones; }
    public WoodFactory getResourceB() { return woods; }
    public void setResourceB(WoodFactory woods) { this.woods = woods; }
}

class WoodWaterFactory {
    WoodFactory wood;
    WaterFactory water;
    public WoodFactory getResourceA() { return wood; }
    public void setResourceA(WoodFactory wood) { this.wood = wood; }
    public WaterFactory getResourceB() { return water; }
    public void setResourceB(WaterFactory water) { this.water = water; }
}

class WaterStoneFactory {
    WaterFactory water;
    StoneFactory stones;
    public WaterFactory getResourceA() { return water; }
    public void setResourceA(WaterFactory water) { this.water = water; }
    public StoneFactory getResourceB() { return stones; }
    public void setResourceB(StoneFactory stones) { this.stones = stones; }
}



class GenericFactory<T extends resource>{
	T item;
	public T getItem(){
		return this.item;
	}
	public void setItem(T item){
		this.item = item;
	}
}

class TwoResourceFactory<A extends Resource, B extends resource>{
	GenericFactory<A> resourceA;
	GenericFactory<B> resourceB;

	public GenericFactory<A> getResourceA(){
		return resourceA;
	}
	public void setResourceA(GenericFactory<A> resourceA){
		this.resourceA = resourceA;
	}
	public GenericFactory<B> getResourceB(){
		return resourceB;
	}
	public void setResourceB(GenericFactory<B> resourceB){
		this.resourceB = resourceB;
	}

}
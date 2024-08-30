class Duck{}
class Swan{}
class Heron{}

class GenericFactory<T, U>{
	private int counter = 1;
	private T firstInstance;
	private U secondInstance;

	public T getItem1(){
		if (counter % 2 == 1){
			return firstInstance;
		}
		counter++;
		return firstInstance;
	}
	public U getItem2(){
		if (counter % 2 == 0){
			return secondInstance;
		}
		counter++;
		return secondInstance;
	}


	//public T getNewItem(){
	//	if(counter % 2 == 1){
	//		counter++;
	//		return firstInstance;

	//	} else{
	//		counter++;
	//		return secondInstance;
	//	}
	//}

	GenericFactory(T firstInstance, U secondInstance){
		this.firstInstance = firstInstance;
		this.secondInstance = secondInstance;
	}


    public static void main(String[] args) {
        Duck duck = new Duck();
        Swan swan = new Swan();
        GenericFactory<Duck, Swan> factory = new GenericFactory<>(duck, swan);

        System.out.println(factory.getItem1());
        System.out.println(factory.getItem2());
        System.out.println(factory.getItem1());
        System.out.println(factory.getItem2());
    }

}
class Apple { }
class AppleFactory extends Factory<Apple> {
    Apple item;
    public Apple getItem() { return this.item; }
    public setItem(Apple item) { this.item = item; }
}

class Orange { }
class OrangeFactory extends Factory <Orange>{
    Orange item;
    public Orange getItem() { return new Orange(); }
    public setItem(Orange item) { this.item = item; }
}

class Lemon extends Factory<Lemon>{
	public void removeItem(){
		this.item = null;
	}
	@Override
	public Lemon setItem(Lemon item){
		if(this.item != null){
			return ;
		} else{
			this.item = item;
		}
	}

}


class Factory<T>{
	T item;
	public T getItem(){
		return this.item;
	}
	public T setItem(T item){
		this.item = item;
	}
}


// Exception

class NoCakeFoundException extends Exception{
	NoCakeFoundException(){
		return super();
	}
	NoCakeFoundException(String message){
		return super(message);
	}
	public String toString(){
		return "The Cake is a Lie!"
	}
}
class Cake{
	public void getCake() throws NoCakeFoundException{
		throw new NoCakeFoundException();
	}
	public void eatCake(){
		try{
			getCake();
		} catch( NoCakeFoundException exception){
			System.out.println(exception);
		}
	}
}


// FizzBuzz

class NumberObject{}
interface Div3{}
interface div5{}
class NumDiv3 extends NumberObject implements Div3{}
class NumDiv5 extends NumberObject implements Div5{}
class NumDiv15 extends NumberObject implements Div3, Div5{}



class Game {
    public static void play(NumberObject obj) {
        if ((obj instanceof Div3) || (obj instanceof Div5)) {
            if (obj instanceof Div3) {
                System.out.print("Fizz");
            }
            if (obj instanceof Div5) {
                System.out.print("Buzz");
            }
            System.out.println();
        } else {
            System.out.println(obj);
        }
    }
}
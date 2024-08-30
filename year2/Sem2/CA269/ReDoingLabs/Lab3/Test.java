
interface Message{
	String communicate();
}
class Test implements Message{
	public String communicate(){
		return "Hello World";
	}
	public static void main(String[] args){
		Test t1 = new Test();
		System.out.println(t1.communicate());
	}
}
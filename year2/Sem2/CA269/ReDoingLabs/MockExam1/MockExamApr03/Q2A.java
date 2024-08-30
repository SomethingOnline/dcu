

//interface FamilyMember extends PersonalDetails {
//    String getNickname();
//    void setNickname(String name);
//}

//interface PersonalDetails {
//    String getName();
//    int getAge();
//}

//class Individual{
//	public String name;
//	Individual(String name){
//		this.name = name;
//	}
//	public String toString(){
//		return this.name;
//	}
//}

//class Person extends Individual implements FamilyMember{
//	protected String nickname;
//	private int age;

//	public int getAge(){
//		return age;
//	}
//	public String getName(){
//		return name;
//	}
//	public String getNickname(){
//		return this.nickname;
//	}
//	public void setNickname(String nickname){
//		this.nickname = nickname;
//	}


//	Person(String name, String nickname){
//		super(name);
//		this.nickname = nickname;
//	}
//	public String toString(){
//		return this.name + " (" + this.nickname + ")";
//	}
//}

class Person {
    private String name;
}
class Employee extends Person {
    private String empoyeeID;
}
interface VIP {
    String VIPStatus();
}

class CompanyGathering {
	public boolean admitPerson(Person person){
		return (person instanceof Employee || person instanceof VIP);
	}
}
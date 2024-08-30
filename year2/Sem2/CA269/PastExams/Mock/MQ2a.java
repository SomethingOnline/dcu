
interface FamilyMember extends PersonalDetails {
    String getNickname();
    void setNickname(String name);
}

interface PersonalDetails {
    String getName();
    int getAge();
}

class Person {
    private String name;
}
class Employee extends Person {
    private String empoyeeID;
}
interface VIP {
    String VIPStatus();
}

class CompanyGathering{
    public boolean admitPerson(Person person){
        if (person instanceof VIP|| person instanceof Employee){
            return true;
        }
        return false;
    }
}
class Individual{
    public String name = "Harshvardhan";
    public Individual(String name){
        this.name = name;
    }
    public String toString(){
        System.out.println(this.name);
    }
}

class Person extends Individual implements FamilyMember{
    private int age;
    protected String nickname = "Harsh";
    public Person(String name, String nickname){
        super(name);
        this.nickname = nickname;
    }
    public String getNickname(){
        return this.nickname;
    }
    public void setNickname(String nickname){
        this.nickname = nickname;
    }
    public String getName(){
        return this.name;
    }
    public int getAge(){
        return this.age;
    }

    public String toString(){
        System.out.println(this.name + " " + this.nickname);
    }
}
import java.util.Arrays;

public class Pokemon_2 {

    static String GENERATION = "Gen-I";
    static final String LOCATION = "Kanto";
    static final String[] VERSIONS = { "RED", "GREEN", "YELLOW", "BLUE" };

    int health_max = 100;
    int moves_max = 5;
    String type = "";
    private String newName;

    public Pokemon_2(String newName) {
        this.newName = newName;
    }

    public String sayHello() {
        return "Hello " + this.newName + ". You are being printed by this method.";
    }

    public String getName() {
        return newName;
    }

    public void setName(String newName) {
        if ("lukas".equals(newName)) {
            this.newName = "testing";
        } else {
            this.newName = newName;
        }
    }

    public String toString() {
        return sayHello();
    }

    public static void main(String[] args) {
        Pokemon_2 myInstance = new Pokemon_2("Jack");
        System.out.println(myInstance);

        Pokemon_2 myInstance2 = new Pokemon_2("lukas");
        myInstance2.setName("lukas");
        System.out.println(myInstance2);
    }
}

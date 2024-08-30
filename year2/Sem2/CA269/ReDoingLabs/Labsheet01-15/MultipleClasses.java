// Pokemon 1
import java.util.Arrays;

class Pokemon_1{
	static String GENERATION = "GEN-I";
	static final String LOCATION = "Kanto";
	static final String[] VERSIONS = {"RED", "GREEN", "YELLOW", "BLUE"};

	// creating the basic pokemon
	int health_max = 100;
	int moves_max = 5;
	String type = "";
	String name = "";

	// constructor to create objects 
	public Pokemon_1(String name, String type, int health_max){
		this.name = name;
		this.type = type;
		if (health_max > 0){
			this.health_max = health_max;
		}
	}

	public String toString(){
		return this.name + " (" + this.type + ", " + this.health_max + ")";
	}

	
    public static void main(String[] args) {
        // class specific stuff
        System.out.println(Pokemon_1.GENERATION);
        System.out.println(Pokemon_1.LOCATION);
        System.out.println(Arrays.toString(Pokemon_1.VERSIONS));

        // creating instances with their own variables
        // check the outputs are distinct
        Pokemon_1 Charmander = new Pokemon_1("Charmander", "Fire", 39);
        System.out.println(Charmander);
        Pokemon_1 Bulbasaur = new Pokemon_1("Bulbasaur", "Grass", 45);
        System.out.println(Bulbasaur);
        Pokemon_1 Squirtle = new Pokemon_1("Squirtle", "Fire", 44);
        System.out.println(Squirtle);

        // this also works! Class variables are shared amongst instances
        // check the below output that show sthis
        System.out.println(Charmander.GENERATION);
        Charmander.GENERATION = "Gen-II";
        System.out.println(Bulbasaur.GENERATION);
        // change the GENERATION variable to final and
        // check if the above is still allowed

		XYZ xyzInstance = new XYZ("SomeName");
		String message = xyzInstance.sayHello("Random");
		System.out.println(message);
		System.out.println(xyzInstance);
    }
}

class XYZ{
	private String name;

	public XYZ(String name){
		this.name = name;
	}
	public String sayHello(String name){
		return "Hello " + name;
	}

	public String toString(){
		return "This is ur name " + this.name;
	}
}
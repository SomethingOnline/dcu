import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.io.Writer;
import java.io.IOException;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.csv.CSVFormat;
import java.util.*;
import com.google.gson.Gson;

class StarWarsCharacter {
    String name = "";
    String height = "";
    String mass = "";
    String hairColor = "";
    String skinColor = "";
    String eyeColor = "";
    String birthYear = "";
    String gender = "";
    String homeworld = "";
    String species = "";

    StarWarsCharacter() { }

    // additional constructors go here
    StarWarsCharacter(String name, String height, String mass, String hairColor, String skinColor, String eyeColor, String birthYear, String gender, String homeworld, String species){
        this.name = name;
        this.height = height;
        this.mass = mass;
        this.hairColor = hairColor;
        this.skinColor = skinColor;
        this.eyeColor = eyeColor;
        this.birthYear = birthYear;
        this.gender = gender;
        this.homeworld = homeworld;
        this.species = species;
    }

    // getters and setters go here
   public void setName(String name) {
        this.name = name;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public void setMass(String mass) {
        this.mass = mass;
    }

    public void setHairColor(String hairColor) {
        this.hairColor = hairColor;
    }

    public void setSkinColor(String skinColor) {
        this.skinColor = skinColor;
    }

    public void setEyeColor(String eyeColor) {
        this.eyeColor = eyeColor;
    }

    public void setBirthYear(String birthYear) {
        this.birthYear = birthYear;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setHomeworld(String homeworld) {
        this.homeworld = homeworld;
    }

    public void setSpecies(String species) {
        this.species = species;
    }
    // toString to print character info.
    public String toString(){
        return "Name: " + name + "\nHeight: " + height + "\nMass: " + mass + "\nHair Color: " + hairColor + "\nSkin Color: " + skinColor + "\nEye Color: " + eyeColor + "\nBirth Year: " + birthYear + "\nGender" + gender + "\nHomeworld: " + homeworld + "\nSpecies: " + species + "\n";
    }
}


public class JarJarBinks {
    public static void main(String[] arg) throws IOException {
        List<StarWarsCharacter> charactersList = new ArrayList<>();
        Reader in = new FileReader("characters.csv");
        CSVFormat CSVparser = CSVFormat.Builder.create().setHeader().build();
        Iterable<CSVRecord> records = CSVparser.parse(in);
        // Iterable<CSVRecord> records = CSVFormat.DEFAULT.withHeader.parse(in);
        for (CSVRecord record: records){
            // System.out.println for local testing
            // commented out for the code
            // gson writes the code to the characters.json file
            StarWarsCharacter character = new StarWarsCharacter();
            //System.out.println(record.get("name"));
            character.name = record.get("name");
            //System.out.println(record.get("height"));
            character.height = record.get("height");
            //System.out.println(record.get("mass"));
            character.mass = record.get("mass");
            //System.out.println(record.get("hair_color"));
            character.hairColor = record.get("hair_color");
            //System.out.println(record.get("skin_color"));
            character.skinColor = record.get("skin_color");
            //System.out.println(record.get("eye_color"));
            character.eyeColor = record.get("eye_color");
            //System.out.println(record.get("birth_year"));
            character.birthYear = record.get("birth_year");
            //System.out.println(record.get("gender"));
            character.gender = record.get("gender");
            //System.out.println(record.get("homeworld"));
            character.homeworld = record.get("homeworld");
            //System.out.println(record.get("species"));
            character.species = record.get("species");
            charactersList.add(character);
        }

        Writer out = new FileWriter("characters.json");
        Gson gson = new Gson();
        gson.toJson(charactersList, out);
        out.close();
        //System.out.println(gson.toJson(charactersList.get(0)));
        //System.out.println(gson.toJson(charactersList.get(charactersList.size()-1)));
    }
}
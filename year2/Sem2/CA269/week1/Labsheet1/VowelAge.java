import java.util.Scanner;

public class VowelAge{

    public static void main(String[] args){

        Scanner input = new Scanner(System.in);
        String name = input.nextLine();
        String lowerCaseName = name.toLowerCase();
        int age = input.nextInt();

        char[] name_chars = lowerCaseName.toCharArray();
        int vowelCount = 0;
        for (int i = 0; i < name_chars.length; i++)
        {
            if (name_chars[i] == 'a' || name_chars[i] == 'e' || name_chars[i] == 'i' || name_chars[i] == 'o' || name_chars[i] == 'u')
            {
                vowelCount++;
            }
        }
        if (age < 18){
            System.out.println("Hello " + name + ", you have " + vowelCount + " vowels, and you are a minor");
        }
        else{
            System.out.println("Hello " + name + ", you have " + vowelCount + " vowels, and you are an adult");
        }


        


    }
}
package JavaBase.Exercices;

import java.util.Scanner;

public class CheckLetter {
    static void main() {
        System.out.println("Check if a letter is Uppercase or Lowercase");
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a letter");
        char letter = in.next().charAt(0);

        if(Character.isUpperCase(letter)){
            System.out.println("The letter is Uppercase");
        }else{
            System.out.println("The letter is Lowercase");
        }
    }
}

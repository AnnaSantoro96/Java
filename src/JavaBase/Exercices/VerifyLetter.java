package JavaBase.Exercices;

import java.util.Scanner;

public class VerifyLetter {
    static void main() {
        Scanner in = new Scanner(System.in);
        System.out.println("Verify if the letter is a consonant or a vowel");
        System.out.println("Enter a letter");
        char letter = in.next().charAt(0);

        if(letter == 'a' || letter == 'e' || letter == 'i' || letter == 'o' || letter == 'u' || letter == 'A' || letter == 'E' || letter == 'I' || letter == 'O' || letter == 'U'){
            System.out.println("The letter is a vowel");
        }else{
            System.out.println("The letter is a consonant");
        }
    }
}

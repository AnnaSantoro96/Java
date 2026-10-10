package JavaBase.Methods;

import java.util.Scanner;

public class Occurrences {

    static int countOccurrences(String str, char target){
        int count = 0;

        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == target){
                count++;
            }
        }
        return count;
    }

    static void main() {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter a word.");
        String word = in.nextLine();

        System.out.println("Enter the character to found");
        char character = in.next().charAt(0);

        int occurrences = countOccurrences(word, character);
        System.out.println("In the word " + word + " the character " + character + " is present " + occurrences + " times");

    }
}

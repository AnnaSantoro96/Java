package JavaBase.String;

import java.util.Scanner;

public class CountNumberCharacter {
    static void main() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a word");
        String word = in.nextLine();

       int length = word.length();

       System.out.println("The word has " + length + " character");
    }
}

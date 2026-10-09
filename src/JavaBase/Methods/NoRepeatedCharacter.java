package JavaBase.Methods;

import java.util.Scanner;

public class NoRepeatedCharacter {
    static char noRepeatedCharacter(String str) {
        for (int i = 0; i < str.length(); i++) {
            boolean repeated = false;

            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(i) == str.charAt(j) && i != j) {
                    repeated = true;
                    break;
                }
            }

            if(!repeated) return str.charAt(i);
        }

        return '\0';
    }

    static void main() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a word");
        String word = in.nextLine();

        char character = noRepeatedCharacter(word);
        System.out.println("The no-repeated character in the word " + word + " is " + character);
    }
}

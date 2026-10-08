package JavaBase.Methods;

import java.util.Scanner;

public class CountInAString {

    static int countVowels(String str) {
        int count = 0;
        str = str.toLowerCase();

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'a' ||
                    str.charAt(i) == 'e' ||
                    str.charAt(i) == 'i' ||
                    str.charAt(i) == 'o' ||
                    str.charAt(i) == 'u') {

                count++;
            }
        }

        return count;
    }

    static int countConsonants(String str) {
        int count = 0;
        str = str.toLowerCase();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (Character.isLetter(c) &&
                    !(c == 'a' ||
                            c == 'e' ||
                            c == 'i' ||
                            c == 'o' ||
                            c == 'u')) {

                count++;
            }
        }

        return count;
    }

    static void main() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a word");
        String word = in.nextLine();

        int vowels = countVowels(word);
        int consonants = countConsonants(word);
        System.out.println("The word " + word + " has " + vowels + " vowels");
        System.out.println("The word " + word + " has " + consonants + " consonants");
    }
}

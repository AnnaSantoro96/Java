package JavaBase.Methods;

import java.util.Scanner;

public class CountWords {

    static int countWords(String str) {
        int count = 0;

        for (int i = 0; i < str.length(); i++) {
            if (Character.isLetter(str.charAt(i)) &&
                    (i == 0 || !Character.isLetter(str.charAt(i - 1)))) {
                count++;
            }
        }

        return count;
    }


    static void main() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a sentence");
        String sentence = in.nextLine();

        int count = countWords(sentence);
        System.out.println("Number of words");
        System.out.println(count);
    }
}

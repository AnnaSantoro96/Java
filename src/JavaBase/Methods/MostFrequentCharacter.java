package JavaBase.Methods;

import java.util.Scanner;

public class MostFrequentCharacter {
    static char mostFrequentChar(String str) {
        int maxCount = 0;
        char mostFrequent = str.charAt(0);

        for (int i = 0; i < str.length(); i++) {
            int count = 0;

            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(i) == str.charAt(j)) {
                    count++;
                }
            }

            if(count > maxCount){
                maxCount = count;
                mostFrequent = str.charAt(i);
            }
        }

        return mostFrequent;
    }


    static void main() {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter a word");
        String word = in.nextLine();

        char occurrences = mostFrequentChar(word);
        System.out.println("The frequest character in the word " + word + " is " + occurrences);
    }
}

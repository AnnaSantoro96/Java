package JavaBase.Methods;

import java.util.Scanner;

public class LeastFrequentChar {

    static char leastFrequentChar(String str){
        int minCount = Integer.MAX_VALUE;
        char leastFrequent = str.charAt(0);

        for (int i = 0; i < str.length(); i++) {
            int count = 0;

            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(i) == str.charAt(j)) {
                    count++;
                }
            }
            if(count <= minCount){
                minCount = count;
                leastFrequent = str.charAt(i);
            }
        }

        return leastFrequent;
    }

    static void main() {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter a word");
        String word = in.nextLine();

        char occurrences = leastFrequentChar(word);
        System.out.println("The  character with the least frequent  in the word " + word + " is " + occurrences);
    }
}

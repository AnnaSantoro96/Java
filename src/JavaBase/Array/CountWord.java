package JavaBase.Array;

import java.util.Scanner;

public class CountWord {
    static void main() {

        Scanner in = new Scanner(System.in);

        String [] words = {"house", "car", "car", "dog", "pen"};
        int count = 0;

        System.out.println("Enter a word that you want found.");
        String word = in.nextLine();

        for(String w : words){
            if(w.equalsIgnoreCase(word)){
                count++;
            }
        }

        System.out.println("The word " + word + " is present " + count + " times.");
    }
}

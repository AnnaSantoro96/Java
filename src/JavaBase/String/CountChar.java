package JavaBase.String;

import java.util.Scanner;

public class CountChar {
    static void main() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a word.");
        String word = in.nextLine();

        int count = 0;

        for(int i = 0; i < word.length(); i++){
            if(word.charAt(i) == 'A' || word.charAt(i) == 'a'){
                count++;
            }
        }

        System.out.println("The number of a/A present in the word " + word + " are " + count);
    }
}

package JavaBase.String;

import java.util.Scanner;

public class ReverseString {
    static void main() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a word");
        String word = in.nextLine();
        String reverse = "";

        System.out.println("WITH FOR LOOP");
        for(int i = word.length() - 1; i >= 0; i--){
            reverse += word.charAt(i);
        }

        System.out.println(reverse);

        System.out.println("WITH STRING BUILDER");
        String rev = new StringBuilder(word).reverse().toString();
        System.out.println(rev);
    }
}

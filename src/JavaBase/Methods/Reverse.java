package JavaBase.Methods;

import java.util.Scanner;

public class Reverse {
    static String reverse(String str){
        String reverse = "";
        for(int i = str.length()-1; i >= 0; i--){
            reverse += str.charAt(i);
        }

        return reverse;
    }

    static void main() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a word");
        String word = in.nextLine();

        System.out.println("String reverse");
        String reverse = reverse(word);
        System.out.println(reverse);
    }
}

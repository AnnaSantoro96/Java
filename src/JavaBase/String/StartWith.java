package JavaBase.String;

import java.util.Scanner;

public class StartWith {
    static void main() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a word");
        String word = in.nextLine();

        if(word.toLowerCase().startsWith("A")){
            System.out.println("The word " + word + " starts with the letter A");
        }else{
            System.out.println("The word " + word + " does not starts with the letter A");
        }
    }
}

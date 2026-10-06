package JavaBase.Exercices;

import java.util.Scanner;

public class PrintStringChart {
    static void main() {
        Scanner in = new Scanner(System.in);

        System.out.println("Print a single chart of a String");

        System.out.println(" ");
        System.out.println("Enter a word");
        String word = in.nextLine();
        System.out.println(" ");
        System.out.println("Normal FOR");
        for (int i = 0; i < word.length(); i++){
            char character = word.charAt(i);
            System.out.println(character);
        }

        System.out.println(" ");
        System.out.println("FOR EACH");

        for(char i : word.toCharArray()){
            System.out.println(i);
        }
    }
}

package JavaBase.Methods;

import java.util.Scanner;

public class CountUpperCase {
    static int countUpperCase(String str){
        int count = 0;

        for(int i = 0; i < str.length(); i++){
            if(Character.isUpperCase(str.charAt(i))){
                count++;
            }
        }

        return count;
    }

    static void main() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a word");
        String word = in.nextLine();

        int upperCase = countUpperCase(word);
        System.out.println("The word " + word + " has " + upperCase + " uppercase characters");
    }
}

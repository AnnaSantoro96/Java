package JavaBase.Methods;

import java.util.Scanner;

public class RepeatedCharacter {

    static char firstRepeatedChar(String str){

        for(int i = 0; i < str.length(); i++){
            for(int j = i + 1; j < str.length(); j++){
                if(str.charAt(i) == str.charAt(j)){
                    return str.charAt(i);
                }
            }
        }
        return '\0';
    }

    static void main() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a word");
        String word = in.nextLine();

        char character = firstRepeatedChar(word);
        System.out.println("The repeated character in the word " + word + " is " + character);
    }
}

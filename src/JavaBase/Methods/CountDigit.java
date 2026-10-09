package JavaBase.Methods;

import java.util.Scanner;

public class CountDigit {

    static int countDigit(String str){
        int count = 0;
        for(int i = 0; i < str.length(); i++){
            if(Character.isDigit(str.charAt(i))){
                count++;

            }
        }
        return count;
    }

    static void main() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a word");
        String word = in.nextLine();

        int digit = countDigit(word);
        System.out.println("The string " + word + " contains " + digit + " digits");
    }
}

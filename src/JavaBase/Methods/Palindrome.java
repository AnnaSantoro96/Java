package JavaBase.Methods;

import java.util.Scanner;

public class Palindrome {

    /*static boolean isPalindrome(String str){
      str = str.toLowerCase();
      String reverse = new StringBuilder(str).reverse().toString();
      return str.equals(reverse);

    }*/

    static boolean isPalindrome(String str){
        str = str.toLowerCase().replaceAll("[^\\p{L}\\p{N}]", "");

        for(int i = 0; i < str.length()/2; i++){
            if(str.charAt(i) != str.charAt(str.length() - 1 - i)){
                return false;
            }
        }

        return true;
    }

    static void main() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a word");
        String word = in.nextLine();

        boolean palindrome = isPalindrome(word);
        System.out.println("The word " + word + " is palindrome? " + palindrome);
    }
}

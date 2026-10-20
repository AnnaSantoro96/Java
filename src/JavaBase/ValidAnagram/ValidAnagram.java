package JavaBase.ValidAnagram;

import java.util.Scanner;

public class ValidAnagram {

    static String orderLetter(String str){
        char [] letter = str.toCharArray();

        for(int i = 0; i < letter.length-1; i++){
            int minIndex = i;

            for(int j = i+1; j < letter.length; j++){
                if(letter[j] < letter[minIndex])
                    minIndex = j;
            }

            char temp = letter[i];
            letter[i] = letter[minIndex];
            letter[minIndex] = temp;
        }

        return new String(letter);
    }

    static boolean isAnagram(String s, String t) {
        s = s.replaceAll("\\s", "").toLowerCase();
        t = t.replaceAll("\\s", "").toLowerCase();

        if(s.length() != t.length()) return false;

        String str1 = orderLetter(s);
        String str2 = orderLetter(t);

        return str1.equalsIgnoreCase(str2);
    }
    static void main() {

        Scanner in = new Scanner(System.in);
        IO.println("Enter the first word");
        String str1 = in.nextLine();
        IO.println("Enter the secondo word");
        String str2 = in.nextLine();

        boolean isAnagram = isAnagram(str1, str2);
        System.out.println();
        System.out.println("The word " + str1 + " and the word " + str2 + " are anagram?");
        System.out.println(isAnagram);
    }
}

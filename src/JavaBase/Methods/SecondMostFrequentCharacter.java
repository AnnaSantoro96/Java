package JavaBase.Methods;

import java.util.Scanner;

public class SecondMostFrequentCharacter {

    static char secondMostFrequentChar(String str){
        int firstMaxCount = 0;
        int secondMaxCount = 0;
        char mostFrequentChar = str.charAt(0);
        char secondMostFrequentChar = '\0';

        for(int i = 0; i < str.length(); i++){
            int count = 0;

            for(int j = 0; j < str.length(); j++){
                if(str.charAt(i) == str.charAt(j)){
                    count++;
                }
            }
            if(count > firstMaxCount){
                if(firstMaxCount > 0){
                    secondMaxCount = firstMaxCount;
                    secondMostFrequentChar = mostFrequentChar;
                }
                firstMaxCount = count;
                mostFrequentChar = str.charAt(i);
            }

            if(count < firstMaxCount &&  count > secondMaxCount){
                secondMaxCount = count;
                secondMostFrequentChar = str.charAt(i);
            }
        }

        return secondMostFrequentChar;
    }

    static void main() {
        Scanner in =  new Scanner(System.in);
        System.out.println("Enter a word");
        String str = in.nextLine();

        char secondMostFrequentChar = secondMostFrequentChar(str);
        System.out.println("The second most frequent character is: " + secondMostFrequentChar);
    }
}

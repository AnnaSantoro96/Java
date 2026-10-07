package JavaBase.String;

import java.util.Scanner;

public class CheckWorkInAString {
    static void main() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a String");
        String str = in.nextLine();
        boolean found = false;

       for(int i = 0; i < str.length(); i++){
           if(str.substring(i, i+4).equalsIgnoreCase("test")){
               found = true;
               break;
           }
       }
        if (found) {
            System.out.println("The word test is present.");
        } else {
            System.out.println("The word test is NOT present.");
        }
    }
}

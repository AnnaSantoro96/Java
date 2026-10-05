package JavaBase.Exercices;

import java.util.Scanner;

public class CheckNumber {
    static void main() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a number:");
        int number = in.nextInt();

        if(number > 0){
            System.out.println("The number is positive.");
        } else if (number < 0) {
            System.out.println("The number is negative");
        }else{
            System.out.println("The number is zero");
        }
    }
}

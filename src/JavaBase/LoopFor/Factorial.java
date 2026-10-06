package JavaBase.LoopFor;

import java.util.Scanner;

public class Factorial {
    static void main() {

        Scanner in = new Scanner(System.in);
        System.out.println("Enter a number for count the factorial.");
        int number = in.nextInt();

        int fact = 1;
        for (int i = 1; i <= number; i++){
            fact *= i;
        }

        System.out.println("Factorial of " + number + " is " + fact);
    }
}

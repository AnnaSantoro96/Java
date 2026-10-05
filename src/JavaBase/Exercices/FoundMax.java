package JavaBase.Exercices;

import java.util.Scanner;

public class FoundMax {
    static void main() {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter the first number:");
        int number1 = in.nextInt();

        System.out.println("Enter the second number:");
        int number2 = in.nextInt();

        System.out.println("The maximum between " + number1 + " and " + number2 + " is " + Math.max(number1, number2));
    }
}

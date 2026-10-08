package JavaBase.Methods;

import java.util.Scanner;

public class CalculateSquare {

    static double calculateSquare(double x) {
        return Math.pow(x, 2);
    }

    static double calculateExp(double x, int exp) {
        return Math.pow(x, exp);
    }

    static void main() {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter a number");
        double x = in.nextDouble();

        double square = calculateSquare(x);
        System.out.println("The square of " + x + " is " + square);

        System.out.println();

        System.out.println("Enter the number.");
        double num = in.nextDouble();

        System.out.println("Enter the exponent");
        int exp = in.nextInt();

        double result = calculateExp(num, exp);
        System.out.println("Result: " + result);

        in.close();
    }
}
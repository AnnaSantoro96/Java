package JavaBase.Exercices;

import java.util.Scanner;

public class SwapValue {
    static void main() {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter the first value");
        int varA = in.nextInt();

        System.out.println("Enter the second value");
        int varB = in.nextInt();

        System.out.println("Value before the swap " + "varA: " + varA + " varB " + varB);

        System.out.println(" ");

        System.out.println("I swap the values...");
        int tmp = 0;
        tmp = varA;
        varA = varB;
        varB = tmp;


    System.out.println("Swap value: " + "VarA: " + varA + " VarB: " + varB);
    }
}

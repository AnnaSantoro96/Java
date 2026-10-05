package JavaBase.Exercices;

import java.util.Scanner;

public class AverageAge {
    static void main() {
        Scanner in = new Scanner(System.in);
        final int NUMBER_PERSON = 3;

        System.out.println("Enter the age of the first person.");
        int age1 = in.nextInt();

        System.out.println("Enter the age of the second person.");
        int age2 = in.nextInt();

        System.out.println("Enter the age of the third person.");
        int age3 = in.nextInt();

        int averageAge = (age1 + age2 + age3) / NUMBER_PERSON;

        System.out.println("The average age is: " + averageAge);
    }
}

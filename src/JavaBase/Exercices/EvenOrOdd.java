package JavaBase.Exercices;

import java.util.Scanner;

public class EvenOrOdd {
    static void main() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a number:");
        int number = in.nextInt();

        if(number % 2 == 0){
            System.out.println("The number is Even.");
        }else{
            System.out.println("The number is Odd.");
        }
    }
}

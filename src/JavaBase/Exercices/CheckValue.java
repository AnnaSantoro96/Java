package JavaBase.Exercices;

import java.util.Scanner;

public class CheckValue {
    static void main() {
        System.out.println("Check if the number is present in a range");
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a number.");
        int number = in.nextInt();

        int max = 20;
        int min = 10;

        if(number > 10 && number < 20){
            System.out.println(number + " is present in the range.");
        }else{
            System.out.println(number + " is not present in the range");
        }
    }
}

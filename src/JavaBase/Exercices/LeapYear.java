package JavaBase.Exercices;

import java.util.Scanner;

public class LeapYear {
    static void main() {
        System.out.println("Check Leap Year");
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a year.");

        int year = in.nextInt();

        if(year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)){
            System.out.println(year + " is a leap year.");
        }else{
            System.out.println(year + " is not a leap year");
        }
    }
}

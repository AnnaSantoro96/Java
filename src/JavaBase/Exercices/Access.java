package JavaBase.Exercices;

import java.util.Scanner;

public class Access {
    static void main() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter your age:");

        int age = in.nextInt();

        if(age >= 18){
            System.out.println("You can access");
        }else{
            System.out.println("You cannot access");
        }
    }
}

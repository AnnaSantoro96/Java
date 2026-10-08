package JavaBase.Methods;

import java.util.Scanner;

public class CountFromOneToN {

    static void count(int n){
        for(int i = 1; i <= n; i++){
            System.out.println(i);
        }
    }

    static void countDown(int n){
        for(int i = n; i >= 1; i--){
            System.out.println(i);
        }
    }

    static void main() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a number");
        int n = in.nextInt();
        count(n);

        System.out.println(" ");
        System.out.println("COUNTDOWN");
        System.out.println("Enter a number");
        int x = in.nextInt();
        countDown(x);
    }
}

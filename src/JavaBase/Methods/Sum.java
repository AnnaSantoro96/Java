package JavaBase.Methods;

import java.util.Scanner;

public class Sum {
    static int sum(int n){
        int sum = 0;

        for(int i = 0; i <= n; i++){
            sum += i;
        }
        return sum;
    }
    static void main() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a number");
        int x = in.nextInt();

        int sum = sum(x);
        System.out.println("Sum: " + sum);
    }
}

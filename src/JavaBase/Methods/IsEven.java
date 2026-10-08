package JavaBase.Methods;

import java.util.Scanner;

public class IsEven {

    static  boolean isEven(int x){
        return x % 2 == 0;
    }

    static void main() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a number.");
        int num = in.nextInt();

        boolean even = isEven(num);
        System.out.println(even);

    }
}

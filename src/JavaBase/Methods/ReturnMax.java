package JavaBase.Methods;

import java.util.Scanner;

public class ReturnMax {

    static int returnMax(int x, int y, int z){
        int max = 0;
        if(x >= y && x >= z){
            max = x;
        } else if (y >= x && y >= z) {
            max = y;
        }else{
            max = z;
        }

        return max;
    }

    static void main() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter three numbers");
        int num1 = in.nextInt();
        int num2 = in.nextInt();
        int num3 = in.nextInt();

        int max = returnMax(num1, num2, num3);
        System.out.println(max);
    }
}

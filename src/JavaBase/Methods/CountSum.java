package JavaBase.Methods;

import java.util.Scanner;

public class CountSum {

    static int sum(int x){
        int sum = 0;

        for(int i = 1; i <= x; i++){
            sum += i;
        }
        return sum;
    }

    static int sumEven(int x){
        int sum = 0;
        for(int i = 1; i <= x; i++){
            if(i % 2 == 0){
                sum += i;
            }
        }
        return sum;
    }

    static int sumOdd(int x){
        int sum = 0;
        for(int i = 1; i <= x; i++){
            if(i % 2 == 1){
                sum += i;
            }
        }
        return sum;
    }

    static int countEven(int x){
        int count = 0;
        for(int i = 1; i <= x; i++){
            if(i % 2 == 0){
                count++;
            }
        }
        return count;
    }

    static int countOdd(int x){
        int count = 0;
        for(int i = 1; i <= x; i++){
            if(i % 2 == 1){
                count++;
            }
        }
        return count;
    }

    static void main() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a number");
        int num = in.nextInt();

        int sum = sum(num);
        System.out.println("SUM ALL");
        System.out.println("Result: " + sum);

        System.out.println(" ");
        int sumEven = sumEven(num);
        System.out.println("SUM EVEN");
        System.out.println("Result: " + sumEven);

        System.out.println(" ");
        int sumOdd = sumOdd(num);
        System.out.println("SUM ODD");
        System.out.println("Result: " + sumOdd);

        System.out.println(" ");
        int countEven = countEven(num);
        System.out.println("NUMBER OF EVEN ELEMENTS");
        System.out.println(countEven);

        System.out.println(" ");
        int countOdd = countOdd(num);
        System.out.println("NUMBER OF ODD ELEMENTS");
        System.out.println(countOdd);
    }

}

package JavaBase.Methods;

import java.util.Scanner;

public class IsPrime {

    static boolean isPrime(int n) {
        if (n <= 1) return false;

        if (n == 2) return true;

        if (n % 2 == 0) return false;

        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    static int countPrimes(int n){
        int count = 0;

        for(int i = 1; i <= n; i++){
            if(isPrime(i))
                count++;
        }

        return count;
    }

    static int sumPrimes(int n){
        int sum = 0;

        for(int i = 1; i <= n; i++){
            if(isPrime(i)){
                sum += i;
            }
        }

        return sum;
    }

    static void main() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a number");
        int num = in.nextInt();

        boolean prime = isPrime(num);
        System.out.println("The number " + num + " is prime? " + prime);

        System.out.println(" ");
        System.out.println("Enter a number");
        int c = in.nextInt();
        System.out.println("NUMBER OF PRIME");
        int count = countPrimes(c);
        System.out.println(count);

        System.out.println(" ");
        System.out.println("SUM OF PRIMES NUMBERS");
        int sum = sumPrimes(c);
        System.out.println(sum);
    }
}

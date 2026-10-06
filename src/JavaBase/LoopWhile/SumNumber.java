package JavaBase.LoopWhile;

public class SumNumber {
    static void main() {
        System.out.println("Sum values from 1 to 100");

        int i = 1;
        int sum = 0;

        while(i <= 100){
            sum = sum + i;
            System.out.println("Sum: " + sum);
            i++;
        }
        System.out.println("Sum: " + sum);
    }
}

package JavaBase.LoopFor;

public class Sum {
    static void main() {
        System.out.println("Print the sum from 1 to 100");

        int sum = 0;
        for (int i = 1; i <= 100; i++){
            sum += i;
        }

        System.out.println("The sum from 1 to 100 is " + sum);
    }
}

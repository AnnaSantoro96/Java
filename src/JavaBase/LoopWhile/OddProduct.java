package JavaBase.LoopWhile;

public class OddProduct {
    static void main() {
        System.out.println("Calculate the product of the odd numbers from 1 to 15");

        int i = 1;
        int product = 1;

        while(i <= 15){

            product *= i;
            i *= 2;
        }

        System.out.println("The product is " + product);
    }
}

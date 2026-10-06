package JavaBase.LoopFor;

public class Count {
    static void main() {
        System.out.println("Count One Hundred Times.");

        for(int i = 1; i <= 100; i++){
            System.out.println(i);
        }

        System.out.println(" ");
        System.out.println("Count to 100 by tens");

        for (int i = 0; i <= 100; i+= 10){
            System.out.println(i);
        }

        System.out.println(" ");
        System.out.println("Count even values between 0 and 10");

        for (int i = 0; i <= 10; i += 2){
            System.out.println(i);
        }

        System.out.println(" ");
        System.out.println("Print the multiplication table for the number 2");

        int number = 2;
        for (int i = 1; i <= 10; i++){
            System.out.println(number + " x " + i + " = " + (number * i));
        }

    }
}

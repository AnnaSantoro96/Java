package JavaBase.LoopWhile;

public class FiveTabel {
    static void main() {
        System.out.println("Print the Five Tabel.");

        int number = 5;
        int i = 1;

        while(i <= 10){
            int result = number * i;
            System.out.println(number + " x " + i + " = " + result);
            i++;
        }
    }
}

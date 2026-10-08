package JavaBase.Methods;

public class DoubleGame {

    static int doubleGame(int x){
        return x * 2;
    }

    static void main() {

        for(int i = 1; i <= 5; i++){
            System.out.println("Double of " + i + " is " + doubleGame(i));
        }
    }
}

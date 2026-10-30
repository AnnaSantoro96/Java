package Exceptions.CheckNumber;

public class CheckNumber {
    static void checkNumber(int number) {
        if(number < 0) {
            throw new IllegalArgumentException("Numero negativo");
        }

        System.out.println("Numero valido");
    }

    static void main() {
        try {
            checkNumber(-2);
        } catch (IllegalArgumentException e) {
            System.out.println("Errore: " + e.getMessage());
        }
    }
}

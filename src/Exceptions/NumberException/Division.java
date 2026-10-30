package Exceptions.NumberException;

public class Division {

    static double divide(double a, double b) {
        if (b == 0) {
            throw new IllegalArgumentException("Il divisore non può essere zero");
        }

        return a / b;
    }

    static void main() {
        try {
            double total = divide(10, 0);
            System.out.println(total);
        } catch (ArithmeticException e) {
            System.out.println("Errore: " + e.getMessage());
        }
    }
}

package Exceptions.CalculateNumber;

public class Calculate {
    private static int calculate(int number){
        if(number < 0){
            throw new IllegalArgumentException("Valore non valido");
        }

        return number;
    }

    static void main() {
        try {
            int number = calculate(-1);
            System.out.println(number);
        }catch (IllegalArgumentException e){
            System.out.println("Errore: " + e.getMessage());
        }finally {
            System.out.println("Operazione terminata");
        }
    }
}

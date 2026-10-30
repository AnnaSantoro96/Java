package Exceptions.NumberConverter;

public class NumberConverter {
    private static int convertToNumber(String value){

        int number = Integer.parseInt(value);

        return number;

    }

    static void main() {
        try {
            int number = convertToNumber("4");
            System.out.println(number);
        }catch (NumberFormatException e){
            System.out.println("Invalid input");
        }finally {
            System.out.println("Conversione terminata");
        }
    }
}

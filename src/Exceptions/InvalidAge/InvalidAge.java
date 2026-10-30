package Exceptions.InvalidAge;

public class InvalidAge {

    static int calculateAge(int age){
        if(age < 0){
            throw new IllegalArgumentException("L'età non può essere negativa");
        }

        return age;
    }

    static void main(String[] args) {
        try {
            int age = calculateAge(-1);
            System.out.println(age);
        }catch (IllegalArgumentException e){
            System.out.println("Errore: " + e.getMessage());
        }
    }
}

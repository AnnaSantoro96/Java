package JavaBase.Array;

public class SeatNumber {
    static void main() {

        String seats[] = {"Jenny", "Liam", "Angie", "Bo"};

        for(int i = 0; i < seats.length; i++){
            System.out.println("Seat number " + i + " is taken by " + seats[i]);
        }
    }
}

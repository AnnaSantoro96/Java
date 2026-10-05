package JavaBase.Operators;

public class CountPeople {
    static void main() {
        int peopleInRoom = 0;

        System.out.println("3 people enter in the room");
        //3 PEOPLE ENTER
        peopleInRoom++;
        peopleInRoom++;
        peopleInRoom++;

        System.out.println("People in the Room: " + peopleInRoom);
        System.out.println("");
        System.out.println("1 person leaves the room");
        peopleInRoom--;

        System.out.println("People in the room: " + peopleInRoom);
    }
}

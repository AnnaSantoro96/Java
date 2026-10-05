package JavaBase.Exercices;

import javax.sound.midi.SysexMessage;
import java.util.Scanner;

public class InteractionWithTheUser {
    static void main() {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter your name.");
        String name = in.nextLine();

        System.out.println("Enter your lastname.");
        String lastname = in.nextLine();

        System.out.println("Enter you favourite musician.");
        String musician = in.nextLine();

        System.out.println("Hi " + name + " " + lastname + "! Your favourite musician is " + musician);
    }
}

package Project.UniqueNames;

public class Main {
    static void main() {
        UniqueNames uniqueNames = new UniqueNames();

        if (uniqueNames.addName("Anna")) {
            System.out.println("Name added");
        } else {
            System.out.println("Name already exists");
        }

        if (uniqueNames.addName("Luca")) {
            System.out.println("Name added");
        } else {
            System.out.println("Name already exists");
        }

        if (uniqueNames.addName("Marco")) {
            System.out.println("Name added");
        } else {
            System.out.println("Name already exists");
        }

        if (uniqueNames.addName("Anna")) {
            System.out.println("Name added");
        } else {
            System.out.println("Name already exists");
        }

        IO.println();
        System.out.println("ALL NAMES");
        uniqueNames.printNames();

    }
}

package Project.WalkableManagement;

import java.util.ArrayList;

public class Main {
    static void main() {
        ArrayList<Walkable> walkables = new ArrayList<>();
        walkables.add(new Dog("Dog"));
        walkables.add(new Human("Human"));
        walkables.add(new Robot("Robot"));

        for(Walkable walkable : walkables){
            walkable.walk();
            walkable.stop();
        }

        IO.println();
        Walkable.showInfo();

    }
}

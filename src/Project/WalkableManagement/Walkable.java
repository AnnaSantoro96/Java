package Project.WalkableManagement;

public interface Walkable {
    void walk();

    default void stop(){
        System.out.println("Movimento interrotto.");
    }

    static void showInfo(){
        System.out.println("Walkable definisce il comportamento di camminare.");
    }

}

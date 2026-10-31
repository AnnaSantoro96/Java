package Project.WalkableManagement;

public class Human implements Walkable{

    private String name;

    public Human(String name){
        setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Nome non valido");
        } else {
            this.name = name;
        }
    }

    @Override
    public void walk() {
        System.out.println("L'essere umano cammina su due gambe.");
    }
}

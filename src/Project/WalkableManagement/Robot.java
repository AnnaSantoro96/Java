package Project.WalkableManagement;

public class Robot implements Walkable{

    private String name;

    public Robot(String name){
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
        System.out.println("Il robot cammina meccanicamente.");
    }
}

package Project.WalkableManagement;

public class Dog implements Walkable, Swimmable{

    private String name;

    public Dog(String name){
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
        System.out.println("Il cane cammina a quattro zampe.");
    }

    @Override
    public void swim(){
        System.out.println("Il cane nuota");
    }
}

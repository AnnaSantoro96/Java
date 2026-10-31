package Project.AnimalManagement;

public class Horse extends Animal{

    public Horse(String name){
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println("III III");
    }
}

package Project.AnimalManagement;

public abstract class Animal {

    private String name;

    public Animal(String name){
        setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name == null || name.isBlank()){
            throw new IllegalArgumentException("Invalid name");
        }else{
            this.name = name;
        }
    }

    public abstract void makeSound();
}

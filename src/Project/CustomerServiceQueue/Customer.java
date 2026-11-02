package Project.CustomerServiceQueue;

public class Customer {
    private String name;

    public Customer(String name){
        setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Invalid name");
        } else {
            this.name = name;
        }
    }

    public void printInfo(){
        System.out.println("Name: " + getName());
    }
}

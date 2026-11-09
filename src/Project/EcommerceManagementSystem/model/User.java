package Project.EcommerceManagementSystem.model;

public abstract class User {
    private final String id;
    private String name;
    private String lastName;
    private String email;

    public User(String id, String name, String lastName, String email){
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("Invalid id");
        }
        this.id = id;
        setName(name);
        setLastName(lastName);
        setEmail(email);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name == null || name.isBlank()){
            throw new IllegalArgumentException("Invalid name");
        }
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if(lastName == null || lastName.isBlank()){
            throw new IllegalArgumentException("Invalid lastname");
        }
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if(email == null || email.isBlank()){
            throw new IllegalArgumentException("Invalid email");
        }
        this.email = email;
    }

    @Override
    public String toString() {
        return "ID: " + id + "\nName: " + name + "\nLast name: " + lastName + "\nEmail: " + email;
    }

    public abstract void displayRole();
}

package Project.LibraryManagementSystem;

public class Member {
    private String id;
    private String name;
    private String lastName;

    public Member(String id, String name, String lastName){
        setId(id);
        setName(name);
        setLastName(lastName);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        if(id == null || id.isBlank()){
            throw new IllegalArgumentException("Invalid id");
        }
        this.id = id;
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
            throw new IllegalArgumentException("Invalid last name");
        }
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "\nID: " + getId() + "\nName: " + getName() + "\nLast Name: " + getLastName();
    }
}

package Classes.ContactBook;

public class Contact {

    private String name;
    private String phoneNumber;
    private String email;

    public Contact(String name, String phoneNumber, String email){
        setName(name);
        setPhoneNumber(phoneNumber);
        setEmail(email);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Invalid name");
        }

        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if(email == null || email.isBlank()){
            throw new IllegalArgumentException("Invalid email");
        }else{
            this.email = email;
        }
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        if(phoneNumber == null || phoneNumber.isBlank()){
            throw new IllegalArgumentException("Inavlid phone number");
        }else{
            this.phoneNumber = phoneNumber;
        }
    }

    public void printInfo(){
        System.out.println("Name: " + name + "\nPhone number: " + phoneNumber + "\nEmail: " + email);
    }
}

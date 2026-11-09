package Project.EcommerceManagementSystem.model;

public class Customer extends User{
    private String address;
    private String phoneNumber;

    public Customer(String id, String name, String lastName, String email, String address, String phoneNumber){
        super(id, name, lastName, email);
        setAddress(address);
        setPhoneNumber(phoneNumber);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        if(address == null || address.isBlank()){
            throw new IllegalArgumentException("Invalid address");
        }
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        if(phoneNumber == null || phoneNumber.isBlank()){
            throw new IllegalArgumentException("Invalid phone number");
        }
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void displayRole() {
        System.out.println("Role: Customer");
        }

    @Override
    public String toString() {
        return super.toString() + "\nAddress: " + address + "\nPhone Number: " + phoneNumber;
    }
}

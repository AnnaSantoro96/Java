package Project.DeviceManagement;

public class Laptop extends Device implements Connectable, Rechargeable{

    public Laptop(String brand, String model, int batteryLevel){
        super(brand, model, batteryLevel);
    }

    @Override
    public void turnOn() {
        IO.println("The laptop is on!");
    }

    @Override
    public void connect() {
        IO.println("The laptop is connect.");
    }

    @Override
    public void disconnect() {
        IO.println("The laptop is disconnect");
    }

    @Override
    public void charge() {
        IO.println("The laptop is chargeing.");
    }
}

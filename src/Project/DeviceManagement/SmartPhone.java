package Project.DeviceManagement;

public class SmartPhone extends Device implements Connectable, Rechargeable{

    public SmartPhone(String brand, String model, int batteryLevel){
        super(brand, model, batteryLevel);
    }

    @Override
    public void turnOn() {
        IO.println("The smartphone is on!");
    }

    @Override
    public void connect() {
        IO.println("The smartphone is connect.");
    }

    @Override
    public void disconnect() {
        IO.println("The smartphone is disconnect");
    }

    @Override
    public void charge() {
        IO.println("The smartphone is chargeing.");
    }
}

package Project.DeviceManagement;

public class Smartwatch extends Device implements Rechargeable{

    public Smartwatch(String brand, String model, int batteryLevel){
        super(brand, model, batteryLevel);
    }

    @Override
    public void turnOn() {
        IO.println("The smartwatch is on!");
    }

    @Override
    public void charge() {
        IO.println("The smartwatch is chargeing.");
    }
}

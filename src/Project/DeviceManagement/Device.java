package Project.DeviceManagement;

public abstract class Device {

    private String brand;
    private String model;
    private int batteryLevel;

    public Device(String brand, String model, int batteryLevel){
        setBrand(brand);
        setModel(model);
        setBatteryLevel(batteryLevel);
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        if(model == null || model.isBlank()){
            throw new IllegalArgumentException("Invalid input");
        }else{
            this.model = model;
        }
    }

    public int getBatteryLevel() {
        return batteryLevel;
    }

    public void setBatteryLevel(int batteryLevel) {
        if(batteryLevel < 0 || batteryLevel > 100){
            throw new IllegalArgumentException("Invalid input");
        }else {
            this.batteryLevel = batteryLevel;
        }
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        if(brand == null || brand.isBlank()){
            throw new IllegalArgumentException("Invalid input");
        }else {
            this.brand = brand;
        }
    }

    public void displayInfo(){
        System.out.println("Brand: " + getBrand() + "\nModel: " + getModel() + "\nBattery Level: " + getBatteryLevel());
    }

    public abstract void turnOn();
}

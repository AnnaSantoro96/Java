package Project.DeviceManagement;

public interface Rechargeable {

    void charge();

    default void showBatteryInfo(){
        IO.println("Dispositivo ricaricabile.");
    }
}

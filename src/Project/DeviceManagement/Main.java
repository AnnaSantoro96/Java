package Project.DeviceManagement;

import java.util.ArrayList;

public class Main {
    static void main() {
        ArrayList<Device> devices = new ArrayList<>();

        SmartPhone smartPhone = new SmartPhone("Apple", "Iphone", 70);
        devices.add(smartPhone);

        Smartwatch smartwatch = new Smartwatch("Garmin", "Forerunner 250", 80);
        devices.add(smartwatch);

        Laptop laptop = new Laptop("Acer", "Nitro", 100);
        devices.add(laptop);

        Connectable.showInfo();
        IO.println();

        for (Device device : devices) {

            device.turnOn();
            device.displayInfo();

            if (device instanceof Connectable connectable) {
                connectable.connect();
                connectable.showConnectionStatus();
                connectable.disconnect();
            }

            if (device instanceof Rechargeable rechargeable) {
                rechargeable.charge();
                rechargeable.showBatteryInfo();
            }
        }
    }
}

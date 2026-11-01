package Project.DeviceManagement;

public interface Connectable {

    void connect();
    void disconnect();

    default void showConnectionStatus(){
        IO.println("Controllo connessione...");
    }

    static void showInfo(){
        IO.println("Interfaccia per dispositivi connessi.");
    }
}

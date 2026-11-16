package JavaBase.Generics.Storage;

public class Main {
    static void main() {
        Storage<String> str = new Storage<>("Ciao");
        Storage<Integer> itg = new Storage<>(10);

        IO.println(str.getItem());
        IO.println(itg.getItem());
    }
}

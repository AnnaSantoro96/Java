package JavaBase.Generics.Repository;

public class Main {
    static void main() {
        Repository<String> str = new Repository<>();
        str.addItem("Anna");
        str.addItem("Luca");
        str.addItem("Marco");
        IO.println(str.getAll());

        Repository<Integer> itg = new Repository<>();
        itg.addItem(10);
        itg.addItem(12);
        IO.println(itg.getAll());
    }
}

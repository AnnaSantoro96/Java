package Project.PersonRegistry;

public class Main {
    static void main() {
        PersonRegistry registry = new PersonRegistry();


        registry.addPerson("001", new Person("001", "Anna"));
        registry.addPerson("002", new Person("002", "Bob"));
        registry.addPerson("003", new Person("003", "Anna"));

        IO.println("FULL LIST");
        registry.printAll();

    }
}

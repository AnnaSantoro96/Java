package Project.ContactBookHashSet;

public class Main {
    static void main() {
        ContactBook contactBook = new ContactBook();

        if(contactBook.addContact(new Person("Anna", "Santoro", "123123123"))){
            IO.println("Contact added");
        }else {
            IO.println("Contact already exists");
        }
        if(contactBook.addContact(new Person("Luca", "Rossi", "123123122"))){
            IO.println("Contact added");
        }else {
            IO.println("Contact already exists");
        }
        if(contactBook.addContact(new Person("Anna", "Santoro", "123123123"))){
            IO.println("Contact added");
        }else {
            IO.println("Contact already exists");
        }
        if(contactBook.addContact(new Person("Giuseppe", "Verdi", "112234432"))){
            IO.println("Contact added");
        }else {
            IO.println("Contact already exists");
        }

        IO.println();
        String contactList = contactBook.printContacts();
        IO.println(contactList);
    }
}

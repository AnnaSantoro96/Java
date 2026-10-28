package Classes.ContactBook;

import java.util.Scanner;

public class Main {
    static void main() {
        Scanner in = new Scanner(System.in);
        ContactBook contactBook = new ContactBook();
        int value = -1;

        do {
            System.out.println("\n===== CONTACT BOOK =====");
            System.out.println("1. Add contact");
            System.out.println("2. Print all contacts");
            System.out.println("3. Search contact");
            System.out.println("4. Edit contact");
            System.out.println("5. Delete contact");
            System.out.println("0. Exit");
            System.out.println("Choose an option:");

            if (!in.hasNextInt()) {
                System.out.println("Incorrect input...");
                in.nextLine();
                continue;
            }

            value = in.nextInt();
            in.nextLine();



            if(value == 0){
                System.out.println("BYE BYE...");
                break;
            }

            if (value < 0 || value > 5) {
                System.out.println("Incorrect value");
                continue;
            }

            switch (value){
                case 1:

                    System.out.println("ADD A NEW CONTACT");
                    System.out.println("Enter the contact name");
                    String name = in.nextLine();

                    System.out.println("Enter the contact phone number");
                    String phoneNumber = in.nextLine();
                    System.out.println("Enter the contact email:");
                    String email = in.nextLine();
                    while (name.isBlank()
                            || phoneNumber.isBlank()
                            ||email.isBlank()) {

                        System.out.println("Invalid input");

                        System.out.println("Enter the contact name");
                        name = in.nextLine();

                        System.out.println("Enter the contact phone number");
                        phoneNumber = in.nextLine();

                        System.out.println("Enter the contact email:");
                        email = in.nextLine();

                    }
                    contactBook.addContact(new Contact(name, phoneNumber, email));
                    break;

                case 2:
                    System.out.println();
                    System.out.println("CONTACT PRESENT IN THE CONTACT BOOK");
                    contactBook.printContact();
                    break;

                case 3:
                    System.out.println("Enter the contact name");
                    String n = in.nextLine();
                    Contact contact = contactBook.searchContactByName(n);



                    if(contact == null){
                        System.out.println("Contact is not present.");
                    }else{
                        contact.printInfo();
                    }
                    break;

                case 4:
                    System.out.println("Enter the contact name that you want edit");
                    String na = in.nextLine();
                    System.out.println("Enter the new phone number");
                    String newPhoneNumber = in.nextLine();
                    System.out.println("Enter the new email");
                    String newEmail = in.nextLine();

                    boolean success = contactBook.editContact(na, newPhoneNumber, newEmail);

                    if(success){
                        System.out.println("The contact has been edited successfully!");
                    }else {
                        System.out.println("Error...");
                    }
                    break;

                case 5:
                    System.out.println("Enter the contact name that you want remove");
                    String nm = in.nextLine();

                    boolean removed = contactBook.deleteContact(nm);

                    if(removed){
                        System.out.println("The contact has been removed correctly");
                    }else {
                        System.out.println("Error...");
                    }
                    break;

                default:
                    System.out.println("ERROR...");
            }




        }while (value != 0);
    }
}

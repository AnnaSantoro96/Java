package Project.ContactBook;

import java.util.ArrayList;

public class ContactBook {

    private ArrayList<Contact> contacts;

    public ContactBook(){
        contacts = new ArrayList<>();
    }

    public void addContact(Contact contact){
        if(contact != null) {
            contacts.add(contact);
        }else{
            System.out.println("Invalid contact...");
        }
    }

    public void printContact(){

        if (contacts.isEmpty()) {
            System.out.println("No contacts are present...");
            return;
        }

        for(Contact contact : contacts) {

                contact.printInfo();

        }
    }

    public Contact searchContactByName(String name){
        for (Contact contact : contacts){
            if(contact.getName().equalsIgnoreCase(name)){
                return contact;
            }
        }

        return null;
    }


    public boolean editContact(String name, String newPhoneNumber, String newEmail){
        Contact contact = searchContactByName(name);

        if(contact == null){
            return false;
        }
              if((newPhoneNumber == null || newPhoneNumber.isBlank()) || (newEmail == null || newEmail.isBlank()) ){
                  System.out.println("ERROR...empty value");
                  return false;

        }else {
                  contact.setPhoneNumber(newPhoneNumber);
                  contact.setEmail(newEmail);
              }

        return true;
    }

    public boolean deleteContact(String name){
        Contact contact = searchContactByName(name);

        if(contact == null){
            return false;
        }

        contacts.remove(contact);
        return true;
    }

}

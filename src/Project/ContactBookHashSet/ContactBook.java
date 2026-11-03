package Project.ContactBookHashSet;

import java.util.HashSet;

public class ContactBook {

    private HashSet<Person> contacts;

    public ContactBook(){
        contacts = new HashSet<>();
    }

    public boolean addContact(Person person){
        if(person == null){
            throw new IllegalArgumentException("Invalid input");
        }

        return contacts.add(person);
    }

    public boolean removeContact(String phoneNumber){
        Person person = searchContact(phoneNumber);

        if(person == null){
            return false;
        }

        return contacts.remove(person);
    }

    public Person searchContact(String phoneNumber){
        if(phoneNumber == null || phoneNumber.isBlank()){
            throw new IllegalArgumentException("Invalid phone number");
        }

        for(Person person : contacts){
            if(person.getPhoneNumber().equals(phoneNumber)){
                return person;
            }
        }

        return null;
    }

    public String printContacts() {
        if (contacts.isEmpty()) {
            return "No contacts are present...";
        }

        StringBuilder contactList = new StringBuilder();

        for (Person person : contacts) {
            contactList.append(person).append("\n");
        }

        return contactList.toString();
    }
}

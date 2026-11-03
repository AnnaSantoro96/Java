package Project.PersonRegistry;

import java.util.HashMap;

public class PersonRegistry {

    private HashMap<String,Person> register;

    public PersonRegistry(){
        register = new HashMap<>();
    }

    public void addPerson(String id, Person person){
        if(id == null || id.isBlank()){
            throw new IllegalArgumentException("Invalid id");
        }

        if(person == null){
            throw new IllegalArgumentException("Invalid person");
        }

        if(register.containsKey(id)){
            throw new IllegalArgumentException("Person already exists");
        }

        register.put(id,person);
    }

    public Person findPersonById(String id) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("Invalid name");
        }

        return register.get(id);
    }

    public Person findPersonByName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Invalid name");
        }

        for (Person person : register.values()) {
            if (person.getName().equals(name)) {
                return person;
            }
        }

        return null;
    }

    public void removePersonById(String id){
        if(id == null || id.isBlank()){
            throw new IllegalArgumentException("Invalid id");
        }

        register.remove(id);
    }

    public void printAll(){
        for(Person person : register.values()){
            System.out.println(person);
        }
    }
}

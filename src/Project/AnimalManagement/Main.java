package Project.AnimalManagement;

import java.util.ArrayList;

public class Main {
    static void main(String[] args) {

        ArrayList<Animal> animals = new ArrayList<>();

        animals.add(new Dog("Dog"));
        animals.add(new Cat("Cat"));
        animals.add(new Horse("Horse"));

        for (Animal animal : animals){
            System.out.println("Animal: " + animal.getName());
            animal.makeSound();
        }
    }
}

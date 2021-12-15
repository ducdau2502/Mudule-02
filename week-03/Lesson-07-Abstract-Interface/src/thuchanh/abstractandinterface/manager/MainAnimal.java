package thuchanh.abstractandinterface.manager;

import thuchanh.abstractandinterface.animal.Animal;
import thuchanh.abstractandinterface.animal.Chicken;
import thuchanh.abstractandinterface.animal.Tiger;
import thuchanh.abstractandinterface.edible.Edible;


public class MainAnimal {
    public static void main(String[] args) {
        Animal[] animals = new Animal[2];
        animals[0] = new Tiger();
        animals[1] = new Chicken();

        displayAnimal(animals);

    }

    private static void displayAnimal(Animal[] animals) {
        for (Animal animal : animals) {
            System.out.println(animal.makeSound());
            if (animal instanceof Chicken) {
                Chicken edibler = (Chicken) animal;
                System.out.println(edibler.howToEat());

                Edible edible = (Chicken) animal;
                System.out.println(edible.howToEat());
            }
        }
    }
}

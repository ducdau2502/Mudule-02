package practice.factorymethod;

public class FactoryAnimalTest {
    public static void main(String[] args) {
        AnimalFactory animalFactory = new AnimalFactory();

        Animal animal1 = animalFactory.getAnimal("canine");
        System.out.println(animal1.makeSound());

        Animal animal2 = animalFactory.getAnimal("abc");
        System.out.println(animal2.makeSound());
    }
}

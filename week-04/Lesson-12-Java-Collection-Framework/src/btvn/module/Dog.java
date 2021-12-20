package btvn.module;

public class Dog extends Animal implements Interfaces {

    public Dog() {
    }

    public Dog(String name, int age, double weight) {
        super(name, age, weight);
    }

    public void tailWagging() {
        System.out.println("tail wagging");
    }

    @Override
    public int run() {
        return 3;
    }

    @Override
    public String makeSound() {
        return "Gấu gấu";
    }

    @Override
    public String toString() {
        return "Dog " + super.toString() + ", " + makeSound();
    }
}

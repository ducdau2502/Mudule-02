package btvn.module;

public class Cat extends Animal implements Interfaces {

    public Cat() {
    }

    public Cat(String name, int age, double weight) {
        super(name, age, weight);
    }

    public String jump() {
        return "jump on the table";
    }

    @Override
    public int run() {
        return 2;
    }

    @Override
    public String makeSound() {
        return "méo méo";
    }

    @Override
    public String toString() {
        return "Cat " + super.toString() + ", " + makeSound();
    }

}

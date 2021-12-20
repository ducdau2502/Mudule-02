package btvn.module;

public class Mouse extends Animal implements Interfaces {

    public Mouse() {
    }

    public Mouse(String name, int age, double weight) {
        super(name, age, weight);
    }

    public String hidden() {
        return "hide in the nest";
    }

    @Override
    public int run() {
        return 1;
    }

    @Override
    public String makeSound() {
        return "chít chít";
    }

    @Override
    public String toString() {
        return "Mouse " + super.toString()+ ", " + makeSound();
    }
}

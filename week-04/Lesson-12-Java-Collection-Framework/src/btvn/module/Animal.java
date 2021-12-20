package btvn.module;

public class Animal {
    private static int VALUE = 1;
    private String name;
    private int age;
    private double weight;
    private int id;

    public Animal(String name, int age, double weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.id = VALUE++;
    }

    public Animal() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", age=" + getAge() +
                ", weight=" + getWeight();
    }
}

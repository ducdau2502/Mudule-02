package models;

public class Person {
    private static int VALUE = 1;
    private int id;
    private String name;
    private int age;

    public Person(String name, int age) {
        this.id = VALUE++;
        this.name = name;
        this.age = age;
    }

    public Person() {
    }

    public int getId() {
        return id;
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

    @Override
    public String toString() {
        return String.format("%-5s%-12s%-5s", getId(), getName(), getAge());
    }
}

package module;

import java.util.ArrayList;

public class Person {
    private String name;
    private int age;
    private static int VALUE = 1;
    private int id;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        this.id += VALUE;
        VALUE++;
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

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Person: " +
                "id = " + id +
                ", name = '" + name + '\'' +
                ", age = " + age;
    }
}

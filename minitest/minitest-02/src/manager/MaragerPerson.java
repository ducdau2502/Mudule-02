package manager;

import module.Person;
import module.Student;

import java.util.*;

public class MaragerPerson implements Manager {
    Scanner scanner = new Scanner(System.in);
    public List<Person> people;

    public MaragerPerson() {
        this.people = new ArrayList<>();
    }

    @Override
    public void displayAllPerson() {
        for (Person person : people) {
            System.out.println(person);
        }
        System.out.println("--------------------");
    }

    @Override
    public void addPerson(Scanner scanner, int choice, String name, int age) {
        if (choice == 1) {
            Person person = new Person(name, age);
            people.add(person);
        } else if (choice == 2) {
            System.out.print("Enter average point: ");
            double avgPoint = scanner.nextDouble();
            Student student = new Student(name, age, avgPoint);
            people.add(student);
        }
    }

    @Override
    public void findById(int id) {
        for (Person person : people) {
            if (person.getId() == id) {
                System.out.println(person);
                System.out.println("--------------------");
            }
        }
    }

    @Override
    public void deleteById(int id) {
        for (Person person: people) {
            if (person.getId() == id) {
                people.remove(person);
                break;
            }
        }
    }

    @Override
    public void editById(int id) {
        for (Person person : people) {
            if (person.getId() == id) {
                if (person instanceof Person) {
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    person.setName(name);
                    System.out.print("Enter age: ");
                    int age = scanner.nextInt();
                    person.setAge(age);
                } else if (person instanceof Student) {
                    System.out.print("Enter name: ");
                    String name1 = scanner.nextLine();
                    ((Student) person).setName(name1);
                    System.out.print("Enter age: ");
                    int age = scanner.nextInt();
                    ((Student) person).setAge(age);
                    System.out.print("Enter average point: ");
                    double avgPoint = scanner.nextDouble();
                    ((Student) person).setAveragePoint(avgPoint);
                }
            }
        }
    }

    @Override
    public void rangeByAvgPoint() {
    }

    @Override
    public void totalPoint() {
        double sum = 0;
        for (Person person : people) {
            if (person instanceof Student) {
                sum += ((Student) person).getAveragePoint();
            }
        }
        System.out.println("Total point is " + sum);
        System.out.println("--------------------");
    }
}

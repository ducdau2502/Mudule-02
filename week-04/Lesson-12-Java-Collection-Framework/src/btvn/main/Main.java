package btvn.main;

import btvn.manager.ManagerAnimal;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ManagerAnimal managerAnimal = new ManagerAnimal();

        int choice;
        do {
            System.out.println("*** Menu bar ***");
            System.out.println("1. Add an animal");
            System.out.println("2. Delete an animal by name");
            System.out.println("3. Edit an animal by name");
            System.out.println("4. Display animals by name");
            System.out.println("5. Display all");
            System.out.println("6. Display animals by species");
            System.out.println("7. Display animals by range of weight");
            System.out.println("0. Exit");
            System.out.print("Enter you choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    int choice1;
                    do {
                        System.out.println("1. Add dog");
                        System.out.println("2. Add cat");
                        System.out.println("3. Add mouse");
                        System.out.println("0. Back");
                        System.out.print("Enter you choice: ");
                        choice1 = scanner.nextInt();
                        if (choice1 > 0 && choice1 < 4) {
                            managerAnimal.addAnimal(choice1);
                        }
                    } while (choice1 != 0);
                    break;
                case 2:
                    System.out.print("Enter animal's name you want to delete: ");
                    String deleteName = scanner.nextLine();
                    System.out.println(managerAnimal.deleteAnimalByName(deleteName));
                    break;
                case 3:
                    System.out.print("Enter animal's name you want to edit: ");
                    String updateName = scanner.nextLine();
                    System.out.println(managerAnimal.updateAnimalByName(updateName));
                    break;
                case 4:
                    System.out.print("Enter animal's name you want to display: ");
                    String displayName = scanner.nextLine();
                    managerAnimal.displayByName(displayName);
                    break;
                case 5:
                    managerAnimal.displayAll();
                    break;
                case 6:
                    int choice2;
                    do {
                        System.out.println("1. Display dog");
                        System.out.println("2. Display cat");
                        System.out.println("3. Display mouse");
                        System.out.println("0. Back");
                        System.out.print("Enter you choice: ");
                        choice2 = scanner.nextInt();
                        if (choice2 > 0 && choice2 < 4) {
                            managerAnimal.displayBySpecies(choice2);
                        }
                    } while (choice2 != 0);
                    break;
                case 7:
                    System.out.println("Enter range of weight");
                    double lowerWeight;
                    double higherWeight;
                    do {
                        System.out.print("Enter the lower limit: ");
                        lowerWeight = scanner.nextDouble();
                        System.out.print("Enter the higher limit: ");
                        higherWeight = scanner.nextDouble();
                    } while (lowerWeight > higherWeight);
                    managerAnimal.displayByWeight(lowerWeight, higherWeight);
                    break;
            }
        } while (choice != 0);

    }
}

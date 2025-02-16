package AnimalShelterQueue;

import java.util.Scanner;

public class AnimalShelterCLI {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AnimalShelter shelter = new AnimalShelter();

        while (true) {
            System.out.println("\nAnimal Shelter System");
            System.out.println("1. Add a Dog");
            System.out.println("2. Add a Cat");
            System.out.println("3. Adopt Any Animal");
            System.out.println("4. Adopt a Dog");
            System.out.println("5. Adopt a Cat");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter dog name: ");
                    String dogName = scanner.nextLine();
                    shelter.enqueue(new Dog(dogName));
                    System.out.println(dogName + " has been added to the shelter.");
                    break;
                case 2:
                    System.out.print("Enter cat name: ");
                    String catName = scanner.nextLine();
                    shelter.enqueue(new Cat(catName));
                    System.out.println(catName + " has been added to the shelter.");
                    break;
                case 3:
                    Animal adoptedAny = shelter.dequeueAny();
                    if (adoptedAny != null) {
                        System.out.println("You adopted: " + adoptedAny.getName());
                    } else {
                        System.out.println("No animals available for adoption.");
                    }
                    break;
                case 4:
                    Dog adoptedDog = shelter.dequeueDog();
                    if (adoptedDog != null) {
                        System.out.println("You adopted the dog: " + adoptedDog.getName());
                    } else {
                        System.out.println("No dogs available for adoption.");
                    }
                    break;
                case 5:
                    Cat adoptedCat = shelter.dequeueCat();
                    if (adoptedCat != null) {
                        System.out.println("You adopted the cat: " + adoptedCat.getName());
                    } else {
                        System.out.println("No cats available for adoption.");
                    }
                    break;
                case 6:
                    System.out.println("Thank you for using the Animal Shelter System. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}


import java.util.ArrayList;
import java.util.Scanner;

class Cargo {
    public String description;

    public Cargo(String description) {
        this.description = description;
    }
}

class Truck {
    private static int nextID = 1;
    public int id;
    public String typeOfCargo;

    public Truck(String typeOfCargo) {
        this.id = nextID++;
        this.typeOfCargo = typeOfCargo;
    }

    @Override
    public String toString() {
        return "Truck ID: " + id + ", Type of Cargo: " + typeOfCargo;
    }
}

public class Question1 {
    private static ArrayList<Truck> trucks = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("[Truck Yard]");
            System.out.println("1. Add Truck");
            System.out.println("2. Remove Truck");
            System.out.println("3. Quit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addTruck();
                    break;
                case 2:
                    removeTruck();
                    break;
                case 3:
                    System.out.println("Terminating the program.");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void addTruck() {
        System.out.print("Enter cargo description: ");
        String description = scanner.nextLine();
        Cargo cargo = new Cargo(description);
        Truck truck = new Truck(cargo.description);
        trucks.add(truck);
        System.out.println("Truck added successfully: " + truck);
    }

    private static void removeTruck() {
        System.out.print("Enter the index of the truck to remove: ");
        int index = scanner.nextInt();
        if (index >= 0 && index < trucks.size()) {
            Truck removedTruck = trucks.remove(index);
            System.out.println("Truck removed successfully: " + removedTruck);
        } else {
            System.out.println("Error: Index out of bounds.");
        }
    }
}
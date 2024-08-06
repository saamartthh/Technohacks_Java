import java.util.ArrayList;
import java.util.Scanner;

public class ToDoList {
    private static ArrayList<String> toDoList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nTo-Do List Application");
            System.out.println("1. View To-Do List");
            System.out.println("2. Add Item");
            System.out.println("3. Remove Item");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    viewToDoList();
                    break;
                case 2:
                    addItem(scanner);
                    break;
                case 3:
                    removeItem(scanner);
                    break;
                case 4:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }

    private static void viewToDoList() {
        System.out.println("\nYour To-Do List:");
        if (toDoList.isEmpty()) {
            System.out.println("Your to-do list is empty.");
        } else {
            for (int i = 0; i < toDoList.size(); i++) {
                System.out.println((i + 1) + ". " + toDoList.get(i));
            }
        }
    }

    private static void addItem(Scanner scanner) {
        System.out.print("Enter the item to add: ");
        String item = scanner.nextLine();
        toDoList.add(item);
        System.out.println("Item added.");
    }

    private static void removeItem(Scanner scanner) {
        viewToDoList();
        System.out.print("Enter the number of the item to remove: ");
        int index = scanner.nextInt() - 1;
        if (index >= 0 && index < toDoList.size()) {
            toDoList.remove(index);
            System.out.println("Item removed.");
        } else {
            System.out.println("Invalid index. Please try again.");
        }
    }
}

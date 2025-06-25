/**
 * Liam Wild
 * CEN 3024 - Software Development 1
 * June 24, 2025
 * MainMenu.java
 * This class contains the user interface and controls the Audio Gear Checkout System.
 * It allows users to load data, display, add, remove, update, and list overdue gear records.
 */

import java.util.Scanner;

public class MainMenu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CheckoutManager manager = new CheckoutManager();
        boolean running = true;

        while (running) {
            System.out.println("\n--- Audio Gear Checkout System ---");
            System.out.println("1. Load data from file");
            System.out.println("2. Display all records");
            System.out.println("3. Add a new record");
            System.out.println("4. Remove a record");
            System.out.println("5. Update a due date");
            System.out.println("6. List overdue gear");
            System.out.println("7. Exit");
            System.out.print("Enter option: ");

            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    /**
                     * method: loadFromFile
                     * purpose: asks user for filename and loads data into the system
                     * parameters: none
                     * return: void
                     */
                    System.out.print("Enter filename: ");
                    String filename = scanner.nextLine();
                    if (manager.loadFromFile(filename)) {
                        System.out.println("Data loaded successfully.");
                    } else {
                        System.out.println("Error loading file.");
                    }
                    break;

                case "2":
                    /**
                     * method: displayAllRecords
                     * purpose: displays all current checkout records
                     * parameters: none
                     * return: void
                     */
                    for (CheckoutRecord r : manager.getRecords()) {
                        System.out.println(r);
                    }
                    break;

                case "3":
                    /**
                     * method: addNewRecord
                     * purpose: gathers input and adds a new record
                     * parameters: none
                     * return: void
                     */
                    try {
                        System.out.print("ID: ");
                        String id = scanner.nextLine();
                        System.out.print("Item: ");
                        String item = scanner.nextLine();
                        System.out.print("Borrower: ");
                        String borrower = scanner.nextLine();
                        System.out.print("Checkout Date (YYYY-MM-DD): ");
                        String checkoutDate = scanner.nextLine();
                        System.out.print("Due Date (YYYY-MM-DD): ");
                        String dueDate = scanner.nextLine();
                        CheckoutRecord newRecord = new CheckoutRecord(id, item, borrower, checkoutDate, dueDate);
                        if (manager.addRecord(newRecord)) {
                            System.out.println("Record added.");
                        } else {
                            System.out.println("Duplicate ID. Record not added.");
                        }
                    } catch (Exception e) {
                        System.out.println("Invalid input. Record not added.");
                    }
                    break;

                case "4":
                    /**
                     * method: removeRecord
                     * purpose: removes a record by ID
                     * parameters: none
                     * return: void
                     */
                    System.out.print("Enter ID to remove: ");
                    String removeId = scanner.nextLine();
                    if (manager.removeRecord(removeId)) {
                        System.out.println("Record removed.");
                    } else {
                        System.out.println("Record not found.");
                    }
                    break;

                case "5":
                    /**
                     * method: updateDueDate
                     * purpose: updates due date for a record by ID
                     * parameters: none
                     * return: void
                     */
                    System.out.print("Enter ID to update: ");
                    String updateId = scanner.nextLine();
                    System.out.print("Enter new due date (YYYY-MM-DD): ");
                    String newDueDate = scanner.nextLine();
                    if (manager.updateDueDate(updateId, newDueDate)) {
                        System.out.println("Due date updated.");
                    } else {
                        System.out.println("Record not found.");
                    }
                    break;

                case "6":
                    /**
                     * method: listOverdueGear
                     * purpose: lists all overdue gear as of today's date
                     * parameters: none
                     * return: void
                     */
                    System.out.print("Enter today’s date (YYYY-MM-DD): ");
                    String today = scanner.nextLine();
                    System.out.println("Overdue Gear:\n" + manager.listOverdueGear(today));
                    break;

                case "7":
                    /**
                     * method: exitProgram
                     * purpose: ends the main loop
                     * parameters: none
                     * return: void
                     */
                    running = false;
                    break;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}
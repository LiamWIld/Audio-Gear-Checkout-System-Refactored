/**
 * Liam Wild
 * CEN 3024 - Software Development 1
 * June 24, 2025
 * CheckoutManager.java
 * This class manages all gear checkout records. It provides methods for adding,
 * removing, updating, listing, and loading checkout records, including a custom
 * action to list overdue gear.
 */

import java.io.*;
import java.util.*;

public class CheckoutManager {
    private List<CheckoutRecord> records = new ArrayList<>();

    /**
     * method: addRecord
     * purpose: adds a new checkout record if the ID does not already exist
     * parameters: CheckoutRecord record
     * return: boolean
     */
    public boolean addRecord(CheckoutRecord record) {
        for (CheckoutRecord r : records) {
            if (r.getId().equals(record.getId())) return false;
        }
        records.add(record);
        return true;
    }

    /**
     * method: removeRecord
     * purpose: removes a checkout record by its ID
     * parameters: String id
     * return: boolean
     */
    public boolean removeRecord(String id) {
        return records.removeIf(r -> r.getId().equals(id));
    }

    /**
     * method: updateDueDate
     * purpose: updates the due date for a checkout record by its ID
     * parameters: String id, String newDueDate
     * return: boolean
     */
    public boolean updateDueDate(String id, String newDueDate) {
        for (CheckoutRecord r : records) {
            if (r.getId().equals(id)) {
                r.setDueDate(newDueDate);
                return true;
            }
        }
        return false;
    }

    /**
     * method: loadFromFile
     * purpose: loads checkout records from a file into the system
     * parameters: String filename
     * return: boolean
     */
    public boolean loadFromFile(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 5) {
                    CheckoutRecord r = new CheckoutRecord(parts[0], parts[1], parts[2], parts[3], parts[4]);
                    addRecord(r);
                }
            }
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    /**
     * method: listOverdueGear
     * purpose: returns a list of overdue gear as a formatted string
     * parameters: String today
     * return: String
     */
    public String listOverdueGear(String today) {
        StringBuilder result = new StringBuilder();
        for (CheckoutRecord r : records) {
            if (r.getDueDate().compareTo(today) < 0) {
                result.append(r.toString()).append("\n");
            }
        }
        if (result.isEmpty()) {
            return "No overdue gear found.";
        }
        return result.toString();
    }
    /**
     * method: getRecords
     * purpose: returns the list of checkout records
     * parameters: none
     * return: List<CheckoutRecord>
     */
    public List<CheckoutRecord> getRecords() {
        return records;
    }
}
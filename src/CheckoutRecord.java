/**
 * Liam Wild
 * CEN 3024 - Software Development 1
 * June 24, 2025
 * CheckoutRecord.java
 * This class represents a single gear checkout record, storing all related details
 * such as the gear ID, gear name, borrower name, checkout date, and due date.
 */

public class CheckoutRecord {
    private String id;
    private String item;
    private String borrower;
    private String checkoutDate;
    private String dueDate;

    /**
     * constructor
     * purpose: initializes a CheckoutRecord with given values
     * parameters: String id, String item, String borrower, String checkoutDate, String dueDate
     * return: none
     */
    public CheckoutRecord(String id, String item, String borrower, String checkoutDate, String dueDate) {
        this.id = id;
        this.item = item;
        this.borrower = borrower;
        this.checkoutDate = checkoutDate;
        this.dueDate = dueDate;
    }

    // getters
    public String getId() { return id; }
    public String getItem() { return item; }
    public String getBorrower() { return borrower; }
    public String getCheckoutDate() { return checkoutDate; }
    public String getDueDate() { return dueDate; }

    // setters
    public void setItem(String item) { this.item = item; }
    public void setBorrower(String borrower) { this.borrower = borrower; }
    public void setCheckoutDate(String checkoutDate) { this.checkoutDate = checkoutDate; }
    public void setDueDate(String dueDate) { this.dueDate = dueDate; }

    /**
     * method: toString
     * purpose: converts the record to a comma-separated string for output
     * parameters: none
     * return: String
     */
    @Override
    public String toString() {
        return id + "," + item + "," + borrower + "," + checkoutDate + "," + dueDate;
    }
}
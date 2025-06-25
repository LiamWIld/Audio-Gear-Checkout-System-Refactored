/**
 * Liam Wild
 * CEN 3024 - Software Development 1
 * June 24, 2025
 * DMSUnitTest.java
 * This class contains unit tests to validate all functionality in the Audio Gear Checkout System.
 * It verifies adding, removing, updating, file loading, and custom overdue listing features.
 */

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class DMSUnitTest {
    private CheckoutManager manager;

    /**
     * method: setUp
     * purpose: initializes a fresh CheckoutManager with sample data before each test
     * parameters: none
     * return: void
     */
    @BeforeEach
    public void setUp() {
        manager = new CheckoutManager();
        manager.addRecord(new CheckoutRecord("001", "Camera", "Alice", "2025-06-01", "2025-06-10"));
        manager.addRecord(new CheckoutRecord("002", "Tripod", "Bob", "2025-06-02", "2025-06-11"));
    }

    /**
     * method: testAddRecord
     * purpose: verifies that a new record can be added and duplicates are rejected
     * parameters: none
     * return: void
     */
    @Test
    public void testAddRecord() {
        CheckoutRecord record = new CheckoutRecord("003", "Microphone", "Carol", "2025-06-03", "2025-06-12");
        assertTrue(manager.addRecord(record)); // Affirmative

        CheckoutRecord duplicate = new CheckoutRecord("003", "Mic", "Dan", "2025-06-04", "2025-06-13");
        assertFalse(manager.addRecord(duplicate)); // Negative
    }

    /**
     * method: testRemoveRecord
     * purpose: verifies that records can be removed and non-existent IDs are rejected
     * parameters: none
     * return: void
     */
    @Test
    public void testRemoveRecord() {
        assertTrue(manager.removeRecord("001")); // Affirmative
        assertFalse(manager.removeRecord("999")); // Negative
    }

    /**
     * method: testUpdateDueDate
     * purpose: ensures the due date is updated for valid IDs and fails for invalid IDs
     * parameters: none
     * return: void
     */
    @Test
    public void testUpdateDueDate() {
        assertTrue(manager.updateDueDate("002", "2025-07-01")); // Affirmative
        assertFalse(manager.updateDueDate("999", "2025-07-01")); // Negative
    }

    /**
     * method: testLoadFromFile
     * purpose: ensures data loads correctly from a file and handles bad file names
     * parameters: none
     * return: void
     */
    @Test
    public void testLoadFromFile() {
        CheckoutManager testManager = new CheckoutManager();
        assertTrue(testManager.loadFromFile("sample_data.txt")); // Affirmative
        assertFalse(testManager.loadFromFile("missingfile.txt")); // Negative
    }

    /**
     * method: testListOverdueGear
     * purpose: checks that overdue gear is listed and handles when nothing is overdue
     * parameters: none
     * return: void
     */
    @Test
    public void testListOverdueGear() {
        String today = "2025-06-15";
        String result = manager.listOverdueGear(today);
        assertTrue(result.contains("001")); // Affirmative

        CheckoutManager emptyManager = new CheckoutManager();
        String resultEmpty = emptyManager.listOverdueGear(today);
        assertEquals("No overdue gear found.", resultEmpty); // Negative
    }
}
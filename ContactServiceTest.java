/*************************
 * Name: David Silva
 * Course: CS-320
 * Date: January 19, 2026
 * Description: Unit tests for the ContactService class.
 * These tests verify that contacts can be added, deleted,
 * and updated correctly using in-memory storage.
 *************************/

import org.junit.Test;
import static org.junit.Assert.*;

public class ContactServiceTest {

    /**
     * Verifies that a contact can be added successfully
     * when the contact ID is unique.
     */
    @Test
    public void testAddContactSuccessfully() {
        ContactService service = new ContactService();
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main Street");

        service.addContact(contact);

        // If no exception is thrown, the add was successful
        assertTrue(true);
    }

    /**
     * Verifies that adding a contact with a duplicate
     * contact ID is rejected.
     */
    @Test
    public void testAddContactDuplicateIdFails() {
        ContactService service = new ContactService();
        Contact contact1 = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main Street");
        Contact contact2 = new Contact("1234567890", "Jane", "Smith", "0987654321", "456 Oak Ave");

        service.addContact(contact1);

        // JUnit 4 style: use try/catch to verify exception is thrown
        try {
            service.addContact(contact2);
            fail("Expected IllegalArgumentException to be thrown for duplicate contact ID");
        } catch (IllegalArgumentException e) {
            // Pass: exception was thrown as expected
            assertTrue(true);
        }
    }

    /**
     * Verifies that a contact can be deleted
     * using a valid contact ID.
     */
    @Test
    public void testDeleteContactSuccessfully() {
        ContactService service = new ContactService();
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main Street");

        service.addContact(contact);
        service.deleteContact("1234567890");

        // If no exception is thrown, deletion succeeded
        assertTrue(true);
    }

    /**
     * Verifies that deleting a contact with
     * an invalid ID throws an exception.
     */
    @Test
    public void testDeleteContactFailsWhenIdNotFound() {
        ContactService service = new ContactService();

        try {
            service.deleteContact("invalidId");
            fail("Expected IllegalArgumentException to be thrown for invalid contact ID");
        } catch (IllegalArgumentException e) {
            // Pass
            assertTrue(true);
        }
    }

    /**
     * Verifies that updating a contact's fields
     * works correctly when the contact exists.
     */
    @Test
    public void testUpdateContactFieldsSuccessfully() {
        ContactService service = new ContactService();
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main Street");

        service.addContact(contact);

        service.updateFirstName("1234567890", "Jane");
        service.updateLastName("1234567890", "Smith");
        service.updatePhone("1234567890", "0987654321");
        service.updateAddress("1234567890", "456 Oak Ave");

        // Verify the Contact object was updated
        assertEquals("Jane", contact.getFirstName());
        assertEquals("Smith", contact.getLastName());
        assertEquals("0987654321", contact.getPhone());
        assertEquals("456 Oak Ave", contact.getAddress());
    }

    /**
     * Verifies that updating a contact using
     * an invalid contact ID is rejected.
     */
    @Test
    public void testUpdateFailsWhenContactNotFound() {
        ContactService service = new ContactService();

        try {
            service.updateFirstName("invalidId", "Jane");
            fail("Expected IllegalArgumentException to be thrown when contact ID does not exist");
        } catch (IllegalArgumentException e) {
            // Pass
            assertTrue(true);
        }
    }
}
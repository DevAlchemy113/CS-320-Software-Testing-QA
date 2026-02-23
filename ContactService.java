/*************************
 * Name: David Silva
 * Course: CS-320
 * Date: January 19, 2026
 * Description: This class provides services to add, delete,
 * and update Contact objects using in-memory storage.
 *************************/

import java.util.HashMap;
import java.util.Map;

/**
 * The ContactService class manages Contact objects in memory.
 * It provides functionality to add, delete, and update contacts
 * while enforcing unique contact IDs and validation rules.
 */

public class ContactService {

    // In-memory storage of contacts using contactId as the key
    private final Map<String, Contact> contacts = new HashMap<>();

    /**
     * Adds a new contact to the service.
     * Throws IllegalArgumentException if the contact is null
     * or if the contact ID already exists.
     */
    public void addContact(Contact contact) {

        // Validate contact object
        if (contact == null) {
            throw new IllegalArgumentException("Contact cannot be null");
        }

        String contactId = contact.getContactId();

        // Ensure contact ID is unique
        if (contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact ID already exists");
        }

        // Add contact to in-memory storage
        contacts.put(contactId, contact);
    }

    /**
     * Deletes a contact using the contact ID.
     * Throws IllegalArgumentException if the contact ID does not exist.
     */
    public void deleteContact(String contactId) {

        // Validate contact ID
        if (contactId == null || !contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact ID not found");
        }

        // Remove contact from storage
        contacts.remove(contactId);
    }

    /**
     * Updates the first name of an existing contact.
     */
    public void updateFirstName(String contactId, String firstName) {
        getExistingContact(contactId).setFirstName(firstName);
    }

    /**
     * Updates the last name of an existing contact.
     */
    public void updateLastName(String contactId, String lastName) {
        getExistingContact(contactId).setLastName(lastName);
    }

    /**
     * Updates the phone number of an existing contact.
     */
    public void updatePhone(String contactId, String phone) {
        getExistingContact(contactId).setPhone(phone);
    }

    /**
     * Updates the address of an existing contact.
     */
    public void updateAddress(String contactId, String address) {
        getExistingContact(contactId).setAddress(address);
    }

    /**
     * Helper method to retrieve an existing contact.
     * Throws IllegalArgumentException if the contact ID does not exist.
     */
    private Contact getExistingContact(String contactId) {

        if (contactId == null || !contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact ID not found");
        }

        return contacts.get(contactId);
    }
}
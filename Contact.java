/*************************
 * Name: David Silva
 * Course: CS-320
 * Date: January 19, 2026
 * Description: This is the Contact class. It creates and stores contact information
 * while enforcing validation rules defined in the project requirements.
 *************************/

public class Contact {

    // Unique contact ID (required, max 10 characters, not updatable)
    private final String contactId;

    // Required first name (max 10 characters)
    private String firstName;

    // Required last name (max 10 characters)
    private String lastName;

    // Required phone number (exactly 10 digits)
    private String phone;

    // Required address (max 30 characters)
    private String address;

    /**
     * Creates a Contact object and validates all required fields.
     * Throws IllegalArgumentException if any field does not meet
     * the project requirements.
     */
    public Contact(String contactId, String firstName, String lastName, String phone, String address) {

        // Validate contact ID
        if (contactId == null || contactId.length() > 10) {
            throw new IllegalArgumentException("Invalid contact ID");
        }

        // Validate first name
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("Invalid first name");
        }

        // Validate last name
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Invalid last name");
        }

        // Validate phone number
        if (phone == null || phone.length() != 10 || !phone.matches("\\d+")) {
            throw new IllegalArgumentException("Invalid phone number");
        }

        // Validate address
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("Invalid address");
        }

        // Assign validated values
        this.contactId = contactId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
    }

    // ----- Getters and Setters -----

    public String getContactId() {
        return contactId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("Invalid first name");
        }
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Invalid last name");
        }
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        if (phone == null || phone.length() != 10 || !phone.matches("\\d+")) {
            throw new IllegalArgumentException("Invalid phone number");
        }
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("Invalid address");
        }
        this.address = address;
    }
}
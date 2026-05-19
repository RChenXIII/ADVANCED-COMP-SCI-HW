
public class ContactListTester {
    public static void main(String[] args) {
        ContactList contactList = new ContactList();

        // Create test contacts
        Contact contact1 = new Contact("Alice", "Smith", "555-0001");
        Contact contact2 = new Contact("Tommy", "Brown", "555-0002");
        Contact contact3 = new Contact("Bobby", "Jones", "555-0003");
        Contact contact4 = new Contact("Annabelle", "Davis", "555-0004");
        Contact contact5 = new Contact("Samantha", "Miller", "555-0005");
        Contact contact6 = new Contact("Samuel", "Wilson", "555-0006");
        Contact contact7 = new Contact("Alice", "Johnson", "555-0007"); // Same first name as
                                                                        // contact1
        Contact contact8 = new Contact("Alice", "Smith", "555-0001"); // Duplicate phone number
                                                                      // attempt

        System.out.println("=== Testing Add Method ===");
        System.out.println("Adding contact1: " + contactList.add(contact1)); // true
        System.out.println("Adding contact2: " + contactList.add(contact2)); // true
        System.out.println("Adding contact3: " + contactList.add(contact3)); // true
        System.out.println("Adding contact4: " + contactList.add(contact4)); // true
        System.out.println("Adding contact5: " + contactList.add(contact5)); // true
        System.out.println("Adding contact6: " + contactList.add(contact6)); // true
        System.out.println("Adding contact7: " + contactList.add(contact7)); // true
        System.out.println(
                "Adding duplicate contact8 (same phone as contact1): " + contactList.add(contact8)); // false
        System.out.println("Current list: " + contactList);
        System.out.println();

        System.out.println("=== Testing Remove Method ===");
        System.out.println("Removing contact3: " + contactList.remove(contact3)); // true
        System.out.println("Current list: " + contactList);
        System.out.println("Removing null: " + contactList.remove(null)); // false
        System.out.println();

        System.out.println("=== Testing Sort by First Name ===");
        contactList.sortByFirstName();
        System.out.println("After sorting by first name: " + contactList);
        System.out.println();

        System.out.println("=== Testing Sort by Last Name ===");
        contactList.sortByLastName();
        System.out.println("After sorting by last name: " + contactList);
        System.out.println();

        System.out.println("=== Testing Sort by Telephone Number ===");
        contactList.sortByTelephoneNumber();
        System.out.println("After sorting by telephone: " + contactList);
        System.out.println();

        System.out.println("=== Testing Search Contacts ===");
        contactList.sortByTelephoneNumber();
        System.out.println("List sorted by phone number for search");
        Contact found = contactList.searchContacts("555-0005");
        System.out.println("Searching for 555-0005: " + found);
        Contact notFound = contactList.searchContacts("555-9999");
        System.out.println("Searching for 555-9999: " + notFound);
        System.out.println();
    }
}


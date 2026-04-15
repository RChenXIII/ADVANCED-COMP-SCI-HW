import java.util.AbstractList;
import java.util.ArrayList;


public class ContactList extends AbstractList {

    // instance variable
    private ArrayList<String> contactList;

    // constructor
    // to-do: initializes an empty contact list
    public ContactList() {
        contactList = new ArrayList<String>();
    }

    // methods

    // to-do: findInsertLocation(String name)
    /**
     * returns the location in the contact list where the name should go to keep the list
     * alphabetized
     */
    private int findInsertLocation(String name) {
        // Binary search implementation (Stretch Challenge)
        int left = 0;
        int right = contactList.size();

        while (left < right) {
            int mid = (left + right) / 2;
            int comparison = name.compareTo(contactList.get(mid));

            if (comparison < 0) {
                right = mid;
            } else if (comparison > 0) {
                left = mid + 1;
            } else {
                // Name already exists, return the index
                return mid;
            }
        }

        return left;
    }

    // to-do: add(String name)
    /**
     * adds a name to the contact list so that the list remains alphabetized, it prints out which
     * name is being added, also the method prevents duplicate names from being added
     */
    public boolean add(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }

        int insertIndex = findInsertLocation(name);

        // Check if the name already exists at the insert location
        if (insertIndex < contactList.size() && contactList.get(insertIndex).equals(name)) {
            return false;
        }

        System.out.println("+ Adding " + name);
        contactList.add(insertIndex, name);
        return true;
    }

    // to-do: add(ArrayList<String> names)
    /* this method adds a list of names to the contact list */
    public void add(ArrayList<String> names) {
        if (names == null) {
            throw new IllegalArgumentException("Names list cannot be null");
        }

        for (String name : names) {
            add(name);
        }
    }

    // to-do: remove(String name)
    /** removes name from the contact list and keeps list alphabetized */
    public boolean remove(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }

        for (int i = 0; i < contactList.size(); i++) {
            if (contactList.get(i).equals(name)) {
                System.out.println("- Removing " + name);
                contactList.remove(i);
                return true;
            }
        }

        return false;
    }

    // to-do: remove(ArrayList<String> names)
    /* this method removes a list of names from the contact list */
    public void remove(ArrayList<String> names) {
        if (names == null) {
            throw new IllegalArgumentException("Names list cannot be null");
        }

        for (String name : names) {
            remove(name);
        }
    }

    /** returns a String containing all of the words in list */
    public String toString() {
        return "Contact List: " + contactList.toString();
    }

    // to-do: get(int index)
    /** returns the name at the specified index */
    public String get(int index) {
        return contactList.get(index);
    }

    // to-do: size()
    /** returns the number of names in the contact list */
    public int size() {
        return contactList.size();
    }

    // to-do: clear()
    /** removes all names from the contact list */
    public void clear() {
        System.out.println("Clearing the contact list");
        contactList.clear();
    }

}

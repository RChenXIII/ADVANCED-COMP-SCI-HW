import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collections;


public class ContactList extends AbstractList<Contact> {

    private ArrayList<Contact> contactList;

    public ContactList() {
        contactList = new ArrayList<Contact>();
    }

    public boolean add(Contact contact) {
        if (contact == null) {
            return false;
        }

        for (Contact c : contactList) {
            if (c.equals(contact)) {
                return false;
            }
        }

        contactList.add(contact);
        return true;
    }

    public boolean remove(Contact contact) {
        if (contact == null) {
            return false;
        }

        return contactList.remove(contact);
    }

    public void sortByFirstName() {
        Collections.sort(contactList);
    }

    public void sortByLastName() {
        for (int i = 0; i < contactList.size() - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < contactList.size(); j++) {
                Contact current = contactList.get(j);
                Contact min = contactList.get(minIndex);
                if (current.compareByLastName(min) < 0) {
                    minIndex = j;
                }
            }
            Contact temp = contactList.get(i);
            contactList.set(i, contactList.get(minIndex));
            contactList.set(minIndex, temp);
        }
    }

    public void sortByTelephoneNumber() {
        for (int i = 1; i < contactList.size(); i++) {
            Contact current = contactList.get(i);
            int j = i - 1;

            while (j >= 0 && contactList.get(j).getTelephoneNumber()
                    .compareTo(current.getTelephoneNumber()) > 0) {
                contactList.set(j + 1, contactList.get(j));
                j--;
            }
            contactList.set(j + 1, current);
        }
    }

    public Contact searchContacts(String telephoneNumber) {
        if (telephoneNumber == null || telephoneNumber.isEmpty()) {
            throw new IllegalArgumentException("Phone number cannot be null");
        }

        sortByTelephoneNumber();

        int left = 0;
        int right = contactList.size() - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            Contact midContact = contactList.get(mid);
            int comparison = midContact.getTelephoneNumber().compareTo(telephoneNumber);

            if (comparison == 0) {
                return midContact;
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return null;
    }

    public String toString() {
        return "Contact List: " + contactList.toString();
    }

    @Override
    public Contact get(int index) {
        return contactList.get(index);
    }

    @Override
    public int size() {
        return contactList.size();
    }
}

public class Contact implements Comparable<Contact> {
    public String firstName;
    public String lastName;
    public String telephoneNumber;

    public Contact(String firstName, String lastName, String telephoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.telephoneNumber = telephoneNumber;

    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public int compareTo(Contact other) {
        if (other == null) {
            return -1;
        }

        int firstNameComparison = firstName.compareTo(other.firstName);
        if (firstNameComparison != 0) {
            return firstNameComparison;
        }

        int lastNameComparison = lastName.compareTo(other.lastName);
        if (lastNameComparison != 0) {
            return lastNameComparison;
        }

        return telephoneNumber.compareTo(other.telephoneNumber);
    }

    public int compareByLastName(Contact other) {
        if (other == null) {
            return -1;
        }

        int lastNameComparison = lastName.compareTo(other.lastName);
        if (lastNameComparison != 0) {
            return lastNameComparison;
        }

        int firstNameComparison = firstName.compareTo(other.firstName);
        if (firstNameComparison != 0) {
            return firstNameComparison;
        }

        return telephoneNumber.compareTo(other.telephoneNumber);
    }

    public String toString() {
        return firstName + " " + lastName + ": " + telephoneNumber;
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof Contact) {
            Contact otherContact = (Contact) other;
            return telephoneNumber.equals(otherContact.telephoneNumber);
        }
        return false;
    }

    public String validateTelephoneNumber(String telephoneNumber) {
        // format should be xxx-xxx-xxxx
        if (telephoneNumber == null) {
            throw new IllegalArgumentException("Phone number cannot be null.");
        }

        if (telephoneNumber.length() == 12) {
            if ((telephoneNumber.charAt(3) != '-') || (telephoneNumber.charAt(7) != '-')) {
                throw new IllegalArgumentException(
                        "Phone number must have a dash after the 3rd and 6th number.");
            }
            return telephoneNumber;
        } else {
            throw new IllegalArgumentException("Phone number must be 10 digits");
        }
    }
}

public class Bank {
    private int numberOfLoanOfficers;
    private int numberOfTellers;

    // constructors
    public Bank(int numberOfLoanOfficers, int numberOfTellers) {
        this.numberOfLoanOfficers = numberOfLoanOfficers;
        this.numberOfTellers = numberOfTellers;
    }

    // getters
    public int getNumberOfLoanOfficers() {
        return numberOfLoanOfficers;
    }

    public int getNumberOfTellers() {
        return numberOfTellers;
    }

    // setters
    public void setNumberOfLoanOfficers(int input) {
        numberOfLoanOfficers = input;
    }

    public void setNumberOfTellers(int input) {
        numberOfTellers = input;
    }

    // methods
    public String toString() {
        String firstPart = ("This bank has " + numberOfLoanOfficers);
        return (firstPart + " loan officers and " + numberOfTellers + " tellers.");
    }

    public int computeTotalEmployees() {
        return (numberOfLoanOfficers + numberOfTellers);
    }

    public boolean equals(Bank other) {
        boolean areLoanOfficersEqual = numberOfLoanOfficers == other.numberOfLoanOfficers;
        return areLoanOfficersEqual && numberOfTellers == other.numberOfTellers;
    }

    public int hireMembers(int numberToHire, boolean isLoanOfficer) {
        if (isLoanOfficer == true) {
            return numberOfLoanOfficers += numberToHire;
        } else {
            return numberOfTellers += numberToHire;
        }
    }
}

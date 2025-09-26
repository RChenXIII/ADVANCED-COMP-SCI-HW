public class Customer {

    private String name;
    private String address;
    private int rewardPoints;

    // constructors
    public Customer(String name, String address, int rewardPoints) {
        this.name = name;
        this.address = address;
        this.rewardPoints = rewardPoints;
    }


    // getters
    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getRewardPoints() {
        return rewardPoints;
    }

    // setters
    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setRewardPoints(int rewardPoints) {
        this.rewardPoints = rewardPoints;
    }

    // methods
    public String toString() {// Customer Name: Jane Doe, Address: 777 Coldwater Road, Reward
                              // Points: 3500
        return ("Customer Name: " + name + ", Address: " + address + ", Reward Points: "
                + rewardPoints);
    }

    public boolean equals(Customer other) {
        return this.name == other.name && this.address == other.address
                && this.rewardPoints == other.rewardPoints;
    }

    public double boostPoints() {
        return (int) ((Math.random() + 1) * rewardPoints);
    }
}

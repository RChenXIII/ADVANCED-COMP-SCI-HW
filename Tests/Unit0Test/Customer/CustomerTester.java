public class CustomerTester {
    public static void main(String[] args) {
        System.out.println("Customer Tester");

        // Instantiating Customer Objects
        Customer customer1 = new Customer("John Smith", "456 Faring Rd", 800);
        Customer customer2 = new Customer("Jane Doe", "777 Coldwater Rd", 3500);
        Customer customer3 = new Customer("Jane Doe", "777 Coldwater Rd", 3500);

        // Testing Getters
        System.out.println("1. Customer 1 Name: " + customer1.getName()
                + testGetName(customer1, "John Smith"));
        System.out.println("2. Customer 2 Address: " + customer2.getAddress()
                + testGetAddress(customer2, "777 Coldwater Rd"));
        System.out.println("3. Customer 1 Rewards: " + customer2.getRewardPoints()
                + testGetRewardPoints(customer2, 3500));

        // Testing equals()
        System.out.println("4. Are Customer 1 and 2 equal? "
                + (customer1.equals(customer2) ? "Yes... Pass!" : "No... Fail!"));
        System.out.println("5. Are Customer 2 and 3 equal? "
                + (customer2.equals(customer3) ? "Yes... Pass!" : "No... Fail!"));


        // Testing toString()
        String outputMatcher =
                "Customer Name: Jane Doe, Address: 777 Coldwater Rd, Reward Points: 3500";

        System.out.println("6. Did I match the string exactly? "
                + (customer3.toString().equals(outputMatcher) ? "Yes... Pass!" : "No... Fail!"));

        System.out.println();
        System.out.println("To String Method: ");
        System.out.println(customer2.toString());
        System.out.println();

        // Test other methods here
        System.out.println(customer1.boostPoints());



    }

    public static String testGetName(Customer customer1, String name) {
        return customer1.getName().equals(name) ? "... Pass!" : "... Fail!";
    }

    public static String testGetAddress(Customer customer1, String address) {
        return customer1.getAddress().equals(address) ? "... Pass!" : "... Fail!";
    }

    public static String testGetRewardPoints(Customer customer1, int rewardPoints) {
        return customer1.getRewardPoints() == rewardPoints ? "... Pass!" : "... Fail!";
    }
}

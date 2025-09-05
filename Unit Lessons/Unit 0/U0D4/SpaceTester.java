public class SpaceTester {
    public static void main(String[] args) {
        // 1. instantiate a spaceship object
        Spaceship ship = new Spaceship("red", 30, 100.0, true);

        // 2. invoke a method
        String shipDescription = ship.getDescription();

        int shipPassengerCount = ship.getPassengerCount();

        double shipFuelLevel = ship.getFuelLevel();

        System.out.println(shipDescription);
        System.out.println(shipPassengerCount);
        System.out.println(shipFuelLevel);
        // 3. manipulate the data


        // Challenge
        ship.setDescription("blue");
        shipDescription = ship.getDescription();
        System.out.println(shipDescription);

        ship.setPassengerCount(1000);
        shipPassengerCount = ship.getPassengerCount();
        System.out.println(shipPassengerCount);

        ship.setFuelLevel(50.0);
        shipFuelLevel = ship.getFuelLevel();
        System.out.println(shipFuelLevel);
    }
}

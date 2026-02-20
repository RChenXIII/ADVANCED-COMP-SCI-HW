public class AnimalTester {
    public static void main(String[] args) {
        // Emu tests
        Emu emu1 = new Emu("Eddy");
        Emu emu2 = new Emu();
        emu2.setName("Emma");

        System.out.println("--- Emu 1 ---");
        System.out.println(emu1);
        emu1.makeSound();
        emu1.move();
        emu1.eat("seeds and insects");
        emu1.ageOneYear();

        System.out.println("\n--- Emu 2 ---");
        System.out.println(emu2);

        // Ostrich tests
        Ostrich ostrich1 = new Ostrich("Olly");
        Ostrich ostrich2 = new Ostrich();
        ostrich2.setName("Opal");

        System.out.println("\n--- Ostrich 1 ---");
        System.out.println(ostrich1);
        ostrich1.makeSound();
        ostrich1.move();
        ostrich1.eat("plants and small animals");
        ostrich1.layEgg();

        System.out.println("\n--- Ostrich 2 ---");
        System.out.println(ostrich2);

        // Octopus tests
        Octopus oct1 = new Octopus("Octavia");
        Octopus oct2 = new Octopus();
        oct2.setName("Otis");

        System.out.println("\n--- Octopus 1 ---");
        System.out.println(oct1);
        oct1.makeSound();
        oct1.move();
        oct1.eat("crab");
        oct1.camouflage();
        oct1.shootInk();

        System.out.println("\n--- Octopus 2 ---");
        System.out.println(oct2);

        // Test setter/getter interaction
        emu1.setTopSpeedKmph(55);
        System.out.println("\nEddy's updated top speed: " + emu1.getTopSpeedKmph() + " km/h");
    }
}

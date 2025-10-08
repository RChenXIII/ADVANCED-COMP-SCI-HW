public class DogTester {
    public static void main(String[] args) {
        System.out.println("=== Original Tests (Updated) ===");
        Dog dog1 = new Dog("Justin", "Daniel", 5, 456, false);
        Dog dog2 = new Dog();
        Dog dog3 = new Dog("Owen", "Morgan", 7, 693, true);

        System.out.println(dog1.toString());
        System.out.println(dog2.toString());
        System.out.println(dog3.toString());

        dog1.setAge(dog1.getAge() + 1);
        dog2.setAge(dog2.getAge() + 1);

        System.out.println(PawesomeUtils.generateDogTag(dog1.getDogId(), dog1.getDogChar()));
        System.out.println(PawesomeUtils.generateDogTag(dog2.getDogId(), dog2.getDogChar()));

        System.out.println("dog1 equals dog2: " + dog1.equals(dog2));
        System.out.println(dog1.toString());
        System.out.println(dog2.toString());
        System.out.println(dog3.toString());

        System.out.println(PawesomeUtils.generateDogChar(dog1.getDogId()));
        System.out.println(PawesomeUtils.generateDogChar(dog2.getDogId()));
        System.out.println(PawesomeUtils.generateDogChar(123));

        System.out.println(PawesomeUtils.pickup(dog1, "Daniel"));
        System.out.println(PawesomeUtils.pickup(dog2, "Daniel"));

        PawesomeUtils.checkIn(dog1, "Daniel");
        System.out.println(dog1.toString());

        System.out.println("\n=== Testing validateDogId() ===");

        System.out.println("Valid ID 456: " + PawesomeUtils.validateDogId(456));
        System.out.println("Valid ID 100: " + PawesomeUtils.validateDogId(100));
        System.out.println("Valid ID 999: " + PawesomeUtils.validateDogId(999));


        System.out.println("Invalid ID 50: " + PawesomeUtils.validateDogId(50));
        System.out.println("Invalid ID 1000: " + PawesomeUtils.validateDogId(1000));
        System.out.println("Invalid ID -5: " + PawesomeUtils.validateDogId(-5));

        System.out.println("\n=== Testing validateDogTag() ===");

        Dog testDog1 = new Dog("Max", "John", 3, 234, true);
        Dog testDog2 = new Dog("Bella", "Sarah", 4, 567, false);
        Dog testDog3 = new Dog("Charlie", "Mike", 2, 890, true);

        System.out.println("testDog1 tag valid: " + PawesomeUtils.validateDogTag(testDog1));
        System.out.println("testDog2 tag valid: " + PawesomeUtils.validateDogTag(testDog2));
        System.out.println("testDog3 tag valid: " + PawesomeUtils.validateDogTag(testDog3));

        System.out.println("\n=== Testing Edge Cases ===");

        testDog1.setDogTag("INVALID");
        System.out.println("testDog1 with invalid tag: " + PawesomeUtils.validateDogTag(testDog1));


        testDog2.setDogChar('X');
        System.out
                .println("testDog2 with modified char: " + PawesomeUtils.validateDogTag(testDog2));
    }
}

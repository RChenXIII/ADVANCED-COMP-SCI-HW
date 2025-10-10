public class DogTester {
    public static void main(String[] args) {
        System.out.println("=== Original Tests ===");
        Dog dog1 = new Dog("Daniel", "Matthew", 2, 123);
        Dog dog2 = new Dog();
        Dog dog3 = new Dog("Owen", "Morgan", 7, 693);

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

        Dog testDog1 = new Dog("Max", "John", 3, 234);
        Dog testDog2 = new Dog("Bella", "Sarah", 4, 567);
        Dog testDog3 = new Dog("Charlie", "Mike", 2, 890);

        System.out.println("testDog1 tag valid: " + PawesomeUtils.validateDogTag(testDog1));
        System.out.println("testDog2 tag valid: " + PawesomeUtils.validateDogTag(testDog2));
        System.out.println("testDog3 tag valid: " + PawesomeUtils.validateDogTag(testDog3));

        System.out.println("\n=== Testing Edge Cases ===");
        testDog1.setDogTag("INVALID");
        System.out.println("testDog1 with invalid tag: " + PawesomeUtils.validateDogTag(testDog1));


        testDog2.setDogChar('X');
        System.out
                .println("testDog2 with modified char: " + PawesomeUtils.validateDogTag(testDog2));

        System.out.println("\n=== Testing checkIn() with Invalid Tag ===");

        Dog counterfeitDog = new Dog("Fake", "BadGuy", 3, 555);
        counterfeitDog.setDogTag("FAKE123");
        PawesomeUtils.checkIn(counterfeitDog, "BadGuy");


        Dog validDog = new Dog("Buddy", "Alice", 4, 321);
        PawesomeUtils.checkIn(validDog, "Alice");

        System.out.println("\n=== Testing convertAgeToHumanAge() ===");

        Dog puppy = new Dog("Puppy", "Owner1", 1, 111);
        Dog youngDog = new Dog("Young", "Owner2", 2, 222);
        Dog olderDog = new Dog("Older", "Owner3", 5, 333);

        System.out.println(puppy.getName() + " (age " + puppy.getAge() + ") is "
                + PawesomeUtils.convertAgeToHumanAge(puppy) + " in human years");
        System.out.println(youngDog.getName() + " (age " + youngDog.getAge() + ") is "
                + PawesomeUtils.convertAgeToHumanAge(youngDog) + " in human years");
        System.out.println(olderDog.getName() + " (age " + olderDog.getAge() + ") is "
                + PawesomeUtils.convertAgeToHumanAge(olderDog) + " in human years");

        System.out.println("\n=== Testing convertAgeToDogYears() ===");

        System.out
                .println("Human age 10 = " + PawesomeUtils.convertAgeToDogYears(10) + " dog years");
        System.out
                .println("Human age 15 = " + PawesomeUtils.convertAgeToDogYears(15) + " dog years");
        System.out
                .println("Human age 20 = " + PawesomeUtils.convertAgeToDogYears(20) + " dog years");
        System.out
                .println("Human age 24 = " + PawesomeUtils.convertAgeToDogYears(24) + " dog years");
        System.out
                .println("Human age 30 = " + PawesomeUtils.convertAgeToDogYears(30) + " dog years");
        System.out
                .println("Human age 39 = " + PawesomeUtils.convertAgeToDogYears(39) + " dog years");
        System.out
                .println("Human age 49 = " + PawesomeUtils.convertAgeToDogYears(49) + " dog years");
        System.out
                .println("Human age 60 = " + PawesomeUtils.convertAgeToDogYears(60) + " dog years");
    }
}

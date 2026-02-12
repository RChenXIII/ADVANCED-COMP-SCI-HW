import java.util.ArrayList;
import java.util.Arrays;

public class ShelterTester {
    public static void main(String[] args) {
        // some good dogs
        Dog dog1 = new Dog("Fido", 3);
        Dog dog2 = new Dog("Spot", 4);
        Dog dog3 = new Dog("Rex", 2);
        Dog dog4 = new Dog("Fido", 4);

        // taking the good dogs, and putting them in a list
        ArrayList<Dog> goodDogs = new ArrayList<Dog>(Arrays.asList(dog1, dog2, dog3, dog4));

        // creating a shelter
        Shelter shelter = new Shelter();

        // setting the shelter's kennels to a 3x3 array of dogs, note that some kennels are empty
        Dog[][] starterKennels =
                new Dog[][] {{dog1, null, null}, {null, dog2, null}, {dog3, null, dog4}};
        shelter.setKennels(starterKennels);


        // extra dogs for you to use
        Dog dog5 = new Dog("Growlithe", 5);
        Dog dog6 = new Dog("Inu", 2);
        Dog dog7 = new Dog("Cerberus", 3);


        // method that displays the shelter's current status
        shelter.displayStatus();

        System.out.println("\n--- Test add(Dog animal, int row, int col) ---");
        // add an animal to the shelter at a specific location
        // then display the shelter's status
        shelter.add(dog5, 0, 1);
        shelter.displayStatus();

        System.out.println("\n--- Test add(Dog animal) ---");
        // add an animal to the shelter at the first available location
        // then display the shelter's status
        shelter.add(dog6);
        shelter.displayStatus();

        System.out.println("\n--- Test add(ArrayList<Dog> animals) ---");
        // add a list of animals to the shelter at the first available location
        // then display the shelter's status
        ArrayList<Dog> newDogs = new ArrayList<Dog>(Arrays.asList(dog7));
        shelter.add(newDogs);
        shelter.displayStatus();

        System.out.println("\n--- Test adopt(int row, int col) ---");
        // remove an animal from the shelter at a specific location
        // then display the shelter's status
        Dog adoptedDog = shelter.adopt(0, 0);
        System.out.println("Adopted: " + adoptedDog);
        shelter.displayStatus();

        System.out.println("\n--- Test search(String name) ---");
        // search the kennel for animals with a specific name
        // then print the list
        System.out.println(shelter.search("Fido"));

        System.out.println("\n--- Test search(int age) ---");
        // search the kennel for animals with a specific age
        // then print the list
        System.out.println(shelter.search(4));
    }
}

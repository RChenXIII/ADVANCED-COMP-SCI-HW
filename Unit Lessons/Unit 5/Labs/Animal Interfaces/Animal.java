public abstract class Animal {

    // Basic Characteristics
    // All animals have these characteristics
    public static final String KINGDOM = "Animalia";

    // These fields are shared by ALL animals.
    // This shows an "is a" relationship: every specific animal IS AN Animal,
    // so it automatically has these characteristics.
    private String name;
    private String order;
    private String family;
    private String genus;
    private String species;
    private String habitat;

    // All concrete animals must call this constructor to set up their shared state.
    public Animal(String name, String order, String family, String genus, String species,
            String habitat) {
        this.name = name;
        this.order = order;
        this.family = family;
        this.genus = genus;
        this.species = species;
        this.habitat = habitat;
    }

    // returns the common name of the animal (e.g. "Axolotl", "Eagle")
    public String getName() {
        return name;
    }

    // returns the order of the animal
    public String getOrder() {
        return order;
    }

    // returns the family of the animal
    public String getFamily() {
        return family;
    }

    // returns the genus of the animal
    public String getGenus() {
        return genus;
    }

    // returns the species of the animal
    public String getSpecies() {
        return species;
    }

    // returns the most common location where the animal is found
    public String getHabitat() {
        return habitat;
    }

    // Example of a shared helper method that uses the common fields.
    public String getScientificName() {
        return genus + " " + species;
    }

    // returns a fact at the index, out of 5 total facts
    public abstract String getFact(int index);

    // returns a random fact (out of 5) of the animal
    public abstract String getFact();

    // Basic Behaviors - BE CREATIVE

    // prints out the sound the animal makes
    public abstract void makeSound();

    // prints out the sound the animal makes when it eats
    public abstract void eat();

    // prints out the sound the animal makes when it moves
    public abstract void move();

    // descriptive text versions of the basic behaviors, for displaying in a GUI
    public abstract String getSoundDescription();

    public abstract String getEatDescription();

    public abstract String getMoveDescription();
}

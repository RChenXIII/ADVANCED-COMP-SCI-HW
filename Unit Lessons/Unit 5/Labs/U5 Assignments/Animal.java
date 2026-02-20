
public abstract class Animal {
    protected String name;
    protected String species;
    protected String scientificName;
    protected String habitat;
    protected String diet;
    protected double averageLifespan;
    protected String movement;
    protected double weight;
    protected String conservationStatus;

    public Animal() {
        this.name = "Unknown";
        this.species = "Unknown";
        this.scientificName = "Unknown";
        this.habitat = "Unknown";
        this.diet = "Unknown";
        this.averageLifespan = 0.0;
        this.movement = "Unknown";
        this.weight = 0.0;
        this.conservationStatus = "Unknown";
    }

    public Animal(String name, String species, String scientificName, String habitat, String diet,
            double averageLifespan, String movement, double weight, String conservationStatus) {
        this.name = name;
        this.species = species;
        this.scientificName = scientificName;
        this.habitat = habitat;
        this.diet = diet;
        this.averageLifespan = averageLifespan;
        this.movement = movement;
        this.weight = weight;
        this.conservationStatus = conservationStatus;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getScientificName() {
        return scientificName;
    }

    public void setScientificName(String scientificName) {
        this.scientificName = scientificName;
    }

    public String getHabitat() {
        return habitat;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    public String getDiet() {
        return diet;
    }

    public void setDiet(String diet) {
        this.diet = diet;
    }

    public double getAverageLifespan() {
        return averageLifespan;
    }

    public void setAverageLifespan(double averageLifespan) {
        this.averageLifespan = averageLifespan;
    }

    public String getMovement() {
        return movement;
    }

    public void setMovement(String movement) {
        this.movement = movement;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getConservationStatus() {
        return conservationStatus;
    }

    public void setConservationStatus(String conservationStatus) {
        this.conservationStatus = conservationStatus;
    }

    // Behaviors that each concrete animal will implement differently
    public abstract void makeSound();

    public abstract void move();

    public abstract void eat(String food);

    public String toString() {
        return species + " (" + scientificName + ") - Name: " + name + "\n" + "Habitat: " + habitat
                + "\n" + "Diet: " + diet + "\n" + "Average lifespan: " + averageLifespan
                + " years\n" + "Movement: " + movement + "\n" + "Weight (approx): " + weight
                + " kg\n" + "Conservation status: " + conservationStatus;
    }
}

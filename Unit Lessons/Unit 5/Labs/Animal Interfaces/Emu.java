import java.util.Random;

public class Emu extends Animal implements Pettable, Swimmable {
    private double heightMeters;
    private int topSpeedKmph;
    private double wingSpanMeters;
    private boolean canFly;
    private int ageYears;
    private int populationEstimate;
    private int friendlinessLevel;
    private int energyLevel;
    private double swimSpeed;
    private double preferredDepth;

    private static final String[] FACTS = {
            "Emus are the second-largest living bird by height after the ostrich.",
            "Emus cannot walk backwards, which is why they're on the Australian coat of arms.",
            "A single emu egg weighs about as much as 10-12 chicken eggs.",
            "Emus can run at speeds up to 50 km/h and can jump nearly 3 meters high.",
            "Emus have been around for over 80 million years and survived the Ice Age."};

    public Emu() {
        super("Unknown Emu", "Casuariiformes", "Dromaiidae", "Dromaius", "novaehollandiae",
                "Australian grasslands and savannas");
        this.heightMeters = 1.7;
        this.topSpeedKmph = 50;
        this.wingSpanMeters = 1.5;
        this.canFly = false;
        this.ageYears = 0;
        this.populationEstimate = 8000000;
        this.friendlinessLevel = 6;
        this.energyLevel = 8;
        this.swimSpeed = 8.0;
        this.preferredDepth = 2.0;
    }

    public Emu(String name) {
        super(name, "Casuariiformes", "Dromaiidae", "Dromaius", "novaehollandiae",
                "Australian grasslands and savannas");
        this.heightMeters = 1.7;
        this.topSpeedKmph = 50;
        this.wingSpanMeters = 1.5;
        this.canFly = false;
        this.ageYears = 0;
        this.populationEstimate = 8000000;
        this.friendlinessLevel = 6;
        this.energyLevel = 8;
        this.swimSpeed = 8.0;
        this.preferredDepth = 2.0;
    }

    public double getHeightMeters() {
        return heightMeters;
    }

    public void setHeightMeters(double heightMeters) {
        this.heightMeters = heightMeters;
    }

    public int getTopSpeedKmph() {
        return topSpeedKmph;
    }

    public void setTopSpeedKmph(int topSpeedKmph) {
        this.topSpeedKmph = topSpeedKmph;
    }

    public double getWingSpanMeters() {
        return wingSpanMeters;
    }

    public void setWingSpanMeters(double wingSpanMeters) {
        this.wingSpanMeters = wingSpanMeters;
    }

    public boolean isCanFly() {
        return canFly;
    }

    public void setCanFly(boolean canFly) {
        this.canFly = canFly;
    }

    public int getAgeYears() {
        return ageYears;
    }

    public void setAgeYears(int ageYears) {
        this.ageYears = ageYears;
    }

    public int getPopulationEstimate() {
        return populationEstimate;
    }

    public void setPopulationEstimate(int populationEstimate) {
        this.populationEstimate = populationEstimate;
    }

    @Override
    public String getFact(int index) {
        if (index < 0 || index >= FACTS.length) {
            return "Invalid fact index";
        }
        return FACTS[index];
    }

    @Override
    public String getFact() {
        Random random = new Random();
        return FACTS[random.nextInt(FACTS.length)];
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " the emu makes a low drumming call.");
    }

    @Override
    public void eat() {
        System.out.println(getName() + " the emu pecks at seeds and vegetation.");
    }

    @Override
    public void move() {
        System.out.println(
                getName() + " is running with long strides at up to " + topSpeedKmph + " km/h.");
    }

    @Override
    public String getSoundDescription() {
        return "A low, resonant drumming sound used for communication";
    }

    @Override
    public String getEatDescription() {
        return "Pecks at seeds, plants, and small animals with its strong beak";
    }

    @Override
    public String getMoveDescription() {
        return "Runs with powerful legs at impressive speeds across open land";
    }

    // Pettable interface methods
    @Override
    public int getFriendlinessLevel() {
        return friendlinessLevel;
    }

    @Override
    public int getEnergyLevel() {
        return energyLevel;
    }

    @Override
    public void greetHuman() {
        System.out.println(getName() + " looks curious and approaches cautiously.");
    }

    @Override
    public void bePetted() {
        System.out.println(getName() + " allows itself to be petted and makes soft chirps.");
    }

    @Override
    public void playWithHuman() {
        System.out.println(getName() + " playfully runs in circles around the human!");
    }

    // Swimmable interface methods
    @Override
    public double getSwimSpeed() {
        return swimSpeed;
    }

    @Override
    public double getPreferredDepth() {
        return preferredDepth;
    }

    @Override
    public void enterWater() {
        System.out.println(getName() + " wades into the water with cautious steps.");
    }

    @Override
    public void swim() {
        System.out.println(getName() + " paddles through the water at " + swimSpeed
                + " km/h with surprising grace.");
    }

    @Override
    public void exitWater() {
        System.out.println(getName() + " shakes off the water and hops back onto dry land.");
    }

    public void ageOneYear() {
        ageYears++;
        System.out.println(getName() + " is now " + ageYears + " years old.");
    }

    @Override
    public String toString() {
        return "Emu: " + getName() + " (" + getScientificName() + ")\n" + "Habitat: " + getHabitat()
                + "\n" + "Height: " + heightMeters + " m, Top speed: " + topSpeedKmph
                + " km/h, Wing span: " + wingSpanMeters + " m, Flight capable: " + canFly
                + "\nAge: " + ageYears + " years, Population estimate: " + populationEstimate
                + "\nFriendliness: " + friendlinessLevel + "/10, Energy: " + energyLevel + "/10"
                + "\nSwim Speed: " + swimSpeed + " km/h, Preferred Depth: " + preferredDepth + " m";
    }
}

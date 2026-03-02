import java.util.Random;

public class Ostrich extends Animal implements Predator {
    private int feedMeter;
    private double heightMeters;
    private int topSpeedKmph;
    private int toeCount;
    private int ageYears;
    private int eggsLaid;
    private String primaryPrey;
    private double averagePreyMass;

    private static final String[] FACTS = {
            "Ostriches are the fastest-running birds in the world, reaching speeds of 72 km/h.",
            "An ostrich egg weighs about 1.4 kg, which is about 20 times heavier than a chicken egg.",
            "Ostriches do not bury their heads in the sand; they lower them to tend to eggs.",
            "An ostrich's kick is powerful enough to kill a lion with a single blow.",
            "Ostriches can live up to 40-45 years in captivity."};

    public Ostrich() {
        super("Unknown Ostrich", "Struthioniformes", "Struthionidae", "Struthio", "camelus",
                "Savannas and open woodlands");
        this.feedMeter = 50;
        this.heightMeters = 2.1;
        this.topSpeedKmph = 70;
        this.toeCount = 2;
        this.ageYears = 0;
        this.eggsLaid = 0;
        this.primaryPrey = "Small animals and insects";
        this.averagePreyMass = 0.5;
    }

    public Ostrich(String name) {
        super(name, "Struthioniformes", "Struthionidae", "Struthio", "camelus",
                "Savannas and open woodlands");
        this.feedMeter = 50;
        this.heightMeters = 2.1;
        this.topSpeedKmph = 70;
        this.toeCount = 2;
        this.ageYears = 0;
        this.eggsLaid = 0;
        this.primaryPrey = "Small animals and insects";
        this.averagePreyMass = 0.5;
    }

    public int getFeedMeter() {
        return feedMeter;
    }

    public void setFeedMeter(int feedMeter) {
        this.feedMeter = feedMeter;
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

    public int getToeCount() {
        return toeCount;
    }

    public void setToeCount(int toeCount) {
        this.toeCount = toeCount;
    }

    public int getAgeYears() {
        return ageYears;
    }

    public void setAgeYears(int ageYears) {
        this.ageYears = ageYears;
    }

    public int getEggsLaid() {
        return eggsLaid;
    }

    public void setEggsLaid(int eggsLaid) {
        this.eggsLaid = eggsLaid;
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
        System.out.println(getName() + " the ostrich makes a booming call.");
    }

    @Override
    public void eat() {
        feedMeter = Math.min(100, feedMeter + 10);
        System.out.println(getName() + " the ostrich eats with its powerful beak. Feed meter: "
                + feedMeter + "%.");
    }

    @Override
    public void move() {
        System.out.println(getName() + " is running fast at up to " + topSpeedKmph + " km/h!");
    }

    @Override
    public String getSoundDescription() {
        return "A loud, booming call that can be heard from great distances";
    }

    @Override
    public String getEatDescription() {
        return "Swallows food whole using its powerful beak and long neck";
    }

    @Override
    public String getMoveDescription() {
        return "Runs with powerful legs on two massive feet at incredible speeds";
    }

    // Predator interface methods
    @Override
    public String getPrimaryPrey() {
        return primaryPrey;
    }

    @Override
    public double getAveragePreyMass() {
        return averagePreyMass;
    }

    @Override
    public void stalkPrey() {
        System.out.println(getName() + " slowly approaches small prey with calculated steps.");
    }

    @Override
    public void attackPrey() {
        System.out.println(getName() + " charges at its prey with powerful kicks!");
    }

    @Override
    public void eatPrey() {
        System.out.println(getName() + " swallows its prey whole in one gulp.");
    }

    public void layEgg() {
        eggsLaid++;
        System.out.println(getName() + " laid an egg. Total eggs laid: " + eggsLaid);
    }

    public void ageOneYear() {
        ageYears++;
        System.out.println(getName() + " is now " + ageYears + " years old.");
    }

    @Override
    public String toString() {
        return "Ostrich: " + getName() + " (" + getScientificName() + ")\n" + "Habitat: "
                + getHabitat() + "\n" + "Height: " + heightMeters + " m, Top speed: " + topSpeedKmph
                + " km/h, Toes: " + toeCount + ", Feed meter: " + feedMeter + "%" + "\nAge: "
                + ageYears + " years, Eggs laid: " + eggsLaid;
    }
}


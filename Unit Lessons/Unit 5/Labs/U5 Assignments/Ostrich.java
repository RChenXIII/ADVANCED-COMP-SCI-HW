public class Ostrich extends Animal {
    private int feedMeter;
    private double heightMeters;
    private int topSpeedKmph;
    private int toeCount;
    private int ageYears;
    private int eggsLaid;

    public Ostrich() {
        super("Unknown Ostrich", "Ostrich", "Struthio camelus", "Savannas and open woodlands",
                "Omnivore", 40.0, "runs", 100.0, "Least Concern");
        this.feedMeter = 50;
        this.heightMeters = 2.1;
        this.topSpeedKmph = 70;
        this.toeCount = 2;
        this.ageYears = 0;
        this.eggsLaid = 0;
    }

    public Ostrich(String name) {
        super(name, "Ostrich", "Struthio camelus", "Savannas and open woodlands", "Omnivore", 40.0,
                "runs", 100.0, "Least Concern");
        this.feedMeter = 50;
        this.heightMeters = 2.1;
        this.topSpeedKmph = 70;
        this.toeCount = 2;
        this.ageYears = 0;
        this.eggsLaid = 0;
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

    public void makeSound() {
        System.out.println(name + " the ostrich makes a booming call.");
    }

    public void move() {
        System.out.println(name + " is running fast at up to " + topSpeedKmph + " km/h!");
    }

    public void eat(String food) {
        feedMeter = Math.min(100, feedMeter + 10);
        System.out
                .println(name + " the ostrich eats " + food + ". Feed meter: " + feedMeter + "%.");
    }

    public void layEgg() {
        eggsLaid++;
        System.out.println(name + " laid an egg. Total eggs laid: " + eggsLaid);
    }

    public String toString() {
        return super.toString() + "\nHeight: " + heightMeters + " m, Top speed: " + topSpeedKmph
                + " km/h, Toes: " + toeCount + ", Feed meter: " + feedMeter + "%, Eggs laid: "
                + eggsLaid;
    }
}


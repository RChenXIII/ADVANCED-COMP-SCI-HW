public class Emu extends Animal {
    private double heightMeters;
    private int topSpeedKmph;
    private double wingSpanMeters;
    private boolean canFly;
    private int ageYears;
    private int populationEstimate;

    public Emu() {
        super("Unknown Emu", "Emu", "Dromaius novaehollandiae",
                "Australian grasslands and savannas", "Omnivore", 10.0, "runs", 45.0,
                "Least Concern");
        this.heightMeters = 1.7;
        this.topSpeedKmph = 50;
        this.wingSpanMeters = 1.5;
        this.canFly = false;
        this.ageYears = 0;
        this.populationEstimate = 8000000;
    }

    public Emu(String name) {
        super(name, "Emu", "Dromaius novaehollandiae", "Australian grasslands and savannas",
                "Omnivore", 10.0, "runs", 45.0, "Least Concern");
        this.heightMeters = 1.7;
        this.topSpeedKmph = 50;
        this.wingSpanMeters = 1.5;
        this.canFly = false;
        this.ageYears = 0;
        this.populationEstimate = 8000000;
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

    public void makeSound() {
        System.out.println(name + " the emu makes a low drumming call.");
    }

    public void move() {
        System.out.println(
                name + " is running with long strides at up to " + topSpeedKmph + " km/h.");
    }

    public void eat(String food) {
        System.out.println(name + " the emu eats " + food + ".");
    }

    public void ageOneYear() {
        ageYears++;
        System.out.println(name + " is now " + ageYears + " years old.");
    }

    public String toString() {
        return super.toString() + "\nHeight: " + heightMeters + " m, Top speed: " + topSpeedKmph
                + " km/h, Wing span: " + wingSpanMeters + " m, Flight capable: " + canFly
                + "\nAge: " + ageYears + " years, Population estimate: " + populationEstimate;
    }
}

public class Octopus extends Animal {
    private int armsCount;
    private double inkCapacityMl;
    private int intelligenceLevel; // 1-10
    private boolean canCamouflage;
    private double armSpanMeters;
    private boolean nocturnal;

    public Octopus() {
        super("Unknown Octopus", "Octopus", "Octopus vulgaris", "Coastal marine, reefs and rocks",
                "Carnivore", 3.0, "swims and crawls", 15.0, "Not Evaluated");
        this.armsCount = 8;
        this.inkCapacityMl = 30.0;
        this.intelligenceLevel = 8;
        this.canCamouflage = true;
        this.armSpanMeters = 1.5;
        this.nocturnal = true;
    }

    public Octopus(String name) {
        super(name, "Octopus", "Octopus vulgaris", "Coastal marine, reefs and rocks", "Carnivore",
                3.0, "swims and crawls", 15.0, "Not Evaluated");
        this.armsCount = 8;
        this.inkCapacityMl = 30.0;
        this.intelligenceLevel = 8;
        this.canCamouflage = true;
        this.armSpanMeters = 1.5;
        this.nocturnal = true;
    }

    public int getArmsCount() {
        return armsCount;
    }

    public void setArmsCount(int armsCount) {
        this.armsCount = armsCount;
    }

    public double getInkCapacityMl() {
        return inkCapacityMl;
    }

    public void setInkCapacityMl(double inkCapacityMl) {
        this.inkCapacityMl = inkCapacityMl;
    }

    public int getIntelligenceLevel() {
        return intelligenceLevel;
    }

    public void setIntelligenceLevel(int intelligenceLevel) {
        this.intelligenceLevel = intelligenceLevel;
    }

    public boolean isCanCamouflage() {
        return canCamouflage;
    }

    public void setCanCamouflage(boolean canCamouflage) {
        this.canCamouflage = canCamouflage;
    }

    public double getArmSpanMeters() {
        return armSpanMeters;
    }

    public void setArmSpanMeters(double armSpanMeters) {
        this.armSpanMeters = armSpanMeters;
    }

    public boolean isNocturnal() {
        return nocturnal;
    }

    public void setNocturnal(boolean nocturnal) {
        this.nocturnal = nocturnal;
    }

    public void makeSound() {
        // Octopuses are mostly silent; provide descriptive output
        System.out.println(name + " the octopus is mostly silent but uses body language.");
    }

    public void move() {
        System.out.println(name + " swims and crawls using its arms and jet propulsion.");
    }

    public void eat(String food) {
        System.out.println(name + " the octopus catches and eats " + food + ".");
    }

    public void camouflage() {
        if (canCamouflage) {
            System.out.println(name + " changes color and texture to blend with surroundings.");
        } else {
            System.out.println(name + " cannot camouflage.");
        }
    }

    public void shootInk() {
        if (inkCapacityMl > 0) {
            System.out.println(name + " releases a cloud of ink to escape predators.");
            inkCapacityMl = Math.max(0, inkCapacityMl - 10);
        } else {
            System.out.println(name + " has no ink left to release.");
        }
    }

    public String toString() {
        return super.toString() + "\nArms: " + armsCount + ", Ink left: " + inkCapacityMl + " ml, "
                + "Intelligence: " + intelligenceLevel + ", Camouflage: " + canCamouflage
                + "\nArm span: " + armSpanMeters + " m, Nocturnal: " + nocturnal;
    }
}

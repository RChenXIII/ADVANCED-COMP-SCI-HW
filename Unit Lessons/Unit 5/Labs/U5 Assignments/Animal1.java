public abstract class Animal1 extends Animal{
    protected String name;
    protected final String fact;
    protected final String behavior;

    public Animal1(String name, String fact, String behavior) {
        this.name = name;
        this.fact = fact;
        this.behavior = behavior;
    }

    public String getName() {
        return name;
    }

    public abstract String getSpecies();

    public abstract String getScientificName();

    public String getFact() {
        return fact;
    }

    public String getBehavior() {
        return behavior;
    }

    public abstract void speak();

    public abstract void run();
}

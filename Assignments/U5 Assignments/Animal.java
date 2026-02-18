public abstract class Animal {
    protected String name;
    protected final String[] facts;
    protected final String[] behaviors;

    public Animal(String name, String[] facts, String[] behaviors) {
        this.name = name;
        this.facts = facts.clone();
        this.behaviors = behaviors.clone();
    }

    public String getName() {
        return name;
    }

    public abstract String getSpecies();

    public abstract String getScientificName();

    public String[] getFacts() {
        return facts.clone();
    }

    public String[] getBehaviors() {
        return behaviors.clone();
    }

    public abstract void speak();

    public abstract void run();
}

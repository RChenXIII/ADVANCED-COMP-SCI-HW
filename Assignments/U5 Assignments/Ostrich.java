public class Ostrich extends Animal {
    private int feedMeter = 50;

    public Ostrich(String name) {
        super(name, new String[] {"Largest living bird by height", "Cannot fly",
                "Native to savannas and open woodlands"}, new String[] {"run", "kick"});
    }

    public String getSpecies() {
        return "Ostrich";
    }

    public String getScientificName() {
        return "Struthio camelus";
    }

    public void speak() {
        System.out.println(name + " the ostrich makes a booming call.");
    }

    public void run() {
        System.out.println(name + " is running fast!");
    }

    public int getFeedMeter() {
        return feedMeter;
    }

    public void feed(String food) {
        feedMeter = Math.min(100, feedMeter + 10);
        System.out
                .println(name + " the ostrich eats " + food + ". Feed meter: " + feedMeter + "%.");
    }
}


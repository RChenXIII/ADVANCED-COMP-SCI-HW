public class Emu extends Animal {
    private int age = 0;

    public Emu(String name) {
        super(name, new String[] {"Native to Australia", "Can travel long distances quickly",
                "Second-largest living bird by height"}, new String[] {"run", "drum"});
    }

    public int getAge() {
        return age;
    }

    public String getSpecies() {
        return "Emu";
    }

    public String getScientificName() {
        return "Dromaius novaehollandiae";
    }

    public void speak() {
        System.out.println(name + " the emu makes a low drumming call.");
    }

    public void run() {
        System.out.println(name + " is running with long strides!");
    }

    public void feed(String food) {
        System.out.println(name + " the emu eats " + food + ".");
    }

    public void age() {
        age++;
        System.out.println(name + " is now " + age + " years old.");
    }
}

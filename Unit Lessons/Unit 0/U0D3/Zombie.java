public class Zombie {
    // instance variables (attributes)
    // rot
    boolean isDead = true;

    // green
    String skinColor = "Green";

    // shamble about
    int humansEaten = 0;

    // main
    public static void main(String[] args) {
        Zombie phillip = new Zombie();

        System.out.println(phillip.growl());

        System.out.println("Phillip ate " + phillip.humansEaten() + " people.");

        Zombie brian = new Zombie();

        brian.growl();

        System.out.println(brian.humansEaten());
        brian.eatHuman();
        System.out.println(brian.humansEaten());
        brian.feast(14);
        System.out.println(brian.humansEaten());
    }

    // methods (behaviors)
    // eat brains
    // walk with arms out
    // growl
    public String growl() {
        return "grr";
    }

    // Challenge
    public int humansEaten() {
        return humansEaten;
    }

    public void eatHuman() {
        humansEaten++;
    }

    public void feast(int humanCount) {
        humansEaten += humanCount;


    }
}

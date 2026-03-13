public class Treant extends Monster {
    public Treant() {
        super("Treant", ElementType.EARTH, 100, 150, 0, 0, "Vine Whip", "Air Slash",
                ElementType.EARTH, ElementType.AIR);
    }

    @Override
    public String victoryNoise() {
        return "Rustle!";
    }
}

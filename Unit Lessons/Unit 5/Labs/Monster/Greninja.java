public class Greninja extends Monster {
    public Greninja(String name) {
        super(name, ElementType.WATER, 51, 67, 47, 85, "Water Shuriken", "Quick Attack",
                ElementType.WATER, ElementType.AIR, 134, 94, 170, 102);
    }

    @Override
    public String victoryNoise() {
        return "Greninja";
    }

    public String getPokemonType() {
        return "Greninja";
    }
}

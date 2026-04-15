public class Charmander extends Monster {

    public Charmander(String name) {

        super(name, ElementType.FIRE, 10, 25, 11, 8, "Flamethrower", "Scratch",
                ElementType.FIRE, ElementType.AIR, 100, 100, 100, 100);
    }

    @Override
    public String victoryNoise() {
        return "Char mander";
    }

    public String getPokemonType(){
        return "Charmander";
    }
}

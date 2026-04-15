


public class Charizard extends Monster{
    public Charizard(){
        super("Charizard", ElementType.FIRE, 57, 62, 57, 74, "Flare Blitz", "Dragon Claw", ElementType.FIRE, ElementType.Dragon, 100, 100, 100, 100);
    }

    @Override
    public String victoryNoise() {
        return "Charizard";
    }
}

/*
 * CONCRETE SUBCLASS: Blade extends Card
 *
 * Same structure as Granite and Parchment — extends Card, calls super(...),
 * overrides getType(). The only difference is getType() returns CardType.BLADE.
 *
 * Blade beats Parchment, but loses to Granite (see TypeChart.java).
 */
public class CardBlade extends Card {

    public CardBlade(String name, int strength, int health, Ability ability) {
        super(name, strength, health, ability);
    }

    @Override
    public CardType getType() {
        return CardType.BLADE;
    }
}

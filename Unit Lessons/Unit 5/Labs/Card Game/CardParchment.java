/*
 * CONCRETE SUBCLASS: Parchment extends Card
 *
 * Same structure as Granite — extends Card, calls super(...), overrides getType().
 * The only difference is getType() returns CardType.PARCHMENT.
 *
 * Parchment beats Granite, but loses to Blade (see TypeChart.java).
 */
public class CardParchment extends Card {

    public CardParchment(String name, int strength, int health, Ability ability) {
        super(name, strength, health, ability);
    }

    @Override
    public CardType getType() {
        return CardType.PARCHMENT;
    }
}

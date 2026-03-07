/*
 * CONCRETE SUBCLASS: Granite extends Card
 *
 * "extends Card" means Granite INHERITS all of Card's fields and methods.
 * Because Card is abstract, Granite MUST override the abstract method getType().
 *
 * The constructor calls super(...) to pass arguments up to Card's constructor,
 * which initializes the shared fields (name, strength, health, ability).
 *
 * Granite beats Blade, but loses to Parchment (see TypeChart.java).
 */
public class CardGranite extends Card {

    public CardGranite(String name, int strength, int health, Ability ability) {
        // super(...) calls Card's constructor to set up the inherited fields
        super(name, strength, health, ability);
    }

    // Required override — without this, Granite won't compile because
    // Card declares getType() as abstract
    @Override
    public CardType getType() {
        return CardType.GRANITE;
    }
}

/*
 * ABSTRACT CLASS: Card
 *
 * An abstract class is a class that CANNOT be instantiated directly.
 * You can never write "new Card(...)". Instead, you must create an instance
 * of a concrete subclass like Granite, Parchment, or Blade.
 *
 * Why make it abstract?
 *   - All cards share common fields (name, strength, health, etc.) and
 *     common behavior (takeDamage, computeDamageAgainst, etc.).
 *   - But every card MUST have a type, and that type depends on which
 *     kind of card it is. We declare getType() as abstract to FORCE
 *     each subclass to provide its own implementation.
 *
 * Think of Card as a blueprint: it defines what every card has and does,
 * but leaves the specifics (like type) to the subclasses.
 *
 * COMPOSITION WITH AN INTERFACE:
 *   Each Card holds an Ability reference (see Ability.java).
 *   This is "composition" — the Card HAS-A Ability, rather than IS-A Ability.
 *   Any class that implements the Ability interface can be plugged in here:
 *   BastionAbility, RippleAbility, CleaveAbility, or NoneAbility.
 */
public abstract class Card {

    private final String name;
    private final int strength;
    private int health;
    private int shield;
    private int bonusDamage;

    // This field's type is the Ability INTERFACE — it can hold ANY object
    // whose class implements Ability (BastionAbility, CleaveAbility, etc.)
    private final Ability ability;

    // Constructor is protected-by-convention: only subclasses call it via super(...)
    public Card(String name, int strength, int health, Ability ability) {
        this.name = name;
        this.strength = strength;
        this.health = health;
        this.ability = ability;

        this.shield = 0;
        this.bonusDamage = 0;
    }

    /*
     * ABSTRACT METHOD — has no body (no curly braces), just a signature.
     * Every concrete subclass MUST override this and return its CardType.
     * This is how Java enforces that Granite returns GRANITE, Blade returns BLADE, etc.
     */
    public abstract CardType getType();

    // --- Getters ---

    public String getName() {
        return name;
    }

    public int getStrength() {
        return strength;
    }

    public int getHealth() {
        return health;
    }

    public int getShield() {
        return shield;
    }

    public int getBonusDamage() {
        return bonusDamage;
    }

    // Returns the Ability interface reference — could be any implementation
    public Ability getAbility() {
        return ability;
    }

    // Uses "instanceof" to check whether the ability is the NoneAbility class.
    // Returns true if this card has a real ability (Bastion, Ripple, or Cleave).
    public boolean hasAbility() {
        return !(ability instanceof AbilityNone);
    }

    // --- On-play effects ---

    // When a card is played, its ability may grant shield or bonus damage.
    // Because ability is an interface reference, Java uses POLYMORPHISM here:
    // it calls the version of shieldOnPlay() / bonusDamageOnPlay() that belongs
    // to whatever class the ability actually is (e.g. BastionAbility returns 2 shield).
    public void applySelfOnPlay() {
        shield += ability.shieldOnPlay();
        bonusDamage += ability.bonusDamageOnPlay();
    }

    // --- Combat ---

    public boolean isDefeated() {
        return health <= 0;
    }

    // Shield absorbs damage first, then remaining damage reduces health
    public void takeDamage(int dmg) {
        if (dmg <= 0)
            return;

        int blocked = Math.min(shield, dmg);
        shield -= blocked;
        health -= (dmg - blocked);
    }

    // Damage is modified by the type matchup (see TypeChart.java).
    // Notice getType() is called on both this card and the defender —
    // even though getType() is abstract in Card, polymorphism ensures
    // each subclass's version is called at runtime.
    public int computeDamageAgainst(Card defender) {
        int base = strength + bonusDamage;
        double mult = TypeChart.multiplier(getType(), defender.getType());

        if (mult == 2.0)
            return base * 2;
        if (mult == 0.5)
            return (int) Math.ceil(base * 0.5);
        return base;
    }

    @Override
    public String toString() {
        return name + " [" + getType().display() + "] "
                + strength + "/" + health
                + " shield=" + shield
                + " bonus=" + bonusDamage
                + " ability=" + ability.getId();
    }
}

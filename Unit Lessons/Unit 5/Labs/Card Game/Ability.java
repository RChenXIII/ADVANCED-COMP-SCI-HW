/*
 * INTERFACE: Ability
 *
 * An interface defines a CONTRACT — a set of methods that any implementing
 * class MUST provide. It says WHAT an ability can do, but not HOW it does it.
 *
 * Key differences from an abstract class:
 *   - An interface has NO instance variables and NO constructor.
 *   - A class can implement MULTIPLE interfaces, but can only extend ONE class.
 *   - Interfaces define pure behavior; abstract classes can also hold shared state.
 *
 * Any class that says "implements Ability" must provide a body for ALL
 * five methods below. See BastionAbility, RippleAbility, CleaveAbility,
 * and NoneAbility for examples.
 *
 * In Card.java, the field "private final Ability ability" can hold ANY object
 * whose class implements this interface. This is polymorphism through interfaces.
 */
public interface Ability {
    String getId();              // "BASTION", "RIPPLE", "CLEAVE", or "NONE"
    int shieldOnPlay();          // shield granted when this card is played
    int bonusDamageOnPlay();     // extra damage added to this card's attacks
    int pingDamageOnPlay();      // damage dealt to opponent's active card on play
    boolean cyclesOnPlay();      // whether the card moves to the bottom of the deck on play
}

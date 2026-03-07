/*
 * IMPLEMENTS Ability: RippleAbility
 *
 * Ripple deals 1 ping damage to the opponent's active card when played,
 * and cycles the card to the bottom of the deck.
 * No shield or bonus damage.
 */
public class AbilityRipple implements Ability {

    public String getId() {
        return "RIPPLE";
    }

    public int shieldOnPlay() {
        return 0;
    }

    public int bonusDamageOnPlay() {
        return 0;
    }

    public int pingDamageOnPlay() {
        return 1;
    }

    public boolean cyclesOnPlay() {
        return true;
    }
}

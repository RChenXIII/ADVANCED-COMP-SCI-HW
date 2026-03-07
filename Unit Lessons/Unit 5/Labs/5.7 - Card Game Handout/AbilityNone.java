/*
 * IMPLEMENTS Ability: None
 *
 * Represents a card with NO special ability. All methods return 0 or false.
 * This avoids null checks — instead of ability being null for cards
 * without abilities, we give them a NoneAbility that does nothing.
 * (This pattern is called the "Null Object" pattern.)
 */
public class AbilityNone implements Ability {

    public String getId() {
        return "NONE";
    }

    public int shieldOnPlay() {
        return 0;
    }

    public int bonusDamageOnPlay() {
        return 0;
    }

    public int pingDamageOnPlay() {
        return 0;
    }

    public boolean cyclesOnPlay() {
        return false;
    }
}

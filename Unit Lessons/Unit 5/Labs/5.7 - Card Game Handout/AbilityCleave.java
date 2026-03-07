/*
 * IMPLEMENTS Ability: Cleave
 *
 * Cleave grants +2 bonus damage when played — the card hits harder
 * in combat. No shield, no ping, no cycling.
 */
public class AbilityCleave implements Ability {

    public String getId() {
        return "CLEAVE";
    }

    public int shieldOnPlay() {
        return 0;
    }

    public int bonusDamageOnPlay() {
        return 2;
    }

    public int pingDamageOnPlay() {
        return 0;
    }

    public boolean cyclesOnPlay() {
        return false;
    }
}

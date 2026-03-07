/*
 * IMPLEMENTS Ability: Bastion 
 *
 * "implements Ability" means this class promises to provide a body for
 * every method listed in the Ability interface.
 *
 * Bastion grants 2 shield when played — the card absorbs 2 damage
 * before its health is reduced. No other on-play effects.
 */
public class AbilityBastion implements Ability {

    public String getId() {
        return "BASTION";
    }

    public int shieldOnPlay() {
        return 2;
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

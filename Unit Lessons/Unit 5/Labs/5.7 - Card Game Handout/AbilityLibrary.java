/*
 * AbilityLibrary — a collection of shared Ability instances.
 *
 * Since abilities have no mutable state, we only need ONE instance of each.
 * These are stored as public static final fields so any code can reference
 * them as AbilityLibrary.BASTION, AbilityLibrary.RIPPLE, etc.
 *
 * The constructor is private so no one can create an AbilityLibrary object —
 * this class is just a holder for the four shared constants.
 *
 * fromText() converts user input (like "bastion") into the matching
 * Ability object, which is useful for building decks from Scanner input.
 */
public final class AbilityLibrary {
    private AbilityLibrary() {}

    public static final Ability NONE = new AbilityNone();
    public static final Ability BASTION = new AbilityBastion();
    public static final Ability RIPPLE = new AbilityRipple();
    public static final Ability CLEAVE = new AbilityCleave();

    public static Ability fromText(String text) {
        if (text == null) return NONE;
        String t = text.trim().toLowerCase();
        if (t.equals("bastion") || t.equals("b")) return BASTION;
        if (t.equals("ripple") || t.equals("r")) return RIPPLE;
        if (t.equals("cleave") || t.equals("c")) return CLEAVE;
        return NONE;
    }
}

/*
 * ENUM: CardType
 *
 * An enum is a special type with a fixed set of constant values.
 * There are exactly three card types: GRANITE, PARCHMENT, and BLADE.
 *
 * Each Card subclass returns one of these from its getType() method.
 * The TypeChart uses CardType to determine damage multipliers.
 *
 * fromText() converts user input (like "granite" or "g") into
 * the matching CardType, which is useful for the deck builder.
 */
public enum CardType {
    GRANITE, PARCHMENT, BLADE;

    public static CardType fromText(String text) {
        if (text == null)
            return null;
        String t = text.trim().toLowerCase();
        if (t.equals("granite") || t.equals("g"))
            return GRANITE;
        if (t.equals("parchment") || t.equals("p"))
            return PARCHMENT;
        if (t.equals("blade") || t.equals("b"))
            return BLADE;
        return null;
    }

    public String display() {
        switch (this) {
            case GRANITE:
                return "Granite";
            case PARCHMENT:
                return "Parchment";
            default:
                return "Blade";
        }
    }
}

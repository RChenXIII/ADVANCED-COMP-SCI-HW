import java.util.ArrayList;

/*
 * PlayerState — tracks one player's deck, active card, and pending damage.
 *
 * The "active" field is declared as Card (the abstract type), so it can
 * hold a Granite, Parchment, or Blade. The game doesn't need to know
 * which subclass it is — it just calls methods like getType(),
 * applySelfOnPlay(), and takeDamage(), and polymorphism handles the rest.
 *
 * pendingDamage is used by the Ripple ability: if the opponent has no
 * active card when Ripple's ping fires, the damage is stored here and
 * applied to their next card.
 */
public class PlayerState {
    private String name;
    private ArrayList<Card> deck;
    private Card active;
    private int pendingDamage;

    PlayerState(String name, ArrayList<Card> deck) {
        this.name = name;
        this.deck = deck;
        this.active = null;
        this.pendingDamage = 0;
    }

    boolean hasAnythingLeft() {
        return active != null || (deck != null && !deck.isEmpty());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Card> getDeck() {
        return deck;
    }

    public void setDeck(ArrayList<Card> deck) {
        this.deck = deck;
    }

    public Card getActive() {
        return active;
    }

    public void setActive(Card active) {
        this.active = active;
    }

    public int getPendingDamage() {
        return pendingDamage;
    }

    public void setPendingDamage(int pendingDamage) {
        this.pendingDamage = pendingDamage;
    }
}

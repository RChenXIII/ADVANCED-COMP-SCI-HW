import java.util.ArrayList;

/*
 * DeckBuilderBot — builds the opponent's deck.
 *
 * Notice that the ArrayList holds Card references, but each element
 * is actually a Granite, Parchment, or Blade. This works because
 * all three extend Card. You can put any subclass into a collection
 * typed as the parent class — this is polymorphism with collections.
 */
public class DeckBuilderBot {

    // Bot has 5 base cards, all 3/3, no abilities
    public static ArrayList<Card> buildBotDeck() {
        ArrayList<Card> deck = new ArrayList<>();
        deck.add(new CardGranite("Bot-1", 3, 3, AbilityLibrary.NONE));
        deck.add(new CardParchment("Bot-2", 3, 3, AbilityLibrary.NONE));
        deck.add(new CardBlade("Bot-3", 3, 3, AbilityLibrary.NONE));
        deck.add(new CardGranite("Bot-4", 3, 3, AbilityLibrary.NONE));
        deck.add(new CardBlade("Bot-5", 3, 3, AbilityLibrary.NONE));
        return deck;
    }
}

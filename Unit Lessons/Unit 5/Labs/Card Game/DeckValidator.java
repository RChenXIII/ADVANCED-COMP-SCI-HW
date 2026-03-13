import java.util.ArrayList;
import java.util.Scanner;

/*
 * DeckValidator — deck validation and building (students implement).
 *
 * USEFUL METHODS FOR YOUR IMPLEMENTATIONS:
 *
 * card.hasAbility() -> true if the card has a real ability (not NONE) card.getAbility() -> returns
 * the Ability interface reference card.getAbility().getId() -> returns "BASTION", "RIPPLE",
 * "CLEAVE", or "NONE" card.getType() -> returns the CardType enum (GRANITE, PARCHMENT, BLADE)
 * card.getStrength() -> returns the card's strength stat card.getHealth() -> returns the card's
 * health stat
 *
 * CardType.fromText("granite") -> returns CardType.GRANITE AbilityLibrary.fromText("bastion") ->
 * returns the BastionAbility instance
 *
 * createCard("name", type, str, hp, ability) -> creates the right subclass (Granite, Parchment, or
 * Blade) based on the CardType
 */
public class DeckValidator {

    // ----------------------------
    // CHECKERS (students implement)
    // ----------------------------

    // Rule: no more than 3 total ability cards in the deck.
    // HINT: loop through the deck, use card.hasAbility() to count how many
    // cards have a real ability, and return true if the count is <= 3.
    public static boolean checkNoMoreThanThreeAbilityCards(ArrayList<Card> deck) {
        if (deck == null)
            return false;
        int count = 0;
        for (Card c : deck) {
            if (c != null && c.hasAbility())
                count++;
        }
        return count <= 3;
    }

    // Rule: no duplicate abilities in the deck (max one BASTION, one RIPPLE, one
    // CLEAVE).
    // HINT: loop through the deck, use card.getAbility().getId() to get
    // each ability's name, and check for duplicates.
    public static boolean checkNoDuplicateAbilities(ArrayList<Card> deck) {
        if (deck == null)
            return false;
        // we'll track which ability ids we've seen (except NONE)
        boolean seenBastion = false;
        boolean seenRipple = false;
        boolean seenCleave = false;
        for (Card c : deck) {
            if (c == null)
                continue;
            String id = c.getAbility().getId();
            switch (id) {
                case "BASTION":
                    if (seenBastion)
                        return false;
                    seenBastion = true;
                    break;
                case "RIPPLE":
                    if (seenRipple)
                        return false;
                    seenRipple = true;
                    break;
                case "CLEAVE":
                    if (seenCleave)
                        return false;
                    seenCleave = true;
                    break;
                default:
                    // NONE or unknown, ignore
                    break;
            }
        }
        return true;
    }

    // Rule: strength and health must be 1..5, and strength + health <= 6.
    // HINT: loop through the deck, use card.getStrength() and card.getHealth().
    public static boolean checkStatsInRange(ArrayList<Card> deck) {
        if (deck == null)
            return false;
        for (Card c : deck) {
            if (c == null)
                return false;
            int s = c.getStrength();
            int h = c.getHealth();
            if (s < 1 || s > 5 || h < 1 || h > 5)
                return false;
            if (s + h > 6)
                return false;
        }
        return true;
    }

    // Returns true only if the deck is fully valid:
    // - deck has exactly 5 cards
    // - AND all checks above return true
    public static boolean isValidDeck(ArrayList<Card> deck) {
        if (deck == null)
            return false;
        if (deck.size() != 5)
            return false;
        return checkNoMoreThanThreeAbilityCards(deck) && checkNoDuplicateAbilities(deck)
                && checkStatsInRange(deck);
    }

    // ----------------------------
    // DECK BUILDERS (students implement)
    // ----------------------------

    // Must create 5 cards, all 3/3, no abilities (use AbilityLibrary.NONE).
    // Use the Granite, Parchment, and Blade subclasses directly,
    // or use the createCard() helper below.
    public static ArrayList<Card> buildDefaultDeck() {
        ArrayList<Card> deck = new ArrayList<>();
        // create a simple 5‑card default deck; all cards 3/3, no ability
        deck.add(createCard("Default1", CardType.GRANITE, 3, 3, AbilityLibrary.NONE));
        deck.add(createCard("Default2", CardType.PARCHMENT, 3, 3, AbilityLibrary.NONE));
        deck.add(createCard("Default3", CardType.BLADE, 3, 3, AbilityLibrary.NONE));
        deck.add(createCard("Default4", CardType.GRANITE, 3, 3, AbilityLibrary.NONE));
        deck.add(createCard("Default5", CardType.BLADE, 3, 3, AbilityLibrary.NONE));
        return deck;
    }

    // Prompts the user 5 times using Scanner and validates inputs.
    // Required prompt order per card:
    // 1. name (String)
    // 2. type (granite / parchment / blade) -> use CardType.fromText()
    // 3. strength (int)
    // 4. health (int)
    // 5. ability (bastion / ripple / cleave / none) -> use
    // AbilityLibrary.fromText()
    //
    // Then use createCard() to build the right subclass from the parsed type.
    public static ArrayList<Card> buildUserDeck(Scanner sc) {
        while (true) {
            ArrayList<Card> deck = new ArrayList<>();

            for (int i = 0; i < 5; i++) {
                System.out.println("--- Building card #" + (i + 1) + " ---");
                String name;
                CardType type = null;
                int strength = 0;
                int health = 0;
                Ability ability = null;

                // name
                System.out.print("Enter name: ");
                name = sc.next();

                // type
                while (type == null) {
                    System.out.print("Enter type (granite/parchment/blade): ");
                    type = CardType.fromText(sc.next());
                    if (type == null)
                        System.out.println("  invalid type, try again");
                }

                // strength and health
                while (true) {
                    System.out.print("Enter strength (1-5): ");
                    if (sc.hasNextInt()) {
                        strength = sc.nextInt();
                    } else {
                        sc.next();
                        System.out.println("  please enter a number");
                        continue;
                    }

                    System.out.print("Enter health (1-5): ");
                    if (sc.hasNextInt()) {
                        health = sc.nextInt();
                    } else {
                        sc.next();
                        System.out.println("  please enter a number");
                        continue;
                    }

                    if (strength < 1 || strength > 5 || health < 1 || health > 5) {
                        System.out.println("  stats must each be 1..5");
                        continue;
                    }
                    if (strength + health > 6) {
                        System.out.println("  strength + health must be <= 6");
                        continue;
                    }
                    
                    
                    break;
                }

                // ability
                while (true) {
                    System.out.print("Enter ability (bastion/ripple/cleave/none): ");
                    String rawAbility = sc.next();
                    ability = AbilityLibrary.fromText(rawAbility);

                    // fromText() returns NONE for invalid values, so we must
                    // distinguish between a real "none" and an invalid input.
                    String norm = rawAbility.trim().toLowerCase();
                    if (ability == AbilityLibrary.NONE
                            && !(norm.equals("none") || norm.equals("n"))) {
                        System.out.println("  invalid ability, try again");
                        continue;
                    }
                    break;
                }

                Card card = createCard(name, type, strength, health, ability);
                deck.add(card);
            }

            // Validate the full deck and re-prompt if invalid
            if (isValidDeck(deck)) {
                return deck;
            }

            System.out.println("\nDeck invalid:");
            if (!checkNoMoreThanThreeAbilityCards(deck))
                System.out.println(" - No more than 3 cards may have abilities.");
            if (!checkNoDuplicateAbilities(deck))
                System.out.println(" - No duplicate abilities allowed.");
            System.out.println("Please rebuild your deck.\n");
        }
    }

    // ----------------------------
    // Helper: create a Card subclass from a CardType
    // ----------------------------

    // This is a FACTORY METHOD — it decides which subclass to instantiate
    // based on the CardType enum value. The caller doesn't need to know
    // about the specific subclasses; they just pass in the type and get
    // back a Card reference.
    public static Card createCard(String name, CardType type, int strength, int health,
            Ability ability) {
        switch (type) {
            case GRANITE:
                return new CardGranite(name, strength, health, ability);
            case PARCHMENT:
                return new CardParchment(name, strength, health, ability);
            case BLADE:
                return new CardBlade(name, strength, health, ability);
            default:
                return null;
        }
    }

    // ----------------------------
    // Optional helpers you may use
    // ----------------------------

    public static boolean isYes(String s) {
        if (s == null)
            return false;
        s = s.trim().toLowerCase();
        return s.equals("y") || s.equals("yes");
    }
}

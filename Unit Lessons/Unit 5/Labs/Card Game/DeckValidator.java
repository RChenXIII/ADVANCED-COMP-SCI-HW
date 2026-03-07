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
        for (Card card : deck) {
            if (card != null && card.hasAbility()) {
                count++;
            }
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

        boolean seenBastion = false;
        boolean seenRipple = false;
        boolean seenCleave = false;

        for (Card card : deck) {
            if (card == null)
                continue;
            String id = card.getAbility().getId();
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
                    // NONE or unknown counts as no-op
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

        for (Card card : deck) {
            if (card == null)
                return false;
            int str = card.getStrength();
            int hp = card.getHealth();
            if (str < 1 || str > 5 || hp < 1 || hp > 5)
                return false;
            if (str + hp > 6)
                return false;
        }
        return true;
    }

    // Returns true only if the deck is fully valid:
    // - deck has exactly 5 cards
    // - AND all checks above return true
    public static boolean isValidDeck(ArrayList<Card> deck) {
        if (deck == null || deck.size() != 5)
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
        deck.add(createCard("Card1", CardType.GRANITE, 3, 3, AbilityLibrary.NONE));
        deck.add(createCard("Card2", CardType.PARCHMENT, 3, 3, AbilityLibrary.NONE));
        deck.add(createCard("Card3", CardType.BLADE, 3, 3, AbilityLibrary.NONE));
        deck.add(createCard("Card4", CardType.GRANITE, 3, 3, AbilityLibrary.NONE));
        deck.add(createCard("Card5", CardType.BLADE, 3, 3, AbilityLibrary.NONE));
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
        ArrayList<Card> deck = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            String name;
            CardType type;
            int strength;
            int health;
            Ability ability;

            System.out.println("Building card " + i + " of 5");

            // Name
            while (true) {
                System.out.print("Name: ");
                name = sc.nextLine().trim();
                if (!name.isEmpty() && !name.contains(" "))
                    break;
                System.out.println("Please enter a single word name.");
            }

            // Type
            while (true) {
                System.out.print("Type (granite/parchment/blade): ");
                String input = sc.nextLine();
                type = CardType.fromText(input);
                if (type != null)
                    break;
                System.out.println("Invalid type. Please enter granite, parchment, or blade.");
            }

            // Strength + Health
            while (true) {
                System.out.print("Strength (1-5): ");
                String strInput = sc.nextLine().trim();
                System.out.print("Health (1-5): ");
                String hpInput = sc.nextLine().trim();

                try {
                    strength = Integer.parseInt(strInput);
                    health = Integer.parseInt(hpInput);
                } catch (NumberFormatException e) {
                    System.out.println("Strength and health must be integers.");
                    continue;
                }

                if (strength < 1 || strength > 5 || health < 1 || health > 5) {
                    System.out.println("Strength and health must be between 1 and 5.");
                    continue;
                }

                if (strength + health > 6) {
                    System.out.println("The sum of strength and health must be 6 or less.");
                    continue;
                }

                break;
            }

            // Ability
            while (true) {
                System.out.print("Ability (bastion/ripple/cleave/none): ");
                String abInput = sc.nextLine();
                String normalized = abInput == null ? "" : abInput.trim().toLowerCase();
                if (normalized.equals("bastion") || normalized.equals("b")
                        || normalized.equals("ripple") || normalized.equals("r")
                        || normalized.equals("cleave") || normalized.equals("c")
                        || normalized.equals("none") || normalized.equals("n")) {
                    ability = AbilityLibrary.fromText(normalized);
                    break;
                }
                System.out
                        .println("Invalid ability. Please enter bastion, ripple, cleave, or none.");
            }

            deck.add(createCard(name, type, strength, health, ability));
        }

        return deck;
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

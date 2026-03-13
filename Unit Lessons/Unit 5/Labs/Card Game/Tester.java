import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/*
 * Tester — a quick demo you can run to see abstract classes and interfaces in action.
 *
 * POLYMORPHISM IN ACTION: Both "a" and "b" are declared as type Card (the abstract class), but they
 * are actually a Granite and a Blade. When we call a.getType(), Java calls Granite's version; when
 * we call b.getType(), Java calls Blade's version. This is polymorphism.
 *
 * Similarly, a.applySelfOnPlay() calls ability.shieldOnPlay() — since "a" holds a BastionAbility,
 * it gets 2 shield. Since "b" holds a CleaveAbility, it gets 2 bonus damage. Same method call,
 * different behavior — that's polymorphism through the Ability interface.
 */
public class Tester {

    public static void main(String[] args) {
        System.out.println("== LOCAL CARD TESTER ==");

        Scanner sc = new Scanner(System.in);
        try {
            // Demonstrate default deck validation
            System.out.println("\n== DECK VALIDATOR DEMO ==");
            ArrayList<Card> defaultDeck = DeckValidator.buildDefaultDeck();
            System.out.println("Default deck valid? " + DeckValidator.isValidDeck(defaultDeck));

            // Let the user choose which deck to play with
            System.out.println("\nChoose your deck:");
            System.out.println("  1) Default deck");
            System.out.println("  2) Build your own deck");
            System.out.print("Enter 1 or 2: ");

            int choice = 0;
            while (choice != 1 && choice != 2) {
                if (sc.hasNextInt()) {
                    choice = sc.nextInt();
                } else {
                    sc.next();
                }
                if (choice != 1 && choice != 2) {
                    System.out.print("Please enter 1 or 2: ");
                }
            }

            ArrayList<Card> playerDeck =
                    (choice == 1) ? defaultDeck : DeckValidator.buildUserDeck(sc);

            System.out.println("\nYour deck:");
            for (Card c : playerDeck) {
                System.out.println("  " + c);
            }

            // Run a game against a bot deck
            ArrayList<Card> botDeck = DeckBuilderBot.buildBotDeck();

            System.out.println("\n== RUNNING GAME ==");
            String winner = CardBattleGame.playGame(playerDeck, botDeck, new Random(7));
            System.out.println("Returned winner: " + winner);
        } catch (Throwable t) {
            System.out.println("\n(Game not run: CardBattleGame/DeckValidator may still be TODO)");
        } finally {
            sc.close();
        }
    }
}

import java.util.ArrayList;
import java.util.Random;

/*
 * Tester — a quick demo you can run to see abstract classes
 * and interfaces in action.
 *
 * POLYMORPHISM IN ACTION:
 *   Both "a" and "b" are declared as type Card (the abstract class),
 *   but they are actually a Granite and a Blade. When we call
 *   a.getType(), Java calls Granite's version; when we call b.getType(),
 *   Java calls Blade's version. This is polymorphism.
 *
 *   Similarly, a.applySelfOnPlay() calls ability.shieldOnPlay() —
 *   since "a" holds a BastionAbility, it gets 2 shield.
 *   Since "b" holds a CleaveAbility, it gets 2 bonus damage.
 *   Same method call, different behavior — that's polymorphism
 *   through the Ability interface.
 */
public class Tester {

    public static void main(String[] args) {
        System.out.println("== LOCAL CARD TESTER ==");

        // The variable type is Card (abstract), but the actual objects
        // are Granite and Blade (concrete subclasses)
        Card a = new CardGranite("Alpha", 3, 3, AbilityLibrary.BASTION);
        Card b = new CardBlade("Bravo", 3, 3, AbilityLibrary.CLEAVE);

        // Each card applies its own ability's effects
        a.applySelfOnPlay();   // BastionAbility -> +2 shield
        b.applySelfOnPlay();   // CleaveAbility  -> +2 bonus damage

        System.out.println("A played: " + a);
        System.out.println("B played: " + b);

        // Granite vs Blade = 2x damage (see TypeChart)
        int dmg = a.computeDamageAgainst(b);
        System.out.println("A attacks B for " + dmg);
        b.takeDamage(dmg);
        System.out.println("B after dmg: " + b);

        // Optional: run your full game if DeckValidator + CardBattleGame exist
        try {
            ArrayList<Card> player = DeckBuilderBot.buildBotDeck();
            ArrayList<Card> bot = DeckBuilderBot.buildBotDeck();

            System.out.println("\n== RUNNING GAME (if implemented) ==");
            String winner = CardBattleGame.playGame(player, bot, new Random(7));
            System.out.println("Returned winner: " + winner);
        } catch (Throwable t) {
            System.out.println("\n(Game not run: CardBattleGame/DeckValidator may still be TODO)");
        }
    }
}

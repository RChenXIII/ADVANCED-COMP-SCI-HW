import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/*
 * CardBattleGame — the main game loop (students implement).
 *
 * USEFUL METHODS YOU'LL NEED:
 *
 * Card methods: card.applySelfOnPlay() -> applies shield/bonusDamage from the card's ability
 * card.getAbility().pingDamageOnPlay() -> how much ping damage this ability deals
 * card.getAbility().cyclesOnPlay() -> whether the card cycles to the bottom of the deck
 * card.computeDamageAgainst(defender) -> calculates damage with type multipliers
 * card.takeDamage(amount) -> reduces shield first, then health card.isDefeated() -> true if health
 * <= 0 card.getType() -> returns CardType (uses polymorphism!)
 *
 * PlayerState methods: state.getDeck() -> returns the player's ArrayList<Card> state.getActive() /
 * setActive(card) -> the currently active card (or null) state.hasAnythingLeft() -> true if active
 * card or cards remain in deck state.getPendingDamage() / setPendingDamage(int) -> stored Ripple
 * damage for next drawn card
 */
public class CardBattleGame {

    // To-do: Implement the full game.
    // Must print:
    // == CARD CLASH ==
    // Starting: Player/Bot
    // Winner: Player/Bot
    public static String playGame(ArrayList<Card> playerDeck, ArrayList<Card> botDeck, Random rng) {
        // create mutable copies so original lists are not changed
        PlayerState player = new PlayerState("Player", new ArrayList<>(playerDeck));
        PlayerState bot = new PlayerState("Bot", new ArrayList<>(botDeck));

        boolean playerTurn = (rng.nextInt() % 2 == 0);
        int turn = 1;

        System.out.println("== CARD CLASH ==");
        System.out.println("Starting: " + (playerTurn ? "Player" : "Bot"));

        // main loop: continue while both sides still have something
        while (player.hasAnythingLeft() && bot.hasAnythingLeft()) {
            PlayerState self = playerTurn ? player : bot;
            PlayerState other = playerTurn ? bot : player;

            System.out.println("\n---- Turn " + turn + ": " + self.getName() + " ----");
            drawAndPlayIfNeeded(self, other);
            attackOnce(self, other);

            // show current active cards after the turn
            System.out.println("  " + player.getName() + " active: "
                    + (player.getActive() != null ? player.getActive() : "(none)"));
            System.out.println("  " + bot.getName() + " active: "
                    + (bot.getActive() != null ? bot.getActive() : "(none)"));

            // switch turns regardless of what happened
            playerTurn = !playerTurn;
            turn++;
        }

        String winner = player.hasAnythingLeft() ? "Player" : "Bot";
        System.out.println("\nWinner: " + winner);
        return winner;
    }

    // ----- helpers you may implement or use -----

    // Draw top card if no active, apply on-play effects via card.applySelfOnPlay()
    public static void drawAndPlayIfNeeded(PlayerState self, PlayerState other) {
        // draw cards until we either have an active card that doesn't cycle
        // or run out of cards
        while (self.getActive() == null && !self.getDeck().isEmpty()) {
            Card card = self.getDeck().remove(0);
            System.out.println("  " + self.getName() + " draws " + card);

            // apply any pending damage from opponent's Ripple
            if (self.getPendingDamage() > 0) {
                int pending = self.getPendingDamage();
                System.out.println("    pending ripple damage: " + pending);
                card.takeDamage(pending);
                self.setPendingDamage(0);
                if (card.isDefeated()) {
                    System.out.println("    " + card.getName() + " is defeated by pending damage.");
                    // card died immediately; continue drawing
                    continue;
                }
            }

            self.setActive(card);
            card.applySelfOnPlay();
            System.out.println("    plays " + card);

            // ping damage
            int ping = card.getAbility().pingDamageOnPlay();
            if (ping > 0) {
                System.out.println("    ping damage: " + ping);
                if (other.getActive() != null) {
                    other.getActive().takeDamage(ping);
                    System.out.println("      " + other.getName() + "'s " + other.getActive()
                            + " takes " + ping + " ping damage");
                    if (other.getActive().isDefeated()) {
                        System.out.println("      " + other.getName() + "'s "
                                + other.getActive().getName() + " is defeated.");
                        other.setActive(null);
                    }
                } else {
                    other.setPendingDamage(other.getPendingDamage() + ping);
                    System.out.println("      " + other.getName()
                            + " has no active card; ping stored for next draw.");
                }
            }

            // cycle effect
            if (card.getAbility().cyclesOnPlay()) {
                System.out.println("    " + card.getName() + " cycles to bottom of deck.");
                // move this card to bottom and clear active so we draw again
                self.getDeck().add(card);
                self.setActive(null);
                // loop will iterate again if deck still has cards
                continue;
            }

            // if we reach here the drawn card stays active
            break;
        }
    }

    // One attack (self active attacks other active if both exist)
    public static void attackOnce(PlayerState attacker, PlayerState defender) {
        Card a = attacker.getActive();
        Card d = defender.getActive();
        if (a == null || d == null)
            return;

        int dmg = a.computeDamageAgainst(d);
        System.out.println("  " + attacker.getName() + " attacks " + defender.getName() + " with "
                + a.getName() + " -> " + d.getName() + " for " + dmg + " damage");
        d.takeDamage(dmg);
        System.out.println("    " + defender.getName() + "'s " + d + " after damage");
        if (d.isDefeated()) {
            System.out.println("    " + defender.getName() + "'s " + d.getName() + " is defeated.");
            defender.setActive(null);
        }
    }

    // Optional local run (not graded)
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Card> player = DeckValidator.buildDefaultDeck();
        ArrayList<Card> bot = DeckBuilderBot.buildBotDeck();

        if (!DeckValidator.isValidDeck(player)) {
            System.out.println("Player deck invalid!");
            return;
        }

        playGame(player, bot, new Random());
    }
}

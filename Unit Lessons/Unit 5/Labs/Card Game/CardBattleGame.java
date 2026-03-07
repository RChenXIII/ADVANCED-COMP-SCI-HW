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
        PlayerState player = new PlayerState("Player", playerDeck);
        PlayerState bot = new PlayerState("Bot", botDeck);

        boolean playerTurn = rng.nextBoolean();
        String starting = playerTurn ? "Player" : "Bot";

        System.out.println("== CARD CLASH ==");
        System.out.println("Starting: " + starting);

        PlayerState current = playerTurn ? player : bot;
        PlayerState other = playerTurn ? bot : player;

        // Main loop: continue until one player has nothing left
        while (player.hasAnythingLeft() && bot.hasAnythingLeft()) {
            drawAndPlayIfNeeded(current, other);

            if (!current.hasAnythingLeft())
                break;

            attackOnce(current, other);

            if (!other.hasAnythingLeft())
                break;

            // switch turns
            PlayerState temp = current;
            current = other;
            other = temp;
        }

        String winner = player.hasAnythingLeft() ? "Player" : "Bot";
        System.out.println("Winner: " + winner);
        return winner;
    }

    // ----- helpers you may implement or use -----

    // Draw top card if no active, apply on-play effects via card.applySelfOnPlay()
    public static void drawAndPlayIfNeeded(PlayerState self, PlayerState other) {
        while (self.getActive() == null && self.getDeck() != null && !self.getDeck().isEmpty()) {
            Card card = self.getDeck().remove(0);
            self.setActive(card);

            // Apply on-play effects (shield / bonus damage)
            card.applySelfOnPlay();

            // Apply any pending damage (from Ripple)
            int pending = self.getPendingDamage();
            if (pending > 0) {
                card.takeDamage(pending);
                self.setPendingDamage(0);
            }

            // If the card died from pending damage, discard it and draw again
            if (card.isDefeated()) {
                self.setActive(null);
                continue;
            }

            // Apply ping damage to opponent
            int ping = card.getAbility().pingDamageOnPlay();
            if (ping > 0) {
                if (other.getActive() != null) {
                    other.getActive().takeDamage(ping);
                    if (other.getActive().isDefeated()) {
                        other.setActive(null);
                    }
                } else {
                    other.setPendingDamage(other.getPendingDamage() + ping);
                }
            }

            // If the card cycles, move it to the bottom and draw again
            if (card.getAbility().cyclesOnPlay()) {
                self.getDeck().add(card);
                self.setActive(null);
                continue;
            }

            // Otherwise, keep this card as the active card
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
        d.takeDamage(dmg);

        if (d.isDefeated()) {
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


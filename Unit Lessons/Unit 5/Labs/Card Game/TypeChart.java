/*
 * TypeChart — determines damage multipliers based on card types.
 *
 * Works like rock-paper-scissors:
 *   Granite  beats Blade      (2x damage)
 *   Blade    beats Parchment  (2x damage)
 *   Parchment beats Granite   (2x damage)
 *
 * Attacking into your weakness deals half damage (0.5x).
 * Same type vs. same type deals normal damage (1x).
 */
public class TypeChart {

    public static double multiplier(CardType attacker, CardType defender) {
        if (attacker == defender)
            return 1.0;

        if (attacker == CardType.GRANITE && defender == CardType.BLADE)
            return 2.0;
        if (attacker == CardType.GRANITE && defender == CardType.PARCHMENT)
            return 0.5;

        if (attacker == CardType.PARCHMENT && defender == CardType.GRANITE)
            return 2.0;
        if (attacker == CardType.PARCHMENT && defender == CardType.BLADE)
            return 0.5;

        if (attacker == CardType.BLADE && defender == CardType.PARCHMENT)
            return 2.0;
        if (attacker == CardType.BLADE && defender == CardType.GRANITE)
            return 0.5;

        return 1.0;
    }
}

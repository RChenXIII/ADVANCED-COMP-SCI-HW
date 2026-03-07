# Unit 5.7 Lab — Card Game

## Card Game Lab: Build-a-Deck + Abstract Classes + Interfaces

In this lab, you will create your own 5-card deck and battle a bot deck.

You will practice:

- **Abstract classes** — `Card` is abstract; `CardGranite`, `CardParchment`, and `CardBlade` extend it
- **Interfaces** — `Ability` is an interface; `AbilityBastion`, `AbilityRipple`, `AbilityCleave`, and `AbilityNone` implement it
- **Polymorphism** — declaring variables as `Card` or `Ability` while the actual objects are specific subclasses/implementations
- **ArrayList**, loops, `Scanner`, and `Random`

---

## Class Hierarchy Overview

```
        Card (abstract class)
       /        |         \
 CardGranite  CardParchment  CardBlade
   (extends)   (extends)     (extends)


        Ability (interface)
       /      |        \         \
 AbilityBastion  AbilityRipple  AbilityCleave  AbilityNone
 (implements)    (implements)   (implements)   (implements)
```

Each `Card` holds a single `Ability` reference — this is **composition** (a Card HAS-A Ability).
The card's type is determined by **which subclass** it is (a `CardGranite` IS-A `Card`).

---

## How the Game Works

- Each player has a **deck of 5 cards**.
- Each player can have **only 1 active card** at a time.
- On your turn:
    1. If you have no active card, **draw the next card** from your deck and **play it** (its ability triggers).
    2. Your active card then **attacks** the opponent's active card (if they have one).
- When a card's health reaches 0 or less, it is **defeated** and removed from play.
- If you have **no active card AND no cards left in your deck**, you lose.

---

## Card Stats + Limits

Each card has:

- **Name:** any single word
- **Type:** `Granite`, `Parchment`, or `Blade` (determines which subclass to create)
- **Strength:** 1–5 (base attack damage)
- **Health:** 1–5 (how much damage the card can take)
- **Stat limit:** `strength + health <= 6` (example: 3/3 is valid, 4/3 is not)
- **Ability:** one of `Bastion`, `Ripple`, `Cleave`, or `None`

---

## Type Advantage (Rock-Paper-Scissors)

Damage is multiplied by the type matchup (see `TypeChart.java`):

| Attacker   | vs Defender  | Multiplier |
|------------|-------------|------------|
| Granite    | Blade       | **2x**     |
| Granite    | Parchment   | **0.5x**   |
| Parchment  | Granite     | **2x**     |
| Parchment  | Blade       | **0.5x**   |
| Blade      | Parchment   | **2x**     |
| Blade      | Granite     | **0.5x**   |
| Same type  | Same type   | 1x         |

When damage is halved (0.5x), the result is **rounded up** (e.g., 3 * 0.5 = 2).

---

## Abilities

Each card has exactly **one** `Ability` (which may be `AbilityNone` for no effect).

There are 3 real abilities:

1. **BASTION** (`AbilityBastion`)
    - When played: gain **2 shield** (shield absorbs damage before health is reduced)

2. **RIPPLE** (`AbilityRipple`)
    - When played: deal **1 damage** to the opponent's active card
    - If opponent has no active card, store it as **pending damage** applied to their next drawn card
    - Then **cycle**: move this card to the bottom of your deck and immediately draw your next card (if any)

3. **CLEAVE** (`AbilityCleave`)
    - When played: gain **+2 bonus damage** added to every attack this card makes

### Deck Ability Rules

- No more than **3 total ability cards** in the deck
- No more than **1 of each ability** in the deck (at most one Bastion, one Ripple, one Cleave)

---

## Your Tasks (What You Implement)

You will implement **two** files:

### 1) `DeckValidator.java`

**Checker methods** — each returns `true` if the deck passes the rule:

- `checkNoMoreThanThreeAbilityCards(deck)` — at most 3 cards with abilities
    - *Hint:* use `card.hasAbility()` to check if a card has a real ability
- `checkNoDuplicateAbilities(deck)` — no two cards share the same ability
    - *Hint:* use `card.getAbility().getId()` to get the ability name (`"BASTION"`, `"RIPPLE"`, `"CLEAVE"`, or `"NONE"`)
- `checkStatsInRange(deck)` — strength and health are each 1–5, and `strength + health <= 6`
    - *Hint:* use `card.getStrength()` and `card.getHealth()`
- `isValidDeck(deck)` — returns `true` only if the deck has exactly 5 cards AND all checks pass

**Deck builder methods:**

- `buildDefaultDeck()` — creates 5 cards, all 3/3, no abilities
    - Use the card subclasses directly (e.g. `new CardGranite(...)`) or the `createCard()` helper
- `buildUserDeck(scanner)` — prompts the user 5 times to build their deck (see Input Format below)

### 2) `CardBattleGame.java`

**Game loop:**

- Coin flip to decide who goes first (use `Random`)
    ```java
    int randomInt = rng.nextInt();  // use even/odd or positive/negative to pick
    ```
- Each turn: draw & play if no active card, then attack
- Apply abilities correctly (shield, ping, cycle, bonus damage)
- Attack using type multipliers (see `card.computeDamageAgainst(defender)`)
- Detect when a player has no cards left (active or in deck)
- Print output:
    ```
    == CARD CLASH ==
    Starting: Player    (or "Starting: Bot")
    Winner: Player      (or "Winner: Bot")
    ```

**Useful methods for your implementation:**

| Method | What it does |
|--------|-------------|
| `card.applySelfOnPlay()` | Applies shield and bonus damage from the card's ability |
| `card.getAbility().pingDamageOnPlay()` | How much ping damage this ability deals (0 or 1) |
| `card.getAbility().cyclesOnPlay()` | Whether the card cycles to the bottom of the deck |
| `card.computeDamageAgainst(defender)` | Calculates damage with type multipliers |
| `card.takeDamage(amount)` | Reduces shield first, then health |
| `card.isDefeated()` | `true` if health <= 0 |
| `card.getType()` | Returns `CardType` (uses polymorphism!) |
| `state.getDeck()` | Returns the player's `ArrayList<Card>` |
| `state.getActive()` / `setActive(card)` | The currently active card (or `null`) |
| `state.hasAnythingLeft()` | `true` if active card exists or cards remain in deck |
| `state.getPendingDamage()` / `setPendingDamage(int)` | Stored Ripple damage for next drawn card |

---

## Input Format for `buildUserDeck`

For each of the 5 cards, prompt in this order:

1. **Name** — a single word (String)
2. **Type** — `granite`, `parchment`, or `blade`
3. **Strength** — an integer 1–5
4. **Health** — an integer 1–5
5. **Ability** — `bastion`, `ripple`, `cleave`, or `none`

Use `CardType.fromText()` to parse the type and `AbilityLibrary.fromText()` to parse the ability.
Then use `createCard(name, type, strength, health, ability)` to build the right subclass.

If any input is invalid (bad type, out-of-range stats, `strength + health > 6`), reprompt until valid.

---

## All Files

### Files you implement:
| File | What you write |
|------|---------------|
| `DeckValidator.java` | Deck validation checks and deck builders |
| `CardBattleGame.java` | The full game loop |

### Files provided (do not modify):
| File | Purpose |
|------|---------|
| `Card.java` | Abstract class — shared card fields, combat logic, abstract `getType()` |
| `CardGranite.java` | Extends `Card`, returns `CardType.GRANITE` |
| `CardParchment.java` | Extends `Card`, returns `CardType.PARCHMENT` |
| `CardBlade.java` | Extends `Card`, returns `CardType.BLADE` |
| `Ability.java` | Interface — contract for all abilities |
| `AbilityBastion.java` | Implements `Ability` — grants 2 shield |
| `AbilityRipple.java` | Implements `Ability` — pings for 1, cycles card |
| `AbilityCleave.java` | Implements `Ability` — grants +2 bonus damage |
| `AbilityNone.java` | Implements `Ability` — no effect (null object pattern) |
| `AbilityLibrary.java` | Shared constants (`AbilityLibrary.BASTION`, etc.) and `fromText()` |
| `CardType.java` | Enum: `GRANITE`, `PARCHMENT`, `BLADE` with `fromText()` |
| `TypeChart.java` | Type matchup damage multipliers |
| `PlayerState.java` | Tracks a player's deck, active card, and pending damage |
| `DeckBuilderBot.java` | Builds the bot's 5-card deck |
| `Tester.java` | Quick demo — run this to test your code locally |

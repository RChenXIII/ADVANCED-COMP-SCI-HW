public interface ElementalAttacks {

    // to-do: Implement the attack method for ElementalAttacks
    // Every monster has 2 different attacks, each with different name and type
    // Base damage is based on the monster's attack
    // There is a 45% chance the monster should use AttackOne
    // There is a 45% chance the monster should use AttackTwo
    // There is a 10% chance the monster doubles down and uses BOTH attacks with doubleDown Attack
    // - The double down attack is only available once per battle.
    // - After using double down, the attack probability is 50% / 50% for Attacks 1/2
    default void attack(Monster opponent) {
        Monster thisMonster = thisMonster();
        double rand = Math.random();
        if (thisMonster.hasUsedDoubleDown()) {
            // 50/50 after double down used
            if (rand < 0.5) {
                performSingleElementalAttack(1, opponent);
            } else {
                performSingleElementalAttack(2, opponent);
            }
        } else {
            // 50% double down, 50% 50/50 attacks
            if (rand < 0.5) {
                performDoubleDownAttack(opponent);
            } else {
                if (Math.random() < 0.5) {
                    performSingleElementalAttack(1, opponent);
                } else {
                    performSingleElementalAttack(2, opponent);
                }
            }
        }
    }

    // to-do: Implement the attack method for performSingleElementalAttack
    // The current moster attacks the opponent using the attackNumber provided
    // Inputs:
    // attackNumber: either 1 or 2
    // opponent: the opposing Monster to attack
    default void performSingleElementalAttack(int attackNumber, Monster opponent) {
        Monster thisMonster = thisMonster();
        String attackName;
        ElementType attackElement;
        if (attackNumber == 1) {
            attackName = thisMonster.attackNameOne;
            attackElement = thisMonster.attackElementOne;
        } else if (attackNumber == 2) {
            attackName = thisMonster.attackNameTwo;
            attackElement = thisMonster.attackElementTwo;
        } else {
            throw new IllegalArgumentException("Invalid attack number: " + attackNumber);
        }

        double baseDamage = 10.0;
        double attackRatio = (double) thisMonster.getAttack() / opponent.getDefense();
        double stab = (attackElement == thisMonster.getElement()) ? 1.5 : 1.0;
        double effectiveness = getElementalMultiplier(attackElement, opponent.getElement());
        double crit = didAttackCrit(thisMonster.getSpeed()) ? 2.0 : 1.0;

        double totalDamage = baseDamage * attackRatio * stab * effectiveness * crit;
        int damage = (int) Math.round(totalDamage);

        opponent.takeDamage(damage);

        System.out.println(thisMonster.getName() + " used " + attackName + "!");
        if (effectiveness == 2.0) {
            System.out.println("It was super effective!");
        } else if (effectiveness == 0.5) {
            System.out.println("It was not very effective...");
        }
        if (crit == 2.0) {
            System.out.println("It was a critical hit!");
        }
    }


    // to-do: Implement the useDoubleDown() method for the monster
    // This method is called when the monster uses their double down attack.
    // The double down attack is only available once per battle
    // If the monster has already used their double down attack, print a message saying so and
    // return. The
    // monster effectively loses their turn.
    default void performDoubleDownAttack(Monster opponent) {
        Monster thisMonster = thisMonster();
        if (thisMonster.hasUsedDoubleDown()) {
            System.out.println(thisMonster.getName() + " has already used Double Down!");
            return;
        }
        thisMonster.useDoubleDown();
        System.out.println(thisMonster.getName() + " used Double Down!");
        performSingleElementalAttack(1, opponent);
        performSingleElementalAttack(2, opponent);
    }

    /**
     * didAttackCrit returns a boolean if an attack critically struck based on the speed of the
     * attacking monster
     */
    public static boolean didAttackCrit(int speed) {
        if (speed <= 0)
            return false;
        if (speed >= 250)
            return true;
        return Math.random() < (speed / 250.0);
    }


    /**
     * Returns true if attackType is super effective against defenderType. Fire->Air, Air->Earth,
     * Earth->Water, Water->Fire
     */
    static boolean isSuperEffectiveAgainst(ElementType attackType, ElementType defenderType) {
        if (attackType == null || defenderType == null)
            return false;
        return (attackType == ElementType.FIRE && defenderType == ElementType.AIR)
                || (attackType == ElementType.AIR && defenderType == ElementType.EARTH)
                || (attackType == ElementType.EARTH && defenderType == ElementType.WATER)
                || (attackType == ElementType.WATER && defenderType == ElementType.FIRE);
    }


    /**
     * Returns the effectiveness multiplier: 2.0 (super), 1.0 (normal), or 0.5 (low).
     */
    static double getElementalMultiplier(ElementType attackType, ElementType defenderType) {
        if (attackType == null || defenderType == null)
            return 1.0;
        if (isSuperEffectiveAgainst(attackType, defenderType))
            return 2.0;
        if ((attackType == ElementType.FIRE
                && (defenderType == ElementType.WATER || defenderType == ElementType.FIRE))
                || (attackType == ElementType.WATER
                        && (defenderType == ElementType.EARTH || defenderType == ElementType.WATER))
                || (attackType == ElementType.EARTH
                        && (defenderType == ElementType.AIR || defenderType == ElementType.EARTH))
                || (attackType == ElementType.AIR
                        && (defenderType == ElementType.FIRE || defenderType == ElementType.AIR)))
            return 0.5;
        return 1.0;
    }

    // Using this to get the Monster.
    // You can use: (Monster) this
    // or: Monster thisMonster = thisMonster();
    private Monster thisMonster() {
        if (!(this instanceof Monster)) {
            throw new IllegalStateException("ElementalAttack implementations must be Monsters");
        }
        return (Monster) this;
    }
}

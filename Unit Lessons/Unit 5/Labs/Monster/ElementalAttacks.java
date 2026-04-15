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
        double randomNum = Math.random() * 10;
        if (thisMonster().hasUsedDoubleDown == false) {
            if (randomNum < 4.5) {
                performSingleElementalAttack(1, opponent);
            } else if (randomNum < 9) {
                performSingleElementalAttack(2, opponent);
            } else {
                performDoubleDownAttack(opponent);
            }
        } else {
            if (randomNum < 5) {
                performSingleElementalAttack(1, opponent);
            } else if (randomNum < 10) {
                performSingleElementalAttack(2, opponent);
            }
        }
    }

    // to-do: Implement the attack method for performSingleElementalAttack
    // The current moster attacks the opponent using the attackNumber provided
    // Inputs:
    // attackNumber: either 1 or 2
    // opponent: the opposing Monster to attack
    default void performSingleElementalAttack(int attackNumber, Monster opponent) {
        if (attackNumber != 1 && attackNumber != 2) {
            throw new IllegalArgumentException("Invalid attack number");
        }
        int critDmg;
        int STABDMG;
        Monster thisMonster = thisMonster();
        if (didAttackCrit(thisMonster.getSpeed())) {
            critDmg = 2;
        } else {
            critDmg = 1;
        }

        if (attackNumber == 1) {
            if (thisMonster.getElement() == thisMonster.attackElementOne) {
                STABDMG = 2;
            } else {
                STABDMG = 1;
            }
        } else {
            if (thisMonster.getElement() == thisMonster.attackElementTwo) {
                STABDMG = 2;
            } else {
                STABDMG = 1;
            }
        }


        double damage = 10 * (thisMonster().getAttack() / opponent.getDefense()) * STABDMG
                * getElementalMultiplier(thisMonster.getElement(), opponent.getElement()) * critDmg;
        opponent.setHealth(opponent.getHealth() - (int) damage);
        // implement this method here
    }


    // to-do: Implement the useDoubleDown() method for the monster
    // This method is called when the monster uses their double down attack.
    // The double down attack is only available once per battle
    // If the monster has already used their double down attack, print a message saying so and
    // return. The
    // monster effectively loses their turn.
    default void performDoubleDownAttack(Monster opponent) {
        Monster thisMonster = thisMonster();
        if (thisMonster.hasUsedDoubleDown == true) {
            return;
        }
        performSingleElementalAttack(1, opponent);
        performSingleElementalAttack(2, opponent);
        this.thisMonster().hasUsedDoubleDown = true;
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

// a class for all of the battle engine functions
// this class will be used to validate the type, element, weakness, health, and attack of the
// monsters
// there's also methods that will be used to calculate the damage and the health of the monsters
// and apply the type advantage multipliers

import java.util.ArrayList;

public class BattleEngine {

    // to-do: validateStats
    // checks if the monster stats are valid
    // the total combined stats of the monster should not exceed 250
    public static boolean validateStats(Monster monster) {
        if (monster == null)
            return false;
        return monster.getTotalStatSum() <= 250 && monster.getHealth() >= 0
                && monster.getAttack() >= 0 && monster.getDefense() >= 0 && monster.getSpeed() >= 0;

    }


    // to-do: validateElement
    // checks if the monster element is valid
    // the only valid types allowed are "Fire", "Water", "Earth", and "Air"
    public static boolean validateElement(Monster monster) {
        if (monster == null)
            return false;
        ElementType elem = monster.getElement();
        if (elem == ElementType.FIRE || elem == ElementType.WATER || elem == ElementType.EARTH
                || elem == ElementType.AIR) {
            return true;
        } else {
            monster.setElement(ElementType.FIRE);
            return false;
        }

    }

    // to-do: correctStats
    // checks if stats are invalid
    // fixes them so they are valid, however you choose
    public static void correctStats(Monster monster) {
        if (monster == null)
            return;
        // Fix negatives
        if (monster.getHealth() < 0)
            monster.setHealth(0);
        if (monster.getAttack() < 0)
            monster.setAttack(0);
        if (monster.getDefense() < 0)
            monster.setDefense(0);
        if (monster.getSpeed() < 0)
            monster.setSpeed(0);

        int sum = monster.getTotalStatSum();
        if (sum <= 250)
            return;

        // Reduce proportionally
        double factor = 250.0 / sum;
        monster.setHealth((int) Math.floor(monster.getHealth() * factor));
        monster.setAttack((int) Math.floor(monster.getAttack() * factor));
        monster.setDefense((int) Math.floor(monster.getDefense() * factor));
        monster.setSpeed((int) Math.floor(monster.getSpeed() * factor));
    }

    // to-do: startBattle
    // each monster takes turn attacking the other until a monster's hp reaches 0. It returns the
    // winning monster.
    public static Monster startBattle(Monster monster1, Monster monster2) {
        if (monster1 == null || monster2 == null) {
            throw new IllegalArgumentException("Monsters cannot be null");
        }

        // Correct stats and elements
        correctStats(monster1);
        correctStats(monster2);
        validateElement(monster1);
        validateElement(monster2);

        boolean valid1 = validateStats(monster1) && validateElement(monster1);
        boolean valid2 = validateStats(monster2) && validateElement(monster2);

        if (!valid1 && !valid2)
            return null;
        if (!valid1)
            return monster2;
        if (!valid2)
            return monster1;

        // Both valid, proceed
        System.out.println(monster1.getName() + " wants to fight!");
        System.out.println(monster2.getName() + " wants to fight!");

        displayStatus(monster1, monster2);

        // Determine first attacker
        Monster attacker, defender;
        if (monster1.getSpeed() > monster2.getSpeed()) {
            attacker = monster1;
            defender = monster2;
        } else if (monster2.getSpeed() > monster1.getSpeed()) {
            attacker = monster2;
            defender = monster1;
        } else {
            // Tie, random
            if (Math.random() < 0.5) {
                attacker = monster1;
                defender = monster2;
            } else {
                attacker = monster2;
                defender = monster1;
            }
        }


        while (monster1.getHealth() > 0 && monster2.getHealth() > 0) {
            attacker.attack(defender);
            displayStatus(monster1, monster2);
            if (defender.getHealth() <= 0) {
                break;
            }
            // Switch
            Monster temp = attacker;
            attacker = defender;
            defender = temp;
        }

        Monster winner = (monster1.getHealth() > 0) ? monster1 : monster2;
        System.out.println(winner.getName() + " wins!");
        System.out.println(winner.victoryNoise());
        return winner;
    }

    // Tournament battle
    public static Monster startBattle(ArrayList<Monster> monsters) {
        if (monsters == null || monsters.size() < 2) {
            throw new IllegalArgumentException("Need at least 2 monsters for tournament");
        }
        Monster currentWinner = startBattle(monsters.get(0), monsters.get(1));
        if (currentWinner != null) {
            currentWinner.setHealth(currentWinner.getMaxHealth());
            System.out.println(currentWinner.victoryNoise());
        }
        for (int i = 2; i < monsters.size(); i++) {
            Monster next = monsters.get(i);
            currentWinner = startBattle(currentWinner, next);
            if (currentWinner != null) {
                currentWinner.setHealth(currentWinner.getMaxHealth());
                System.out.println(currentWinner.victoryNoise());
            }
        }
        return currentWinner;
    }

    // to-do: displayStatus
    // method prints out the current health of each monster.
    public static void displayStatus(Monster monster, Monster opponent) {
        System.out.println(monster.getName() + ": " + monster.getHealth() + "hp || "
                + opponent.getName() + ": " + opponent.getHealth() + "hp");
    }

}

// a class for all of the battle engine functions
// this class will be used to validate the type, element, weakness, health, and attack of the
// monsters
// there's also methods that will be used to calculate the damage and the health of the monsters
// and apply the type advantage multiplier

import java.util.Scanner;

public class BattleEngine {

    // to-do: validateStats
    // checks if the monster stats are valid
    // the total combined stats of the monster should not exceed 250
    public static boolean validateStats(Monster monster) {
        if (monster == null) {
            throw new IllegalArgumentException("monster is null");
        }
        return ((monster.getAttack() + monster.getDefense() + monster.getHealth()
                + monster.getSpeed() <= 250)
                && (monster.getAttack() > 0 && monster.getDefense() > 0 && monster.getHealth() > 0
                        && monster.getSpeed() > 0));

    }

    public static boolean validateMegaStats(Monster monster) {
        if (monster == null) {
            throw new IllegalArgumentException("monster is null");
        }
        return ((monster.getMegaattack() + monster.getMegadefense() + monster.getMegahealth()
                + monster.getMegaspeed() <= 500)
                && (monster.getMegaattack() > 0 && monster.getMegadefense() > 0 && monster.getMegahealth() > 0
                        && monster.getMegaspeed() > 0));

    }

    // to-do: validateElement
    // checks if the monster element is valid
    // the only valid types allowed are "Fire", "Water", "Earth", and "Air"
    public static boolean validateElement(Monster monster) {
        if (monster == null) {
            throw new IllegalArgumentException("monster is null");
        }
        if (monster.getElement() == null) {
            monster.setElement(ElementType.FIRE);
            return false;
        }
        if (monster.getElement().getDisplayName().equals("Fire")
                || monster.getElement().getDisplayName().equals("Water")
                || monster.getElement().getDisplayName().equals("Air")
                || monster.getElement().getDisplayName().equals("Earth")) {
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
        if (monster == null) {
            throw new IllegalArgumentException("monster is null");
        }
        if (validateStats(monster) == false) {
            monster.setAttack(62);
            monster.setDefense(62);
            monster.setHealth(63);
            monster.setSpeed(63);
        }
    }

    // to-do: startBattle
    // each monster takes turn attacking the other until a monster's hp reaches 0. It returns the
    // winning monster.
    public static Monster startBattle(Monster monster1, Monster monster2) {
        double dodgeChance;
        int Mega1 = 0;
        int Mega2 = 0;
        boolean canUseMega1 = true;
        boolean canUseMega2 = true;
        Scanner scanner = new Scanner(System.in);
        int storedAtk1 = 0;
        int storedDef1 = 0;
        int storedSpd1 = 0;
        int storedHp1 = 0;
        int storedAtk2 = 0;
        int storedDef2 = 0;
        int storedSpd2 = 0;
        int storedHp2 = 0;

        if (monster1 == null || monster2 == null) {
            throw new IllegalArgumentException("monster is null");
        }
        if (validateStats(monster1) == false && validateStats(monster2) == false) {
            return null;
        }
        if (validateStats(monster2) == false) {
            return monster1;
        }
        if (validateStats(monster1) == false) {
            return monster2;
        }
        if (validateStats(monster2) == false) {
            return monster1;
        }
        if (monster1.getSpeed() >= monster2.getSpeed()) {
            while (monster1.getHealth() > 0 && monster2.getHealth() > 0) {
                if (Mega1 > 0) {
                    Mega1--;
                    
                }
                if (Mega1 == 0) {
                        monster1.setAttack(storedAtk1);
                        monster1.setDefense(storedDef1);
                        monster1.setSpeed(storedSpd1);
                        monster1.setDefense(storedDef1);
                }
                if (Mega2 > 0) {
                    Mega2--;
                }
                if (Mega2 == 0) {
                        monster2.setAttack(storedAtk2);
                        monster2.setDefense(storedDef2);
                        monster2.setSpeed(storedSpd2);
                        monster2.setDefense(storedDef2);
                    }
                dodgeChance = ((double)monster1.getSpeed() / (monster1.getSpeed() + monster2.getSpeed())) * 0.4;
                if (Utils.doesAttackLand(dodgeChance)) {
                    monster1.attack(monster2);
                }
                dodgeChance = ((double)monster2.getSpeed() / (monster2.getSpeed() + monster1.getSpeed())) * 0.4;
                if (Utils.doesAttackLand(dodgeChance)) {
                    monster2.attack(monster1);
                }
                displayStatus(monster1, monster2);
                if (canUseMega1) {
                    System.out.println("monster 1 do you want to use mega evolution y/n");
                    String output = scanner.nextLine();
                    if (output.equals("y")) {
                        canUseMega1 = false;
                        Mega1 = 3;
                        storedAtk1 = monster1.getAttack();
                        storedSpd1 = monster1.getSpeed();
                        storedDef1 = monster1.getDefense();
                        storedHp1 = monster1.getHealth();
                        monster1.setAttack(monster1.getMegaattack());
                        monster1.setDefense(monster1.getMegadefense());
                        monster1.setSpeed(monster1.getMegaspeed());
                    }
                }
                if (canUseMega2) {
                    System.out.println("monster 2 do you want to use mega evolution y/n");
                    String output = scanner.nextLine();
                    if (output.equals("y")) {
                        canUseMega2 = false;
                        Mega2 = 3;
                        storedAtk2 = monster2.getAttack();
                        storedSpd2 = monster2.getSpeed();
                        storedDef2 = monster2.getDefense();
                        storedHp2 = monster2.getHealth();
                        monster2.setAttack(monster2.getMegaattack());
                        monster2.setDefense(monster2.getMegadefense());
                        monster2.setSpeed(monster2.getMegaspeed());
                    }
                }
            }

            if (monster1.getHealth() > 0) {
                return monster1;
            } else {
                return monster2;
            }
        }
        if (monster2.getSpeed() > monster1.getSpeed()) {
            while (monster1.getHealth() > 0 && monster2.getHealth() > 0) {
                if (Mega1 > 0) {
                    Mega1--;
                    if (Mega1 == 0) {
                        monster1.setAttack(storedAtk1);
                        monster1.setDefense(storedDef1);
                        monster1.setSpeed(storedSpd1);
                    }
                }
                if (Mega2 > 0) {
                    Mega2--;
                    if (Mega2 == 0) {
                        monster2.setAttack(storedAtk2);
                        monster2.setDefense(storedDef2);
                        monster2.setSpeed(storedSpd2);
                    }
                }
                dodgeChance = ((double)monster2.getSpeed() / (monster2.getSpeed() + monster1.getSpeed())) * 0.4;
                if (Utils.doesAttackLand(dodgeChance)) {
                    monster2.attack(monster1);
                }
                dodgeChance = ((double)monster1.getSpeed() / (monster1.getSpeed() + monster2.getSpeed())) * 0.4;
                if (Utils.doesAttackLand(dodgeChance)) {
                    monster1.attack(monster2);
                }
                displayStatus(monster2, monster1);
                if (canUseMega1) {
                    System.out.println("monster 1 do you want to use mega evolution y/n");
                    String output = scanner.nextLine();
                    if (output.equals("y")) {
                        canUseMega1 = false;
                        Mega1 = 3;
                        storedAtk1 = monster1.getAttack();
                        storedSpd1 = monster1.getSpeed();
                        storedDef1 = monster1.getDefense();
                        storedHp1 = monster1.getHealth();
                        monster1.setAttack(monster1.getMegaattack());
                        monster1.setDefense(monster1.getMegadefense());
                        monster1.setSpeed(monster1.getMegaspeed());
                    }
                }
                if (canUseMega2) {
                    System.out.println("monster 2 do you want to use mega evolution y/n");
                    String output = scanner.nextLine();
                    if (output.equals("y")) {
                        canUseMega2 = false;
                        Mega2 = 3;
                        storedAtk2 = monster2.getAttack();
                        storedSpd2 = monster2.getSpeed();
                        storedDef2 = monster2.getDefense();
                        storedHp2 = monster2.getHealth();
                        monster2.setAttack(monster2.getMegaattack());
                        monster2.setDefense(monster2.getMegadefense());
                        monster2.setSpeed(monster2.getMegaspeed());
                    }
                }
            }

            if (monster1.getHealth() > 0) {
                return monster1;
            } else {
                return monster2;
            }
        }
        return monster1;
    }

    // to-do: displayStatus
    // method prints out the current health of each monster.
    public static void displayStatus(Monster monster, Monster opponent) {
        if (monster == null || opponent == null) {
            throw new IllegalArgumentException("monster is null");
        }
        System.out.println(monster.getName() + ": " + monster.getHealth() + "hp"
                + opponent.getName() + ": " + opponent.getHealth() + "hp");
    }

}

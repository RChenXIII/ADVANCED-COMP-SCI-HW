import java.util.ArrayList;

public class Main {

    /**
     * Return an ArrayList of monsters for automated testing. Populate this with your created
     * monsters (e.g. Chimera, custom subclasses).
     */
    public static ArrayList<Monster> getMonstersForTest() {

        ArrayList<Monster> list = new ArrayList<>();
        // TODO: Add your monsters here (required for auto tester).
        list.add(new Chimera());
        list.add(new Treant());

        return list;
    }

    public static void main(String[] args) {

        // Run a tournament using monsters from getMonstersForTest():
        ArrayList<Monster> monsters = getMonstersForTest();
        Monster winner = BattleEngine.startBattle(monsters.get(0), monsters.get(1));

        System.out.println("Winner: " + (winner != null ? winner.getName() : "None"));

    }
}

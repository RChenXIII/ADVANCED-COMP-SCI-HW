public class CatTester {
    public static void main(String[] args) {
        // Step 1: Create a new Cat object
        Cat cookie = new Cat("Cookie", "Sarah", 8, "1432");

        // Step 2: Use setters to update values
        System.out.println("=== Testing Setters ===");
        cookie.setName("Cookie");
        cookie.setOwnerName("Sarah");
        cookie.setMoodLevel(8);
        cookie.setCatId("1432");
        cookie.isHungry = false;
        System.out.println("Setters applied successfully!\n");

        // Step 3: Create another Cat object with same values and test equals()
        System.out.println("=== Testing equals() Method ===");
        Cat cookie2 = new Cat("Cookie", "Sarah", 8, "1435");
        System.out.println("Are the two cats equal? " + cookie.equals(cookie2));
        System.out.println();

        // Step 4: Call bootUp()
        System.out.println("=== Testing bootUp() ===");
        PurrfectUtils.bootUp(cookie);
        System.out.println();

        // Step 5: Call pet()
        System.out.println("=== Testing pet() ===");
        PurrfectUtils.pet(cookie);
        System.out.println();

        // Step 6: Call trimClaws() 4 times using a for-loop
        System.out.println("=== Testing trimClaws() 4 times ===");
        for (int i = 0; i < 4; i++) {
            PurrfectUtils.trimClaws(cookie);
        }
        System.out.println();

        // Step 7: Call cleanLitterBox()
        System.out.println("=== Testing cleanLitterBox() ===");
        PurrfectUtils.cleanLitterBox(cookie);
        System.out.println();

        // Step 8: Call feed()
        System.out.println("=== Testing feed() ===");
        PurrfectUtils.feed(cookie);
    }
}

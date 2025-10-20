public class TriangleLoopsTester {

    public static void main(String[] args) {
        System.out.println("=== Testing createLetterTriangleUp ===");

        System.out.println("Test 1: numberOfRows=3, letter='A'");
        String output1 = TriangleLoops.createLetterTriangleUp(3, 'A');
        System.out.println(output1);

        System.out.println("Test 2: numberOfRows=5, letter='B'");
        String output2 = TriangleLoops.createLetterTriangleUp(5, 'B');
        System.out.println(output2);

        System.out.println("Test 3: Edge case - numberOfRows=-3, letter='B'");
        String output3 = TriangleLoops.createLetterTriangleUp(-3, 'B');
        System.out.println("Output: '" + output3 + "' (should be empty)");
        System.out.println();

        System.out.println("Test 4: Edge case - numberOfRows=0, letter='C'");
        String output4 = TriangleLoops.createLetterTriangleUp(0, 'C');
        System.out.println("Output: '" + output4 + "' (should be empty)");
        System.out.println();


        System.out.println("=== Testing createLetterTriangleDown ===");

        System.out.println("Test 1: numberOfRows=3, letter='A'");
        System.out.println(TriangleLoops.createLetterTriangleDown(3, 'A'));

        System.out.println("Test 2: numberOfRows=5, letter='B'");
        System.out.println(TriangleLoops.createLetterTriangleDown(5, 'B'));

        System.out.println("Test 3: Edge case - numberOfRows=-2, letter='X'");
        String output5 = TriangleLoops.createLetterTriangleDown(-2, 'X');
        System.out.println("Output: '" + output5 + "' (should be empty)");
        System.out.println();


        System.out.println("=== Testing createNumbersTriangle ===");

        System.out.println("Test 1: numberOfRows=4");
        System.out.println(TriangleLoops.createNumbersTriangle(4));

        System.out.println("Test 2: numberOfRows=6");
        System.out.println(TriangleLoops.createNumbersTriangle(6));

        System.out.println("Test 3: Edge case - numberOfRows=0");
        String output6 = TriangleLoops.createNumbersTriangle(0);
        System.out.println("Output: '" + output6 + "' (should be empty)");
        System.out.println();


        System.out.println("=== Testing createAlphabetTriangle ===");

        System.out.println("Test 1: numberOfRows=5");
        System.out.println(TriangleLoops.createAlphabetTriangle(5));

        System.out.println("Test 2: numberOfRows=3");
        System.out.println(TriangleLoops.createAlphabetTriangle(3));

        System.out.println("Test 3: Edge case - numberOfRows=30 (should cap at 26)");
        System.out.println(TriangleLoops.createAlphabetTriangle(30));

        System.out.println("Test 4: Edge case - numberOfRows=-5");
        String output7 = TriangleLoops.createAlphabetTriangle(-5);
        System.out.println("Output: '" + output7 + "' (should be empty)");
        System.out.println();

        System.out.println("=== All Tests Complete ===");
    }
}

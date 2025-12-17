// Simple driver to trigger the buggy methods in DebugDemoStudent.
// Run with: javac DebugDemoStudent.java Tester.java && java Tester
public class Tester {
    public static void main(String[] args) {
        System.out.println("Starting Tester...");

        // Run ONE exception task at a time (uncomment the call you want):
        // tryGetFifthElement(); // ArrayIndexOutOfBoundsException
        // tryDivideNumbers(); // ArithmeticException
        // tryGetStringLength(); // NullPointerException
        // tryMiddleNameLength(); // NullPointerException
        // tryAverageScoreNull(); // IllegalArgumentException
        // tryAverageScoreEmpty(); // IllegalArgumentException
        // trySquareRootFloorNegative(); // IllegalArgumentException
        // trySliceBadBounds(); // IllegalArgumentException

        // Logic/loop bugs (be ready to pause/stop the debugger to avoid infinite
        // loops):
        // DebugDemoStudent.countDown(3); // Infinite loop
        // DebugDemoStudent.printNumbersUntil(3); // Infinite loop
        // trySumArray(); // ArrayIndexOutOfBoundsException
        // tryIsEqualIgnoreCase(); // NullPointerException with nulls
        // tryIncrementArrayValues(); // Shows unexpected mutation
        // tryAlternatingSum(); // Wrong toggling
        // tryStrangeMin(); // Wrong comparison
        // tryEveryOtherChar(); // Double increment in loop

        // Safe example to step through substring math:
        System.out.println("\nstringEnds sample: " +
                DebugDemoStudent.stringEnds("Chocolate", 3));

        System.out.println("Tester finished.");
    }

    private static void tryGetFifthElement() {
        int[] nums = { 1, 2, 3 };
        System.out.println("Fifth element: " + DebugDemoStudent.getFifthElement(nums));
    }

    private static void tryDivideNumbers() {
        System.out.println("Divide result: " + DebugDemoStudent.divideNumbers(10, 0));
    }

    private static void tryGetStringLength() {
        String value = null;
        System.out.println("Length: " + DebugDemoStudent.getStringLength(value));
    }

    private static void tryMiddleNameLength() {
        String[] names = { "Ana", null, "Lee" };
        System.out.println("Middle name length: " + DebugDemoStudent.middleNameLength(names));
    }

    private static void tryAverageScoreNull() {
        int[] scores = null;
        System.out.println("Average score (null): " + DebugDemoStudent.averageScore(scores));
    }

    private static void tryAverageScoreEmpty() {
        int[] scores = {};
        System.out.println("Average score (empty): " + DebugDemoStudent.averageScore(scores));
    }

    private static void trySquareRootFloorNegative() {
        System.out.println("Square root floor: " + DebugDemoStudent.squareRootFloor(-9));
    }

    private static void trySliceBadBounds() {
        System.out.println("Slice: " + DebugDemoStudent.slice("Hello", 3, 1));
    }

    private static void trySumArray() {
        int[] data = { 4, 5, 6 };
        System.out.println("Sum: " + DebugDemoStudent.sumArray(data));
    }

    private static void tryIsEqualIgnoreCase() {
        String a = null;
        String b = "hello";
        System.out.println("Equal ignore case: " + DebugDemoStudent.isEqualIgnoreCase(a, b));
    }

    private static void tryIncrementArrayValues() {
        int[] data = { 1, 1, 1 };
        DebugDemoStudent.incrementArrayValues(data);
        System.out.print("Incremented array: ");
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }

    private static void tryAlternatingSum() {
        int[] nums = { 5, 2, 7 };
        System.out.println("Alternating sum: " + DebugDemoStudent.alternatingSum(nums));
    }

    private static void tryStrangeMin() {
        int[] nums = { 9, 2, 3, -1, 5 };
        System.out.println("Strange min: " + DebugDemoStudent.strangeMin(nums));
    }

    private static void tryEveryOtherChar() {
        System.out.println("Every other char: " + DebugDemoStudent.everyOtherChar("a b c d"));
    }
}
// A deliberately buggy program for practicing the VS Code debugger.
// Each scenario below contains issues that are easier to understand by
// stepping through the code with breakpoints, watches, and exception pauses.

public class DebuggerDemo {

    public static void main(String[] args) {
        System.out.println("Starting Debugger Demo...");
        try {
            runParserScenario();
        } catch (Exception e) {
            System.out.println("Parser scenario blew up: " + e.getMessage());
        }

        try {
            runAverageScenario();
        } catch (Exception e) {
            System.out.println("Average scenario blew up: " + e.getMessage());
        }

        try {
            runNullPointerScenario();
        } catch (Exception e) {
            System.out.println("Null pointer scenario blew up: " + e.getMessage());
        }

        try {
            runNullArrayElementScenario();
        } catch (Exception e) {
            System.out.println("Null array element scenario blew up: " + e.getMessage());
        }

        try {
            runDivideByZeroScenario();
        } catch (Exception e) {
            System.out.println("Divide-by-zero scenario blew up: " + e.getMessage());
        }

        runLogicBugScenario();

        System.out.println("Debugger Demo finished.");
    }

    private static void runParserScenario() {
        System.out.println("\n=== Scenario 1: Number parsing ===");
        String raw = "10,5,-2,30";
        System.out.println("Raw input: \"" + raw + "\"");
        int[] parsed = parseNumbers(raw); // Throws NumberFormatException on "oops"
        System.out.println("Parsed numbers: " + formatArray(parsed));
    }

    private static void runAverageScenario() {
        System.out.println("\n=== Scenario 2: Off-by-one average ===");
        int[] scores = {90, 70, 80, 100};
        double average = average(scores); // ArrayIndexOutOfBoundsException
        System.out.println("Average score: " + average);
    }

    private static void runNullPointerScenario() {
        System.out.println("\n=== Scenario 3: Missing data ===");
        String studentName = "Alex";
        String city = null; // city never set
        System.out.println("Student: " + studentName);
        // city is null, so this call will throw a NullPointerException.
        city = getUppercaseCity(city);
        System.out.println("City in uppercase: " + city);
    }

    private static void runNullArrayElementScenario() {
        System.out.println("\n=== Scenario 4: Null element in array ===");
        String[] names = {"Ana", null, "Lee"};
        int indexToUse = 1; // points at the null element
        int length = nameLength(names, indexToUse); // NullPointerException
        System.out.println("Length of name: " + length);
    }

    private static void runDivideByZeroScenario() {
        System.out.println("\n=== Scenario 5: Divide by zero ===");
        int total = 50;
        int count = findCountWithBug(total); // count ends up zero, leading to /0
        int result = total / count; // ArithmeticException
        System.out.println("Result: " + result);
    }

    private static void runLogicBugScenario() {
        System.out.println("\n=== Scenario 6: Wrong Fibonacci result ===");
        int n = 7;
        int result = fib(n); // Returns an incorrect value due to bad base case.
        System.out.println("fib(" + n + ") reported: " + result);
        System.out.println("Expected: 13");
    }

    // Former InputParser functionality as static methods
    public static int[] parseNumbers(String csv) {
        String[] parts = csv.split(",");
        int[] result = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            String part = parts[i];
            // Bug: we forget to trim whitespace before parsing, which is minor,
            // but the bigger problem is the non-numeric token "oops".
            int value = Integer.parseInt(part); // Throws NumberFormatException
            result[i] = value;
        }
        return result;
    }

    public static String formatArray(int[] data) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < data.length; i++) {
            sb.append(data[i]);
            if (i < data.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    // Former AverageCalculator functionality as static method
    public static double average(int[] data) {
        if (data.length == 0) {
            return 0.0;
        }
        int sum = 0;
        // Bug: the loop condition should be i < data.length, not <=.
        for (int i = 0; i <= data.length; i++) {
            sum += data[i]; // ArrayIndexOutOfBoundsException when i == data.length
        }
        return sum / (double) data.length;
    }

    // Former Student/Address functionality simplified into one method
    public static String getUppercaseCity(String city) {
        // Bug: city is expected to be non-null; null will throw a NullPointerException.


        if (city == null) {
            return "N/A";
        }
        return city.toUpperCase();
    }

    public static int nameLength(String[] names, int index) {
        // Bug: assumes names[index] is never null.

        if (names[index] == null) {
            return 0;
        }

        return names[index].length();
    }

    public static int findCountWithBug(int total) {
        // Bug: logic accidentally returns zero when total is positive.
        int count = 0;
        if (total > 0) {
            count = count - 1; // should have incremented, not decremented
        }
        return count;
    }

    // Former Fibonacci functionality as static method
    public static int fib(int n) {
        // Bug: incorrect base cases produce wrong sequence values.
        if (n <= 1) {
            return 1; // Should be 0 when n == 0 and 1 when n == 1
        }
        return fib(n - 1) + fib(n - 2);
    }
}

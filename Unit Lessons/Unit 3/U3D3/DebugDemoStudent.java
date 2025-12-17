// A set of small, intentionally buggy examples for students to debug.
// Each method is short and focuses on a single mistake.
public class DebugDemoStudent {

    // --- Exception tasks (trigger with bad inputs) ---

    // ArrayIndexOutOfBoundsException when array has fewer than 6 items.
    // Students: add a guard and throw ArrayIndexOutOfBoundsException (or a clear
    // message) if the array is too short instead of letting the JVM crash here.
    public static int getFifthElement(int[] arr) {
        if (arr == null) {
            throw new IllegalArgumentException("NULL"); // FIXED: Added missing semicolon
        }

        if (arr.length < 5) {
            throw new IllegalArgumentException("Array length is too short");
        }
        return arr[4];
    }

    // ArithmeticException when b is zero.
    // Students: explicitly check for b == 0 and throw ArithmeticException with a
    // short message before dividing.
    public static int divideNumbers(int a, int b) {
        if (b == 0) { // FIXED: Added check for division by zero
            throw new ArithmeticException("Cannot divide by zero");
        }
        return a / b;
    }

    // NullPointerException when str is null (precondition allows null).
    // Students: if str is null, throw NullPointerException with a helpful message
    // instead of dereferencing it.
    public static int getStringLength(String str) {
        if (str == null) { // FIXED: Added null check
            throw new NullPointerException("String cannot be null");
        }
        return str.length();
    }

    // NullPointerException when the target slot is null.
    // Students: check names[1] for null and throw NullPointerException if it is,
    // so callers get a clearer failure.
    public static int middleNameLength(String[] names) {
        if (names[1] == null) { // FIXED: Added null check for array element
            throw new NullPointerException("Middle name cannot be null");
        }
        return names[1].length();
    }

    // IllegalArgumentException when array is null or empty.
    // Students: validate input and throw IllegalArgumentException with a short
    // message before doing the math.
    public static double averageScore(int[] scores) {
        if (scores == null || scores.length == 0) { // FIXED: Added validation
            throw new IllegalArgumentException("Scores array cannot be null or empty");
        }
        int sum = 0;
        for (int i = 0; i < scores.length; i++) {
            sum += scores[i];
        }
        return (double) sum / scores.length;
    }

    // IllegalArgumentException when n is negative.
    // Students: reject negative inputs with IllegalArgumentException so callers
    // know why they failed.
    public static int squareRootFloor(int n) {
        if (n < 0) { // FIXED: Added check for negative input
            throw new IllegalArgumentException("Cannot compute square root of negative number");
        }
        return (int) Math.sqrt(n);
    }

    // IllegalArgumentException when bounds are invalid or string is null.
    // Students: ensure word is non-null and start/end are inside 0..length and
    // start <= end, otherwise throw IllegalArgumentException with a hint.
    public static String slice(String word, int start, int end) {
        if (word == null) { // FIXED: Added comprehensive validation
            throw new IllegalArgumentException("Word cannot be null");
        }
        if (start < 0 || end > word.length() || start > end) {
            throw new IllegalArgumentException("Invalid bounds: start=" + start + ", end=" + end);
        }
        return word.substring(start, end);
    }

    // --- Logic/loop bugs to step through in the debugger ---

    // BUG: loop never ends (condition counts up, update counts down).
    public static void countDown(int end) {
        for (int i = end; i >= 0; i--) { // FIXED: Changed initialization and condition
            System.out.println(i);
        }
    }

    // BUG: while loop never increments i, so it never stops.
    public static void printNumbersUntil(int n) {
        int i = 0;
        while (i < n) {
            System.out.println(i);
            i++; // FIXED: Added missing increment
        }
    }

    // BUG: off-by-one on the loop bound causes ArrayIndexOutOfBoundsException.
    public static int sumArray(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) { // FIXED: Changed <= to <
            sum += array[i];
        }
        return sum;
    }

    // BUG: returns false if either string is null even though precondition allows
    // nulls.
    public static boolean isEqualIgnoreCase(String str1, String str2) {
        if (str1 == null && str2 == null) { // FIXED: Handle null cases
            return true;
        }
        if (str1 == null || str2 == null) {
            return false;
        }
        return str1.toLowerCase().equals(str2.toLowerCase());
    }

    // Correct logic but useful for stepping through substring math.
    // Precondition: str length is at least n.
    public static String stringEnds(String str, int n) {
        return str.substring(0, n) + str.substring(str.length() - n);
    }

    // BUG: modifies the array, which may be unexpected for callers wanting a pure
    // sum.
    public static void incrementArrayValues(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] += i;
        }
        // NOTE: This method's "bug" is more about design - it modifies the array.
        // If this is unintended, consider returning a new array instead.
    }

    // BUG: toggling the sign happens at the wrong time; step through to see how
    // sum drifts. Intended to alternate + and - on successive elements.
    public static int alternatingSum(int[] nums) {
        int sum = 0;
        boolean add = true;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (add)
                sum += num;
            else
                sum -= num;
            add = !add; // FIXED: Removed extra toggle
        }
        return sum;
    }

    // BUG: tries to find the minimum but the comparison is reversed; debugger
    // watch on "min" helps reveal the mistake.
    public static int strangeMin(int[] nums) {
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < min) { // FIXED: Changed > to <
                min = nums[i];
            }
        }
        return min;
    }

    // BUG: intended to collect every other character, but increments i twice in
    // some iterations; stepping shows skipped characters and an occasional
    // StringIndexOutOfBoundsException when text is short.
    public static String everyOtherChar(String text) {
        String result = "";
        for (int i = 0; i < text.length(); i += 2) { // FIXED: Increment by 2 in loop
            result += text.charAt(i);
        }
        return result;
    }
}
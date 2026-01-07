public class Unit3Tester {

    public static void main(String[] args) {
        System.out.println("=== Testing calculateAverageStringLength ===");
        testCalculateStringLengthAverage();

        System.out.println("\n=== Testing reverseString ===");
        testReverseString();

        System.out.println("\n=== Testing findMaxValue ===");
        testFindMaxValue();

        System.out.println("\n=== Testing isPalindrome ===");
        testIsPalindrome();

        System.out.println("\n=== Testing sumEvenNumbers ===");
        testSumEvenNumbers();
    }

    public static void testCalculateStringLengthAverage() {
        // Test Case - Main Case
        String[] letters = { "abc", "cde", "efg", "hij" };
        // expected output: 3.0
        System.out.println("Expected 3.0: " + Unit3Exercises.calculateAverageStringLength(letters));

        // Test Case - Edge Case: Null element in array
        letters = new String[] { "abc", "cde", "efg", null, "hij" };
        // expected output: 3.0
        System.out.println("Expected 3.0: " + Unit3Exercises.calculateAverageStringLength(letters));

        // Test Case - Edge Case: Null array
        try {
            letters = null;
            System.out.println("Expected exception: " + Unit3Exercises.calculateAverageStringLength(letters));
        } catch (Exception e) {
            System.out.println(e.toString());
            System.out.println("The method threw an exception when the array was null, as intended");
        }
    }

    public static void testReverseString() {
        // Test Case - Main Case
        String testString = "abc";
        System.out.println("Expected cba: " + Unit3Exercises.reverseString(testString));

        // Test Case - Edge Case: String with spaces at the end and in the middle
        testString = " ab c ";
        System.out.println("Expected ' c ba ': " + Unit3Exercises.reverseString(testString));

        // Test Case - Edge Case: String with special characters
        testString = "a1b!c&";
        System.out.println("Expected '&c!b1a': " + Unit3Exercises.reverseString(testString));

        // Test Case - Edge Case: Null string
        try {
            testString = null;
            System.out.println("Expected exception: " + Unit3Exercises.reverseString(testString));
        } catch (Exception e) {
            System.out.println(e.toString());
            System.out.println("The method threw an exception when the string was null, as intended");
        }
    }

    public static void testFindMaxValue() {
        // Test Case 1 - Main Case: Array with only positive integers
        int[] numbers = { 5, 12, 3, 9, 15, 7 };
        System.out.println("Expected 15: " + Unit3Exercises.findMaxValue(numbers));

        // Test Case 2 - Edge Case: Array with negative integers and zero
        numbers = new int[] { -5, 0, -12, 3, -2 };
        System.out.println("Expected 3: " + Unit3Exercises.findMaxValue(numbers));

        // Test Case 3 - Edge Case: Array with only negative integers
        numbers = new int[] { -15, -3, -8, -1, -20 };
        System.out.println("Expected -1: " + Unit3Exercises.findMaxValue(numbers));

        // Test Case 4 - Edge Case: Null array
        try {
            numbers = null;
            System.out.println("Expected exception: " + Unit3Exercises.findMaxValue(numbers));
        } catch (Exception e) {
            System.out.println(e.toString());
            System.out.println("The method threw an exception when the array was null, as intended");
        }
    }

    public static void testIsPalindrome() {
        // Test Case 1 - Main Case: Palindrome string
        String testString = "racecar";
        System.out.println("Expected true: " + Unit3Exercises.isPalindrome(testString));

        testString = "deed";
        System.out.println("Expected true: " + Unit3Exercises.isPalindrome(testString));

        // Test Case 2 - Main Case: Non-palindrome string
        testString = "hello";
        System.out.println("Expected false: " + Unit3Exercises.isPalindrome(testString));

        testString = "world";
        System.out.println("Expected false: " + Unit3Exercises.isPalindrome(testString));

        // Test Case 3 - Edge Case: Null string
        try {
            testString = null;
            System.out.println("Expected exception: " + Unit3Exercises.isPalindrome(testString));
        } catch (Exception e) {
            System.out.println(e.toString());
            System.out.println("The method threw an exception when the string was null, as intended");
        }

        // Test Case 4 - Edge Case: Empty string
        testString = "";
        System.out.println("Expected true: " + Unit3Exercises.isPalindrome(testString));
    }

    public static void testSumEvenNumbers() {
        // Test Case 1 - Main Case: Array with positive even and odd integers
        int[] numbers = { 1, 2, 3, 4, 5, 6 };
        System.out.println("Expected 12: " + Unit3Exercises.sumEvenNumbers(numbers));

        // Test Case 2 - Edge Case: Array with only negative even and odd integers
        numbers = new int[] { -1, -2, -3, -4, -5, -6 };
        System.out.println("Expected -12: " + Unit3Exercises.sumEvenNumbers(numbers));

        // Test Case 3 - Edge Case: Array with positive and negative even and odd
        // integers
        numbers = new int[] { -2, 3, 4, -5, 6, 7, -8 };
        System.out.println("Expected 0: " + Unit3Exercises.sumEvenNumbers(numbers));

        // Test Case 4 - Edge Case: Null array
        try {
            numbers = null;
            System.out.println("Expected exception: " + Unit3Exercises.sumEvenNumbers(numbers));
        } catch (Exception e) {
            System.out.println(e.toString());
            System.out.println("The method threw an exception when the array was null, as intended");
        }
    }
}
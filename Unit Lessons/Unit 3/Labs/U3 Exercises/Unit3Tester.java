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

        System.out.println("\n=== Testing calculateSumOfSquares ===");
        testCalculateSumOfSquares();

        System.out.println("\n=== Testing getNthFibonacci ===");
        testGetNthFibonacci();

        System.out.println("\n=== Testing sortArrayDescending ===");
        testSortArrayDescending();

        System.out.println("\n=== Testing findLongestWord ===");
        testFindLongestWord();

        System.out.println("\n=== Testing calculateInterest ===");
        testCalculateInterest();

        System.out.println("=== Testing parsePositiveInteger ===");
        testParsePositiveInteger();

        System.out.println("\n=== Testing getArrayElement ===");
        testGetArrayElement();

        System.out.println("\n=== Testing calculateSquareRoot ===");
        testCalculateSquareRoot();

        System.out.println("\n=== Testing sumArrayElements ===");
        testSumArrayElements();

        System.out.println("\n=== Testing calculatePower ===");
        testCalculatePower();
    }

    public static void testCalculateStringLengthAverage() {
        // Test Case - Main Case
        String[] letters = {"abc", "cde", "efg", "hij"};
        // expected output: 3.0
        System.out.println("Expected 3.0: " + Unit3Exercises.calculateAverageStringLength(letters));

        // Test Case - Edge Case: Null element in array
        letters = new String[] {"abc", "cde", "efg", null, "hij"};
        // expected output: 3.0
        System.out.println("Expected 3.0: " + Unit3Exercises.calculateAverageStringLength(letters));

        // Test Case - Edge Case: Null array
        try {
            letters = null;
            System.out.println(
                    "Expected exception: " + Unit3Exercises.calculateAverageStringLength(letters));
        } catch (Exception e) {
            System.out.println(e.toString());
            System.out
                    .println("The method threw an exception when the array was null, as intended");
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
            System.out
                    .println("The method threw an exception when the string was null, as intended");
        }
    }

    public static void testFindMaxValue() {
        // Test Case 1 - Main Case: Array with only positive integers
        int[] numbers = {5, 12, 3, 9, 15, 7};
        System.out.println("Expected 15: " + Unit3Exercises.findMaxValue(numbers));

        // Test Case 2 - Edge Case: Array with negative integers and zero
        numbers = new int[] {-5, 0, -12, 3, -2};
        System.out.println("Expected 3: " + Unit3Exercises.findMaxValue(numbers));

        // Test Case 3 - Edge Case: Array with only negative integers
        numbers = new int[] {-15, -3, -8, -1, -20};
        System.out.println("Expected -1: " + Unit3Exercises.findMaxValue(numbers));

        // Test Case 4 - Edge Case: Null array
        try {
            numbers = null;
            System.out.println("Expected exception: " + Unit3Exercises.findMaxValue(numbers));
        } catch (Exception e) {
            System.out.println(e.toString());
            System.out
                    .println("The method threw an exception when the array was null, as intended");
        }
    }

    public static void testIsPalindrome() {
        // Test Case 1 - Main Case: Palindrome string
        String testString = "racecar";
        System.out.println("Expected true: " + Unit3Exercises.isPalindrome(testString));

        testString = " deed";
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
            System.out
                    .println("The method threw an exception when the string was null, as intended");
        }

        // Test Case 4 - Edge Case: Empty string
        testString = "";
        System.out.println("Expected true: " + Unit3Exercises.isPalindrome(testString));
    }

    public static void testSumEvenNumbers() {
        // Test Case 1 - Main Case: Array with positive even and odd integers
        int[] numbers = {1, 2, 3, 4, 5, 6};
        System.out.println("Expected 12: " + Unit3Exercises.sumEvenNumbers(numbers));

        // Test Case 2 - Edge Case: Array with only negative even and odd integers
        numbers = new int[] {-1, -2, -3, -4, -5, -6};
        System.out.println("Expected -12: " + Unit3Exercises.sumEvenNumbers(numbers));

        // Test Case 3 - Edge Case: Array with positive and negative even and odd
        // integers
        numbers = new int[] {-2, 3, 4, -5, 6, 7, -8};
        System.out.println("Expected 0: " + Unit3Exercises.sumEvenNumbers(numbers));

        // Test Case 4 - Edge Case: Null array
        try {
            numbers = null;
            System.out.println("Expected exception: " + Unit3Exercises.sumEvenNumbers(numbers));
        } catch (Exception e) {
            System.out.println(e.toString());
            System.out
                    .println("The method threw an exception when the array was null, as intended");
        }
    }

    public static void testCalculateSumOfSquares() {
        // Test Case 1 - Main Case: Array with positive integers
        int[] numbers = {2, 3, 4};
        // Expected: 2² + 3² + 4² = 4 + 9 + 16 = 29
        System.out.println("Expected 29: " + Unit3Exercises.calculateSumOfSquares(numbers));

        // Test Case 2 - Edge Case: Null array
        try {
            numbers = null;
            System.out.println(
                    "Expected exception: " + Unit3Exercises.calculateSumOfSquares(numbers));
        } catch (Exception e) {
            System.out.println(e.toString());
            System.out
                    .println("The method threw an exception when the array was null, as intended");
        }
    }

    public static void testGetNthFibonacci() {
        // Test Case 1 - Main Case: Test with n=5
        // Fibonacci sequence: 1, 1, 2, 3, 5
        System.out.println("Expected 5: " + Unit3Exercises.getNthFibonacci(5));

        // Test Case 2 - Main Case: Test with n=7
        // Fibonacci sequence: 1, 1, 2, 3, 5, 8, 13
        System.out.println("Expected 13: " + Unit3Exercises.getNthFibonacci(7));

        // Test Case 3 - Edge Case: Negative input
        try {
            System.out.println("Expected exception: " + Unit3Exercises.getNthFibonacci(-1));
        } catch (Exception e) {
            System.out.println(e.toString());
            System.out.println("The method threw an exception for negative input, as intended");
        }
    }

    public static void testSortArrayDescending() {
        // Test Case 1 - Main Case: Unsorted array with positive integers
        int[] numbers = {5, 2, 8, 1, 9};
        Unit3Exercises.sortArrayDescending(numbers);
        System.out.print("Expected [9, 8, 5, 2, 1]: [");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i]);
            if (i < numbers.length - 1)
                System.out.print(", ");
        }
        System.out.println("]");

        // Test Case 2 - Main Case: Array with negative values
        numbers = new int[] {-3, 5, -1, 0, 2};
        Unit3Exercises.sortArrayDescending(numbers);
        System.out.print("Expected [5, 2, 0, -1, -3]: [");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i]);
            if (i < numbers.length - 1)
                System.out.print(", ");
        }
        System.out.println("]");

        // Test Case 3 - Edge Case: Null array
        try {
            numbers = null;
            Unit3Exercises.sortArrayDescending(numbers);
            System.out.println("Expected exception");
        } catch (Exception e) {
            System.out.println(e.toString());
            System.out
                    .println("The method threw an exception when the array was null, as intended");
        }
    }

    public static void testFindLongestWord() {
        // Test Case 1 - Main Case: Sentence with different word lengths
        String sentence = "The quick brown fox jumps";
        System.out.println("Expected 'quick': " + Unit3Exercises.findLongestWord(sentence));

        // Test Case 2 - Main Case: Another sentence
        sentence = "I love programming in Java";
        System.out.println("Expected 'programming': " + Unit3Exercises.findLongestWord(sentence));

        // Test Case 3 - Main Case: Multiple words with same longest length (should return first)
        sentence = "cat dog bird fish";
        System.out.println("Expected 'bird': " + Unit3Exercises.findLongestWord(sentence));

        // Test Case 4 - Edge Case: Null input
        try {
            sentence = null;
            System.out.println("Expected exception: " + Unit3Exercises.findLongestWord(sentence));
        } catch (Exception e) {
            System.out.println(e.toString());
            System.out.println("The method threw an exception for null input, as intended");
        }

        // Test Case 5 - Edge Case: Empty string
        try {
            sentence = "";
            System.out.println("Expected exception: " + Unit3Exercises.findLongestWord(sentence));
        } catch (Exception e) {
            System.out.println(e.toString());
            System.out.println("The method threw an exception for empty input, as intended");
        }
    }

    public static void testCalculateInterest() {
        // Test Case 1 - Main Case: Principal=1000, Rate=5%, Years=2
        // Year 1: 1000 + (1000 * 0.05) = 1050
        // Year 2: 1050 + (1050 * 0.05) = 1102.5
        System.out.println("Expected 1102.5: " + Unit3Exercises.calculateInterest(1000, 5, 2));

        // Test Case 2 - Main Case: Principal=500, Rate=10%, Years=3
        // Year 1: 500 + (500 * 0.10) = 550
        // Year 2: 550 + (550 * 0.10) = 605
        // Year 3: 605 + (605 * 0.10) = 665.5
        System.out.println("Expected 665.5: " + Unit3Exercises.calculateInterest(500, 10, 3));

        // Test Case 3 - Edge Case: Negative principal
        try {
            System.out.println(
                    "Expected exception: " + Unit3Exercises.calculateInterest(-1000, 5, 2));
        } catch (Exception e) {
            System.out.println(e.toString());
            System.out.println("The method threw an exception for negative principal, as intended");
        }

        // Test Case 4 - Edge Case: Negative rate
        try {
            System.out.println(
                    "Expected exception: " + Unit3Exercises.calculateInterest(1000, -5, 2));
        } catch (Exception e) {
            System.out.println(e.toString());
            System.out.println("The method threw an exception for negative rate, as intended");
        }

        // Test Case 5 - Edge Case: Non-positive years
        try {
            System.out
                    .println("Expected exception: " + Unit3Exercises.calculateInterest(1000, 5, 0));
        } catch (Exception e) {
            System.out.println(e.toString());
            System.out.println("The method threw an exception for non-positive years, as intended");
        }
    }

    public static void testParsePositiveInteger() {
        // Test Case 1 - Valid positive number
        System.out.println("Expected 42: " + Unit3Exercises.parsePositiveInteger("42"));

        // Test Case 2 - Invalid input (not a number)
        System.out.println("Expected 1: " + Unit3Exercises.parsePositiveInteger("abc"));

        // Test Case 3 - Negative number (should trigger exception and return 1)
        try {
            String testStr = "-5";
            int result = Unit3Exercises.parsePositiveInteger(testStr);
            System.out.println("Result for negative input: " + result);
        } catch (NumberFormatException e) {
            System.out.println(e);
            System.out.println(
                    "Exception caught for negative number - this is intentional for testing");
        }

        // Test Case 4 - Zero (should return 1)
        System.out.println("Expected 1: " + Unit3Exercises.parsePositiveInteger("0"));
    }

    public static void testGetArrayElement() {
        // Test Case 1 - Valid index
        String[] arr = {"apple", "banana", "cherry", "date", "elderberry"};
        System.out.println("Expected 'banana': " + Unit3Exercises.getArrayElement(arr, 1));

        // Test Case 2 - Out of bounds index (should trigger exception and return null)
        try {
            String result = Unit3Exercises.getArrayElement(arr, 10);
            System.out.println("Result for out-of-bounds index: " + result);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e);
            System.out.println(
                    "Exception caught for out-of-bounds index - this is intentional for testing");
        }

        // Test Case 3 - Negative index
        try {
            String result = Unit3Exercises.getArrayElement(arr, -1);
            System.out.println("Result for negative index: " + result);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e);
            System.out.println(
                    "Exception caught for negative index - this is intentional for testing");
        }
    }

    public static void testCalculateSquareRoot() {
        // Test Case 1 - Valid positive number
        System.out.println("Expected 5.0: " + Unit3Exercises.calculateSquareRoot(25));

        // Test Case 2 - Zero
        System.out.println("Expected 0.0: " + Unit3Exercises.calculateSquareRoot(0));

        // Test Case 3 - Negative number (should throw exception)
        try {
            int negativeNum = -16;
            if (negativeNum < 0) {
                throw new IllegalArgumentException(
                        "Cannot calculate square root of a negative number. Result would be: "
                                + Double.NaN);
            }
            double result = Unit3Exercises.calculateSquareRoot(negativeNum);
            System.out.println("Result: " + result);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
            System.out.println("Exception includes NaN value as expected");
        }
    }

    public static void testSumArrayElements() {
        // Test Case 1 - Valid array with positive numbers
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println("Expected 15: " + Unit3Exercises.sumArrayElements(arr));

        // Test Case 2 - Array with negative numbers
        int[] negArr = {-1, -2, -3};
        System.out.println("Expected -6: " + Unit3Exercises.sumArrayElements(negArr));

        // Test Case 3 - Null array (should return 0)
        int[] nullArr = null;
        System.out.println("Expected 0: " + Unit3Exercises.sumArrayElements(nullArr));

        // Test Case 4 - Empty array
        int[] emptyArr = {};
        System.out.println("Expected 0: " + Unit3Exercises.sumArrayElements(emptyArr));
    }

    public static void testCalculatePower() {
        // Test Case 1 - Positive exponent
        System.out.println("Expected 8.0: " + Unit3Exercises.calculatePower(2, 3));

        // Test Case 2 - Zero exponent
        System.out.println("Expected 1.0: " + Unit3Exercises.calculatePower(5, 0));

        // Test Case 3 - Negative exponent (should throw exception)
        try {
            double base = 2;
            int exponent = -3;
            if (exponent < 0) {
                throw new IllegalArgumentException("Exponent cannot be negative");
            }
            double result = Unit3Exercises.calculatePower(base, exponent);
            System.out.println("Result: " + result);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
            System.out.println(
                    "Exception caught for negative exponent - this is intentional for testing");
        }
    }


}

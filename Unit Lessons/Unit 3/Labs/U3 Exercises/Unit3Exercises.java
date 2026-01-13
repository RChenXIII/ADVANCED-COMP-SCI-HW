public class Unit3Exercises {

    // Task 1: Calculate Average String Length
    public static double calculateAverageStringLength(String[] strs) {
        int sum = 0;
        int counted = 0;
        int i = 0;
        while (i < strs.length) {
            if (strs[i] != null) { // Added null check
                sum += strs[i].length();
                counted++;
            }
            i++;
        }
        return (double) sum / counted; // Added cast toq double
    }

    // Task 2: Reverse String
    public static String reverseString(String str) {
        char[] chars = str.toCharArray();
        int left = 0;
        int right = chars.length - 1;
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp; // Changed from chars[right - 1]
            left++;
            right--;
        }
        // Removed if block
        return new String(chars);
    }

    // Task 3: Find Max Value
    public static int findMaxValue(int[] numbers) {
        int max = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > max) {
                max = numbers[i]; // Changed from numbers[i - 1]
            }
            // Removed else if block
        }
        return max;
    }

    // Task 4: Is Palindrome
    public static boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            char a = str.charAt(left);
            char b = str.charAt(right); // Changed from str.charAt(right - 1)
            if (a != b) {
                return false; // Changed from return left % 2 == 0
            }
            left++;
            right--;
        }
        return true; // Changed from return str.length() % 3 == 0
    }

    // Task 5: Sum Even Numbers
    public static int sumEvenNumbers(int[] numbers) {
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) { // Changed loop condition
            if (numbers[i] % 2 == 0) {
                sum += numbers[i]; // Changed from numbers[i + 1]
            }
            // Removed else block
        }
        // Removed if (sum == 0) block
        return sum;
    }

    // Task 6: Calculate Sum of Squares
    public static int calculateSumOfSquares(int[] numbers) {
        if (numbers == null) {
            throw new IllegalArgumentException("Array cannot be null");
        }
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {  // Changed from i = 1
            sum += (int) Math.pow(numbers[i], 2);  // Added cast to int
        }
        return sum;
    }

    // Task 7: Get Nth Fibonacci
    public static int getNthFibonacci(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n cannot be negative");
        }
        if (n <= 1) {
            return 1;  // Changed from return n - first two Fibonacci numbers are both 1
        }

        int a = 0, b = 1, c;
        for (int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return b;
    }
    

    // Task 8: Sort Array Descending
    public static void sortArrayDescending(int[] arr) {
        if (arr == null) {
            throw new IllegalArgumentException("Array cannot be null");
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] > arr[i]) {  // Changed from arr[j] < arr[i]
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    // Task 9: Find Longest Word
    public static String findLongestWord(String sentence) {
        if (sentence == null || sentence.isEmpty()) {
            throw new IllegalArgumentException("Sentence cannot be null or empty");
        }
        String[] words = sentence.split(" ");
        String longestWord = "";
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() > longestWord.length()) {  // Changed from >=
                longestWord = words[i];
            }
        }
        return longestWord;
    }

    // Task 10: Calculate Interest
    // Added negative validation for each
    public static double calculateInterest(double principal, double rate, int years) {
        if (principal < 0) {
            throw new IllegalArgumentException("Principal cannot be negative");
        }
        if (rate < 0) {
            throw new IllegalArgumentException("Rate cannot be negative");
        }
        if (years <= 0) {
            throw new IllegalArgumentException("Years must be positive");
        }
        for (int i = 0; i < years; i++) {
            principal += principal * (rate / 100);
        }
        return principal;
    }

    // Task 11: Parse Positive Integer
  
    public static int parsePositiveInteger(String str) {
        try {
            int number = Integer.parseInt(str);
            if (number <= 0) {
                throw new NumberFormatException("Number must be positive");
            }
            return number;
        } catch (NumberFormatException e) {
            return 1;  // Return default positive integer
        }
    }

    // Task 12: Get Array Element
    public static String getArrayElement(String[] arr, int index) {
        try {
            return arr[index];
        } catch (ArrayIndexOutOfBoundsException e) {
            return null;  // Return null for invalid index
        }
    }

    // Task 13: Calculate Square Root
    // BUG FIXED: Added validation to check for negative numbers
    // BUG FIXED: Throws IllegalArgumentException with descriptive message including NaN
    public static double calculateSquareRoot(int number) {
        if (number < 0) {
            throw new IllegalArgumentException(
                "Cannot calculate square root of a negative number. Result would be: " + Double.NaN
            );
        }
        return Math.sqrt(number);
    }

    // Task 14: Sum Array Elements
    public static int sumArrayElements(int[] array) {
        try {
            int sum = 0;
            for (int i = 0; i < array.length; i++) {
                sum += array[i];
            }
            return sum;
        } catch (NullPointerException e) {
            System.out.println("Error: Array is null");
            return 0;  // Return 0 for null array
        }
    }

    // Task 15: Calculate Power
    public static double calculatePower(double base, int exponent) {
        if (exponent < 0) {
            throw new IllegalArgumentException("Exponent cannot be negative");
        }
        return Math.pow(base, exponent);
    }
}
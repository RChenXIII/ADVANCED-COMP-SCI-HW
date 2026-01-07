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
}
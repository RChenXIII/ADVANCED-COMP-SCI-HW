public class Unit6Exercises {

    /**
     * Problem 1 - Factorial: Write a recursive and non-recursive method that returns the factorial
     * of a given number n.
     */
    public static int factorial(int n) {
        if (n < 0) {
            return 0;
        }
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static int factorialRecursive(int n) {
        if (n < 0) {
            return 0;
        }
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * factorialRecursive(n - 1);
    }

    /**
     * Problem 2 - Fibonacci Sequence: Write a recursive and non-recursive method that returns the
     * nth number in the Fibonacci sequence.
     */
    public static int fibonacci(int n) {
        if (n < 0) {
            return 0;
        }
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int prev = 0;
        int curr = 1;
        for (int i = 2; i <= n; i++) {
            int next = prev + curr;
            prev = curr;
            curr = next;
        }
        return curr;
    }

    public static int fibonacciRecursive(int n) {
        if (n < 0) {
            return 0;
        }
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    /**
     * Problem 3 - Sum of Digits: Write a recursive and non-recursive method that returns the sum of
     * the digits of a given integer.
     */
    public static int sumDigits(int n) {
        if (n < 0) {
            return 0;
        }
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

    public static int sumDigitsRecursive(int n) {
        if (n < 0) {
            return 0;
        }
        if (n == 0) {
            return 0;
        }
        return (n % 10) + sumDigitsRecursive(n / 10);
    }

    /**
     * Problem 4 - Count X: Write a recursive and non-recursive method that returns the count of
     * occurrences of 'x' in a given string.
     */
    public static int countX(String str) {
        int count = 0;
        for (char c : str.toCharArray()) {
            if (Character.toLowerCase(c) == 'x') {
                count++;
            }
        }
        return count;
    }

    public static int countXRecursive(String str) {
        if (str.length() == 0) {
            return 0;
        }
        int count = (Character.toLowerCase(str.charAt(0)) == 'x') ? 1 : 0;
        return count + countXRecursive(str.substring(1));
    }

    /**
     * Problem 5 - Reverse String: Write a recursive and non-recursive method that returns the
     * reverse of a given string.
     */
    public static String reverseString(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    public static String reverseStringRecursive(String str) {
        if (str.length() == 0) {
            return "";
        }
        return reverseStringRecursive(str.substring(1)) + str.charAt(0);
    }

    /**
     * Problem 6 - Power of a Number: Write a recursive and non-recursive method that calculates and
     * returns the value of base raised to the power of exponent.
     */
    public static int power(int base, int exponent) {
        int result = 1;
        for (int i = 0; i < exponent; i++) {
            result *= base;
        }
        return result;
    }

    public static int powerRecursive(int base, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        return base * powerRecursive(base, exponent - 1);
    }

    /**
     * Problem 7 - Palindrome Checker: Write a recursive and non-recursive method that checks
     * whether a given string is a palindrome.
     */
    public static boolean isPalindrome(String str) {
        String lower = str.toLowerCase();
        int left = 0;
        int right = lower.length() - 1;
        while (left < right) {
            if (lower.charAt(left) != lower.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static boolean isPalindromeRecursive(String str) {
        String lower = str.toLowerCase();
        if (lower.length() <= 1) {
            return true;
        }
        if (lower.charAt(0) != lower.charAt(lower.length() - 1)) {
            return false;
        }
        return isPalindromeRecursive(lower.substring(1, lower.length() - 1));
    }

    /**
     * Problem 8 - Greatest Common Divisor (GCD): Write a recursive and non-recursive method that
     * finds and returns the greatest common divisor of two numbers.
     */
    public static int gcd(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static int gcdRecursive(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        if (b == 0) {
            return a;
        }
        return gcdRecursive(b, a % b);
    }

    /**
     * Problem 9 - Bunny Ears 2: We have bunnies standing in a line, numbered 1, 2, ... The odd
     * bunnies (1, 3, ..) have the normal 2 ears. The even bunnies (2, 4, ..) we'll say have 3 ears,
     * because they each have a raised foot. Recursively return the number of "ears" in the bunny
     * line 1, 2, ... n (without loops or multiplication).
     */
    public static int bunnyEars(int bunnies) {
        int ears = 0;
        for (int i = 1; i <= bunnies; i++) {
            if (i % 2 == 1) {
                ears += 2;
            } else {
                ears += 3;
            }
        }
        return ears;
    }

    public static int bunnyEarsRecursive(int bunnies) {
        if (bunnies <= 0) {
            return 0;
        }
        if (bunnies % 2 == 1) {
            return 2 + bunnyEarsRecursive(bunnies - 1);
        } else {
            return 3 + bunnyEarsRecursive(bunnies - 1);
        }
    }

    /**
     * Problem 10 - Binary Search: Write a recursive and non-recursive method that implements the
     * binary search algorithm to find and return the index of a given element in a sorted array.
     */
    public static int binarySearch(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == key) {
                return mid;
            }
            if (arr[mid] < key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static int binarySearchRecursiveHelper(int[] arr, int key, int low, int high) {
        if (low > high) {
            return -1;
        }
        int mid = low + (high - low) / 2;
        if (arr[mid] == key) {
            return mid;
        }
        if (arr[mid] < key) {
            return binarySearchRecursiveHelper(arr, key, mid + 1, high);
        } else {
            return binarySearchRecursiveHelper(arr, key, low, mid - 1);
        }
    }

    // DO NOT EDIT! Work on the helper version above this method.
    // This method is to be used for testing purposes only.
    public static int binarySearchRecursive(int[] arr, int key) {
        return binarySearchRecursiveHelper(arr, key, 0, arr.length - 1);
    }
}
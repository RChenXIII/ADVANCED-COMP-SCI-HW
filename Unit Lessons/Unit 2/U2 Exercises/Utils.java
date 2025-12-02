public class Utils {
    
    // ========================================
    // ORIGINAL UTILS - Added for StudentRecord/Course Labs
    // ========================================
    
    public static String arrayToString(int[] arr) {
        if (arr == null || arr.length == 0) {
            return "[]";
        }
        
        String result = "[";
        for (int i = 0; i < arr.length; i++) {
            result += arr[i];
            if (i < arr.length - 1) {
                result += ", ";
            }
        }
        result += "]";
        return result;
    }
    
    public static String arrayToString(double[] arr) {
        if (arr == null || arr.length == 0) {
            return "[]";
        }
        
        String result = "[";
        for (int i = 0; i < arr.length; i++) {
            result += arr[i];
            if (i < arr.length - 1) {
                result += ", ";
            }
        }
        result += "]";
        return result;
    }
    
    public static String arrayToString(String[] arr) {
        if (arr == null || arr.length == 0) {
            return "[]";
        }
        
        String result = "[";
        for (int i = 0; i < arr.length; i++) {
            result += "\"" + arr[i] + "\"";
            if (i < arr.length - 1) {
                result += ", ";
            }
        }
        result += "]";
        return result;
    }
    
    public static boolean arraysEqual(int[] arr1, int[] arr2) {
        if (arr1 == null && arr2 == null) {
            return true;
        }
        
        if (arr1 == null || arr2 == null) {
            return false;
        }
        
        if (arr1.length != arr2.length) {
            return false;
        }
        
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        
        return true;
    }
    
    public static boolean arraysEqual(String[] arr1, String[] arr2) {
        if (arr1 == null && arr2 == null) {
            return true;
        }
        
        if (arr1 == null || arr2 == null) {
            return false;
        }
        
        if (arr1.length != arr2.length) {
            return false;
        }
        
        for (int i = 0; i < arr1.length; i++) {
            if (!arr1[i].equals(arr2[i])) {
                return false;
            }
        }
        
        return true;
    }
    
    public static double average(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0.0;
        }
        
        return (double) sum(arr) / arr.length;
    }
    
    public static int average(int[] arr, int first, int last) {
        if (arr == null || arr.length == 0 || first < 0 || last >= arr.length || first > last) {
            return 0;
        }
        
        int sum = 0;
        for (int i = first; i <= last; i++) {
            sum += arr[i];
        }
        return sum / (last - first + 1);
    }
    
    public static int sum(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }
    
    public static int max(int[] arr) {
        if (arr == null || arr.length == 0) {
            return Integer.MIN_VALUE;
        }
        
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
    
    public static int min(int[] arr) {
        if (arr == null || arr.length == 0) {
            return Integer.MAX_VALUE;
        }
        
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }
    
    public static boolean isSorted(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return true;
        }
        
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                return false;
            }
        }
        return true;
    }
    
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        
        int[] copy = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            copy[i] = arr[i];
        }
        return copy;
    }
    
    public static int[] sanitizeArray(int[] arr) {
        if (arr == null) {
            return new int[0];
        }
        
        int[] sanitized = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            sanitized[i] = arr[i] < 0 ? 0 : arr[i];
        }
        return sanitized;
    }
    
    public static boolean contains(int[] arr, int value) {
        return indexOf(arr, value) != -1;
    }
    
    public static int indexOf(int[] arr, int value) {
        if (arr == null) {
            return -1;
        }
        
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                return i;
            }
        }
        return -1;
    }
    
    public static int count(int[] arr, int value) {
        if (arr == null) {
            return 0;
        }
        
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                count++;
            }
        }
        return count;
    }
    
    public static void printArray(int[] arr) {
        System.out.println(arrayToString(arr));
    }
    
    public static void printArray(String[] arr) {
        System.out.println(arrayToString(arr));
    }
    
    // ========================================
    // UNIT 2 ADDITIONS - Added for Unit2Exercises
    // ========================================
    
    public static int countSubstring(String str, String target) {
        if (str == null || target == null || target.length() == 0) {
            return 0;
        }
        
        int count = 0;
        for (int i = 0; i <= str.length() - target.length(); i++) {
            if (str.substring(i, i + target.length()).equals(target)) {
                count++;
            }
        }
        return count;
    }
    
    public static boolean isWeekday(int day) {
        return day >= 1 && day <= 5;
    }
    
    public static boolean isWeekend(int day) {
        return day == 0 || day == 6;
    }
    
    public static boolean startsWith(String str, String prefix) {
        if (str == null || prefix == null || str.length() < prefix.length()) {
            return false;
        }
        return str.substring(0, prefix.length()).equals(prefix);
    }
    
    public static boolean endsWith(String str, String suffix) {
        if (str == null || suffix == null || str.length() < suffix.length()) {
            return false;
        }
        return str.substring(str.length() - suffix.length()).equals(suffix);
    }
    
    public static boolean allSame(int a, int b, int c) {
        return a == b && b == c;
    }
    
    public static int countEvens(int[] arr) {
        if (arr == null) {
            return 0;
        }
        
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                count++;
            }
        }
        return count;
    }
    
    public static int largestSpecial(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        
        int largest = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 10 == 0 && arr[i] > largest) {
                largest = arr[i];
            }
        }
        return largest;
    }
}
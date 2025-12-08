public class Utils {
    
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
            result += arr[i];
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
    
    public static boolean arraysEqual(double[] arr1, double[] arr2) {
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
        
        double sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum / arr.length;
    }
    
    public static double average(double[] arr) {
        if (arr == null || arr.length == 0) {
            return 0.0;
        }
        
        double sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum / arr.length;
    }
    
    public static double average(int[] arr, int first, int last) {
        if (arr == null || arr.length == 0 || first < 0 || last >= arr.length || first > last) {
            return 0.0;
        }
        
        double sum = 0;
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
    
    public static double sum(double[] arr) {
        if (arr == null || arr.length == 0) {
            return 0.0;
        }
        
        double sum = 0;
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
    
    public static int indexOfMax(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        
        int maxIndex = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[maxIndex]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }
    
    public static int indexOfMin(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        
        int minIndex = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[minIndex]) {
                minIndex = i;
            }
        }
        return minIndex;
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
    
    public static boolean isSortedDescending(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return true;
        }
        
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1]) {
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
        if (arr == null) {
            return false;
        }
        
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                return true;
            }
        }
        return false;
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
    
    public static void printArray(double[] arr) {
        System.out.println(arrayToString(arr));
    }
    
    public static void printArray(String[] arr) {
        System.out.println(arrayToString(arr));
    }
}
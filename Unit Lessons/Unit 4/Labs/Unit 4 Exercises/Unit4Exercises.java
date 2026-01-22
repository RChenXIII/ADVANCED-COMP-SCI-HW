import java.util.ArrayList;

public class Unit4Exercises {

    public static boolean matchingEndSequences(int[] nums, int n) {
        for (int i = 0; i < n; i++) {
            if (nums[i] != nums[nums.length - n + i]) {
                return false;
            }
        }
        return true;
    }

    public static boolean hasThreeConsecutive(int[] nums) {
        if (nums.length < 3) {
            return false;
        }
        
        for (int i = 0; i < nums.length - 2; i++) {
            int mod0 = nums[i] % 2;
            int mod1 = nums[i + 1] % 2;
            int mod2 = nums[i + 2] % 2;
            
            if (mod0 == mod1 && mod1 == mod2) {
                return true;
            }
        }
        return false;
    }

    public static int[] generateNumberSequence(int start, int end) {
        int size = end - start;
        if (size < 0) {
            size = 0;
        }
        int[] result = new int[size];
        
        for (int i = 0; i < size; i++) {
            result[i] = start + i;
        }
        
        return result;
    }

    public static String[] fizzBuzz(int start, int end) {
        int size = end - start;
        String[] result = new String[size];
        
        for (int i = 0; i < size; i++) {
            int num = start + i;
            
            if (num % 3 == 0 && num % 5 == 0) {
                result[i] = "FizzBuzz";
            } else if (num % 3 == 0) {
                result[i] = "Fizz";
            } else if (num % 5 == 0) {
                result[i] = "Buzz";
            } else {
                result[i] = String.valueOf(num);
            }
        }
        
        return result;
    }

    public static int[] moveEvenBeforeOdd(int[] nums) {
        int[] result = new int[nums.length];
        int index = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                result[index] = nums[i];
                index++;
            }
        }
        
        for (int i = 0; i < nums.length; i++) {
            int remainder = nums[i] % 2;
            if (remainder == 1 || remainder == -1) {
                result[index] = nums[i];
                index++;
            }
        }
        
        return result;
    }

    public static ArrayList<Integer> noNegatives(ArrayList<Integer> nums) {
        ArrayList<Integer> result = new ArrayList<>();
        
        for (int i = 0; i < nums.size(); i++) {
            if (nums.get(i) >= 0) {
                result.add(nums.get(i));
            }
        }
        
        return result;
    }

    public static ArrayList<Integer> excludeTeenNumbers(ArrayList<Integer> nums) {
        ArrayList<Integer> result = new ArrayList<>();
        
        for (int i = 0; i < nums.size(); i++) {
            int num = nums.get(i);
            if (num < 13 || num > 19) {
                result.add(num);
            }
        }
        
        return result;
    }

    public static ArrayList<String> appendY(ArrayList<String> strs) {
        ArrayList<String> result = new ArrayList<>();
        
        for (int i = 0; i < strs.size(); i++) {
            String str = strs.get(i);
            String withY = str + "y";
            
            if (!withY.contains("yy")) {
                result.add(withY);
            }
        }
        
        return result;
    }

    public static ArrayList<Integer> squarePlus10(ArrayList<Integer> nums) {
        ArrayList<Integer> result = new ArrayList<>();
        
        for (int i = 0; i < nums.size(); i++) {
            int num = nums.get(i);
            int squared = num * num + 10;
            int lastDigit = squared % 10;
            
            if (lastDigit != 5 && lastDigit != 6) {
                result.add(squared);
            }
        }
        
        return result;
    }
}
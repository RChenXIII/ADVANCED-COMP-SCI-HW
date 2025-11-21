public class Unit2Exercises {
    
    public static String alarmClock(int day, boolean vacation) {
        if (vacation) {
            return Utils.isWeekday(day) ? "10:00" : "off";
        }
        return Utils.isWeekday(day) ? "7:00" : "10:00";
    }

    public static boolean love6(int a, int b) {
        return a == 6 || b == 6 || a + b == 6 || Math.abs(a - b) == 6;
    }

    public static int redTicket(int a, int b, int c) {
        if (Utils.allSame(a, b, c)) {
            return a == 2 ? 10 : 5;
        }
        if (b != a && c != a) {
            return 1;
        }
        return 0;
    }

    public static String fizzString(String str) {
        boolean startsF = Utils.startsWith(str, "f");
        boolean endsB = Utils.endsWith(str, "b");
        
        if (startsF && endsB) {
            return "FizzBuzz";
        }
        if (startsF) {
            return "Fizz";
        }
        if (endsB) {
            return "Buzz";
        }
        return str;
    }

    public static String doubleChar(String str) {
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            result += str.substring(i, i + 1);
            result += str.substring(i, i + 1);
        }
        return result;
    }

    public static int countHi(String str) {
        return Utils.countSubstring(str, "hi");
    }

    public static boolean catDog(String str) {
        int cats = Utils.countSubstring(str, "cat");
        int dogs = Utils.countSubstring(str, "dog");
        return cats == dogs;
    }

    public static String mixString(String a, String b) {
        String result = "";
        int minLength = Math.min(a.length(), b.length());
        
        for (int i = 0; i < minLength; i++) {
            result += a.substring(i, i + 1);
            result += b.substring(i, i + 1);
        }
        
        if (a.length() > minLength) {
            result += a.substring(minLength);
        }
        if (b.length() > minLength) {
            result += b.substring(minLength);
        }
        
        return result;
    }

    public static String repeatEnd(String str, int n) {
        String ending = str.substring(str.length() - n);
        String result = "";
        for (int i = 0; i < n; i++) {
            result += ending;
        }
        return result;
    }

    public static boolean endOther(String a, String b) {
        String lowerA = a.toLowerCase();
        String lowerB = b.toLowerCase();
        
        return Utils.endsWith(lowerA, lowerB) || Utils.endsWith(lowerB, lowerA);
    }

    public static int countCode(String str) {
        int count = 0;
        for (int i = 0; i <= str.length() - 4; i++) {
            if (str.substring(i, i + 2).equals("co") && 
                str.substring(i + 3, i + 4).equals("e")) {
                count++;
            }
        }
        return count;
    }

    public static int countEvens(int[] nums) {
        return Utils.countEvens(nums);
    }

    public static int bigDiff(int[] nums) {
        return Utils.max(nums) - Utils.min(nums);
    }

    public static int sum13(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 13) {
                i++;
            } else {
                sum += nums[i];
            }
        }
        return sum;
    }

    public static int[] fizzArray(int n) {
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = i;
        }
        return result;
    }

    public static boolean haveThree(int[] nums) {
        int count = Utils.count(nums, 3);
        if (count != 3) {
            return false;
        }
        
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 3 && nums[i + 1] == 3) {
                return false;
            }
        }
        
        return true;
    }

    public static String[] fizzArray2(int n) {
        String[] result = new String[n];
        for (int i = 0; i < n; i++) {
            result[i] = String.valueOf(i);
        }
        return result;
    }

    public static int[] zeroFront(int[] nums) {
        int[] result = Utils.copyArray(nums);
        int insertPos = 0;
        
        for (int i = 0; i < result.length; i++) {
            if (result[i] == 0) {
                result[i] = result[insertPos];
                result[insertPos] = 0;
                insertPos++;
            }
        }
        
        return result;
    }

    public static String[] wordsWithout(String[] words, String target) {
        int count = 0;
        for (int i = 0; i < words.length; i++) {
            if (!words[i].equals(target)) {
                count++;
            }
        }
        
        String[] result = new String[count];
        int index = 0;
        for (int i = 0; i < words.length; i++) {
            if (!words[i].equals(target)) {
                result[index] = words[i];
                index++;
            }
        }
        
        return result;
    }

    public static int scoresAverage(int[] scores) {
        int firstHalf = Utils.average(scores, 0, scores.length / 2 - 1);
        int secondHalf = Utils.average(scores, scores.length / 2, scores.length - 1);
        return Math.max(firstHalf, secondHalf);
    }

    public static boolean scoresIncreasing(int[] scores) {
        return Utils.isSorted(scores);
    }

    public static int scoresSpecial(int[] a, int[] b) {
        return Utils.largestSpecial(a) + Utils.largestSpecial(b);
    }

    public static String firstTwo(String str) {
        if (str.length() >= 2) {
            return str.substring(0, 2);
        }
        if (str.length() == 1) {
            return str + "*";
        }
        return "**";
    }

    public static double divide(int a, int b) {
        int larger = Math.max(a, b);
        int smaller = Math.min(a, b);
        return (double) larger / smaller;
    }
}
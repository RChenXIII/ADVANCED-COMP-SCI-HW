public class ArrayOps {
    public static String printStringArray(String[] array) {
        if (array == null) {
            System.out.println("[]");
            return "[]";
        }

        String result = "[";
        for (int i = 0; i < array.length; i++) {
            result += array[i];
            if (i < array.length - 1) {
                result += ", ";
            }
        }
        result += "]";

        System.out.println(result);
        return result;
    }


    public static String printIntegerArray(int[] array) {
        if (array == null) {
            System.out.println("[]");
            return "[]";
        }

        String result = "[";
        for (int i = 0; i < array.length; i++) {
            result += array[i];
            if (i < array.length - 1) {
                result += ", ";
            }
        }
        result += "]";

        System.out.println(result);
        return result;
    }


    public static int findMax(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }

        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }


    public static String findLongestString(String[] array) {
        if (array == null || array.length == 0) {
            return "";
        }

        String longest = null;
        int maxLength = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] != null && array[i].length() > maxLength) {
                longest = array[i];
                maxLength = array[i].length();
            }
        }

        return longest == null ? "" : longest;
    }


    public static double averageStringLength(String[] array) {
        if (array == null || array.length == 0) {
            return 0.0;
        }

        int totalLength = 0;
        int count = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] != null) {
                totalLength += array[i].length();
                count++;
            }
        }

        if (count == 0) {
            return 0.0;
        }

        return (double) totalLength / count;
    }


    public static int[] countLetterFrequencies(String input) {
        if (input == null) {
            return new int[0];
        }

        int[] frequencies = new int[26];

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            char upper = Character.toUpperCase(c);


            if (upper >= 'A' && upper <= 'Z') {
                int index = upper - 'A';
                frequencies[index]++;
            }
        }

        return frequencies;
    }


    public static int[] removeIntAndScoot(int[] array, int index) {
        if (array == null || index < 0 || index >= array.length) {
            return array == null ? new int[0] : array;
        }


        for (int i = index; i < array.length - 1; i++) {
            array[i] = array[i + 1];
        }

        array[array.length - 1] = 0;

        return array;
    }


    public static int[] resizeIntArray(int[] array) {
        if (array == null) {
            return new int[0];
        }

        int[] newArray = new int[array.length * 2];

        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }

        return newArray;
    }


    public static String[] addNumToStringArray(String[] array) {
        if (array == null) {
            return new String[0];
        }

        for (int i = 0; i < array.length; i++) {
            if (array[i] != null) {
                array[i] = "#" + i + " " + array[i];
            }
        }

        return array;
    }


    public static int[] reverseIntArray(int[] array) {
        if (array == null) {
            return new int[0];
        }

        int[] reversed = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            reversed[i] = array[array.length - 1 - i];
        }

        return reversed;
    }
}

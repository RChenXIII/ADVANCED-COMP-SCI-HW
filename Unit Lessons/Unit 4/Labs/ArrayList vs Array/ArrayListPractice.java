import java.util.ArrayList;

public class ArrayListPractice {

    public static void main(String[] args) {
        ArrayList<String> fruitList = new ArrayList<String>();
        fruitList.add("apple");
        fruitList.add("pear");
        fruitList.add("banana");
        fruitList.add("grape");
        fruitList.add("peach");
        fruitList.add("pineapple");
        fruitList.add("orange");

        ArrayList<String> fruitList2 = new ArrayList<String>();
        fruitList2.add("apple");
        fruitList2.add("pear");
        fruitList2.add("banana");
        fruitList2.add("grape");
        fruitList2.add("peach");
        fruitList2.add("pineapple");
        fruitList2.add("orange");

        System.out.println("Odd length count: " + countOddLength(fruitList));
        System.out.println("Odd length count: " + countOddLengthForEachLoop(fruitList));

        System.out.println("removeString method - from the front of the Arraylist");
        removeStrings(fruitList, 'p');
        System.out.println(fruitList);

        System.out.println("removeString method - from the end of the Arraylist");
        removeStrings2(fruitList2, 'p');
        System.out.println(fruitList2);

        ArrayList numberList = new ArrayList<Integer>();
        numberList.add(5);
        numberList.add(6);
        numberList.add(5);
        numberList.add(3);
        numberList.add(3);
        numberList.add(5);
        numberList.add(2);
        System.out.println("number of fives: " + numCount(numberList, 5));

    }

    // returns the number of Strings in the ArrayList with an odd length.
    public static int countOddLength(ArrayList<String> list) {
        if (list == null) {
            throw new IllegalArgumentException("list cannot be null");
        }
        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            if (s == null) {
                throw new IllegalArgumentException("list contains null element");
            }
            if (s.length() % 2 != 0) {
                count++;
            }
        }
        return count;
    }

    // returns the number of Strings in the ArrayList with an odd length using a
    // For-Each Loop.
    public static int countOddLengthForEachLoop(ArrayList<String> list) {
        if (list == null) {
            throw new IllegalArgumentException("list cannot be null");
        }
        int count = 0;
        for (String s : list) {
            if (s == null) {
                throw new IllegalArgumentException("list contains null element");
            }
            if (s.length() % 2 != 0) {
                count++;
            }
        }
        return count;
    }

    // removes all Strings in the ArrayList that begin with the same letter as
    // firstLetter. Remove
    // them by iterating from the beginning of the list.
    public static void removeStrings(ArrayList<String> list, char firstLetter) {
        if (list == null) {
            throw new IllegalArgumentException("list cannot be null");
        }

        int i = 0;
        while (i < list.size()) {
            String s = list.get(i);
            if (s == null) {
                throw new IllegalArgumentException("list contains null element");
            }
            if (s.length() > 0 && s.charAt(0) == firstLetter) {
                list.remove(i);
            } else {
                i++;
            }
        }
    }

    // removes all Strings in the ArrayList that begin with the same letter as
    // firstLetter. Remove
    // them by iterating from the end of the list.
    public static void removeStrings2(ArrayList<String> list, char firstLetter) {
        if (list == null) {
            throw new IllegalArgumentException("list cannot be null");
        }

        for (int i = list.size() - 1; i >= 0; i--) {
            String s = list.get(i);
            if (s == null) {
                throw new IllegalArgumentException("list contains null element");
            }
            if (s.length() > 0 && s.charAt(0) == firstLetter) {
                list.remove(i);
            }
        }
    }

    // counts and returns the number of times a the integer number is found in the
    // ArrayList. It
    // iterates through the list using a For-Each Loop.
    public static int numCount(ArrayList<Integer> list, int number) {
        if (list == null) {
            throw new IllegalArgumentException("list cannot be null");
        }
        int count = 0;
        for (Integer n : list) {
            if (n == null) {
                throw new IllegalArgumentException("list contains null element");
            }
            if (n == number) {
                count++;
            }
        }
        return count;
    }

}

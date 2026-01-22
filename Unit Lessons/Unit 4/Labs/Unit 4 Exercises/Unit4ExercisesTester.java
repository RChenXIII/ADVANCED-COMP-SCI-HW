import java.util.ArrayList;
import java.util.Arrays;

public class Unit4ExercisesTester {
    
    public static void main(String[] args) {
        System.out.println("=== Testing Array Methods ===\n");
        testMatchingEndSequences();
        testHasThreeConsecutive();
        testGenerateNumberSequence();
        testFizzBuzz();
        testMoveEvenBeforeOdd();
        
        System.out.println("\n=== Testing ArrayList Methods ===\n");
        testNoNegatives();
        testExcludeTeenNumbers();
        testAppendY();
        testSquarePlus10();
    }
    
    public static void testMatchingEndSequences() {
        System.out.println("Testing matchingEndSequences:");
        
        int[] arr = {5, 6, 45, 99, 13, 5, 6};
        System.out.println("Expected false: " + Unit4Exercises.matchingEndSequences(arr, 1));
        System.out.println("Expected true: " + Unit4Exercises.matchingEndSequences(arr, 2));
        System.out.println("Expected false: " + Unit4Exercises.matchingEndSequences(arr, 3));
        System.out.println();
    }
    
    public static void testHasThreeConsecutive() {
        System.out.println("Testing hasThreeConsecutive:");
        
        System.out.println("Expected true: "
            + Unit4Exercises.hasThreeConsecutive(new int[]{2, 1, 3, 5}));
        System.out.println("Expected false: "
            + Unit4Exercises.hasThreeConsecutive(new int[]{2, 1, 2, 5}));
        System.out.println("Expected true: "
            + Unit4Exercises.hasThreeConsecutive(new int[]{2, 4, 2, 5}));
        System.out.println();
    }
    
    public static void testGenerateNumberSequence() {
        System.out.println("Testing generateNumberSequence:");
        
        System.out.println("Expected [5, 6, 7, 8, 9]: "
            + Arrays.toString(Unit4Exercises.generateNumberSequence(5, 10)));
        System.out.println("Expected [11, 12, 13, 14, 15, 16, 17]: "
            + Arrays.toString(Unit4Exercises.generateNumberSequence(11, 18)));
        System.out.println("Expected [1, 2]: "
            + Arrays.toString(Unit4Exercises.generateNumberSequence(1, 3)));
        System.out.println();
    }
    
    public static void testFizzBuzz() {
        System.out.println("Testing fizzBuzz:");
        
        System.out.println("Expected [1, 2, Fizz, 4, Buzz]: "
            + Arrays.toString(Unit4Exercises.fizzBuzz(1, 6)));
        System.out.println("Expected [1, 2, Fizz, 4, Buzz, Fizz, 7]: "
            + Arrays.toString(Unit4Exercises.fizzBuzz(1, 8)));
        System.out.println("Expected [1, 2, Fizz, 4, Buzz, Fizz, 7, 8, Fizz, Buzz]: "
            + Arrays.toString(Unit4Exercises.fizzBuzz(1, 11)));
        System.out.println();
    }
    
    public static void testMoveEvenBeforeOdd() {
        System.out.println("Testing moveEvenBeforeOdd:");
        
        System.out.println("Expected [0, 0, 0, 1, 1, 1, 1]: "
            + Arrays.toString(Unit4Exercises.moveEvenBeforeOdd(
                new int[]{1, 0, 1, 0, 0, 1, 1})));
        System.out.println("Expected [2, 3, 3]: "
            + Arrays.toString(Unit4Exercises.moveEvenBeforeOdd(new int[]{3, 3, 2})));
        System.out.println("Expected [2, 2, 2]: "
            + Arrays.toString(Unit4Exercises.moveEvenBeforeOdd(new int[]{2, 2, 2})));
        System.out.println();
    }
    
    public static void testNoNegatives() {
        System.out.println("Testing noNegatives:");
        
        ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(1, -2));
        System.out.println("Expected [1]: " + Unit4Exercises.noNegatives(list1));
        
        ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(-3, -3, 3, 3));
        System.out.println("Expected [3, 3]: " + Unit4Exercises.noNegatives(list2));
        
        ArrayList<Integer> list3 = new ArrayList<>(Arrays.asList(-1, -1, -1));
        System.out.println("Expected []: " + Unit4Exercises.noNegatives(list3));
        System.out.println();
    }
    
    public static void testExcludeTeenNumbers() {
        System.out.println("Testing excludeTeenNumbers:");
        
        ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(12, 13, 19, 20));
        System.out.println("Expected [12, 20]: " + Unit4Exercises.excludeTeenNumbers(list1));
        
        ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(1, 14, 1));
        System.out.println("Expected [1, 1]: " + Unit4Exercises.excludeTeenNumbers(list2));
        
        ArrayList<Integer> list3 = new ArrayList<>(Arrays.asList(15));
        System.out.println("Expected []: " + Unit4Exercises.excludeTeenNumbers(list3));
        System.out.println();
    }
    
    public static void testAppendY() {
        System.out.println("Testing appendY:");
        
        ArrayList<String> list1 = new ArrayList<>(Arrays.asList("a", "b", "c"));
        System.out.println("Expected [ay, by, cy]: " + Unit4Exercises.appendY(list1));
        
        ArrayList<String> list2 = new ArrayList<>(Arrays.asList("a", "b", "cy"));
        System.out.println("Expected [ay, by]: " + Unit4Exercises.appendY(list2));
        
        ArrayList<String> list3 = new ArrayList<>(Arrays.asList("xx", "ya", "zz"));
        System.out.println("Expected [xxy, yay, zzy]: " + Unit4Exercises.appendY(list3));
        System.out.println();
    }
    
    public static void testSquarePlus10() {
        System.out.println("Testing squarePlus10:");
        
        ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(3, 1, 4));
        System.out.println("Expected [19, 11]: " + Unit4Exercises.squarePlus10(list1));
        
        ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(1));
        System.out.println("Expected [11]: " + Unit4Exercises.squarePlus10(list2));
        
        ArrayList<Integer> list3 = new ArrayList<>(Arrays.asList(2));
        System.out.println("Expected [14]: " + Unit4Exercises.squarePlus10(list3));
        System.out.println();
    }
}
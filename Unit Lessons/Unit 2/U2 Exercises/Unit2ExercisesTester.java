public class Unit2ExercisesTester {
    public static void main(String[] args) {
        System.out.println("=== Testing alarmClock ===");
        System.out.println(Unit2Exercises.alarmClock(1, false) + " (expected: 7:00)");
        System.out.println(Unit2Exercises.alarmClock(5, false) + " (expected: 7:00)");
        System.out.println(Unit2Exercises.alarmClock(0, false) + " (expected: 10:00)");
        System.out.println(Unit2Exercises.alarmClock(1, true) + " (expected: 10:00)");
        System.out.println(Unit2Exercises.alarmClock(0, true) + " (expected: off)");

        System.out.println("=== Testing love6 ===");
        System.out.println(Unit2Exercises.love6(6, 4) + " (expected: true)");
        System.out.println(Unit2Exercises.love6(4, 5) + " (expected: false)");
        System.out.println(Unit2Exercises.love6(1, 5) + " (expected: true)");

        System.out.println("=== Testing redTicket ===");
        System.out.println(Unit2Exercises.redTicket(2, 2, 2) + " (expected: 10)");
        System.out.println(Unit2Exercises.redTicket(2, 2, 1) + " (expected: 0)");
        System.out.println(Unit2Exercises.redTicket(0, 0, 0) + " (expected: 5)");

        System.out.println("=== Testing fizzString ===");
        System.out.println(Unit2Exercises.fizzString("fig") + " (expected: Fizz)");
        System.out.println(Unit2Exercises.fizzString("dib") + " (expected: Buzz)");
        System.out.println(Unit2Exercises.fizzString("fib") + " (expected: FizzBuzz)");

        System.out.println("=== Testing doubleChar ===");
        System.out.println(Unit2Exercises.doubleChar("The") + " (expected: TThhee)");
        System.out.println(Unit2Exercises.doubleChar("AAbb") + " (expected: AAAAbbbb)");
        System.out.println(Unit2Exercises.doubleChar("Hi-There") + " (expected: HHii--TThheerree)");

        System.out.println("=== Testing countHi ===");
        System.out.println(Unit2Exercises.countHi("abc hi ho") + " (expected: 1)");
        System.out.println(Unit2Exercises.countHi("ABChi hi") + " (expected: 2)");
        System.out.println(Unit2Exercises.countHi("hihi") + " (expected: 2)");

        System.out.println("=== Testing catDog ===");
        System.out.println(Unit2Exercises.catDog("catdog") + " (expected: true)");
        System.out.println(Unit2Exercises.catDog("catcat") + " (expected: false)");
        System.out.println(Unit2Exercises.catDog("1cat1cadodog") + " (expected: true)");

        System.out.println("=== Testing mixString ===");
        System.out.println(Unit2Exercises.mixString("abc", "xyz") + " (expected: axbycz)");
        System.out.println(Unit2Exercises.mixString("Hi", "There") + " (expected: HTihere)");
        System.out.println(Unit2Exercises.mixString("xxxx", "There") + " (expected: xTxhxexre)");

        System.out.println("=== Testing repeatEnd ===");
        System.out.println(Unit2Exercises.repeatEnd("Hello", 3) + " (expected: llollollo)");
        System.out.println(Unit2Exercises.repeatEnd("Hello", 2) + " (expected: lolo)");
        System.out.println(Unit2Exercises.repeatEnd("Hello", 1) + " (expected: o)");

        System.out.println("=== Testing endOther ===");
        System.out.println(Unit2Exercises.endOther("Hiabc", "abc") + " (expected: true)");
        System.out.println(Unit2Exercises.endOther("AbC", "HiaBc") + " (expected: true)");
        System.out.println(Unit2Exercises.endOther("abc", "abXabc") + " (expected: true)");

        System.out.println("=== Testing countCode ===");
        System.out.println(Unit2Exercises.countCode("aaacodebbb") + " (expected: 1)");
        System.out.println(Unit2Exercises.countCode("codexxcode") + " (expected: 2)");
        System.out.println(Unit2Exercises.countCode("cozexxcope") + " (expected: 2)");

        System.out.println("=== Testing countEvens ===");
        System.out.println(Unit2Exercises.countEvens(new int[] {2, 1, 2, 3, 4}) + " (expected: 3)");
        System.out.println(Unit2Exercises.countEvens(new int[] {2, 2, 0}) + " (expected: 3)");
        System.out.println(Unit2Exercises.countEvens(new int[] {1, 3, 5}) + " (expected: 0)");

        System.out.println("=== Testing bigDiff ===");
        System.out.println(Unit2Exercises.bigDiff(new int[] {10, 3, 5, 6}) + " (expected: 7)");
        System.out.println(Unit2Exercises.bigDiff(new int[] {7, 2, 10, 9}) + " (expected: 8)");
        System.out.println(Unit2Exercises.bigDiff(new int[] {2, 10, 7, 2}) + " (expected: 8)");

        System.out.println("=== Testing sum13 ===");
        System.out.println(Unit2Exercises.sum13(new int[] {1, 2, 2, 1}) + " (expected: 6)");
        System.out.println(Unit2Exercises.sum13(new int[] {1, 1}) + " (expected: 2)");
        System.out.println(Unit2Exercises.sum13(new int[] {1, 2, 2, 1, 13}) + " (expected: 6)");

        System.out.println("=== Testing fizzArray ===");
        Utils.printArray(Unit2Exercises.fizzArray(4));
        System.out.println("(expected: [0, 1, 2, 3])");
        Utils.printArray(Unit2Exercises.fizzArray(1));
        System.out.println("(expected: [0])");

        System.out.println("=== Testing haveThree ===");
        System.out
                .println(Unit2Exercises.haveThree(new int[] {3, 1, 3, 1, 3}) + " (expected: true)");
        System.out.println(Unit2Exercises.haveThree(new int[] {3, 1, 3, 3}) + " (expected: false)");
        System.out.println(
                Unit2Exercises.haveThree(new int[] {3, 4, 3, 3, 4}) + " (expected: false)");

        System.out.println("=== Testing fizzArray2 ===");
        Utils.printArray(Unit2Exercises.fizzArray2(4));
        System.out.println("(expected: [\"0\", \"1\", \"2\", \"3\"])");
        Utils.printArray(Unit2Exercises.fizzArray2(2));
        System.out.println("(expected: [\"0\", \"1\"])");

        System.out.println("=== Testing zeroFront ===");
        Utils.printArray(Unit2Exercises.zeroFront(new int[] {1, 0, 0, 1}));
        System.out.println("(expected: [0, 0, 1, 1])");
        Utils.printArray(Unit2Exercises.zeroFront(new int[] {0, 1, 1, 0, 1}));
        System.out.println("(expected: [0, 0, 1, 1, 1])");
        Utils.printArray(Unit2Exercises.zeroFront(new int[] {1, 0}));
        System.out.println("(expected: [0, 1])");

        System.out.println("=== Testing wordsWithout ===");
        Utils.printArray(Unit2Exercises.wordsWithout(new String[] {"a", "b", "c", "a"}, "a"));
        System.out.println("(expected: [\"b\", \"c\"])");
        Utils.printArray(Unit2Exercises.wordsWithout(new String[] {"a", "b", "c", "a"}, "b"));
        System.out.println("(expected: [\"a\", \"c\", \"a\"])");

        System.out.println("=== Testing scoresAverage ===");
        System.out.println(Unit2Exercises.scoresAverage(new int[] {2, 2, 4, 4}) + " (expected: 4)");
        System.out.println(
                Unit2Exercises.scoresAverage(new int[] {4, 4, 4, 2, 2, 2}) + " (expected: 4)");
        System.out.println(
                Unit2Exercises.scoresAverage(new int[] {3, 4, 5, 1, 2, 3}) + " (expected: 4)");

        System.out.println("=== Testing scoresIncreasing ===");
        System.out.println(
                Unit2Exercises.scoresIncreasing(new int[] {1, 3, 4}) + " (expected: true)");
        System.out.println(
                Unit2Exercises.scoresIncreasing(new int[] {1, 3, 2}) + " (expected: false)");
        System.out.println(
                Unit2Exercises.scoresIncreasing(new int[] {1, 1, 4}) + " (expected: true)");

        System.out.println("=== Testing scoresSpecial ===");
        System.out
                .println(Unit2Exercises.scoresSpecial(new int[] {12, 10, 4}, new int[] {2, 20, 30})
                        + " (expected: 40)");
        System.out
                .println(Unit2Exercises.scoresSpecial(new int[] {20, 10, 4}, new int[] {2, 20, 10})
                        + " (expected: 40)");
        System.out
                .println(Unit2Exercises.scoresSpecial(new int[] {12, 11, 4}, new int[] {2, 20, 31})
                        + " (expected: 20)");

        System.out.println("=== Testing firstTwo ===");
        System.out.println(Unit2Exercises.firstTwo("hello") + " (expected: he)");
        System.out.println(Unit2Exercises.firstTwo("hi") + " (expected: hi)");
        System.out.println(Unit2Exercises.firstTwo("h") + " (expected: h*)");
        System.out.println(Unit2Exercises.firstTwo("") + " (expected: **)");

        System.out.println("=== Testing divide ===");
        System.out.println(Unit2Exercises.divide(5, 2) + " (expected: 2.5)");
        System.out.println(Unit2Exercises.divide(2, 5) + " (expected: 2.5)");
        System.out.println(Unit2Exercises.divide(4, 2) + " (expected: 2.0)");
        System.out.println(Unit2Exercises.divide(10, 55) + " (expected: 5.5)");
    }
}

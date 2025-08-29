public class ConditionalChallenge {
    public static void main(String[] args) {
        // part 1: temp converter
        double temperature = 32;
        boolean isCold = true;

        if (isCold) {
            temperature = temperature - 15;
            System.out.println("It is " + temperature + " degrees.");
        } else {
            temperature = temperature + 10;
            System.out.println("It is " + temperature + " degrees.");
        }
        // part 2: grade calc
        int score = 97;

        if (score >= 70) {
            System.out.println("Passed: " + score);
        }
        if (score < 70) {
            System.out.println("Failed: " + score);
        }
        // Part 3: Leap Year Checker
        int seasonTemp = 55;

        if (seasonTemp >= 80) {
            System.out.println("Summer");
        } else if (seasonTemp < 80 && seasonTemp >= 60) {
            System.out.println("Spring");
        } else if (seasonTemp < 60 && seasonTemp >= 40) {
            System.out.println("Fall");
        } else if (seasonTemp < 40) {
            System.out.println("Winter");
        }
        System.out.println(temperature);
        // Part 4: Number Calculator
        int number = 123;

        if (number > 0) {
            System.out.println("Positive");
        } else if (number == 0) {
            System.out.println("Zero");
        } else if (number < 0) {
            System.out.println("Negative");
        }
        if (number > 100) {
            System.out.println("Large");
        } else if (number < -100) {
            System.out.println("Very Negative");
        }
    }
}

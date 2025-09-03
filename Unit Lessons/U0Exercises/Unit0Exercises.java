// Solution: Unit 0 Exercises
public class Unit0Exercises {


    public static void main(String[] args) {
        Unit0Exercises obj = new Unit0Exercises();
        System.out.println();

        // testing sleepIn() method
        System.out.println(obj.sleepIn(false, false)); // output: true
        System.out.println(obj.sleepIn(true, true));
        // sleepIn(true, false) -> false
        // sleepIn(false, true) -> true

        // testing diff21() method
        System.out.println(obj.diff21(17)); // ouput: 2
        // diff21(10) -> 11
        // diff21(21) -> 0

        // testing flooringCalculator() method
        System.out.println(obj.flooringCalculator(500, -3)); // output: 1250.0
        // flooringCalculator(0, 3.0) -> 0.0
        // flooringCalculator(100, -1.5) -> 0.0

    }

    public boolean sleepIn(boolean weekday, boolean vacation) {
        if (weekday && vacation) {
            return true;
        } else if (vacation) {
            return true;
        } else if (weekday == false) {
            return true;
        }
        return false;
    }

    public int diff21(int n) {
        if (n > 21) {
            n = (n - 21) * 2;
        } else if (n <= 21) {
            n = 21 - n;
        }
        return n;
    }

    public double flooringCalculator(int sqft, double pricePerSqft) {
        double num = sqft * pricePerSqft;
        if (num <= 0) {
            return 0.0;
        }
        return num;
    }

}

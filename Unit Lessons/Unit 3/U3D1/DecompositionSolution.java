public class DecompositionSolution {
    public static void run() {
        int[] hours = hoursArray();
        int[] steps = stepsArray();
        int[] activeMinutes = activeMinutesArray();
        if (!lengthValidator(hours, steps, activeMinutes)) {
            System.out.println("Invalit input: arrays must be same length.");
            return;

        int totalSteps = sum(steps);
        double average = average(steps); 

        int totalActiveMinutes = sum(activeMinutes);
        double averageActiveMinutes = average(activeMinutes);
        int activeHalfHourCount = countHalfHours(activeMinutes);
        }
    }
    
    

    // Methods have to have single purpose

    public static int[] hoursArray() {
        return new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 };
    }

    public static int[] stepsArray() {
        return new int[] { 120, 90, 60, 50, 80, 300, 1200, 2200, 2800, 2500, 1800, 900 };
    }

    public static int[] activeMinutesArray() {
        return new int[] { 2, 1, 0, 0, 1, 10, 35, 50, 55, 48, 32, 15 };
    }

    public static boolean lengthValidator(int[] array1, int[] array2, int[] array3) {
        return array1.length == array2.length && array2.length == array3.length;
    }

    public static int sum(int[] array) {
        int sumTotal = 0;
        for (int i = 0; i < array.length; i ++) {
            sumTotal += array[i];
        }
        return sumTotal;
    }

    public static double average(int[] array) {
        int total = sum(array);
        return total / array.length;
    }

    public static int thresholdCounter(int[] array, int value) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] >= value) {
                count++;
            }
        }
        return count;
    }
    
    public static int countHalfHours(int[] array) {
        return thresholdCounter(array, 30);
    }

    public static int morningAverage(int[] array) {

    }
}


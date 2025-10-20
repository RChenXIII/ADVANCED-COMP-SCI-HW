public class Loops {
    public static void main(String[] args) {

        int count = 1;
        while (count < 10) {
            System.out.println(count);
            count++;

        }

        boolean isRunning = true;
        while (isRunning) {
            count++;
            if (count == 100) {
                isRunning = false;
            }

            // a for loop is best when you know the exact number of iterations (repetitions)
            // a for loop is more compact with its syntax

            // a while loop is best when you DON'T know the exact number of repetitions
            // a while loops requires the initialization to be outside of the loop, and the iterator
            // to be updated inside the loop

        }

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.println("Hi");
            }
        }
    }
}

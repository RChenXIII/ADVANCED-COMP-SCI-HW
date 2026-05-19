public class RecursionDemo {
    public static void main(String[] args) {

    }
    public int factorial(int value) {
        if (value == 0) {
            return 1;
        }
        return value * factorial(value - 1);
    }
} 
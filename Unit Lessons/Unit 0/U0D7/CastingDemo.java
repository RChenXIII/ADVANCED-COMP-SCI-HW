public class CastingDemo {
    public static void main(String[] args) {

        // implicit casting
        // storing smaller data types into larger ones
        // happens automatically

        int smallNumber = 100;
        long bigNumber = smallNumber;
        float decimalNumber = bigNumber;
        double largeDecimal = decimalNumber;

        // explicit casting
        // manually converting data type usually to a different data type that may incur data loss

        double pi = 3.14159;
        int engineerPi = (int) pi;
        System.out.println(engineerPi); // truncation - lost all decimals
        pi = engineerPi;
        System.out.println(pi);

        long population = 800000000L;
        int limitedPopulation = (int) population;

        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);

        int letterA = 'a';
        
        System.out.println(letterA + 3);

        // no implicit or explicit casting between booleans and integers
    }
}
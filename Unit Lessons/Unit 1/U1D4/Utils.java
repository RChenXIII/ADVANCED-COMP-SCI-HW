public class Utils {
    public static void main(String[] args) {

        // a class that contains a list of characters to form words
        // it gives strings methods that we can use!
        String x = "hello";

        int y = 10; // primitive and do not have methods

        // Integer Wrapper
        Integer yWrapper = 10;
        yWrapper.toString();
        Integer.parseInt("123");

        // Boolean Wrapper
        boolean isFalse = false;
        Boolean isTrue = true;

        isTrue.toString();
        System.out.println(Boolean.parseBoolean("true"));

        // Double Wrapper
        double decimal = 1.1;
        Double decimalWrapper = 1.1;
        System.out.println(Double.parseDouble("13.76"));

    }
}

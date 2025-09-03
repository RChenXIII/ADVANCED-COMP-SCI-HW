public class HelloWorld {
    // A class is a collection of related attributes and behaviors

    public static void main(String[] args) {
        // Main is an entry point for your computer to start running code
        System.out.println("Hello World");
        System.out.println("My name is Ryan");

        System.out.print("My favorite pizza topping is pepperoni. ");
        System.out.print("I don't like caffinated drinks.");

        int number = 5;
        char letter = 'a';
        boolean isTrue = true;
        float decimal = 50.0f;
        double bigDecimal = 0.6;
        byte age = 25;
        long biginteger = 1000000;
        short shortInteger = 1;
        String myName = "Ryan"; // String is a CLASS not a primitive data type
        // a collection of primitive characters to describe text

        System.out.println("Hello my name is " + myName + ".");

        if (number == 6) {
            System.out.println(number);
        } else {
            System.out.println(letter);
        }
        if (isTrue) {
            System.out.println("no");
        } else {
            System.out.println("Yes");
        }
        // Challenge complete
        int appleCount = 3;
        if (appleCount == 5 || appleCount == 10) {
            System.out.println("You ate " + appleCount + " apples.");
        } else {
            System.out.println("The apples died");
        }
    }

}

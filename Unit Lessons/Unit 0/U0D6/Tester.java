public class Tester {
    public static void main(String[] args) {

        // Parenthesis, brackets, member access(methods)
        String demo = "hello";
        System.out.println(5 * demo.length());

        // Exponents
        Math.pow(2, 4);

        // Multiplication, division, modular arithmetic
        System.out.println(5 * 4 + (5 / 6) + 7 % 1);

        // Addition and subtraction
        System.out.println(5 - 6 + 9);

        // Relational Operators
        System.out.println(6 < 7);

        // Comparison operators
        System.out.println(8 == 9);

        System.out.println((3 + Integer.parseInt("123")) * 9 / 8 + 7 >= 5);

        // challenge
        // 1. parseInt = 123
        // 2. +3 = 126
        // 3. *9 = 1134
        // 4. /8 = 141
        // 5. +7 = 148
        // 6. >=5 = true
        // 7. Print = "true"
    }
}

public class RectangleTester {
    public static void main(String[] args) {
        Rectangle rect = new Rectangle();
        Rectangle rect2 = new Rectangle();

        rect2.setLength(5);
        rect2.setWidth(1);

        System.out.println(rect.toString());

        System.out.println(rect.equals(rect2));

        System.out.println("The area of the rectangle is " + rect.calculateArea());

        System.out.println("The perimeter of the rectangle is " + rect.calculatePerimeter());

        System.out.println("The diagonal of the rectangle is " + rect.calculateDiagonal());
    }
}

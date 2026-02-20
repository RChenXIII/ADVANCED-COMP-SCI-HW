public class Rectangle extends Polygon {
    private double length;
    private double width;

    public Rectangle(double width, double length) {
        super(4);
        this.length = length;
        this.width = width;
    }

    public Rectangle() {
        super(4);
        this.length = 4;
        this.width = 3;
    }

    public double getArea() {
        return length * width;
    }

    public String toString() {
        return super.toString() + "\nIt is a rectangle with a length of " + length
                + " and width of " + width + ". Its area is " + getArea() + ".";
    }
}

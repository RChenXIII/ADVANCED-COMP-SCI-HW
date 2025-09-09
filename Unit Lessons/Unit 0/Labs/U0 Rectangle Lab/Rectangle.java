public class Rectangle {
    public int length;
    public int width;

    // constructors
    public Rectangle(int newLength, int newWidth) {
        length = newLength;
        width = newWidth;
    }

    public Rectangle() {
        length = 1;
        width = 5;
    }

    // getters
    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    // setters
    public void setLength(int input) {
        length = input;
    }

    public void setWidth(int input) {
        width = input;
    }

    // methods
    public String toString() {
        return ("This is a rectangle. Its area is " + (length * width));
    }
    public boolean equals(Rectangle other) {
        return length == other.length && width == other.width;
    }

    public int calculateArea() {
        return length * width;
    }

    public int calculatePerimeter() {
        return 2 * width + 2 * length;
    }

    public double calculateDiagonal() {
        return Math.sqrt((width * width) + (length * length));
    }
    // getters

    // setters
}

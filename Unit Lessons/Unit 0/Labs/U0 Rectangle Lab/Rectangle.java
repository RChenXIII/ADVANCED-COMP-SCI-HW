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
        width = 1;
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
        return ("This is a rectangle" + (length * width));
    }
}

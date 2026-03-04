import java.awt.*;

public class Triangle extends Shape {

    // 2-param constructor initializes coordinate arrays in super
    public Triangle(int[] xCoord, int[] yCoord) {
        super(xCoord, yCoord);
    }

    public Triangle() {
        this(new int[] {0, 50, 100}, new int[] {0, 75, 50});
    }

    // get the area of the triangle using the 3 coordinates
    public double getArea() {
        return Math.abs((xCoord[0] * (yCoord[1] - yCoord[2]) + xCoord[1] * (yCoord[2] - yCoord[0])
                + xCoord[2] * (yCoord[0] - yCoord[1])) / 2);
    }

    public String toString() {
        return super.toString() + " This shape is a triangle with coordinates (" + xCoord[0] + ", "
                + yCoord[0] + "), (" + xCoord[1] + ", " + yCoord[1] + "), and (" + xCoord[2] + ", "
                + yCoord[2] + ").";
    }


    // draw the triangle using inherited coordinate arrays and style properties
    public void draw(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;

        // fill color (use yellow default if none specified)
        Color fill = (fillColor != null) ? fillColor : Color.yellow;
        g2D.setPaint(fill);
        g.fillPolygon(xCoord, yCoord, xCoord.length);

        // stroke color and width
        Color stroke = (strokeColor != null) ? strokeColor : Color.black;
        g2D.setPaint(stroke);
        int sw = (strokeWidth > 0) ? strokeWidth : 1;
        g2D.setStroke(new BasicStroke(sw));
        g.drawPolygon(xCoord, yCoord, xCoord.length);
    }

}

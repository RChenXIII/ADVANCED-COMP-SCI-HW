import java.awt.Graphics;

public abstract class Shape {

    protected int xCoord;
    protected int yCoord;

    public Shape(int xCoord, int yCoord) {
        this.xCoord = xCoord;
        this.yCoord = yCoord;
    }

    abstract public double getArea();

    abstract public void draw(Graphics g);



    public void setCoordinates(int xCoord, int yCoord) {
        this.xCoord = xCoord;
        this.yCoord = yCoord;
    }


    public String toString() {
        return "This is a Polygon.";
    }
}

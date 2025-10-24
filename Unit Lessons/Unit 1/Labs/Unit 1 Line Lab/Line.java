public class Line {
    public int a;
    public int b;
    public int c;
    private Point p1;
    private Point p2;

    // constructors
    public Line(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public Line(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
        // a = - (y2 - y1)
        this.a = -(p2.getY() - p1.getY());

        // b = x2 - x1
        this.b = p2.getX() - p1.getX();

        // c = - (a * x1 + b * y1)
        this.c = -(this.a * p1.getX() + p1.getY() * this.b);
    }

    // getters
    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public int getC() {
        return c;
    }

    public Point getP1() {
        return p1;
    }

    public Point getP2() {
        return p2;
    }

    // setters
    public void setA(int input) {
        a = input;
    }

    public void setB(int input) {
        b = input;
    }

    public void setC(int input) {
        c = input;
    }

    public void setP1(Point p1) {
        this.p1 = p1;
    }

    public void setP2(Point p2) {
        this.p2 = p2;
    }

    // methods
    public String toString() {
        return (a + "x " + b + "y " + c);

    }
    // -a/b = slope

    public double calculateSlope() {
        return (double) (-1 * (double) a / b);
    }

    public boolean isCoordinateOnLine(Point p) {
        if ((a * p.getX()) + (b * p.getY()) + c == 0) {
            return true;
        } else {
            return false;
        }
    }

    public double calculateSlopeFromPoints() {
        return (double) ((p2.getY() - p1.getY()) / (p2.getX() - p1.getX()));
    }

    public String generatePointSlopeFormula() {
        return "(y - " + p1.getY() + ") = "
                + ((double) ((p2.getY() - p1.getY()) / (p2.getX() - p1.getX()))) + "(x - "
                + p1.getX() + ")";
    }
}

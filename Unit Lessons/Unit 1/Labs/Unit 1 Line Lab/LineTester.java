public class LineTester {
    public static void main(String[] args) {
        // Testing Line 1
        Line line1 = new Line(5, 4, -17);
        Line line2 = new Line(-25, 40, 30);

        Point p1 = new Point(2, 7);
        Point p2 = new Point(1, 4);
        Point p3 = new Point(11, 18);
        Point p4 = new Point(4, 13);

        Line pointLine = new Line(p1, p2);

        double slope1 = line1.calculateSlope(); // slope1 should be -1.25
        System.out.println("=== Old Version(Slopes) ===");
        System.out.println(slope1);


        // Testing Line 2
        double slope2 = line2.calculateSlope(); // slope2 should be 0.625

        System.out.println(slope2);

        System.out.println("\n=== Calculating Slope ===");
        System.out.println(pointLine.calculateSlope());
        System.out.println(pointLine.calculateSlopeFromPoints());

        if (pointLine.calculateSlope() == pointLine.calculateSlopeFromPoints()) {
            System.out.println("slopes are the same");
        } else {
            System.out.println("Slopes are not the same");
        }

        System.out.println("\n=== Testing Points ===");
        System.out.println(pointLine.isCoordinateOnLine(p1)); // true
        System.out.println(pointLine.isCoordinateOnLine(p2)); // true
        System.out.println(pointLine.isCoordinateOnLine(p3)); // false
        System.out.println(pointLine.isCoordinateOnLine(p4)); // true


        System.out.println("\n === Testing generatePointSlopeFormula() ===");
        System.out.println(pointLine.generatePointSlopeFormula());
    }

}

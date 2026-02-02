public class SkyViewTester {
    public static void main(String[] args) {
        System.out.println("=== SkyView Tester ===");

        double[] scanned = {0.0, 1.1, 2.2, 3.3, 4.4, 5.5};
        SkyView sv = new SkyView(3, 2, scanned);

        System.out.println("Constructed SkyView (3x2) from scanned:");
        System.out.println(sv);

        // Expected printed output:
        // 0.0 1.1
        // 3.3 2.2
        // 4.4 5.5

        SkyView sv2 = new SkyView(3, 2, new double[] {0.0, 1.1, 2.2, 3.3, 4.4, 5.5});
        System.out.println("sv.equals(sv2): " + sv.equals(sv2));

        double avg = sv.getAverage(1, 2, 0, 1);
        System.out.println("Average of rows 1-2, cols 0-1: " + avg);

        // Test invalid constructor
        try {
            new SkyView(2, 2, new double[] {1.0, 2.0, 3.0});
            System.out.println("ERROR: expected IllegalArgumentException " 
                + "for mismatched scanned length");
        } catch (IllegalArgumentException e) {
            System.out.println("Caught expected exception for bad constructor: " + e.getMessage());
        }

        // Test invalid getAverage
        try {
            sv.getAverage(-1, 0, 0, 0);
            System.out.println("ERROR: expected IllegalArgumentException for invalid indices");
        } catch (IllegalArgumentException e) {
            System.out.println("Caught expected exception for bad indices: " + e.getMessage());
        }

        System.out.println("=== Tests complete ===");
    }
}

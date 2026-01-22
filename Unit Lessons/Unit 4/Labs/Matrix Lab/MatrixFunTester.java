public class MatrixFunTester {

    public static void main(String[] args) {
        System.out.println("=== Testing Constructors ===\n");
        testConstructors();

        System.out.println("\n=== Testing toString ===\n");
        testToString();

        System.out.println("\n=== Testing equals Methods ===\n");
        testEquals();

        System.out.println("\n=== Testing replaceAll ===\n");
        testReplaceAll();

        System.out.println("\n=== Testing swapRow ===\n");
        testSwapRow();

        System.out.println("\n=== Testing Edge Cases ===\n");
        testEdgeCases();
    }

    public static void testConstructors() {
        System.out.println("Test 1: Constructor with rows and cols");
        MatrixFun mat1 = new MatrixFun(3, 4);
        System.out.println(mat1);

        System.out.println("Test 2: Constructor with starter matrix");
        int[][] starter = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        MatrixFun mat2 = new MatrixFun(starter);
        System.out.println(mat2);

        System.out.println("Test 3: No-parameter constructor");
        MatrixFun mat3 = new MatrixFun();
        System.out.println(mat3);

        System.out.println("Test 4: Constructor with irregular matrix (warning expected)");
        int[][] irregular = {{1, 2, 3}, {4, 5}};
        MatrixFun mat4 = new MatrixFun(irregular);
        System.out.println(mat4);
    }

    public static void testToString() {
        System.out.println("Test 1: 3x3 matrix");
        int[][] mat1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        MatrixFun m1 = new MatrixFun(mat1);
        System.out.println(m1);

        System.out.println("Test 2: 2x4 matrix (different dimensions)");
        int[][] mat2 = {{0, 1, 2, 3}, {4, 5, 6, 7}};
        MatrixFun m2 = new MatrixFun(mat2);
        System.out.println(m2);

        System.out.println("Test 3: 4x2 matrix");
        int[][] mat3 = {{1, 2}, {3, 4}, {5, 6}, {7, 8}};
        MatrixFun m3 = new MatrixFun(mat3);
        System.out.println(m3);
    }

    public static void testEquals() {
        int[][] mat1 = {{1, 2, 3}, {4, 5, 6}};
        int[][] mat2 = {{1, 2, 3}, {4, 5, 6}};
        int[][] mat3 = {{1, 2, 3}, {4, 5, 7}};

        MatrixFun m1 = new MatrixFun(mat1);
        MatrixFun m2 = new MatrixFun(mat2);
        MatrixFun m3 = new MatrixFun(mat3);

        System.out.println("Test 1: equals(MatrixFun) - same values");
        System.out.println("Expected true: " + m1.equals(m2));

        System.out.println("\nTest 2: equals(MatrixFun) - different values");
        System.out.println("Expected false: " + m1.equals(m3));

        System.out.println("\nTest 3: equals(int[][]) - same values");
        System.out.println("Expected true: " + m1.equals(mat2));

        System.out.println("\nTest 4: equals(int[][]) - different values");
        System.out.println("Expected false: " + m1.equals(mat3));

        System.out.println("\nTest 5: equals(int[][]) - different dimensions");
        int[][] mat4 = {{1, 2, 3}};
        System.out.println("Expected false: " + m1.equals(mat4));
    }

    public static void testReplaceAll() {
        System.out.println("Test 1: Replace single value");
        int[][] mat1 = {{1, 1, 3}, {4, 5, 6}, {1, 1, 1}};
        MatrixFun m1 = new MatrixFun(mat1);
        System.out.println("Before:");
        System.out.println(m1);
        m1.replaceAll(1, 9);
        System.out.println("After replaceAll(1, 9):");
        System.out.println(m1);

        System.out.println("Test 2: Replace value that doesn't exist");
        int[][] mat2 = {{1, 2, 3}, {4, 5, 6}};
        MatrixFun m2 = new MatrixFun(mat2);
        System.out.println("Before:");
        System.out.println(m2);
        m2.replaceAll(9, 0);
        System.out.println("After replaceAll(9, 0) - should be unchanged:");
        System.out.println(m2);
    }

    public static void testSwapRow() {
        System.out.println("Test 1: Swap rows 0 and 1");
        int[][] mat1 = {{1, 1, 3}, {4, 5, 6}, {7, 8, 9}};
        MatrixFun m1 = new MatrixFun(mat1);
        System.out.println("Before:");
        System.out.println(m1);
        m1.swapRow(0, 1);
        System.out.println("After swapRow(0, 1):");
        System.out.println(m1);

        System.out.println("Test 2: Swap rows 0 and 2");
        int[][] mat2 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        MatrixFun m2 = new MatrixFun(mat2);
        System.out.println("Before:");
        System.out.println(m2);
        m2.swapRow(0, 2);
        System.out.println("After swapRow(0, 2):");
        System.out.println(m2);
    }

    public static void testEdgeCases() {
        System.out.println("Test 1: Invalid constructor arguments");
        try {
            MatrixFun m = new MatrixFun(-1, 3);
        } catch (IllegalArgumentException e) {
            System.out.println("Caught exception for negative rows: " + e.getMessage());
        }

        try {
            MatrixFun m = new MatrixFun(3, 0);
        } catch (IllegalArgumentException e) {
            System.out.println("Caught exception for zero columns: " + e.getMessage());
        }

        System.out.println("\nTest 2: Null starter matrix");
        try {
            MatrixFun m = new MatrixFun(null);
        } catch (IllegalArgumentException e) {
            System.out.println("Caught exception for null matrix: " + e.getMessage());
        }

        System.out.println("\nTest 3: Invalid swapRow indices");
        int[][] mat = {{1, 2, 3}, {4, 5, 6}};
        MatrixFun m = new MatrixFun(mat);
        try {
            m.swapRow(-1, 0);
        } catch (IllegalArgumentException e) {
            System.out.println("Caught exception for negative row index: " + e.getMessage());
        }

        try {
            m.swapRow(0, 5);
        } catch (IllegalArgumentException e) {
            System.out.println("Caught exception for out-of-bounds row index: " + e.getMessage());
        }

        System.out.println("\nTest 4: Single element matrix");
        int[][] single = {{5}};
        MatrixFun m2 = new MatrixFun(single);
        System.out.println(m2);

        System.out.println("Test 5: Equals with null");
        System.out.println("Expected false: " + m.equals((MatrixFun) null));
        System.out.println("Expected false: " + m.equals((int[][]) null));
    }
}

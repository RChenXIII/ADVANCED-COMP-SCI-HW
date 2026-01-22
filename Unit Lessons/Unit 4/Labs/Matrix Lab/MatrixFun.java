import java.util.Random;

public class MatrixFun {
    private int[][] matrix;

    public MatrixFun(int numberOfRows, int numberOfCols) {
        if (numberOfRows <= 0 || numberOfCols <= 0) {
            throw new IllegalArgumentException("Rows and columns must be positive");
        }
        matrix = new int[numberOfRows][numberOfCols];
        fillWithRandomNumbers();
    }

    public MatrixFun(int[][] starterMatrix) {
        if (starterMatrix == null) {
            throw new IllegalArgumentException("Starter matrix cannot be null");
        }
        if (!isRectangular(starterMatrix)) {
            System.out.println("Warning: Matrix is not rectangular");
        }
        matrix = starterMatrix;
    }

    public MatrixFun() {
        this(3, 3);
    }

    private void fillWithRandomNumbers() {
        Random rand = new Random();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = rand.nextInt(10);
            }
        }
    }

    private boolean isRectangular(int[][] mat) {
        if (mat.length == 0) {
            return true;
        }
        int firstRowLength = mat[0].length;
        for (int i = 1; i < mat.length; i++) {
            if (mat[i].length != firstRowLength) {
                return false;
            }
        }
        return true;
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    public String toString() {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return "";
        }
        
        String result = "";
        int rowLength = matrix[0].length * 2 - 1;
        result += "=".repeat(rowLength) + "\n";
        
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                result += matrix[i][j] + " ";
            }
            result += "\n";
        }
        
        result += "=".repeat(rowLength) + "\n";
        return result;
    }

    public boolean equals(MatrixFun other) {
        if (other == null) {
            return false;
        }
        return this.toString().equals(other.toString());
    }

    public boolean equals(int[][] other) {
        if (other == null || matrix == null) {
            return false;
        }
        
        if (matrix.length != other.length) {
            return false;
        }
        
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i].length != other[i].length) {
                return false;
            }
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] != other[i][j]) {
                    return false;
                }
            }
        }
        
        return true;
    }

    public void replaceAll(int oldValue, int newValue) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == oldValue) {
                    matrix[i][j] = newValue;
                }
            }
        }
    }

    public void swapRow(int rowA, int rowB) {
        if (rowA < 0 || rowA >= matrix.length || rowB < 0 || rowB >= matrix.length) {
            throw new IllegalArgumentException("Invalid row indices");
        }
        
        int[] temp = matrix[rowA];
        matrix[rowA] = matrix[rowB];
        matrix[rowB] = temp;
    }
}
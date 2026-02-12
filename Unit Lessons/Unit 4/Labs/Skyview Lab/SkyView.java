public class SkyView {
    private double[][] view;

    public SkyView(int numberOfRows, int numberOfCols, double[] scanned) {
        if (numberOfRows <= 0 || numberOfCols <= 0) {
            throw new IllegalArgumentException("numberOfRows and numberOfCols must be positive");
        }
        if (scanned == null) {
            throw new IllegalArgumentException("scanned must not be null");
        }
        if (scanned.length != numberOfRows * numberOfCols) {
            throw new IllegalArgumentException("scanned length does not match provided dimensions");
        }

        view = new double[numberOfRows][numberOfCols];
        int idx = 0;
        for (int r = 0; r < numberOfRows; r++) {
            if (r % 2 == 0) {
                for (int c = 0; c < numberOfCols; c++) {
                    view[r][c] = scanned[idx++];
                }
            } else {
                for (int c = numberOfCols - 1; c >= 0; c--) {
                    view[r][c] = scanned[idx++];
                }
            }
        }
    }

    public double[][] getView() {
        return view;
    }

    public void setView(double[][] view) {
        if (view == null) {
            throw new IllegalArgumentException("view must not be null");
        }
        this.view = view;
    } 

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int r = 0; r < view.length; r++) {
            for (int c = 0; c < view[r].length; c++) {
                sb.append(view[r][c]).append(" ");
            }
            if (r < view.length - 1) {
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    public boolean equals(SkyView other) {
        if (other == null) {
            return false;
        }
        if (this.view.length != other.view.length) {
            return false;
        }
        for (int r = 0; r < view.length; r++) {
            if (this.view[r].length != other.view[r].length) {
                return false;
            }
            for (int c = 0; c < view[r].length; c++) {
                if (Double.compare(this.view[r][c], other.view[r][c]) != 0) {
                    return false;
                }
            }
        }
        return true;
    }


    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return equals((SkyView) obj);
    }


    public double getAverage(int startRow, int endRow, int startCol, int endCol) {
        if (startRow < 0 || endRow < startRow || endRow >= view.length) {
            throw new IllegalArgumentException("Invalid row indices");
        }
        if (startCol < 0 || endCol < startCol || endCol >= view[0].length) {
            throw new IllegalArgumentException("Invalid column indices");
        }
        double sum = 0.0;
        int count = 0;
        for (int r = startRow; r <= endRow; r++) {
            for (int c = startCol; c <= endCol; c++) {
                sum += view[r][c];
                count++;
            }
        }
        return sum / count;
    }
}


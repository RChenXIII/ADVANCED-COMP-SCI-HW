public class StudentRecord {
    private String name;
    private int[] scores;

    public StudentRecord(String name, int[] scores) {
        this.name = name;
        this.scores = scores;
    }

    public String getName() {
        return name;
    }

    public int[] getScores() {
        return scores;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setScores(int[] scores) {
        this.scores = scores;
    }

    public String toString() {
        String result = name + "'s scores: [";
        for (int i = 0; i < scores.length; i++) {
            result += scores[i];
            if (i < scores.length - 1) {
                result += ", ";
            }
        }
        result += "]";
        return result;
    }

    public boolean equals(StudentRecord other) {
        if (!this.name.equals(other.name)) {
            return false;
        }

        if (this.scores.length != other.scores.length) {
            return false;
        }

        for (int i = 0; i < this.scores.length; i++) {
            if (this.scores[i] != other.scores[i]) {
                return false;
            }
        }

        return true;
    }

    public double getAverage(int first, int last) {
        double sum = 0;
        for (int i = first; i <= last; i++) {
            sum += scores[i];
        }
        return sum / (last - first + 1);
    }

    public int getTestScore(int testNumber) {
        if (testNumber < 0 || testNumber >= scores.length) {
            return -1;
        }
        return scores[testNumber];
    }

    public boolean hasImproved() {
        for (int i = 1; i < scores.length; i++) {
            if (scores[i] < scores[i - 1]) {
                return false;
            }
        }
        return true;
    }

    public double getFinalAverage() {
        if (hasImproved()) {
            return getAverage(scores.length / 2, scores.length - 1);
        } else {
            return getAverage(0, scores.length - 1);
        }
    }
}

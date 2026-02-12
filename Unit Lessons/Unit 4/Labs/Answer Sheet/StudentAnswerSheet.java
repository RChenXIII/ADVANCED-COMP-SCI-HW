import java.util.ArrayList;

public class StudentAnswerSheet {
    private String name;
    private double testScore;
    private ArrayList<String> answers;

    public StudentAnswerSheet(String name, ArrayList<String> answers) {
        if (name == null || answers == null) {
            throw new IllegalArgumentException("name and answers cannot be null");
        }
        this.name = name;
        this.answers = answers;
        this.testScore = 0.0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("name cannot be null");
        }
        this.name = name;
    }

    public double getTestScore() {
        return testScore;
    }

    public void setTestScore(double testScore) {
        this.testScore = testScore;
    }

    public ArrayList<String> getAnswers() {
        return answers;
    }

    public void setAnswers(ArrayList<String> answers) {
        if (answers == null) {
            throw new IllegalArgumentException("answers cannot be null");
        }
        this.answers = answers;
    }

    public double getGrade(ArrayList<String> key) {
        if (key == null) {
            throw new IllegalArgumentException("key cannot be null");
        }
        if (key.size() != answers.size()) {
            throw new IllegalArgumentException("key size must equal answers size");
        }

        double score = 0.0;
        for (int i = 0; i < key.size(); i++) {
            String correct = key.get(i);
            String given = answers.get(i);
            if (given == null) {
                continue;
            }
            if ("?".equals(given)) {
                continue;
            }
            if (given.equals(correct)) {
                score += 1.0;
            } else {
                score -= 0.25;
            }
        }
        return score;
    }
}

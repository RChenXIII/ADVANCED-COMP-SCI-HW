import java.util.ArrayList;

public class TestResults {
    private ArrayList<String> answerKey;
    private ArrayList<StudentAnswerSheet> submissions;

    public TestResults(ArrayList<String> key, ArrayList<StudentAnswerSheet> submissions) {
        if (key == null || submissions == null) {
            throw new IllegalArgumentException("key and submissions cannot be null");
        }
        this.answerKey = key;
        this.submissions = submissions;
    }

    public ArrayList<String> getAnswerKey() {
        return answerKey;
    }

    public void setAnswerKey(ArrayList<String> answerKey) {
        if (answerKey == null) {
            throw new IllegalArgumentException("answerKey cannot be null");
        }
        this.answerKey = answerKey;
    }

    public ArrayList<StudentAnswerSheet> getSubmissions() {
        return submissions;
    }

    public void setSubmissions(ArrayList<StudentAnswerSheet> submissions) {
        if (submissions == null) {
            throw new IllegalArgumentException("submissions cannot be null");
        }
        this.submissions = submissions;
    }

    public void submit(StudentAnswerSheet student) {
        submissions.add(student);
    }

    public void gradeTests() {
        for (StudentAnswerSheet s : submissions) {
            s.setTestScore(s.getGrade(answerKey));
        }
    }

    public String highestScoringStudent() {
        if (submissions.isEmpty()) {
            return "";
        }
        String bestName = "";
        double bestScore = Double.NEGATIVE_INFINITY;
        for (StudentAnswerSheet s : submissions) {
            double score = s.getTestScore();
            if (score > bestScore) {
                bestScore = score;
                bestName = s.getName();
            }
        }
        return bestName;
    }
}

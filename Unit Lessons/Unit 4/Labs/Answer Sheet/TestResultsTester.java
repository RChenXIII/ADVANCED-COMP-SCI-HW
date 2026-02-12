import java.util.ArrayList;

public class TestResultsTester {
    public static void main(String[] args) {
        ArrayList<String> key = new ArrayList<>();
        key.add("A");
        key.add("B");
        key.add("C");
        key.add("D");
        key.add("A");

        ArrayList<StudentAnswerSheet> submissions = new ArrayList<>();

        ArrayList<String> ans1 = new ArrayList<>();
        ans1.add("A");
        ans1.add("B");
        ans1.add("C");
        ans1.add("?");
        ans1.add("A");
        StudentAnswerSheet s1 = new StudentAnswerSheet("Alice", ans1);

        ArrayList<String> ans2 = new ArrayList<>();
        ans2.add("A");
        ans2.add("C");
        ans2.add("C");
        ans2.add("D");
        ans2.add("B");
        StudentAnswerSheet s2 = new StudentAnswerSheet("Bob", ans2);

        ArrayList<String> ans3 = new ArrayList<>();
        ans3.add("B");
        ans3.add("B");
        ans3.add("C");
        ans3.add("D");
        ans3.add("A");
        StudentAnswerSheet s3 = new StudentAnswerSheet("Cara", ans3);

        submissions.add(s1);
        submissions.add(s2);
        submissions.add(s3);

        TestResults results = new TestResults(key, submissions);
        results.gradeTests();

        System.out.println("Scores:");
        for (StudentAnswerSheet s : results.getSubmissions()) {
            System.out.printf("%s: %.2f\n", s.getName(), s.getTestScore());
        }

        System.out.println("Highest scoring student: " + results.highestScoringStudent());
    }
}

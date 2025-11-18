public class CourseTester {
    public static void main(String[] args) {
        int[] anaScores = {90, 89, 91, 95};
        int[] billyScores = {80, 79, 90, 90};
        int[] caseyScores = {70, 80, 90, 100};

        StudentRecord ana = new StudentRecord("Ana", anaScores);
        StudentRecord billy = new StudentRecord("Billy", billyScores);
        StudentRecord casey = new StudentRecord("Casey", caseyScores);

        System.out.println("=== Testing StudentRecord toString() ===");
        System.out.println(ana.toString());
        System.out.println("Expected: Ana's scores: [90, 89, 91, 95]");
        System.out.println();

        System.out.println("=== Testing getAverage() ===");
        System.out.println("Ana's average (0-3): " + ana.getAverage(0, 3));
        System.out.println("Expected: 91.25");
        System.out.println();

        System.out.println("=== Testing getTestScore() ===");
        System.out.println("Ana's test 1 score: " + ana.getTestScore(1));
        System.out.println("Expected: 89");
        System.out.println();

        System.out.println("=== Testing hasImproved() ===");
        System.out.println("Ana improved? " + ana.hasImproved());
        System.out.println("Expected: false (89 < 90)");
        System.out.println("Casey improved? " + casey.hasImproved());
        System.out.println("Expected: true");
        System.out.println();

        System.out.println("=== Testing getFinalAverage() ===");
        System.out.println("Ana's final average: " + ana.getFinalAverage());
        System.out.println("Billy's final average: " + billy.getFinalAverage());
        System.out.println("Casey's final average: " + casey.getFinalAverage());
        System.out.println();

        StudentRecord[] students = {ana, billy, casey};
        Course cs = new Course("Computer Science", students);

        System.out.println("=== Testing Course toString() ===");
        System.out.println(cs.toString());
        System.out.println();

        System.out.println("=== Testing findBestStudent() ===");
        System.out.println("Best student: " + cs.findBestStudent());
        System.out.println();

        System.out.println("=== Testing calculateTestAverage() ===");
        System.out.println("Test 0 average: " + cs.calculateTestAverage(0));
        System.out.println("Test 3 average: " + cs.calculateTestAverage(3));

        System.out.println("\n=== Testing equals() ===");
        int[] anaScores2 = {90, 89, 91, 95};
        StudentRecord ana2 = new StudentRecord("Ana", anaScores2);
        System.out.println("ana.equals(ana2): " + ana.equals(ana2));
        System.out.println("Expected: true");
        System.out.println("ana.equals(billy): " + ana.equals(billy));
        System.out.println("Expected: false");
    }
}

public class CourseTester {
    public static void main(String[] args) {
        int[] anaScores = {90, 89, 91, 95};
        int[] billyScores = {80, 79, 90, 90};
        int[] caseyScores = {70, 80, 90, 100};
        int[] danScores = {85, 88, 90, 92};

        StudentRecord ana = new StudentRecord("Ana", anaScores);
        StudentRecord billy = new StudentRecord("Billy", billyScores);
        StudentRecord casey = new StudentRecord("Casey", caseyScores);
        StudentRecord dan = new StudentRecord("Dan", danScores);

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

        System.out.println("\n========================================");
        System.out.println("=== TESTING NEW COURSE FEATURES ===");
        System.out.println("========================================\n");


        System.out.println("=== Testing Course(String, int) Constructor ===");
        Course math = new Course("Mathematics", 3);
        System.out.println("Created course: " + math.getCourseName());
        System.out.println("Max enrollment: " + math.getEnrolledStudents().length);
        System.out.println("Expected: 3");
        System.out.println();


        System.out.println("=== Testing countEnrolledStudents() - Empty Course ===");
        System.out.println("Enrolled students: " + math.countEnrolledStudents());
        System.out.println("Expected: 0");
        System.out.println();


        System.out.println("=== Testing isFull() - Empty Course ===");
        System.out.println("Is course full? " + math.isFull());
        System.out.println("Expected: false");
        System.out.println();

        System.out.println("=== Testing enrollStudent() ===");
        math.enrollStudent(ana);
        System.out.println("Enrolled Ana");
        System.out.println("Enrolled students: " + math.countEnrolledStudents());
        System.out.println("Expected: 1");
        System.out.println();

        math.enrollStudent(billy);
        System.out.println("Enrolled Billy");
        System.out.println("Enrolled students: " + math.countEnrolledStudents());
        System.out.println("Expected: 2");
        System.out.println();

        System.out.println("=== Testing isFull() - Partially Full ===");
        System.out.println("Is course full? " + math.isFull());
        System.out.println("Expected: false");
        System.out.println();

        math.enrollStudent(casey);
        System.out.println("Enrolled Casey");
        System.out.println("Enrolled students: " + math.countEnrolledStudents());
        System.out.println("Expected: 3");
        System.out.println();


        System.out.println("=== Testing isFull() - Full Course ===");
        System.out.println("Is course full? " + math.isFull());
        System.out.println("Expected: true");
        System.out.println();

        System.out.println("=== Testing Course toString() - After Enrollment ===");
        System.out.println(math.toString());


        System.out.println("=== Testing enrollStudent() - When Full ===");
        math.enrollStudent(dan);
        System.out.println("Attempted to enroll Dan (should fail)");
        System.out.println("Enrolled students: " + math.countEnrolledStudents());
        System.out.println("Expected: 3 (unchanged)");
        System.out.println();


        System.out.println("=== Testing dropStudent() - Successful Drop ===");
        boolean dropped = math.dropStudent(billy);
        System.out.println("Dropped Billy? " + dropped);
        System.out.println("Expected: true");
        System.out.println("Enrolled students: " + math.countEnrolledStudents());
        System.out.println("Expected: 2");
        System.out.println();


        System.out.println("=== Testing dropStudent() - Student Not Found ===");
        dropped = math.dropStudent(dan);
        System.out.println("Dropped Dan? " + dropped);
        System.out.println("Expected: false");
        System.out.println();


        System.out.println("=== Testing enrollStudent() - After Drop ===");
        math.enrollStudent(dan);
        System.out.println("Enrolled Dan");
        System.out.println("Enrolled students: " + math.countEnrolledStudents());
        System.out.println("Expected: 3");
        System.out.println(math.toString());


        System.out.println("=== Testing increaseClassSizeBy() ===");
        System.out.println("Current array size: " + math.getEnrolledStudents().length);
        System.out.println("Expected: 3");
        math.increaseClassSizeBy(2);
        System.out.println("After increasing by 2: " + math.getEnrolledStudents().length);
        System.out.println("Expected: 5");
        System.out.println("Enrolled students count: " + math.countEnrolledStudents());
        System.out.println("Expected: 3 (same students)");
        System.out.println();


        System.out.println("=== Testing enrollStudent() - After Size Increase ===");
        math.enrollStudent(billy);
        System.out.println("Enrolled Billy again");
        System.out.println("Enrolled students: " + math.countEnrolledStudents());
        System.out.println("Expected: 4");
        System.out.println();


        System.out.println("=== Testing findBestStudent() - New System ===");
        System.out.println("Best student: " + math.findBestStudent());
        System.out.println();


        System.out.println("=== Testing calculateTestAverage() - New System ===");
        System.out.println("Test 0 average: " + math.calculateTestAverage(0));
        System.out.println("Test 3 average: " + math.calculateTestAverage(3));
    }
}

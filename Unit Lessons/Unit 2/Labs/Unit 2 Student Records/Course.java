public class Course {
    private String courseName;
    private StudentRecord[] enrolledStudents;

    public Course(String courseName, StudentRecord[] enrolledStudents) {
        this.courseName = courseName;
        this.enrolledStudents = enrolledStudents;
    }

    public String getCourseName() {
        return courseName;
    }

    public StudentRecord[] getEnrolledStudents() {
        return enrolledStudents;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setEnrolledStudents(StudentRecord[] enrolledStudents) {
        this.enrolledStudents = enrolledStudents;
    }

    public String toString() {
        String result = "== " + courseName + " ==\n";
        for (int i = 0; i < enrolledStudents.length; i++) {
            result += (i + 1) + ".) " + enrolledStudents[i].toString() + "\n";
        }
        return result;
    }

    public String findBestStudent() {
        if (enrolledStudents.length == 0) {
            return "";
        }

        String bestStudent = enrolledStudents[0].getName();
        double bestAverage = enrolledStudents[0].getFinalAverage();

        for (int i = 1; i < enrolledStudents.length; i++) {
            double currentAverage = enrolledStudents[i].getFinalAverage();
            if (currentAverage > bestAverage) {
                bestAverage = currentAverage;
                bestStudent = enrolledStudents[i].getName();
            }
        }

        return bestStudent;
    }

    public double calculateTestAverage(int testNumber) {
        double sum = 0;
        int count = 0;

        for (int i = 0; i < enrolledStudents.length; i++) {
            int score = enrolledStudents[i].getTestScore(testNumber);
            if (score != -1) {
                sum += score;
                count++;
            }
        }

        if (count == 0) {
            return 0;
        }

        return sum / count;
    }
}

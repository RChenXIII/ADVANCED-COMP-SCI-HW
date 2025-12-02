public class Course {
    private String courseName;
    private StudentRecord[] enrolledStudents;


    public Course(String courseName, StudentRecord[] enrolledStudents) {
        this.courseName = courseName;
        this.enrolledStudents = enrolledStudents;
    }


    public Course(String courseName, int maxEnrollment) {
        this.courseName = courseName;
        this.enrolledStudents = new StudentRecord[maxEnrollment];
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
            if (enrolledStudents[i] != null) {
                result += (i + 1) + ".) " + enrolledStudents[i].toString() + "\n";
            }
        }
        return result;
    }

    public String findBestStudent() {
        if (enrolledStudents.length == 0) {
            return "";
        }

        String bestStudent = null;
        double bestAverage = -1;

        for (int i = 0; i < enrolledStudents.length; i++) {
            if (enrolledStudents[i] != null) {
                double currentAverage = enrolledStudents[i].getFinalAverage();
                if (bestStudent == null || currentAverage > bestAverage) {
                    bestAverage = currentAverage;
                    bestStudent = enrolledStudents[i].getName();
                }
            }
        }

        return bestStudent == null ? "" : bestStudent;
    }

    public double calculateTestAverage(int testNumber) {
        double sum = 0;
        int count = 0;

        for (int i = 0; i < enrolledStudents.length; i++) {
            if (enrolledStudents[i] != null) {
                int score = enrolledStudents[i].getTestScore(testNumber);
                if (score != -1) {
                    sum += score;
                    count++;
                }
            }
        }

        if (count == 0) {
            return 0;
        }

        return sum / count;
    }


    public boolean isFull() {
        for (int i = 0; i < enrolledStudents.length; i++) {
            if (enrolledStudents[i] == null) {
                return false;
            }
        }
        return true;
    }

    public void enrollStudent(StudentRecord student) {
        for (int i = 0; i < enrolledStudents.length; i++) {
            if (enrolledStudents[i] == null) {
                enrolledStudents[i] = student;
                return;
            }
        }
    }


    public boolean dropStudent(StudentRecord student) {
        for (int i = 0; i < enrolledStudents.length; i++) {
            if (enrolledStudents[i] != null
                    && enrolledStudents[i].getName().equals(student.getName())) {
                enrolledStudents[i] = null;
                return true;
            }
        }
        return false;
    }


    public int countEnrolledStudents() {
        int count = 0;
        for (int i = 0; i < enrolledStudents.length; i++) {
            if (enrolledStudents[i] != null) {
                count++;
            }
        }
        return count;
    }


    public void increaseClassSizeBy(int sizeIncrease) {
        StudentRecord[] newArray = new StudentRecord[enrolledStudents.length + sizeIncrease];

        for (int i = 0; i < enrolledStudents.length; i++) {
            newArray[i] = enrolledStudents[i];
        }

        enrolledStudents = newArray;
    }
}

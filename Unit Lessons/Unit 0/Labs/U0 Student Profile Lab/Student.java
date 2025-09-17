public class Student {
    public String name;
    public int grade;
    public String id;

    // constructors
    public Student(String name, int grade) {
        this.name = name;
        this.grade = grade;
        this.id = generateId();
    }

    public Student(String name) {
        this.name = name;
        this.grade = grade;
        this.id = generateId();
    }

    // getters
    public String getName() {
        return name;
    }

    public int getGrade() {
        return grade;
    }

    public String getId() {
        return id;
    }

    // setters
    public void setName(String input) {
        name = input;
    }

    public void setGrade(int input) {
        grade = input;
    }

    public void setId(String id) {
        this.id = id;
    }


    // methods
    public String toString() {
        return (name + " is in " + grade + "th grade. Their ID is " + id + ".");
    }

    public boolean equals(Student other) {
        return grade == other.grade;
    }

    public String generateId() {
        return (int) ((Math.random() * 7) + 2) + "" + (int) ((Math.random() * 7) + 2) + ""
                + (int) ((Math.random() * 7) + 2) + "-" + (int) (Math.random() * 10) + ""
                + (int) (Math.random() * 10) + "" + (int) (Math.random() * 10) + ""
                + (int) (Math.random() * 10) + "";
    }

}

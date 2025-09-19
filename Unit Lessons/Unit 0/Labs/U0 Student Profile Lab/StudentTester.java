public class StudentTester {
    public static void main(String[] args) {
        Student student1 = new Student("Bob", 11);
        Student student2 = new Student("Sam", 10);
        Student student3 = new Student("David");
        Student student4 = new Student("Jack");

        System.out.println(student1);
        System.out.println(student2);
        System.out.println(student3);
        System.out.println(student4);

        student1.setGrade(student1.getGrade() + 1);
        student2.setGrade(student2.getGrade() + 1);
        student3.setGrade(student3.getGrade() + 1);
        student4.setGrade(student4.getGrade() + 1);

        System.out.println(student1);
        System.out.println(student2);
        System.out.println(student3);
        System.out.println(student4);

        System.out.println("student1 equals student2:" + student1.equals(student2));
        System.out.println("student2 equals student3:" + student2.equals(student3));
        System.out.println("student1 equals student3:" + student1.equals(student3));
    }
}

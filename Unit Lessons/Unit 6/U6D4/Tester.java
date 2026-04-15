public class Tester {
    public static void main(String[] args) {
        Student sarah = new Student("Sarah", 1001, "ABC1");
        Student john = new Student("John", 1002, "DEF2");
        Student owen = new Student("Owen", 1003, "FBC3");

        System.out.println(john.compareTo(owen));
        System.out.println(john.compareTo(sarah));
    }
}

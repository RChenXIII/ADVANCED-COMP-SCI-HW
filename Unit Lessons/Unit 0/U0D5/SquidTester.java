public class SquidTester {
    public static void main(String[] args) {
        Squid larry = new Squid();

        System.out.println(larry.getTentacleCount());
        System.out.println(larry.toString());

        // equal sign does not compare content.
        String s1 = "hello";
        String s2 = "h";
        String s3 = s2 + "ello";
        // use this to compare content
        System.out.println(s1.equals(s3));



        // Math

        System.out.println(Math.sqrt(9)); // =3
        System.out.println(Math.max(5, 9)); // =9
        System.out.println(Math.min(5, 9)); // =5
        System.out.println(math.abs(-9)); // =9

        // Math.sin, Math.cos, Math.tan, Math.pi(approx 3.14159)
        Math.toRadians(180); // radian of degree
    }
}

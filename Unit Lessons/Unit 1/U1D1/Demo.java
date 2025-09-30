public class Demo {
    public static void main(String[] args) {
        int age = 20;
        boolean isFelon = false;
        boolean isRegistered = true;
        boolean isCitizen = true;
        String country = "USA";

            // AND - all condition have to be true
        if ((age >= 18 && age >= 35) && !isFelon) {
            System.out.println("You can run for presidency and vote!");
        }

        age = 15;

        if (age < 35 || isFelon) {
            System.out.println("This person is not eligible for presidency.");

        }

        if (!isRegistered) {
            return;
        }
        if (age < 18) {
            return;
        }
        if (!isCitizen) {
            return;
        }
        if (isFelon) {
            return;
        }
        if (!country.equals("USA")) {
            return;
        }
        System.out.println("You can vote!");
    }
}
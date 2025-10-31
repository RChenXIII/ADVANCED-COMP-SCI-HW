public class AutoUtils {
    public static int validateCleanlinessLevel(int cleanlinessLevel) {
        if (cleanlinessLevel >= 10) {
            return 10;
        } else if (cleanlinessLevel <= 0) {
            return 0;
        } else {
            return cleanlinessLevel;
        }
    }

    public static String generateUsername(String name) {
        name = name.trim();
        int space = name.indexOf(" ");
        return "@" + name.substring(0, space) + "_" + name.substring(space, name.length()) + "_"
                + (int) ((Math.random() * 100) + 1950);
    }

    public static String fixName(String name) {
        String trimmedText = name.trim();
        for (int i = 0; i < trimmedText.length(); i++) {
            int n = trimmedText.indexOf(" ");
            if (n != -1) {
                name = name.substring(0, n) + name.substring(n, trimmedText.length());

            } else {
                return trimmedText.substring(0, i) + trimmedText.substring(i, trimmedText.length());
            }


        }
        return name;
    }

    public static int cleanCar(Car car) {
        System.out.println("Car has been cleaned.");
        return car.cleanlinessLevel += 2;
    }
}

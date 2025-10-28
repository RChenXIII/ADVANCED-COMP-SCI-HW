public class PurrfectUtils {
    public static int validateMoodLevel(int moodLevel) {
        if (moodLevel >= 10) {
            return 10;
        }
        if (moodLevel <= 0) {
            return 0;
        } else {
            return moodLevel;
        }
    }

    public static String validateCatId(String catId) {
        int number1 = Integer.parseInt(catId);
        if (number1 >= 1000 && number1 <= 9999) {
            return String.valueOf(catId);
        } else {

            return String.valueOf(Math.random() * 9000) + 1000;
        }
    }
}

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

    public static String determineCatMood(Cat cat) {
        if (cat.moodLevel > 7 && cat.moodLevel <= 10) {
            return "Currently, " + cat.name + " Cookie is in a great mood.\n  Petting is appreciated.";
        } if (cat.moodLevel > 3 && cat.moodLevel <= 7) {
            return "Currently, " + cat.name + " is reminiscing of a past life.\n  Petting is acceptable.";
        } if (cat.moodLevel < 3) {
            return "Currently, " + cat.name + " is plotting revengeance.\n  Petting is extremely risky";
        }
        return "";
    }
    public static char generateCatChar(String catId) {
    int sum = 0;
    
    
    for (int i = 0; i < catId.length(); i++) {
        String digitStr = catId.substring(i, i + 1);
        int digit = Integer.parseInt(digitStr);
        sum += digit;
    }
    
    // Calculate sum modulo 26 and add to 'A'
    int letterOffset = sum % 26;
    char result = (char) ('A' + letterOffset);
    
    return result;
    }
    public static int generateRandomNumber(int low, int high) {
    // Swap if low is not less than high
    if (low >= high) {
        int temp = low;
        low = high;
        high = temp;
    }
    
    // Generate random number between low (inclusive) and high (exclusive)
    return (int) (Math.random() * (high - low) + low);
}

public static void bootUp(Cat cat) {
    System.out.println(cat.toString());
}

public static void pet(Cat cat) {
    System.out.println("Attempting to pet...");
    
    int originalMood = cat.moodLevel;
    
    if (cat.moodLevel >= 2) {
        cat.moodLevel++;
    } else if (cat.isHungry) {
        cat.moodLevel--;
    } else {
        cat.moodLevel++;
    }
    

    if (cat.moodLevel > originalMood) {
        System.out.println("Petting successful!");
    } else {
        System.out.println("Petting failed...");
    }
}

public static void trimClaws(Cat cat) {
    System.out.println("Attempting to trim claws...");
    

    int decrease = generateRandomNumber(1, 3); // Returns 1 or 2
    cat.moodLevel -= decrease;
    
    if (decrease == 1) {
        System.out.println("Cookie did not like that...");
    } else {
        System.out.println("Cookie really hated that!");
    }
}

public static void cleanLitterBox(Cat cat) {
    System.out.println("Cleaning the litter box...");
    cat.moodLevel++;
    cat.isHungry = true;
    System.out.println("Done! \nCookie appreciated that.");
}

public static void feed(Cat cat) {
    System.out.println("Filling up Cookie's bowl...");
    cat.moodLevel += 2;
    cat.isHungry = false;
    System.out.println("Done!\nCookie is eating...\nCookie is full!");
    }
}

public class TriangleLoops {

    public static String createLetterTriangleUp(int numberOfRows, char letter) {
        if (numberOfRows <= 0) {
            return "";
        }
        
        String result = "";
        for (int i = 1; i <= numberOfRows; i++) {
            for (int j = 0; j < i; j++) {
                result += letter;
            }
            result += "\n";
        }
        return result;
    }

    public static String createLetterTriangleDown(int numberOfRows, char letter) {
        if (numberOfRows <= 0) {
            return "";
        }
        
        String result = "";
        for (int i = numberOfRows; i >= 1; i--) {
            for (int j = 0; j < i; j++) {
                result += letter;
            }
            result += "\n";
        }
        return result;
    }
    

    public static String createNumbersTriangle(int numberOfRows) {
        if (numberOfRows <= 0) {
            return "";
        }
        
        String result = "";
        for (int i = 1; i <= numberOfRows; i++) {
            for (int j = 0; j < i; j++) {
                result += i + " ";
            }
            result += "\n";
        }
        return result;
    }

    public static String createAlphabetTriangle(int numberOfRows) {
        // Handle edge case: limit to 26 rows (alphabet length)
        if (numberOfRows > 26) {
            numberOfRows = 26;
        }

        if (numberOfRows <= 0) {
            return "";
        }
        
        String result = "";
        
        for (int i = 1; i <= numberOfRows; i++) {
            for (int j = 0; j < numberOfRows - i; j++) {
                result += " ";
            }

            for (int j = 0; j < i; j++) {
                result += (char)('A' + j);
            }

            for (int j = i - 2; j >= 0; j--) {
                result += (char)('A' + j);
            }

            result += "\n";
        }
        return result;
    }
}
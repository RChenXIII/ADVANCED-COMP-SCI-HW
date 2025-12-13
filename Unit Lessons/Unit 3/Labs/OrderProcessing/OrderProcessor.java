public class OrderProcessor {

    private static final double PREMIUM_PRICE_THRESHOLD = 50.0;

    public static OrderSummary processCustomerOrder(Item[] items, double taxRate) {
        double subtotal = calculateSubtotal(items);
        String[] expensiveItems = identifyPremiumItems(items);
        double tax = calculateTax(subtotal, taxRate);
        double total = subtotal + tax;

        printOrderDetails(subtotal, tax, total, expensiveItems.length);

        return new OrderSummary(total, subtotal, tax, expensiveItems);
    }

    private static double calculateSubtotal(Item[] items) {
        double subtotal = 0;

        for (Item item : items) {
            double itemTotal = item.getPrice() * item.getQuantity();
            subtotal += itemTotal;
            printItemClassification(item);
        }

        return subtotal;
    }

    private static String[] identifyPremiumItems(Item[] items) {
        String[] tempPremiumItems = new String[items.length];
        int premiumCount = 0;

        for (Item item : items) {
            if (isPremiumItem(item)) {
                tempPremiumItems[premiumCount] = item.getName();
                premiumCount++;
            }
        }

        return trimArray(tempPremiumItems, premiumCount);
    }

    private static boolean isPremiumItem(Item item) {
        return item.getPrice() > PREMIUM_PRICE_THRESHOLD;
    }

    private static void printItemClassification(Item item) {
        String classification = isPremiumItem(item) ? "premium" : "regular";
        System.out.println(item.getName() + " is a " + classification + 
                         " item at $" + item.getPrice());
    }

    private static double calculateTax(double subtotal, double taxRate) {
        return subtotal > 0 ? subtotal * taxRate : 0;
    }

    private static String[] trimArray(String[] array, int actualSize) {
        String[] trimmed = new String[actualSize];
        for (int i = 0; i < actualSize; i++) {
            trimmed[i] = array[i];
        }
        return trimmed;
    }

    private static void printOrderDetails(double subtotal, double tax, 
                                         double total, int premiumCount) {
        System.out.println("Subtotal: $" + subtotal);
        System.out.println("Tax: $" + tax);
        System.out.println("Total: $" + total);
        System.out.println("Number of premium items: " + premiumCount);
    }
}
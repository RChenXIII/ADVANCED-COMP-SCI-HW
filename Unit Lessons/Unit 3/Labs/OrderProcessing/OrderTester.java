public class OrderTester {
    
    public static void main(String[] args) {
        System.out.println("=== Running Order Processor Tests ===\n");
        
        testOriginalScenario();
        testEmptyOrder();
        testAllPremiumItems();
        testNoPremiumItems();
        testZeroTaxRate();
        
        System.out.println("\n=== All Tests Completed ===");
    }
    
    private static void testOriginalScenario() {
        System.out.println("TEST 1: Original Scenario");
        System.out.println("Expected: Subtotal=$153.84, Tax=$13.85, Total=$167.69, 2 premium items\n");
        
        Item[] items = new Item[] {
            new Item("Notebook", 3.50, 4),
            new Item("Backpack", 59.99, 1),
            new Item("Pencil", 0.99, 10),
            new Item("Calculator", 79.95, 1)
        };
        
        OrderSummary summary = OrderProcessor.processCustomerOrder(items, 0.09);
        printTestResults(summary);
        System.out.println("---\n");
    }
    
    private static void testEmptyOrder() {
        System.out.println("TEST 2: Empty Order");
        System.out.println("Expected: Subtotal=$0.00, Tax=$0.00, Total=$0.00, 0 premium items\n");
        
        Item[] items = new Item[] {};
        
        OrderSummary summary = OrderProcessor.processCustomerOrder(items, 0.09);
        printTestResults(summary);
        System.out.println("---\n");
    }
    
    private static void testAllPremiumItems() {
        System.out.println("TEST 3: All Premium Items");
        System.out.println("Expected: All items should be premium\n");
        
        Item[] items = new Item[] {
            new Item("Laptop", 899.99, 1),
            new Item("Monitor", 299.50, 2),
            new Item("Keyboard", 150.00, 1)
        };
        
        OrderSummary summary = OrderProcessor.processCustomerOrder(items, 0.08);
        printTestResults(summary);
        System.out.println("---\n");
    }
    
    private static void testNoPremiumItems() {
        System.out.println("TEST 4: No Premium Items");
        System.out.println("Expected: 0 premium items\n");
        
        Item[] items = new Item[] {
            new Item("Pen", 1.50, 5),
            new Item("Eraser", 0.75, 10),
            new Item("Ruler", 2.99, 3)
        };
        
        OrderSummary summary = OrderProcessor.processCustomerOrder(items, 0.07);
        printTestResults(summary);
        System.out.println("---\n");
    }
    
    private static void testZeroTaxRate() {
        System.out.println("TEST 5: Zero Tax Rate");
        System.out.println("Expected: Tax should be $0.00\n");
        
        Item[] items = new Item[] {
            new Item("Book", 25.00, 2),
            new Item("Magazine", 5.99, 1)
        };
        
        OrderSummary summary = OrderProcessor.processCustomerOrder(items, 0.0);
        printTestResults(summary);
        System.out.println("---\n");
    }
    
    private static void printTestResults(OrderSummary summary) {
        System.out.println("\n--- Test Results ---");
        System.out.printf("Subtotal: $%.2f%n", summary.getSubtotal());
        System.out.printf("Tax: $%.2f%n", summary.getTax());
        System.out.printf("Total: $%.2f%n", summary.getTotal());
        
        String[] premium = summary.getExpensiveItems();
        System.out.println("Premium items (" + premium.length + "):");
        if (premium.length == 0) {
            System.out.println("  (none)");
        } else {
            for (String item : premium) {
                System.out.println("  - " + item);
            }
        }
    }
}
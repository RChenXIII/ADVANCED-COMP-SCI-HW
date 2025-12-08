// LibraryTester.java
public class LibraryTester {
    public static void main(String[] args) {
        // Create some test books
        int[] book1Ratings = {5, 5, 4, 5};
        int[] book2Ratings = {3, 4, 3, 4};
        int[] book3Ratings = {5, 3, 4, 5};
        
        BookRecord book1 = new BookRecord("1984", "George Orwell", book1Ratings);
        BookRecord book2 = new BookRecord("Dune", "Frank Herbert", book2Ratings);
        BookRecord book3 = new BookRecord("Foundation", "Isaac Asimov", book3Ratings);
        
        // Test BookRecord methods
        System.out.println("=== Testing BookRecord ===");
        System.out.println(book1.toString());
        System.out.println("Expected: 1984 by George Orwell, ratings: [5, 5, 4, 5]");
        System.out.println();
        
        System.out.println("Average rating (0-3): " + book1.getAverageRating(0, 3));
        System.out.println("Expected: 4.75");
        System.out.println();
        
        System.out.println("Get rating at index 1: " + book1.getRating(1));
        System.out.println("Expected: 5");
        System.out.println();
        
        System.out.println("Book1 consistently rated? " + book1.isConsistentlyRated());
        System.out.println("Expected: true");
        System.out.println("Book3 consistently rated? " + book3.isConsistentlyRated());
        System.out.println("Expected: false");
        System.out.println();
        
        System.out.println("Book1 final rating: " + book1.getFinalRating());
        System.out.println("Book2 final rating: " + book2.getFinalRating());
        System.out.println("Book3 final rating: " + book3.getFinalRating());
        System.out.println();
        
        System.out.println("=== Testing equals() ===");
        int[] book1Ratings2 = {5, 5, 4, 5};
        BookRecord book1Copy = new BookRecord("1984", "George Orwell", book1Ratings2);
        System.out.println("book1.equals(book1Copy): " + book1.equals(book1Copy));
        System.out.println("Expected: true");
        System.out.println("book1.equals(book2): " + book1.equals(book2));
        System.out.println("Expected: false");
        System.out.println();
        
        // Test Library with pre-filled array
        BookRecord[] initialBooks = {book1, book2};
        Library lib = new Library("City Library", initialBooks);
        
        System.out.println("=== Testing Library toString() ===");
        System.out.println(lib.toString());
        System.out.println();
        
        System.out.println("=== Testing findTopRatedBook() ===");
        System.out.println("Top rated book: " + lib.findTopRatedBook());
        System.out.println();
        
        System.out.println("=== Testing calculateAverageForRating() ===");
        System.out.println("Rating index 0 average: " + lib.calculateAverageForRating(0));
        System.out.println("Rating index 3 average: " + lib.calculateAverageForRating(3));
        System.out.println();
        
        // Test Library with capacity constructor
        System.out.println("=== Testing Library(String, int) Constructor ===");
        Library newLib = new Library("Tech Library", 3);
        System.out.println("Created library: " + newLib.getLibraryName());
        System.out.println("Capacity: " + newLib.getBooks().length);
        System.out.println("Expected: 3");
        System.out.println();
        
        System.out.println("=== Testing countBooks() - Empty ===");
        System.out.println("Books in library: " + newLib.countBooks());
        System.out.println("Expected: 0");
        System.out.println();
        
        System.out.println("=== Testing isFull() - Empty ===");
        System.out.println("Is full? " + newLib.isFull());
        System.out.println("Expected: false");
        System.out.println();
        
        System.out.println("=== Testing addBook() ===");
        newLib.addBook(book1);
        System.out.println("Added book1");
        System.out.println("Books in library: " + newLib.countBooks());
        System.out.println("Expected: 1");
        System.out.println();
        
        newLib.addBook(book2);
        System.out.println("Added book2");
        System.out.println("Books in library: " + newLib.countBooks());
        System.out.println("Expected: 2");
        System.out.println();
        
        System.out.println("=== Testing isFull() - Partially Full ===");
        System.out.println("Is full? " + newLib.isFull());
        System.out.println("Expected: false");
        System.out.println();
        
        newLib.addBook(book3);
        System.out.println("Added book3");
        System.out.println("Books in library: " + newLib.countBooks());
        System.out.println("Expected: 3");
        System.out.println();
        
        System.out.println("=== Testing isFull() - Full ===");
        System.out.println("Is full? " + newLib.isFull());
        System.out.println("Expected: true");
        System.out.println();
        
        System.out.println("=== Testing Library toString() - After Adding ===");
        System.out.println(newLib.toString());
        
        System.out.println("=== Testing addBook() - When Full ===");
        int[] book4Ratings = {4, 4, 4, 4};
        BookRecord book4 = new BookRecord("Neuromancer", "William Gibson", book4Ratings);
        newLib.addBook(book4);
        System.out.println("Attempted to add book4 (should fail)");
        System.out.println("Books in library: " + newLib.countBooks());
        System.out.println("Expected: 3");
        System.out.println();
        
        System.out.println("=== Testing removeBook() - Success ===");
        boolean removed = newLib.removeBook(book2);
        System.out.println("Removed book2? " + removed);
        System.out.println("Expected: true");
        System.out.println("Books in library: " + newLib.countBooks());
        System.out.println("Expected: 2");
        System.out.println();
        
        System.out.println("=== Testing removeBook() - Not Found ===");
        removed = newLib.removeBook(book4);
        System.out.println("Removed book4? " + removed);
        System.out.println("Expected: false");
        System.out.println();
        
        System.out.println("=== Testing addBook() - After Removal ===");
        newLib.addBook(book4);
        System.out.println("Added book4");
        System.out.println("Books in library: " + newLib.countBooks());
        System.out.println("Expected: 3");
        System.out.println();
        
        System.out.println("=== Testing expandCapacityBy() ===");
        System.out.println("Current capacity: " + newLib.getBooks().length);
        System.out.println("Expected: 3");
        newLib.expandCapacityBy(2);
        System.out.println("After expanding by 2: " + newLib.getBooks().length);
        System.out.println("Expected: 5");
        System.out.println("Books in library: " + newLib.countBooks());
        System.out.println("Expected: 3 (same books)");
        System.out.println();
        
        System.out.println("=== Testing addBook() - After Expansion ===");
        newLib.addBook(book2);
        System.out.println("Added book2 again");
        System.out.println("Books in library: " + newLib.countBooks());
        System.out.println("Expected: 4");
        System.out.println();
        
        System.out.println("=== Testing findTopRatedBook() - New Library ===");
        System.out.println("Top rated book: " + newLib.findTopRatedBook());
        System.out.println();
        
        System.out.println("=== Testing calculateAverageForRating() - New Library ===");
        System.out.println("Rating index 0 average: " + newLib.calculateAverageForRating(0));
        System.out.println("Rating index 3 average: " + newLib.calculateAverageForRating(3));
    }
}
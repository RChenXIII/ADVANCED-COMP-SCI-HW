// Library.java
public class Library {
    private String libraryName;
    private BookRecord[] books;

    // Constructor with pre-filled array
    public Library(String libraryName, BookRecord[] books) {
        // TODO: Initialize instance variables
        this.libraryName = libraryName;
        this.books = books;
    }

    // Constructor with capacity (creates empty array)
    public Library(String libraryName, int capacity) {
        // TODO: Initialize libraryName and create empty array with given capacity
        this.libraryName = libraryName;
        this.books = new BookRecord[capacity];
    }

    // Getters and Setters
    public String getLibraryName() {
        // TODO
        return libraryName;
    }

    public BookRecord[] getBooks() {
        // TODO
        return books;
    }

    public void setLibraryName(String libraryName) {
        // TODO
        this.libraryName = libraryName;
    }

    public void setBooks(BookRecord[] books) {
        // TODO
        this.books = books;
    }

    // toString: Display library name and all books (skip nulls)
    public String toString() {
        // TODO
        String result = "== " + libraryName + " ==\n";
        for (int i = 0; i < books.length; i++) {
            if (books[i] != null) {
                result += (i + 1) + ".) " + books[i].toString() + "\n";
            }
        }
        return result;
    }

    // findTopRatedBook: Returns title of book with highest final rating
    public String findTopRatedBook() {
        // TODO
        if (books.length == 0) {
            return "";
        }

        String bestBook = null;
        double bestAverage = -1;

        for (int i = 0; i < books.length; i++) {
            if (books[i] != null) {
                double currentAverage = books[i].getFinalRating();
                if (bestBook == null || currentAverage > bestAverage) {
                    bestAverage = currentAverage;
                    bestBook = books[i].getTitle();
                }
            }
        }

        return bestBook == null ? "" : bestBook;
    }

    // calculateAverageForRating: Returns average across all books for a rating position
    public double calculateAverageForRating(int ratingIndex) {
        // TODO
        double sum = 0;
        int count = 0;

        for (int i = 0; i < books.length; i++) {
            if (books[i] != null) {
                int score = books[i].getRating(ratingIndex);
                if (score != -1) {
                    sum += score;
                    count++;
                }
            }
        }

        if (count == 0) {
            return 0;
        }

        return sum / count;
    }

    // isFull: Returns true if no null entries in array
    public boolean isFull() {
        // TODO
        for (int i = 0; i < books.length; i++) {
            if (books[i] == null) {
                return false;
            }
        }
        return true;
    }

    // addBook: Add book to first available spot (use return, not break)
    public void addBook(BookRecord book) {
        // TODO
        for (int i = 0; i < books.length; i++) {
            if (books[i] == null) {
                books[i] = book;
                return;
            }
        }
    }

    // removeBook: Find and remove book (set to null), return true if found
    public boolean removeBook(BookRecord book) {
        // TODO
        for (int i = 0; i < books.length; i++) {
            if (books[i] != null && books[i].getTitle().equals(book.getTitle())) {
                books[i] = null;
                return true;
            }
        }
        return false;
    }

    // countBooks: Returns number of non-null books
    public int countBooks() {
        // TODO
        int count = 0;
        for (int i = 0; i < books.length; i++) {
            if (books[i] != null) {
                count++;
            }
        }
        return count;
    }

    // expandCapacityBy: Create larger array, copy existing books
    public void expandCapacityBy(int increase) {
        // TODO
        BookRecord[] newArray = new BookRecord[books.length + increase];

        for (int i = 0; i < books.length; i++) {
            newArray[i] = books[i];
        }

        books = newArray;
    }
}

// BookRecord.java
public class BookRecord {
    private String title;
    private String author;
    private int[] ratings;

    // Constructor
    public BookRecord(String title, String author, int[] ratings) {
        // TODO: Initialize instance variables
        this.title = title;
        this.author = author;
        this.ratings = ratings;
    }

    // Getters and Setters
    public String getTitle() {
        // TODO
        return title;
    }

    public String getAuthor() {
        // TODO
        return author;
    }

    public int[] getRatings() {
        // TODO
        return ratings;
    }

    public void setTitle(String title) {
        // TODO
        this.title = title;
    }

    public void setAuthor(String author) {
        // TODO
        this.author = author;
    }

    public void setRatings(int[] ratings) {
        // TODO
        this.ratings = ratings;
    }

    // toString: Returns "[title] by [author], ratings: [rating1, rating2, ...]"
    public String toString() {
        // TODO
        String result = title + " by " + author + ", ratings: [";
        for (int i = 0; i < ratings.length; i++) {
            result += ratings[i];
            if (i < ratings.length - 1) {
                result += ", ";
            }
        }
        result += "]";
        return result;
    }

    // equals: Returns true if both books have same title, author, and all ratings match
    public boolean equals(BookRecord other) {
        if (!this.title.equals(other.title)) {
            return false;
        }

        if (this.author.equals(other.author)) {
            return false;
        }

        for (int i = 0; i < this.ratings.length; i++) {
            if (this.ratings[i] != other.ratings[i]) {
                return false;
            }
        }

        return true;
    }

    // getAverageRating: Returns average of ratings from index first to last (inclusive)
    public double getAverageRating(int first, int last) {
        // TODO
        double sum = 0;
        for (int i = first; i <= last; i++) {
            sum += ratings[i];
        }
        return sum / (last - first + 1);
    }

    // getRating: Returns rating at given index, or -1 if out of bounds
    public int getRating(int index) {
        // TODO

        if (index < 0 || index >= ratings.length) {
            return -1;
        }
        return ratings[index];
    }


    // isConsistentlyRated: Returns true if all ratings differ by at most 1
    public boolean isConsistentlyRated() {
        // TODO
        if (ratings.length == 0) {
            return true;
        }

        int min = ratings[0];
        int max = ratings[0];

        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] < min) {
                min = ratings[i];
            }
            if (ratings[i] > max) {
                max = ratings[i];
            }
        }

        return (max - min) <= 1;
    }


    // getFinalRating: If consistently rated, return average of last half
    // Otherwise return average of all ratings
    public double getFinalRating() {
        // TODO
        if (isConsistentlyRated()) {
            return getAverageRating(ratings.length / 2, ratings.length - 1);
        } else {
            return getAverageRating(0, ratings.length - 1);
        }
    }
}

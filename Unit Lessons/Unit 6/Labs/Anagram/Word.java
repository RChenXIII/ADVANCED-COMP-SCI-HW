public class Word {
    private String originalWord;
    private String sortedWord;

    public Word(String originalWord) {
        this.originalWord = (originalWord == null) ? "" : originalWord.trim();
        this.sortedWord = sortWord();
    }

    public String getOriginalWord() {
        return originalWord;
    }

    public String getSortedWord() {
        return sortedWord;
    }

    public String sortWord() {
        String normalized = originalWord.toLowerCase();
        char[] letters = normalized.toCharArray();

        // Selection sort
        for (int i = 0; i < letters.length; i++) {
            int min = i;
            for (int j = i + 1; j < letters.length; j++) {
                if (letters[j] < letters[min]) {
                    min = j;
                }
            }
            // Swap
            char temp = letters[i];
            letters[i] = letters[min];
            letters[min] = temp;
        }

        return new String(letters);
    }
}

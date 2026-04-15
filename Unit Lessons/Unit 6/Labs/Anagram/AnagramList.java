import java.util.AbstractList;
import java.util.ArrayList;
public class AnagramList extends AbstractList<Word> {
    
    private ArrayList<Word> wordList;

    //constructor
    public AnagramList() {
        wordList = new ArrayList<Word>();
    }

    public boolean add(Word word) {
        wordList.add(word);
        return true;
    }

    public boolean checkAnagram(Word word1, Word word2) {
        if (word1 == null || word2 == null) {
            return false;
        }
        String sorted1 = word1.getSortedWord();
        String sorted2 = word2.getSortedWord();

        if (sorted1 == null || sorted2 == null) {
            return false;
        }

        return sorted1.equalsIgnoreCase(sorted2);
    }

    public ArrayList<Word> searchAnagrams(String key) {
        ArrayList<Word> anagrams = new ArrayList<Word>();

        if (key == null) {
            return anagrams;
        }

        key = key.trim();
        Word keyWord = new Word(key);

        for (Word currentWord : wordList) {
            if (checkAnagram(keyWord, currentWord)) {
                anagrams.add(currentWord);
            }
        }
        return anagrams;
    }

    @Override
    public Word get(int index) {
        return wordList.get(index);
    }

    @Override
    public int size() {
        return wordList.size();
    }
}
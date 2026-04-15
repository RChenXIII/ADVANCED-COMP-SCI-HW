import java.util.ArrayList;

public class AnagramListTester {
    public static void main(String[] args) {
        

        AnagramList list = new AnagramList();
        

        list.add(new Word("listen"));
        list.add(new Word("silent"));
        list.add(new Word("enlist"));
        list.add(new Word("hello"));
        list.add(new Word("world"));
        list.add(new Word("tinsel"));
        list.add(new Word("inlets"));
        
        System.out.println("Total words in list: " + list.size());
        System.out.println();
        

        System.out.println("=== Testing checkAnagram ===");
        Word word1 = new Word("listen");
        Word word2 = new Word("silent");
        Word word3 = new Word("hello");
        
        System.out.println("Is 'listen' an anagram of 'silent'? " + 
                           list.checkAnagram(word1, word2)); // true
        System.out.println("Is 'listen' an anagram of 'hello'? " + 
                           list.checkAnagram(word1, word3)); // false
        System.out.println();
        
  
        System.out.println("=== Testing searchAnagrams ===");
        String key = "silent";
        ArrayList<Word> anagrams = list.searchAnagrams(key);
        
        System.out.println("Anagrams of '" + key + "':");
        for (Word w : anagrams) {
            System.out.println("  - " + w.getOriginalWord() + " (sorted: " + w.getSortedWord() + ")");
        }
        System.out.println("Found " + anagrams.size() + " anagrams");
        System.out.println();
        
   
        key = "hello";
        anagrams = list.searchAnagrams(key);
        System.out.println("Anagrams of '" + key + "':");
        if (anagrams.isEmpty()) {
            System.out.println("  (no anagrams found)");
        } else {
            for (Word w : anagrams) {
                System.out.println("  - " + w.getOriginalWord());
            }
        }
        System.out.println();
        
        System.out.println("=== Testing AbstractList methods ===");
        System.out.println("First word in list: " + list.get(0).getOriginalWord());
        System.out.println("Third word in list: " + list.get(2).getOriginalWord());
        

        System.out.println();
        Word testWord = new Word("listen");
        System.out.println("Original: " + testWord.getOriginalWord());
        System.out.println("Sorted:   " + testWord.getSortedWord());
        
        testWord = new Word("silent");
        System.out.println("Original: " + testWord.getOriginalWord());
        System.out.println("Sorted:   " + testWord.getSortedWord());
    }
}
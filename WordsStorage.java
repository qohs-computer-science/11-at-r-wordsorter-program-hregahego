import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class WordsStorage {
    HashMap<Character, HashSet<String>> words;
    int totalCount;
    public WordsStorage() {
        totalCount = 0;
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        words = new HashMap<Character, HashSet<String>>();
        for(Character i : alphabet) {
            words.put(i, new HashSet<String>());
        }
    }
    public void addWord(String word) {
        char letter = word.toLowerCase().charAt(0);
        if ( words.get(letter).add(word.toLowerCase()) ) {
            totalCount++;
        }
    }

    public void deleteWord(String word) {
        char letter = word.toLowerCase().charAt(0);
        if ( words.get(letter).remove(word.toLowerCase()) ) {
           totalCount--; 
        }
    }

    public void print() {
        if (totalCount == 0) {System.out.println("Empty List"); return;}
        for (Map.Entry<Character, HashSet<String>> e : words.entrySet()) {
            if (words.get(e.getKey()).size() != 0) {
                for(String word : words.get(e.getKey())) {
                    System.out.print(word + ", ");
                }
                System.out.println();
            }   
        }
    }

    public void print(Character letter) {
        if (words.get(letter).size() != 0) {
            for(String word : words.get(letter)) {
                System.out.print(word + ", ");
            }
            System.out.println();
        } else {
            System.out.println("No words start with this letter");
        }
        
    }

    public String numWords() {
        if (totalCount > 0) {
            return "There are " + totalCount + " unique words in the article";
        } else {
            return "Empty List";
        }
    }

    public boolean search(String target) {
        for (Map.Entry<Character, HashSet<String>> e : words.entrySet()) {
            for(String word : words.get(e.getKey())) {
                if (word.toLowerCase().equals(target)) return true;
            }
        }
        return false;
    }
}

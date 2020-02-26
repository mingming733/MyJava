import java.util.ArrayList;
import java.util.List;

public class AmOA1 {
    List<List<String>> threeKeyWordSuggestions(int numReviews, List<String> repository, String customerQuery) {
        List<List<String>> result = new ArrayList<>();
        if (repository == null || repository.size() == 0 || customerQuery.length() < 2) {
            return result;
        }
        Trie1 trie = new Trie1();
        for (int i = 0; i < numReviews; i++) {
            trie.insert(repository.get(i));
        }
        for (int i = 2; i <= customerQuery.length(); i++) {
            List<String> level = new ArrayList<>();
            String target = customerQuery.substring(0, i);
            TrieNode1 resNode = trie.startsWith(target);
            if (resNode != null) {

            }
        }
        return result;
    }
}
class TrieNode1 {
    private TrieNode1[] children;
    public boolean hasWord;
    public Character c;

    public TrieNode1(Character c) {
        children = new TrieNode1[26];
        hasWord = false;
        this.c = c;
    }

    public void insert(String word, int index) {
        if (index == word.length()) {
            this.hasWord = true;
            return;
        }

        int pos = word.charAt(index) - 'a';
        if (children[pos] == null) {
            children[pos] = new TrieNode1(word.charAt(index));
        }
        children[pos].insert(word, index + 1);
    }

    public TrieNode1 find(String word, int index) {
        if (index == word.length()) {
            return this;
        }

        int pos = word.charAt(index) - 'a';
        if (children[pos] == null) {
            return null;
        }
        return children[pos].find(word, index + 1);
    }
}
class Trie1 {
    private TrieNode1 root;

    public Trie1() {
        root = new TrieNode1('c');
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        root.insert(word, 0);
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode1 node = root.find(word, 0);
        return (node != null && node.hasWord);
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public TrieNode1 startsWith(String prefix) {
        TrieNode1 node = root.find(prefix, 0);
        return node ;
    }

//    public List<String> getRestWords(String prefix, TrieNode1 start) {
//        List<String> left = getRestWords(prefix + start.c, start.)
//    }
}
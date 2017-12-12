import java.util.HashMap;

public class Trie {
    TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode curNode = root;
        for(int i = 0; i < word.length(); i++){
            char c =  word.charAt(i);
            if(!curNode.children.containsKey(c)){
                curNode.children.put(c, new TrieNode(c));
            }
            curNode = curNode.children.get(c);
        }
        curNode.hasWord = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode curNode = root;
        for(int i = 0; i < word.length(); i++){
            char c =  word.charAt(i);
            if(!curNode.children.containsKey(c)){
                return false;
            }
            curNode = curNode.children.get(c);
        }
        return curNode.hasWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode curNode = root;
        for(int i = 0; i < prefix.length(); i++){
            char c =  prefix.charAt(i);
            if(!curNode.children.containsKey(c)){
                return false;
            }
            curNode = curNode.children.get(c);
        }
        return true;
    }
}
class TrieNode{
    char c;
    boolean hasWord;
    HashMap<Character, TrieNode> children = new HashMap<>();
    public TrieNode(){
        children = new HashMap<>();
    }
    public TrieNode(char c){
        this.c = c;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
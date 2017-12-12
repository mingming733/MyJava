import java.util.ArrayList;
import java.util.HashMap;

public class Wordsearch {
    /**
     * @param board: A list of lists of character
     * @param words: A list of string
     * @return: A list of string
     */
    public ArrayList<String> wordSearchII(char[][] board, ArrayList<String> words) {
        // write your code here
        Trienode root = new Trienode();
        for(int i = 0; i < words.size(); i++){
            addWord(words.get(i), root);
        }
        ArrayList<String> result = new ArrayList<>();
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                StringBuilder sb = new StringBuilder();
                sb.append(board[i][j]);
                dfs(board, new Point1(i, j), sb, root, result);
            }
        }
        return result;
    }
    private void addWord(String word, Trienode root){
        Trienode curr = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(!curr.map.containsKey(c)){
                curr.map.put(c, new Trienode());
            }
            curr = curr.map.get(c);
        }
        curr.hasWord = true;
    }

    private void dfs(char[][] board, Point1 p, StringBuilder word, Trienode root, ArrayList<String> result){
        char c = board[p.x][p.y];
        if(!root.map.containsKey(c)){
            return;
        }
        if(root.map.get(c).hasWord ){
            result.add(word.toString());
        }
        int[] dx = new int[]{-1, 0, 1, 0};
        int[] dy = new int[]{0, 1, 0, -1};
        for(int i = 0; i < 4; i++){
            int nx = p.x + dx[i];
            int ny = p.y + dy[i];
            if(nx >= 0 && nx < board.length && ny >= 0 && ny < board[0].length){
                word.append(board[nx][ny]);
                char now = board[p.x][p.y];
                board[p.x][p.y] = 0;
                dfs(board, new Point1(nx, ny), word, root.map.get(c), result);
                word.deleteCharAt(word.length() - 1);
                board[p.x][p.y] = now;
            }
        }
    }

}
class Trienode{
    char c;
    HashMap<Character, Trienode> map;
    boolean hasWord;
    public Trienode(){
        map = new HashMap<>();
    }
    public Trienode(Character c, HashMap<Character, Trienode> map){
        this.c = c;
        this.map = map;
    }
}

class Point1{
    int x;
    int y;
    public Point1(int x, int y){
        this.x = x;
        this.y = y;
    }
}
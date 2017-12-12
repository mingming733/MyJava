import java.util.*;

public class WordLadderII {
    int layer;
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> paths = new ArrayList<>();
        wordList.add(beginWord);
        List<String> path = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        bfs(map, beginWord, endWord, wordList);
        layer = map.get(endWord);
        dfs(paths, path, beginWord, endWord, map, wordList);
        return paths;
    }
    private void dfs(List<List<String>> paths, List<String> path, String end, String start, HashMap<String, Integer> map, List<String> wordList){
        path.add(0, start);
        if(start.equals(end)){
            paths.add(new ArrayList<>(path));
        }
        ArrayList<String> neighbours = getNeighbours(wordList, start);
        for(String neighbour : neighbours){
            if(map.containsKey(neighbour) && map.get(neighbour) < map.get(start)){
                dfs(paths, path, end, neighbour, map, wordList);
            }
        }
        path.remove(0);
    }
    private void bfs(HashMap<String, Integer> map, String beginWord, String endWord, List<String> wordList){
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        map.put(beginWord, 0);
        int length = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            length++;
            for(int i = 0; i < size; i++){
                String word = queue.poll();
                ArrayList<String> neighbours = getNeighbours(wordList, word);
                for(int j = 0; j < neighbours.size(); j++){
                    String neighbour = neighbours.get(j);
                    if(neighbour.equals(endWord)){
                        map.put(endWord, length);
                        return;
                    }
                    if(!map.containsKey(neighbour)){
                        map.put(neighbour, length);
                        queue.offer(neighbour);
                    }
                }
            }
        }
    }
    private ArrayList<String> getNeighbours(List<String> wordList, String word){
        ArrayList<String> neighbours = new ArrayList<>();
        for(int i = 0; i < wordList.size(); i++){
            int diff = 0;
            String word2 = wordList.get(i);
            for(int j = 0; j < word.length(); j++){
                if(word.charAt(j) != word2.charAt(j)){
                    diff++;
                }
            }
            if(diff == 1){
                neighbours.add(word2);
            }
        }
        return neighbours;
    }
}
import java.util.*;

class Solution1 {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> ladders = new ArrayList<>();
        if (wordList == null || wordList.size() == 0) {
            return ladders;
        }
        if (!wordList.contains(beginWord)) {
            wordList.add(beginWord);
        }
        HashMap<String, Integer> levels = new HashMap<>();
        bfs(levels, beginWord, endWord, wordList);
        dfs(levels, endWord, beginWord, wordList, new ArrayList<>(), ladders);
        System.out.println(ladders.size());
        return ladders;
    }
    private void bfs(HashMap<String, Integer> levels, String beginWord, String endWord, List<String> wordList) {
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int level = 0;
        int counter = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;
            for (int i = 0; i < size; i++) {
                String curr = queue.poll();
                counter++;
                if (!levels.containsKey(curr)) {
                    levels.put(curr, level);
                    List<String> neighbours = findNeighbours(curr, wordList);
                    for (String word : neighbours) {
                        queue.offer(word);
                    }
                }
                if (curr == endWord) {

                    System.out.println("counter: " + counter);
                    return;

                }
            }
        }
    }
    private void dfs(HashMap<String, Integer> levels, String beginWord, String endWord, List<String> wordList, List<String> ladder, List<List<String>> ladders) {
        ladder.add(0, beginWord);
        if (beginWord.equals(endWord)) {
            ladders.add(new ArrayList<>(ladder));
        }
        List<String> neighbours = findNeighbours(beginWord, wordList);
        for (String neighbour : neighbours) {
            if (levels.containsKey(beginWord) && levels.get(neighbour) < levels.get(beginWord)) {
                dfs(levels, neighbour, endWord, wordList, ladder, ladders);
            }

        }
        ladder.remove(0);
    }
    private List<String> findNeighbours(String word, List<String> wordList) {
        List<String> neighbours = new ArrayList<>();
        for (String str : wordList) {
            int diff = 0;
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) != word.charAt(i)) {
                    diff++;
                }
            }
            if (diff == 1) {
                neighbours.add(str);
            }
        }
        return neighbours;
    }
}
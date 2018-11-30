import java.util.*;

/**
 * Created by mming on 10/2/18.
 */
public class AlienDictionary {
    public String alienOrder(String[] words) {
        // done by Ming
        Map<Character, HashSet<Character>> edges = new HashMap<>();
        // note down nodes
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                edges.put(words[i].charAt(j), new HashSet<>());
            }
        }
        // create edges
        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];
            for (int j = 0; j < word1.length() && j < word2.length(); j++) {
                if (word1.charAt(j) != word2.charAt(j)) {
                    edges.get(word1.charAt(j)).add(word2.charAt(j));
                    break;
                }
            }
        }
        Map<Character, Integer> indegree = new HashMap<>();
        countIndegree(edges, indegree);
        Queue<Character> queue = new LinkedList<>();
        for (Character node : edges.keySet()) {
            if (!indegree.containsKey(node)) {
                queue.offer(node);
            }
        }
        int nodeVisited = 0;
        StringBuilder result = new StringBuilder();
        while (!queue.isEmpty()) {
            Character curr = queue.poll();
            result.append(curr);
            nodeVisited++;
            for (Character outNode : edges.get(curr)) {
                indegree.put(outNode, indegree.get(outNode) - 1);
                if (indegree.get(outNode) == 0) {
                    queue.offer(outNode);
                }
            }
        }
        if (nodeVisited < edges.size()) {
            return "";
        } else {
            return result.toString();
        }
    }
    private void countIndegree(Map<Character, HashSet<Character>> edges, Map<Character, Integer> indegree){
        for (Map.Entry<Character, HashSet<Character>> entry : edges.entrySet()) {
            for (Character toNode: entry.getValue()) {
                int count = 0;
                if (indegree.containsKey(toNode)) {
                    count = indegree.get(toNode);
                }
                indegree.put(toNode, count + 1);
            }
        }
    }


}

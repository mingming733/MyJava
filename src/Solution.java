import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public boolean isBipartite(int[][] graph) {
        HashMap<Integer, Boolean> group = new HashMap<>();
        HashSet<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int j = 0; j < graph.length; j++) {
            if (graph[j] != null && graph[j].length != 0) {
                queue.offer(j);
                visited.add(j);
                boolean flag = true;
                group.put(j, true);
                while (!queue.isEmpty()) {
                    int size = queue.size();
                    flag = !flag;
                    for (int i = 0; i < size; i++) {
                        int vertice = queue.poll();
                        for (int neighbour : graph[vertice]) {
                            if (!visited.contains(neighbour)) {
                                visited.add(neighbour);
                                queue.add(neighbour);
                            }
                            if (group.containsKey(neighbour) && group.get(neighbour) != flag) {
                                return false;
                            } else {
                                group.put(neighbour, flag);
                            }
                        }
                    }
                }
            }
        }

        return true;
    }

}
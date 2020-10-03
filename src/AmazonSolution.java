import java.util.*;
public class AmazonSolution
{
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
// RETURN "null" IF NO ITEM ASSOCIATION IS GIVEN
    List<String> largestItemAssociation(List<PairString> itemAssociation)
    {
// WRITE YOUR CODE HERE
        int n = itemAssociation.size();

        int index = 0;
        Map<String, Integer> map = new HashMap<>();
        List<String> res = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            if(!map.containsKey(itemAssociation.get(i).first)) {
                map.put(itemAssociation.get(i).first, index++);
            }
            if(!map.containsKey(itemAssociation.get(i).second)) {
                map.put(itemAssociation.get(i).second, index++);
            }
        }

        UnionFind un = new UnionFind(map.size());

        for(int i = 0; i < n; i++) {
            un.union(map.get(itemAssociation.get(i).first), map.get(itemAssociation.get(i).second));
        }

        int maxIndex = un.findMaxSize();

        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            Integer ind = entry.getValue();

            if(un.find(ind) == maxIndex) {
                res.add(key);
            }

        }
        return res;
    }
// METHOD SIGNATURE ENDS

    class UnionFind {
        int[] father = null;
        int[] size = null;
        UnionFind(int n) {
            father = new int[n];
            size = new int[n];
            for(int i = 0; i < n; i++) {
                father[i] = i;
                size[i] = 1;
            }
        }

        void union(int a, int b) {
            int root_a = find(a);
            int root_b = find(b);
            if(root_a != root_b) {
                father[root_b] = root_a;
                size[root_a] += size[root_b];
            }
        }

        int find(int x) {
            if (father[x] == x) {
                return x;
            }
            return father[x] - find(father[x]);
        }

        int findMaxSize() {
            int max = 0;
            int index = 0;
            for(int i = 0; i < size.length; i++) {
                if(size[i] > max) {
                    max = size[i];
                    index = i;
                }
            }
            return index;
        }
    }
}

class PairString{
    String first;
    String second;
}
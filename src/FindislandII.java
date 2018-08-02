import java.util.ArrayList;
import java.util.List;

/**
 * Created by mming on 7/14/18.
 */
class FindislandII {
    int[] fathers;
    int count;
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> result = new ArrayList<>();
        count = 0;
        fathers = new int[m * n];
        for (int i = 0; i < fathers.length; i++) {
            fathers[i] = i;
        }
        int[][] islands = new int[m][n];
        int[] horizontal = new int[]{0, 1, 0, -1};
        int[] vertical = new int[]{1, 0, -1, 0};
        for (int i = 0; i < positions.length; i++) {
            int x = positions[i][0];
            int y = positions[i][1];
            if (islands[x][y] != 1) {
                count++;
                islands[x][y] = 1;
                // System.out.println(x + "," + y);
            }
            for(int j = 0; j < 4; j++) {
                int neighbourX = x + horizontal[j];
                int neighbourY = y + vertical[i];
                if (neighbourX >= 0 && neighbourX < m && neighbourY >= 0
                        && neighbourY < n && islands[neighbourX][neighbourY] == 1) {
                    // System.out.println(x * n + y + "," + (neighbourX * n + neighbourY));
                    union(x * n + y, neighbourX * n + neighbourY);
                }
            }
            result.add(count);
        }
        for(int i = 0; i < islands.length; i ++) {
            for(int j = 0; j < islands[0].length; j++) {
                System.out.print(islands[i][j] + "");
            }
            System.out.println(" ");
        }
        return result;
    }
    private int find (int a) {
        if (fathers[a] == a) {
            return a;
        }
        return fathers[a] = find(fathers[a]);
    }
    private void union(int a, int b) {
        int root_a = find(a);
        int root_b = find(b);
        if (root_a != root_b) {
            // System.out.println(a + "," + b);
            count--;
            fathers[root_a] = root_b;
        }
    }
}
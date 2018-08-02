/**
 * Created by mming on 7/8/18.
 */
public class UF {
    int count = 0;
    int[] fathers;
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                }
            }
        }
        System.out.println(count);
        fathers = new int[grid.length * grid[0].length];
        for (int i = 0; i < fathers.length; i++) {
            fathers[i] = i;
        }
        int[] horizontal = new int[]{-1, 0, 1, 0};
        int[] vertical = new int[]{0, 1, 0, -1};
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    for (int k = 0; k <= 3; k++) {
                        int x = i + horizontal[k];
                        int y = j + vertical[k];
                        if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == '1') {
                            int a = grid[0].length * y + x;
                            int b = grid[0].length * i + j;
                            union(a, b);
                        }
                    }
                }
            }
        }
        return count;
    }
    private int find(int x) {
        if (fathers[x] == x) {
            return x;
        }
        return fathers[x] = find(fathers[x]);
    }
    private void union (int a, int b) {
        int root_a = find(a);
        int root_b = find(b);
        if (root_a != root_b) {
            count--;
            fathers[root_a] = root_b;
        }
    }
}

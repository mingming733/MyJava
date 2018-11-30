import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by mming on 9/18/18.
 */
public class AmazonRobot {
    public int distance(int numRows, int numColumns, int[][] lot) {
        if (numRows == 0 || numColumns == 0 || numRows != lot.length || numColumns != lot[0].length) {
            return -1;
        }
        Queue<Loc> queue = new LinkedList<>();
        queue.offer(new Loc(0, 0));
        int[] horizontal = new int[] {0, 1, 0, -1};
        int[] vertical = new int[] {1, 0, -1, 0};
        int dis = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            dis++;
            for (int i = 0; i < size; i++) {
                Loc loc = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int neighbourX = loc.x + horizontal[j];
                    int neighbourY = loc.y + vertical[j];
                    if (neighbourX >= 0 && neighbourX < numRows && neighbourY >= 0 && neighbourY < numColumns) {
                        if (lot[neighbourX][neighbourY] == 1) {
                            queue.offer(new Loc(neighbourX, neighbourY));
                        } else if (lot[neighbourX][neighbourY] == 9) {
                            return dis;
                        }
                        lot[neighbourX][neighbourY] = -1;
                    }
                }
            }

        }
        return -1;
    }
}
class Loc {
    int x;
    int y;
    public Loc(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

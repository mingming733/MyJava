import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by mming on 9/16/18.
 */
public class AmazonSteakHouse {
    public int[][] find(int n, int[][] locations, int x) {
        PriorityQueue<Location> pq = new PriorityQueue<>(new Comparator<Location>() {
            @Override
            public int compare(Location o1, Location o2) {
               return (int) ((long) (o2.x) *  (long) (o2.x) + (long) o2.y * (long) o2.y - (long) (o1.x) *  (long) (o1.x) - (long) o1.y * (long) o1.y);
            }
        });
        for (int i = 0; i < n; i++) {
            pq.add(new Location(locations[i][0], locations[i][1]));
            if (pq.size() > x) {
                pq.poll();
            }
        }
        int[][] result = new int[x][2];
        for (int i = x - 1; i >= 0; i--) {
            Location close = pq.poll();
            result[i][0] = close.x;
            result[i][1] = close.y;
        }
        return result;
    }
}
class Location {
    int x;
    int y;
    public Location (int x, int y) {
        this.x = x;
        this.y = y;
    }
}

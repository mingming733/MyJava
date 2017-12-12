/**
 * Created by mming on 1/28/17.
 */
import java.lang.Math.*;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KthNearest {
    public Point[] Solution(Point[] array, final Point origin, int k) {
        PriorityQueue<Point> kthNearestPoints = new PriorityQueue<>(k, new Comparator<Point>() {
            @Override
            public int compare(Point p1, Point p2) {
                double diff = getDistance(p1, origin) - getDistance(p2, origin);
                if(diff > 0){
                    return 1;
                }else if (diff == 0){
                    return 0;
                }else{
                    return -1;
                }
            }
        });
        for(int i = 0; i < array.length; i++){
            kthNearestPoints.offer(array[i]);
        }
        Point[] result = new Point[k];
        for (int i = 0; i < k; i++){
            result[i] = kthNearestPoints.poll();
        }
        return result;
    }

    private double getDistance(Point p1, Point p2){
        return (Math.sqrt((p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y)));
    }

}

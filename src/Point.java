/**
 * Created by mming on 1/28/17.
 */
public class Point {
    double x;
    double y;
    public Point(double a, double b) {
        x = a;
        y = b;
    }
    @Override
    public String toString(){
        return "("+x+","+y+")"+(x*x+y*y);
    }
}
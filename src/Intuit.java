import java.util.Comparator;

/**
 * Created by mming on 10/6/17.
 */
public class Intuit {
}
class PointComparator implements Comparator<Pointx> {
    public int compare(Pointx p1, Pointx p2){
        if(p1.time == p2.time){
            return p1.fly - p2.fly;
        }
        return p1.time - p2.time;
    }
}

class Pointx{
    public int time;
    int fly;
    public Pointx(int time, int fly){
        this.time = time;
        this.fly = fly;
    }
}
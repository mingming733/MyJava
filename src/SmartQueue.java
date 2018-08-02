import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by mming on 7/7/18.
 */
/*
* 1. Implement a 'smart' queue where it automatically dedups elements by its keys.e.g.,
push (a, 1)
push (b, 2). more info on 1point3acres
push (a, 3) // since (a, 1) already in queue, this will only update (a, 1) to (a, 3).
now the queue should look like:
(a, 3), (b, 2). 围观我们@1point 3 acres
. From 1point 3acres bbs
*/
public class SmartQueue {
    LinkedList<SmartPair> list = new LinkedList<>();
    HashMap<Integer, SmartPair> map = new HashMap<>();
    public void push(int key, int val) {
        if (!map.containsKey(key)) {
            map.put(key, new SmartPair(key, val));
            list.offer(map.get(key));
        } else {
            map.get(key).val = val;
        }
    }
    public int pop() {
        if (list.isEmpty()) {
            return -1;
        }
        SmartPair curr = list.pop();
        map.remove(curr.key);
        return curr.val;
    }
}
class SmartPair {
    int key;
    int val;
    public SmartPair (int key, int val) {
        this.key = key;
        this.val = val;
    }
}

/**
 * Created by mming on 11/15/17.
 */

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class SummaryRanges {

    /** Initialize your data structure here. */
    TreeSet<Interval> set;
    public SummaryRanges() {
        set = new TreeSet<>(new IntervalComparator());
    }

    public void addNum(int val) {
        boolean merge = false;
        Interval curr = new Interval(val, val);
        Interval floor = set.floor(curr);
        Interval higher = set.higher(curr);
        if(floor != null && floor.end > val){
            return;
        }
        if(floor != null && floor.end == val - 1){
            floor.end = val;
            merge = true;
        }
        if(higher != null && higher.start == val + 1){
            higher.start = val;
            if(merge){
                higher.start = floor.start;
                set.remove(floor);
            }
        }else{
            set.add(curr);
        }
    }

    public List<Interval> getIntervals() {
        List<Interval> result = new ArrayList<>();
        for(Interval interval : set){
            result.add(interval);
        }
        return result;
    }
}
class IntervalComparator implements Comparator<Interval> {
    public int compare(Interval o1, Interval o2){
        return o1.start - o2.start;
    }
}

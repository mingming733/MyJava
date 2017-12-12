/**
 * Created by mming on 1/28/17.
 */
import java.util.*;
public class MaxSubTree {
    class ReturnType {
        int sum;
        int count;
        noder crtMax;
        double maxAvg;
        public ReturnType(int sum, int count, noder crtMax, double maxAvg) {
            this.sum = sum;
            this.count = count;
            this.crtMax = crtMax;
            this.maxAvg = maxAvg;
        }
    }


    public noder getMaxAvgnoder(noder root) {
        return getMaxAvgnoderRecursively(root).crtMax;
    }

    public ReturnType getMaxAvgnoderRecursively(noder root) {
        if (root == null) {
            return new ReturnType(0, 0, null, 0);
        } else if (root.children == null || root.children.size() == 0) {
            return new ReturnType(root.val, 1, null, 0);
        } else {
            List<noder> children = root.children;
            double max = 0;
            noder maxnoder = null;
            int sum = root.val;
            int count = 1;
            for (noder n : children) {
                ReturnType rt = getMaxAvgnoderRecursively(n);
                sum += rt.sum;
                count += rt.count;
                if (rt.maxAvg > max) {
                    max = rt.maxAvg;
                    maxnoder = rt.crtMax;
                }
            }
            double crtAvg = ((double)sum) / count;
            if (crtAvg > max) {
                max = crtAvg;
                maxnoder = root;
            }
            return new ReturnType(sum, count, maxnoder, max);
        }
    }
}
class noder { //这个是题目给好的
    int val;
    ArrayList<noder> children;
    public noder(int val){
        this.val = val;
        children = new ArrayList<noder>();
    }
}
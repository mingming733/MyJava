/**
 * Created by mming on 1/27/17.
 */
import java.util.*;
public class CompnayTree {

    public static Node getMaxAvgNode(Node root){
        if(root == null){
            return null;
        }
        return dfsHelper(root).rootWithMaxAvg;
    }
    private static returnValue dfsHelper(Node root){
        if(root.children == null || root.children.size() == 0){
            return new returnValue(root.val, 1, null, 0);
        }
        List<Node> children = root.children;
        double sum = root.val;
        int count = 1;
        Node node = null;
        double maxVal = 0;
        for(Node child : children){
            returnValue avgChildren = dfsHelper(child);
            sum += avgChildren.sum;
            count += avgChildren.count;
            if(maxVal < avgChildren.maxSoFar){
                maxVal = avgChildren.maxSoFar;
                node = avgChildren.rootWithMaxAvg;
            }
        }
        double avg = sum / count;
        if(maxVal < avg){
            node = root;
            maxVal = sum / count;
        }
        return new returnValue(sum, count, node, maxVal);
    }
}

class returnValue{
    int count;
    double sum;
    Node rootWithMaxAvg;
    double maxSoFar;
    public returnValue(double sum, int count, Node rootWithMaxAvg, double maxSoFar){
        this.count = count;
        this.sum = sum;
        this.rootWithMaxAvg = rootWithMaxAvg;
        this.maxSoFar = maxSoFar;
    }
}

class Node { //这个是题目给好的
    int val;
    ArrayList<Node> children;
    public Node(int val){
        this.val = val;
        children = new ArrayList<Node>();
    }
}
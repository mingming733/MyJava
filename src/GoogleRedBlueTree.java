import java.util.ArrayList;
import java.util.List;

/**
 * Created by mming on 11/25/18.
 */
public class GoogleRedBlueTree {
    public List<GoogleTreeNode> deleteRed(GoogleTreeNode root) {
        List<GoogleTreeNode> result = new ArrayList<>();
        if (root.color.equals("blue")) {
            result.add(root);
        }
        helper(root, result);
        return result;
    }
    private void helper(GoogleTreeNode root, List<GoogleTreeNode> result) {
        if (root == null) {
            return;
        }
        if (root.color.equals("red") && root.left != null && root.left.color.equals("blue")) {
            result.add(root.left);
        }
        helper(root.left, result);
        if (root.color.equals("red") && root.right != null && root.right.color.equals("blue")) {
            result.add(root.right);
        }
        helper(root.right, result);
    }
    public void test() {
        GoogleTreeNode root = new GoogleTreeNode("blue", 1, null, null);
        root.left = new GoogleTreeNode("red", 2, null, null);
        root.right = new GoogleTreeNode("red", 3, null, null);
        root.left.left = new GoogleTreeNode("red", 4, null, null);
        root.left.right = new GoogleTreeNode("blue", 5, null, null);
        root.left.left.left = new GoogleTreeNode("blue", 7, null, null);
        root.right.left = new GoogleTreeNode("blue", 6, null, null);
        List<GoogleTreeNode> result = deleteRed(root);
        for (GoogleTreeNode node : result) {
            System.out.println(node.val);
        }
    }
}
class GoogleTreeNode{
    String color;
    int val;
    GoogleTreeNode left;
    GoogleTreeNode right;
    public GoogleTreeNode(String color, int val, GoogleTreeNode left, GoogleTreeNode right) {
        this.color = color;
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

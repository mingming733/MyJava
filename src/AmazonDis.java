/**
 * Created by mming on 9/21/18.
 */
public class AmazonDis {
    public TreeNode contractBST (int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(nums[0]);

        for (int i = 1; i < nums.length; i++) {
            TreeNode curr = root;
            TreeNode pre = root;
            while (curr != null) {
                pre = curr;
                if (curr.val == nums[i]) {
                    break;
                } else if (curr.val > nums[i]) {
                    curr = curr.left;
                } else {
                    curr = curr.right;
                }
            }
            if (pre.val > nums[i]) {
                pre.left = new TreeNode(nums[i]);
            } else {
                pre.right = new TreeNode(nums[i]);
            }
        }
        return root;
    }
    public int disOf2Node (int[] nums, int a, int b) {
        TreeNode root = contractBST(nums);
        return disBST(root, a, b);
    }
    public int disBST (TreeNode root, int a, int b) {
        TreeNode nodeA = findInBst(root, a);
        TreeNode nodeB = findInBst(root, b);
        if (nodeA == null || nodeB == null) {
            return -1;
        }
        TreeNode lca = lca(root, a, b);
        int depthA = depthFromLca(lca, a);
        int depthB = depthFromLca(lca, b);
        return depthA + depthB;
    }
    private TreeNode lca (TreeNode root, int a, int b) {
        if (root == null) {
            return null;
        }
        if (root.val == a || root.val == b) {
            return root;
        }
        TreeNode left = lca(root.left, a, b);
        TreeNode right = lca(root.right, a, b);
        if (left != null && right != null) {
            return root;
        } else if (left != null) {
            return left;
        } else {
            return right;
        }

    }
    private int depthFromLca (TreeNode lca, int a) {
        if (lca == null) {
            return -1;
        }
        if (lca.val == a) {
            return 0;
        }
        int left = depthFromLca(lca.left, a);
        int right = depthFromLca(lca.right, a);
        if (left == -1 && right == -1) {
            return -1;
        }
        if (left == -1) {
            return right + 1;
        } else {
            return left + 1;
        }
    }

    public TreeNode findInBst(TreeNode root, int a) {
        if (root == null || root.val == a) {
            return root;
        }
        if (root.val < a) {
            return findInBst(root.right, a);
        } else {
            return findInBst(root.left, a);
        }
    }
}

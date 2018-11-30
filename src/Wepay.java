import java.util.*;

/**
 * Created by mming on 10/15/18.
 */
public class Wepay {
    public DoubleListNode leafNodes(TreeNode root) {
        DoubleListNode dummy = new DoubleListNode(0, null, null);
        helper(root, dummy);
        return dummy.next;
    }
    private DoubleListNode helper(TreeNode root, DoubleListNode leaves) {
        if (root.left == null && root.right == null) {
            DoubleListNode leaf = new DoubleListNode(root.val, leaves, null);
            leaves.next = leaf;
            return leaf;
        }
        if (root.left != null) {
            leaves = helper(root.left, leaves);
        }
        if (root.right != null) {
            leaves = helper(root.right, leaves);
        }
        return leaves;
    }
    /*地里出现过的 给一个binary tree 和一个target node, construct root到target的双向链表*/
    public DoubleListNode doubleListFromTree(TreeNode root, int target) {
        if (root == null) {
            return null;
        }
        return anotherHelper(root, target);
    }
    private DoubleListNode anotherHelper(TreeNode root, int target) {
        DoubleListNode next = null;
        if (root.val == target) {
            return new DoubleListNode(target, null, null);
        }
        if (root.left != null) {
            next = anotherHelper(root.left, target);
        }
        if (root.right != null && next == null) {
            next = anotherHelper(root.right, target);
        }
        if (next != null) {
            DoubleListNode curr =  new DoubleListNode(root.val, null, next);
            next.pre = curr;
            return curr;
        } else {
            return null;
        }
    }
    /*
    *  打印一棵树，如果如果是空节点，用 . dot 表示
比如
1
2 3
4 5
打印结果为
1
2 3
. 4 . 5*/
    public List<String> printTree(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                if (curr == null) {
                    sb.append(".");
                } else {
                    sb.append(curr.val);
                    queue.offer(curr.left);
                    queue.offer(curr.right);
                }
            }
            result.add(sb.toString());
        }
        result.remove(result.size() - 1);
        return result;
    }
    // word break II

    boolean[] memo;
    List<String> result;
    public List<String> wordBreak(String s, List<String> wordDict) {
        result = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return result;
        }
        memo = new boolean[s.length()];
        for (int i = 0; i < memo.length; i++) {
            memo[i] = true;
        }
        HashSet<String> set = new HashSet<>();
        for (String str : wordDict) {
            set.add(str);
        }
        helper(0, s, set, "");
        return result;
    }
    private boolean helper(int start, String s, HashSet<String> set, String now) {
        if (start == s.length()) {
            result.add(now.trim());
            return true;
        }
        if (!memo[start]) {
            return false;
        }
        String curr = "";
        boolean soluble = false;
        for (int i = start; i < s.length(); i++) {
            curr += s.charAt(i);
            if (set.contains(curr)) {
                soluble |= helper(i + 1, s, set, now  + curr + " ");
            }
        }
        memo[start] = soluble;
        return soluble;
    }
}

class DoubleListNode {
    int val;
    DoubleListNode pre;
    DoubleListNode next;
    public DoubleListNode(int val, DoubleListNode pre, DoubleListNode next) {
        this.val = val;
        this.pre = pre;
        this.next = next;
    }

}
// max queue, can return max
class MaxListNode{
    int val;
    int counter;
    MaxListNode next;
    MaxListNode pre;
    boolean exist;
    public MaxListNode(int val, int counter, MaxListNode pre, MaxListNode next, boolean exist) {
        this.val = val;
        this.counter = counter;
        this.next = next;
        this.exist = exist;
        this.pre = pre;
    }
}
class MaxQueue{
    private MaxListNode head;
    private MaxListNode tail;
    private PriorityQueue<MaxListNode> heap;
    int counter;

    public MaxQueue() {

        heap = new PriorityQueue<>((o1, o2) -> {
            if (o1.val == o2.val) {
                return o1.counter - o2.counter;
            }
            return o2.val - o1.val;
        });
        head = new MaxListNode(0, 0, null, null, true);
        tail = new MaxListNode(0, 0, head, null, true);
        head.next = tail;
        counter = 0;
    }

    public Integer pollMax() {
        if (head.next == tail) {
            return null;
        }
        while (!heap.peek().exist) {
            heap.poll();
        }
        MaxListNode curr = heap.poll();
        curr.pre.next = curr.next;
        curr.next.pre = curr.pre;
        return curr.val;
    }

    public Integer poll() {
        if (head.next == tail) {
            return null;
        }
        MaxListNode node = head.next;
        head.next = node.next;
        node.next.pre = head;
        node.exist = false;
        return node.val;
    }
    public Integer peek() {
        if (head.next == tail) {
            return null;
        }
        return head.next.val;
    }
    public void offer(int val) {
        MaxListNode node = new MaxListNode(val, counter++, null, null, true);
        tail.pre.next = node;
        node.next = tail;
        node.pre = tail.pre;
        tail.pre = node;
        heap.add(node);
    }
}
/*给一个list of word（乱序），然后一个Input word，让你设计一个算法（频繁调用），快速查找出list中input word的下一个字典序的单词
[cat, dog, cow, donkey, zebra, monkey], input duck, output monkey; input dog, output donkey。 可以sort再binary search。或者用trie解决。*/
class TrieTree{
    WPTrieNode root;
    public TrieTree(){
        root = new WPTrieNode(new WPTrieNode[26], false, 'a');
    }

    public void insert(String word) {
        WPTrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (curr.children[index] == null) {
                curr.children[index] = new WPTrieNode(new WPTrieNode[26], false, (char)(index + 'a'));
            }
            curr = curr.children[index];
        }
        curr.hasWord = true;
    }
    public List<WPTrieNode> findPath(String word) {
        WPTrieNode curr = root;
        List<WPTrieNode> list = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (curr.children[index] == null) {
                return list;
            } else {
                curr = curr.children[index];
                list.add(curr);
            }
        }
        return list;
    }
    public String searchNext(String word) {
        List<WPTrieNode> path = findPath(word);
        path.add(0, root);
        String next;
        for (int i = path.size() - 1; i >= 0; i--) {
            WPTrieNode curr = path.get(i);
            if (i == word.length()) {
                next = searchForFirstWord(curr, word, 0);
                if (next != null) {
                    return next;
                }
            } else {
                next = searchForFirstWord(curr, word.substring(0, i), word.charAt(i) - 'a');
                if (next != null) {
                    return next;
                }
            }

        }
        return null;
    }
    private String searchForFirstWord(WPTrieNode root, String prefix, int start) {
        if (root == null || root.children == null) {
            return null;
        }
        for (int i = start + 1; i < 26; i++) {
            WPTrieNode child = root.children[i];
            if (child != null) {
                return child.hasWord ? prefix + child.c : searchForFirstWord(child, prefix + child.c, 0);
            }
        }
        return null;
    }

}
class WPTrieNode{
    WPTrieNode[] children;
    char c;
    boolean hasWord;
    public WPTrieNode(WPTrieNode[] children, boolean hasWord, char c) {
        this.children = children;
        this.hasWord = hasWord;
        this.c = c;
    }
}

/*TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);*/
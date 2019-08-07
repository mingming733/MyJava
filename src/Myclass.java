
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;


/**
 * Created by mming on 9/9/16.
 */
public class Myclass {
    private HashMap<Character, char[]> map;

    public void printArray(int[] arrs){
        for(int i = 0; i < arrs.length; i++){
            System.out.print(arrs[i] + " ");
        }
    }
    public class findMedianFromDataStream {
        PriorityQueue<Integer> smaller = new PriorityQueue<>();
        PriorityQueue<Integer> larger = new PriorityQueue<>();

        public void add(int num) {
            larger.offer(-num);
            smaller.offer(-larger.poll());
            if (larger.size() < smaller.size()) {
                larger.offer(-smaller.poll());
            }
        }

        public double findMedian() {
            if (larger.size() > smaller.size()) {
                return (double) larger.peek();
            } else {
                return ((double) smaller.peek() - (double) larger.peek()) / 2;
            }
        }
    }

    public void partitionArray(int[] arr, int pivot) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            while (arr[left] < pivot && left < right) {
                left++;
            }
            while (arr[right] > pivot && left < right) {
                right--;
            }
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
        }
        return;
    }

    public int lastWord(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        str = str.trim();
        int count = 0;
        for (int i = str.length() - 1; i >= 0; i--) {
            if (str.charAt(i) == 32) {
                return count;
            } else {
                count++;
            }
        }
        return count;
    }

//    public void quickSort(int[] nums){
//        quickSortHelper(nums, 0, nums.length - 1);
//    }
//
//    public void quickSortHelper(int[] nums, int left, int right){
//        if(left >= right){
//            return;
//        }
//        int start = left;
//        int end = right;
//        int pivot = nums[(left + right) / 2];
//        while(left <= right){
//            while(left <= right && nums[right] > pivot){
//                right--;
//            }
//            while(left <= right && nums[left] < pivot){
//                left++;
//            }
//            if(left <= right){
//                int temp = nums[left];
//                nums[left] = nums[right];
//                nums[right] = temp;
//                left++;
//                right--;
//            }
//        }
//        quickSortHelper(nums, start, right);
//        quickSortHelper(nums, left, end);
//        return;
//    }

    public String resolveComflict(String str) {
        // Process input, get employee name
        String[] strs = str.split(",");
        String employeeName1 = strs[strs.length - 2];
        String employeeName2 = strs[strs.length - 1];
        // Get nmanagement relationship hashmap, put manager as key and employee as value
        HashMap<String, String> relationship = new HashMap<>();
        for (int i = 0; i < strs.length - 2; i++) {
            String[] mngerToEmp = strs[i].split("->");
            relationship.put(mngerToEmp[1], mngerToEmp[0]);
        }
        // Use linkedList to present all the managers upper than the concerning employee
        Stack<String> downToUp1 = buildDownToUp(employeeName1, relationship);
        Stack<String> downToUp2 = buildDownToUp(employeeName2, relationship);
        String commanManager = "";
        while (!downToUp1.isEmpty() && !downToUp2.isEmpty() && downToUp1.peek().equals(downToUp2.peek())) {
            commanManager = downToUp1.peek();
            downToUp1.pop();
            downToUp2.pop();
        }
        return commanManager;
    }

    public Stack<String> buildDownToUp(String name, HashMap<String, String> relationship) {
        Stack<String> downToUp = new Stack<>();
        downToUp.push(name);
        while (relationship.containsKey(name)) {
            name = relationship.get(name);
            downToUp.push(name);
        }
        return downToUp;
    }


    public int[] generateArray(int length) {
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            result[i] = (int) (Math.random() * 20);
        }
        return result;
    }

    public String reverseString(String str) {
        if (str.length() == 0 || str == "") {
            return "";
        }
        return reverseHelper(str, 0);
    }

    public String reverseHelper(String str, int i) {
        if (i == str.length() - 1) {
            return str.substring(i, i + 1);
        }
        return reverseHelper(str, ++i) + str.charAt(i - 1);
    }

    public int add2(int a) {
        a = a + 2;
        return a;
    }

    public int addTwo(Num a) {
        a.val = a.val + 2;
        return a.val;
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length();
        int n = s2.length();
        if (m + n != s3.length()) {
            return false;
        }
        boolean[][] interleave = new boolean[m + 1][n + 1];
        interleave[0][0] = true;
        for (int i = 1; i <= m; i++) {
            if (s1.charAt(i - 1) == s3.charAt(i - 1)) {
                interleave[i][0] = true;
            } else {
                break;
            }
        }
        for (int i = 1; i <= n; i++) {
            if (s2.charAt(i - 1) == s3.charAt(i - 1)) {
                interleave[0][i] = true;
            } else {
                break;
            }
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s3.charAt(i + j - 1)) {
                    interleave[i][j] = interleave[i - 1][j];
                } else if (s2.charAt(j - 1) == s3.charAt(i + j - 1)) {
                    interleave[i][j] = interleave[i][j - 1];
                } else {
                    interleave[i][j] = false;
                }
            }
        }
        print2dArray(interleave);
        return interleave[m][n];
    }

    public void print2dArray(boolean[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.print("\n");
        }

    }

    public boolean isInterleaveT(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }

        boolean[][] interleaved = new boolean[s1.length() + 1][s2.length() + 1];
        interleaved[0][0] = true;

        for (int i = 1; i <= s1.length(); i++) {
            if (s3.charAt(i - 1) == s1.charAt(i - 1) && interleaved[i - 1][0])
                interleaved[i][0] = true;
        }

        for (int j = 1; j <= s2.length(); j++) {
            if (s3.charAt(j - 1) == s2.charAt(j - 1) && interleaved[0][j - 1])
                interleaved[0][j] = true;
        }

        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (((s3.charAt(i + j - 1) == s1.charAt(i - 1) && interleaved[i - 1][j]))
                        || ((s3.charAt(i + j - 1)) == s2.charAt(j - 1) && interleaved[i][j - 1]))
                    interleaved[i][j] = true;
            }
        }
        print2dArray(interleaved);
        return interleaved[s1.length()][s2.length()];
    }

    public int backPack(int m, int[] A) {
        // write your code here
        int n = A.length;
        boolean[][] backpack = new boolean[m + 1][n + 1];
        for (int i = 0; i < m + 1; i++) {
            backpack[i][0] = false;
        }
        for (int i = 0; i < n + 1; i++) {
            backpack[0][i] = true;
        }
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (A[j - 1] > i) {
                    backpack[i][j] = backpack[i][j - 1];
                } else {
                    backpack[i][j] = backpack[i][j - 1] || backpack[i - A[j - 1]][j - 1];
                }
            }
        }
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (backpack[i][j])
                    System.out.print(1);
                else
                    System.out.print(0);
            } // for j
            System.out.println();
        }
        for (int i = m; i >= 0; i--) {
            if (backpack[i][n]) {
                return m;
            }
        }
        return 0;
    }

    public int backPackt(int m, int[] A) {
        boolean f[][] = new boolean[A.length + 1][m + 1];
        for (int i = 0; i <= A.length; i++) {
            for (int j = 0; j <= m; j++) {
                f[i][j] = false;
            }
        }
        f[0][0] = true;
        for (int i = 1; i <= A.length; i++) {
            for (int j = 0; j <= m; j++) {
                f[i][j] = f[i - 1][j];
                if (j >= A[i - 1] && f[i - 1][j - A[i - 1]]) {
                    f[i][j] = true;
                }
            } // for j
        } // for i
        for (int i = 0; i <= A.length; i++) {
            for (int j = 0; j <= m; j++) {
                if (f[i][j])
                    System.out.print(1);
                else
                    System.out.print(0);
            } // for j
            System.out.println();
        }

        for (int i = m; i >= 0; i--) {
            if (f[A.length][i]) {
                return i;
            }
        }

        return 0;
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        if (n == 0 || triangle.get(0).size() == 0) {
            return 0;
        }
        int[][] sum = new int[n][n];
        sum[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < n; i++) {
            sum[i][0] = triangle.get(i).get(0) + sum[i - 1][0];
        }
        for (int i = 1; i < n; i++) {
            sum[i][i] = triangle.get(i).get(i) + sum[i - 1][i - 1];
        }

        for (int i = 2; i < n; i++) {
            for (int j = 1; j < i; j++) {
                sum[i][j] = Math.min(sum[i - 1][j - 1], sum[i - 1][j]) + triangle.get(i).get(j);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(sum[i][j]);
            }
            System.out.println();
        }
        int minPath = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            minPath = Math.min(minPath, sum[n - 1][i]);
        }
        System.out.println(minPath);
        return minPath;
    }

    public String reverseVowels(String s) {

        if (s == null | s.length() == 0) return s;

        int start = 0, end = s.length() - 1;
        String v = "aeiouAEIOU";
        char[] a = s.toCharArray();

        while (end > start) {
            while (end > start && !v.contains(a[end] + "")) {
                end--;
            }

            while (end > start && !v.contains(a[start] + "")) {
                start++;
            }

            char temp = a[start];
            a[start] = a[end];
            a[end] = temp;
            start++;
            end--;
        }

        return new String(a);
    }

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();

        if (n <= 0) {
            return result;
        }

        helper(result, "", n, n);

        return result;
    }

    public void helper(List<String> result, String paren, int left, int right) {
        if (left == 0 && right == 0) {
            result.add(paren);
            return;
        }

        if (left > 0) {
            helper(result, "(", left - 1, right);
        }

        if (right > 0 && left < right) {
            helper(result, ")", left, right - 1);
        }
    }

    public int[] twoSumII(int[] array, int target) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("No Solution");
        }
        Arrays.sort(array);
        int start = 0, end = array.length - 1;

        while (start < end) {
            if (target - array[start] > array[end]) {
                start++;
            } else if (target - array[start] < array[end]) {
                end--;
            } else {
                return new int[]{start, end};
            }
        }

        throw new IllegalArgumentException("No Solution");
    }

    public int[] twoSumMap(int[] array, int target) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("No solution");
        }

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(target - array[i])) {
                System.out.println(map.get(target - array[i]) + " " + i);
                return new int[]{map.get(target - array[i]), i};

            }
            map.put(array[i], i);
        }

        throw new IllegalArgumentException("No Solution");
    }

    public int missingNum(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("No Solution");
        }
        int start = 0;
        int end = arr.length;
        while (start + 1 < end) {
            int mid = (start + end) / 2;
            if (arr[mid] > mid + 1) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (arr[start] == start + 1) {
            return arr[start] + 1;
        } else {
            return arr[start] - 1;
        }
    }

    public int sellStock(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int maxProfit = 0;
        int minPrice = prices[0];
        for (int i = 0; i < prices.length; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
        }
        return maxProfit;
    }

    public int sellStockII(int[] price) {
        int diff = 0;
        int profit = 0;
        for (int i = 1; i < price.length; i++) {
            diff = price[i] - price[i - 1];
            if (diff > 0) {
                profit += diff;
            }
        }
        return profit;
    }

    public int sellstockIII(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int maxProfit = 0;
        int length = prices.length;
        int[] profitFromLeft = new int[length];
        int[] profitFromRight = new int[length];
        int minPrice = prices[0];
        int maxPrice = prices[length - 1];
        for (int i = 0; i < length; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
            profitFromLeft[i] = maxProfit;
        }
        maxProfit = 0;
        for (int i = length - 1; i >= 0; i--) {
            maxPrice = Math.max(maxPrice, prices[i]);
            maxProfit = Math.max(maxProfit, maxPrice - prices[i]);
            profitFromRight[i] = maxProfit;
        }
        maxProfit = 0;
        for (int i = 0; i < length; i++) {
            maxProfit = Math.max(maxProfit, profitFromLeft[i] + profitFromRight[i]);
        }
        return maxProfit;
    }


    public int stockHelper(int[] prices, int start, int end) {
        if (start >= end) {
            return 0;
        }
        int maxProfit = 0;
        int minPrice = prices[start];
        for (int i = start; i < end + 1; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
        }
        return maxProfit;
    }

    public TreeNode constructFromisValidBSTAndPre(int[] preOrder, int[] isValidBST) {
        return new TreeNode(2);
    }



    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            } else {
                map.put(nums[i], i);
            }
        }
        return new int[]{-1, -1};
    }

    public int[] towSumTwoPointer(int[] nums, int target) {
        Arrays.sort(nums);
        int start = 0;
        int end = nums.length;
        while (start < end) {
            if (nums[start] + nums[end] == target) {
                return new int[]{start, end};
            } else if (nums[start] + nums[end] > target) {
                end--;
            } else {
                start++;
            }
        }
        return new int[]{-1, -1};
    }

    public int[][] reconstructQueue(int[][] people) {
        int m = people.length;
        int n = people[0].length;
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o2[1] - o1[1];
                } else {
                    return o2[0] - o1[0];
                }
            }
        });
        ArrayList<int[]> list = new ArrayList<>();
        for (int[] curr : people) {
            list.add(curr[1], curr);
        }
        return list.toArray(new int[people.length][]);
    }

    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int start = 0;
        int max = 0;
        int i = 0;
        for (; i < s.length(); i++) {
            if (!map.containsKey((s.charAt(i)))) {
                map.put(s.charAt(i), i);
            } else if (map.get(s.charAt(i)) >= start) {
                start = map.get(s.charAt(i)) + 1;
                map.put(s.charAt(i), i);
            } else {
                map.put(s.charAt(i), i);
            }
            max = Math.max(max, i - start + 1);
        }
        return max;
    }

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return new ArrayList<String>();
        }
        map = new HashMap<>();
        map.put('0', new char[]{});
        map.put('1', new char[]{});
        map.put('2', new char[]{'a', 'b', 'c'});
        map.put('3', new char[]{'d', 'e', 'f'});
        map.put('4', new char[]{'g', 'h', 'i'});
        map.put('5', new char[]{'j', 'k', 'l'});
        map.put('6', new char[]{'m', 'n', 'o'});
        map.put('7', new char[]{'p', 'q', 'r', 's'});
        map.put('8', new char[]{'t', 'u', 'v'});
        map.put('9', new char[]{'w', 'x', 'y', 'z'});
        List<String> result = new ArrayList<String>();
        StringBuilder sb = new StringBuilder();
        helper(digits, result, sb, 0);
        return result;
    }

    public void helper(String digits, List<String> result, StringBuilder sb, int pointer) {
        if (pointer >= digits.length()) {
            result.add(sb.toString());
            return;
        }
        for (char c : map.get(digits.charAt(pointer))) {
            sb.append(c);
            helper(digits, result, sb, pointer + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public String getPermutation(int n, int k) {
        ArrayList<Integer> nums = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();
        nums.add(1);
        int[] factorial = new int[n];
        factorial[0] = 1;
        for (int i = 1; i < n; i++) {
            factorial[i] = (i + 1) * factorial[i - 1];
            nums.add(i + 1);
        }
        for (int i = n - 1; i > 0; i--) {
            int index = ((k - 1) / factorial[i - 1]) % (i + 1);
            result.add(nums.get(index));
            nums.remove(index);
        }
        result.add(nums.get(0));
        return result.toString();
    }

    public int countDigits(int num) {
        int count = 0;
        int primaryNum = num;
        while (num != 0) {
            num = num / 10;
            count++;
        }
        return (primaryNum % count);
    }

    public String charDigi(String str) {
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            result = result + (str.charAt(i) - 'a' + 1) + "/";
        }
        return result;
    }

    public String digiChar(int[] num) {
        String result = "";
        for (int i = 0; i < num.length; i++) {
            result = result + (char) (num[i] - 1 + 'a');
        }
        return result;
    }

    public int[] sortArrayBubble(int arr[]) {
        int len = arr.length;
        int i, j, temp;
        for (i = 0; i < len - 1; i++) {
            for (j = i; j < len; j++) {
                if (arr[i] < arr[j]) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }

    public int[] sortArray(int arr[]) {
        int i, min, location, j, temp, len = arr.length;
        for (i = 0; i < len; i++) {
            min = arr[i];
            location = i;
            for (j = i; j < len; j++) {
                if (min < arr[j]) {
                    min = arr[j];
                    location = j;
                }
            }
            temp = arr[i];
            arr[i] = arr[location];
            arr[location] = temp;
        }
        return arr;
    }

    public int[] reverseArray(int arr[]) {
        int i, temp, originalLen = arr.length;
        int len = originalLen;
        for (i = 0; i < originalLen / 2; i++) {
            temp = arr[len - 1 - i];
            arr[len - 1 - i] = arr[i];
            arr[i] = temp;
//            len += 1;
        }
        return arr;
    }

    public static ArrayList<Connection> getLowestCost(ArrayList<Connection> connections) {
        Map<String, String> root = new HashMap<>();
        ArrayList<Connection> result = new ArrayList<>();
        Set<String> set = new HashSet<>();
        Collections.sort(connections, new Comparator<Connection>() {
            @Override
            public int compare(Connection o1, Connection o2) {
                return o1.cost - o2.cost;
            }
        });
        for (Connection connection : connections) {
            root.put(connection.node1, connection.node1);
            root.put(connection.node2, connection.node2);
            set.add(connection.node1);
            set.add(connection.node2);
        }
        for (Connection connection : connections) {
            if (union(connection.node1, connection.node2, root)) {
                result.add(connection);
            }
        }
        if (set.size() - 1 > result.size()) {
            return new ArrayList<Connection>();
        }
        Collections.sort(result, new Comparator<Connection>() {
            @Override
            public int compare(Connection o1, Connection o2) {
                if (o1.node1.equals(o2.node1)) {
                    return o1.node2.compareTo(o2.node2);
                }
                return o1.node1.compareTo(o2.node1);
            }
        });
        return result;
    }

    private static boolean union(String a, String b, Map<String, String> map) {
        String aRoot = find(a, map);
        String bRoot = find(b, map);
        if (aRoot.equals(bRoot)) {
            return false;
        }
        map.put(bRoot, aRoot);
        return true;
    }

    private static String find(String city, Map<String, String> map) {
        if (city.equals(map.get(city))) {
            return city;
        }
        map.put(city, map.get(map.get(city)));
        return find(map.get(city), map);
    }

    public void connectII(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        TreeLinkNode head = root;
        TreeLinkNode nextHead = null;
        while (head != null) {
            nextHead = null;
            TreeLinkNode curr = null;
            while (head != null) {
                if (nextHead == null) {
                    nextHead = head.left != null ? head.left : head.right;
                }
                if (head.left != null) {
                    if (curr == null) {
                        curr = head.left;
                    } else {
                        curr.next = head.left;
                        curr = curr.next;
                    }
                }
                if (head.right != null) {
                    if (curr == null) {
                        curr = head.right;
                    } else {
                        curr.next = head.right;
                        curr = curr.next;
                    }
                }
                head = head.next;
            }
            head = nextHead;
        }
    }

    private int lo;
    private int max;

    public String longestPalindromSub(String str) {
        if (str.length() < 2) {
            return str;
        }
        lo = 0;
        max = 0;
        for (int i = 0; i < str.length(); i++) {
            extendPalindrom(str, i, i);
            extendPalindrom(str, i, i + 1);
        }
        return str.substring(lo, lo + max);
    }

    private void extendPalindrom(String str, int i, int j) {
        while (i >= 0 && j < str.length() && str.charAt(i) == str.charAt(j)) {
            i--;
            j++;
        }
        if (max < j - i - 1) {
            max = j - i - 1;
            lo = i + 1;
        }
    }

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if ((set.floor(num) != null && set.floor(num) + t >= num) || (set.ceiling(num) != null && set.ceiling(num) - t <= num)) {
                return true;
            }
            set.add(num);
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }

    public int numSquares(int n) {
        while (n % 4 == 0) {
            n /= 4;
        }
        if (n % 8 == 7) {
            return 4;
        }
        for (int i = 0; i * i <= n; i++) {
            int j = (int) Math.sqrt(n - i * i);
            int res = 0;
            if (i * i + j * j == n) {
                if (i == 0 || j == 0) {
                    return 1;
                }
                return 2;
            }
        }
        return 3;
    }

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j]) {
                    dp[i] = Math.min(dp[i - coins[j]] + 1, dp[i]);
                }
            }
        }
        return dp[amount] <= amount ? dp[amount] : -1;
    }

    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();
        if (n < 1) {
            return result;
        }
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                result.add("FizzBuzz");
            } else if (i % 3 == 0) {
                result.add("Fizz");
            } else if (i % 5 == 0) {
                result.add("Buzz");
            } else {
                result.add(i + "");
            }
        }
        return result;
    }

    private long lastVal = Long.MIN_VALUE;

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!isValidBST(root.left)) {
            return false;
        }
        if (lastVal >= root.val) {
            return false;
        }
        lastVal = (long) root.val;
        if (!isValidBST(root.right)) {
            return false;
        }
        return true;
    }
    int pre = Integer.MIN_VALUE;
    public boolean isValidBST2(TreeNode root) {
        if(root == null){
            return true;
        }
        boolean left = isValidBST2(root.left);
        boolean mid = pre < root.val;
        pre = root.val;
        boolean right = isValidBST2(root.right);
        return left && mid && right;
    }

    public boolean isValidBSTIterative(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        Long pre = Long.MIN_VALUE;
        TreeNode curr = root;
        while(!stack.isEmpty() || curr != null){
            while(curr != null){
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            if(curr.val <= pre){
                return false;
            }
            pre = (long)curr.val;
            curr = curr.right;
        }
        return true;
    }
    public int maxSubArray(int A[]) {
        if (A == null || A.length == 0) {
            return 0;
        }
        return maxSubArrayHelper(A, 0, A.length - 1);
    }

    int maxSubArrayHelper(int A[], int left, int right) {
        if (left == right) {
            return A[left];
        }
        int mid = (left + right) / 2;
        int leftMax = maxSubArrayHelper(A, left, mid);
        int rightMax = maxSubArrayHelper(A, mid + 1, right);
        int temp = 0;
        int leftEdgeMax = A[mid];
        int rightEdgeMax = A[mid + 1];
        for (int i = mid; i >= left; i--) {
            temp = temp + A[i];
            leftEdgeMax = leftEdgeMax > temp ? leftEdgeMax : temp;
        }
        temp = 0;
        for (int i = mid + 1; i <= right; i++) {
            temp = temp + A[i];
            rightEdgeMax = rightEdgeMax > temp ? rightEdgeMax : temp;
        }
        return Math.max(Math.max(leftMax, rightMax), rightEdgeMax + leftEdgeMax);
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = head;
        ListNode slow = dummy;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }

    public int sumOfTwo(int a, int b) {
        int carry = 1;
        while (carry != 0) {
            carry = a & b;
            a ^= b;
            carry <<= 1;
            b = carry;
        }
        return a;
    }

    //build bst from sorted array
    public TreeNode sortedArrayToBST(int[] nums) {
        return buildBST(nums, 0, nums.length - 1);
    }

    public TreeNode buildBST(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        if (start == end) {
            return new TreeNode(nums[start]);
        }
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = buildBST(nums, start, mid - 1);
        root.right = buildBST(nums, mid + 1, end);
        return root;
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        int rowStart = 0;
        int rowEnd = matrix.length - 1;
        int colStart = 0;
        int colEnd = matrix[0].length - 1;
        List<Integer> result = new ArrayList<>();
        while (rowStart <= rowEnd && colStart <= colEnd) {
            for (int i = colStart; i <= colEnd; i++) {
                result.add(matrix[rowStart][i]);
            }
            rowStart++;
            for (int i = rowStart; i <= rowEnd; i++) {
                result.add(matrix[i][colEnd]);
            }
            colEnd--;
            for (int i = colEnd; i >= colStart; i--) {
                result.add(matrix[rowEnd][i]);
            }
            rowEnd--;
            for (int i = 0; i >= rowStart; i--) {
                result.add(matrix[i][colStart]);
            }
            colStart++;
        }
        return result;
    }

    int kth;
    int kthVal;

    public int kthSmallest(TreeNode root, int k) {
        inOrder(root, k);
        return kthVal;
    }

    private void inOrder(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        inOrder(root.left, k);
        kth++;
        if (k == kth) {
            kthVal = root.val;
            return;
        }
        inOrder(root.right, k);
    }

    public int strStr(String s1, String s2) {
        if (s1 == null || s1.length() == 0) {
            return -1;
        }
        if (s2 == null || s2.length() == 0) {
            return 0;
        }
        for (int i = 0; i <= s1.length() - s2.length(); i++) {
            int j;
            for (j = i; j < s1.length() && j < i + s2.length(); j++) {
                if (s1.charAt(j) != s2.charAt(j - i)) {
                    break;
                }
            }
            if (j - i == s2.length()) {
                return i;
            }
        }
        return -1;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // cout indgree of each node
        HashMap<Integer, Integer> inDegree = new HashMap<>();
        //key is course, value is outDegree of this course
        HashMap<Integer, ArrayList<Integer>> preCouse = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            preCouse.put(i, new ArrayList<Integer>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            int course = prerequisites[i][1];
            if (inDegree.containsKey(course)) {
                inDegree.put(course, inDegree.get(course) + 1);
            } else {
                inDegree.put(course, 1);
            }
            preCouse.get(prerequisites[i][0]).add(course);
        }
        // BFS queue
        Queue<Integer> queue = new LinkedList<>();
        //find a course that has no inDegree
        for (int i = 0; i < numCourses; i++) {
            if (!inDegree.containsKey(i)) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int course = queue.poll();
            ArrayList<Integer> list = preCouse.get(course);
            for (int out : list) {
                inDegree.put(out, inDegree.get(out) - 1);
                // only put node with indegree == 0 into queue
                if (inDegree.get(out) == 0) {
                    queue.offer(out);
                }
            }
        }
        //if there is node with indgree != 0, then there is circle in this graph.
        for (Integer value : inDegree.values()) {
            if (value != 0) {
                return false;
            }
        }
        return true;
    }


    public int numIslands(char[][] grid) {
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    bst(new Coordinate(i, j), grid);
                    result++;
                }
            }
        }
        return result;
    }

    private void bst(Coordinate point, char[][] grid) {
        int[] xCoordinate = new int[]{0, -1, 0, 1};
        int[] yCoordinate = new int[]{-1, 0, 1, 0};
        Queue<Coordinate> queue = new LinkedList<>();
        queue.offer(point);
        while (!queue.isEmpty()) {
            Coordinate curr = queue.poll();
            for (int i = 0; i < 4; i++) {
                Coordinate neighbor = new Coordinate(curr.x + xCoordinate[i], curr.y + yCoordinate[i]);
                if (neighbor.x < 0 || neighbor.x >= grid.length || neighbor.y < 0 || neighbor.y >= grid[0].length) {
                    continue;
                }
                if (grid[neighbor.x][neighbor.y] == '1') {
                    grid[neighbor.x][neighbor.y] = '0';
                    queue.offer(neighbor);
                }
            }
        }
    }

    class Coordinate {
        int x, y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int numIslandsUnionFind(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        UnionFind unionFind = new UnionFind(m * n);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    unionFind.count++;
                    if (i > 0 && grid[i - 1][j] == '1') {
                        unionFind.connect(i * n + j, (i - 1) * n + j);
                    }
                    if (j > 0 && grid[i][j - 1] == '1') {
                        unionFind.connect(i * n + j, i * n + (j - 1));
                    }
                    if (i + 1 < m && grid[i + 1][j] == '1') {
                        unionFind.connect(i * n + j, (i + 1) * n + j);
                    }
                    if (j + 1 < n && grid[i][j + 1] == '1') {
                        unionFind.connect(i * n + j, i * n + (j + 1));
                    }
                }
            }
        }
        return unionFind.count;
    }

//    public List<Integer> inOrder(TreeNode root){
//        List<Integer> result = new ArrayList<>();
//        if(root == null){
//            return result;
//        }
//        Stack<TreeNode> stack = new Stack<>();
//        TreeNode curr = root;
//        while(!stack.isEmpty() || curr != null){
//            while(curr!= null){
//                stack.push(curr);
//                curr = curr.left;
//            }
//            curr = stack.pop();
//            result.add(curr.val);
//            curr = curr.right;
//        }
//        return result;
//    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (!stack.isEmpty() || curr != null) {
            while (curr != null) {
                result.add(curr.val);
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            curr = curr.right;
        }
        return result;
    }


    public List<Integer> postOrder(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (!stack.isEmpty() || curr != null) {
            while (curr != null) {
                stack.push(curr);
                result.add(curr.val);
                curr = curr.left;
            }
            curr = stack.pop();
            curr = curr.right;
        }
        return result;
    }

    public void solve(char[][] board) { //surrounded regions
        if (board == null || board.length < 3 || board[0].length < 3) {
            return;
        }
        int row = board.length;
        int col = board[0].length;
        for (int i = 0; i < row; i++) {
            bsf(i, 0, board);
            bsf(i, col - 1, board);
        }
        for (int i = 0; i < col; i++) {
            bsf(0, i, board);
            bsf(row - 1, i, board);
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == '0') {
                    board[i][j] = 'X';
                } else if (board[i][j] == '#') {
                    board[i][j] = '0';
                }
            }
        }
    }

    public void bsf(int m, int n, char[][] board) {
        if (board[m][n] != '0') {
            return;
        }
        Queue<Position> queue = new LinkedList<>();
        queue.offer(new Position(m, n));
        while (!queue.isEmpty()) {
            Position curt = queue.poll();
            board[curt.x][curt.y] = '#';
            for (Position neighbour : expand(curt, board)) {
                queue.offer(neighbour);
            }
        }
    }

    public List<Position> expand(Position p, char[][] board) {
        int[] rows = new int[]{0, -1, 0, 1};
        int[] cols = new int[]{-1, 0, 1, 0};
        List<Position> neighbours = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            int x = p.x + rows[i];
            int y = p.y + cols[i];
            if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) {
                continue;
            }
            if (board[x][y] == '0') {
                neighbours.add(new Position(x, y));
            }
        }
        return neighbours;
    }

    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int len = s.length();
        int[] ways = new int[len + 1];
        ways[0] = s.charAt(0) == '0' ? 0 : 1;
        ways[1] = ways[0];
        for (int i = 2; i <= len; i++) {
            if (Integer.parseInt(s.substring(i - 2, i)) > 10 && Integer.parseInt(s.substring(i - 2, i)) <= 26) {
                ways[i] = ways[i - 2] + ways[i - 1];
            } else {
                ways[i] = ways[i - 1];
            }
        }
        return ways[len];
    }

    public double myPow(double x, int n) {
        if (n == 0)
            return 1;
        if (n < 0) {
            n = -n;
            x = 1 / x;
        }
        return (n % 2 == 0) ? myPow(x * x, n / 2) : x * myPow(x * x, n / 2);
    }


    public void quickSort(int[] nums) {
        quickSortHelper(nums, 0, nums.length - 1);
    }

    public void quickSortHelper(int[] nums, int left, int right) {
        int start = left;
        int end = right;
        if (left >= right) {
            return;
        }
        int pivot = nums[(left + right) / 2];
        while (left <= right) {
            while (left <= right && nums[left] < pivot) {
                left++;
            }
            while (left <= right && nums[right] > pivot) {
                right--;
            }
            if (left < right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
                System.out.println(left + " " + right);
            }
        }
        quickSortHelper(nums, start, right);
        quickSortHelper(nums, left, end);
    }

    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, k - 1, 0, nums.length - 1);
    }

    private int quickSelect(int[] arr, int k, int left, int right) {
        if (left >= right) {
            return arr[k];
        }
        int pivot = arr[(left + right) / 2];
        int orgL = left, orgR = right;
        while (left <= right) {
            // 从右向左找到第一个小于枢纽值的数
            while (arr[left] > pivot) {
                left++;
            }
            // 从左向右找到第一个大于枢纽值的数
            while (arr[right] < pivot) {
                right--;
            }
            // 将两个数互换
            if (left <= right) {
                swap(arr, left, right);
                left++;
                right--;
            }
        }
        // 最后退出的情况应该是右指针在左指针左边一格
        // 这时如果右指针还大于等于k，说明kth在左半边
        if (k <= right) return quickSelect(arr, k, orgL, right);
        // 这时如果左指针还小于等于k，说明kth在右半边
        if (k >= left) return quickSelect(arr, k, left, orgR);
        return arr[k];
    }

    private void swap(int[] arr, int idx1, int idx2) {
        int tmp = arr[idx1] + arr[idx2];
        arr[idx1] = tmp - arr[idx1];
        arr[idx2] = tmp - arr[idx2];
    }

    void swap2(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();
        HashMap<Integer, Integer> inDegree = new HashMap<>();
        HashMap<Integer, ArrayList<Integer>> outDegree = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            outDegree.put(i, new ArrayList<Integer>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            if (!inDegree.containsKey(prerequisites[i][0])) {
                inDegree.put(prerequisites[i][0], 1);
            } else {
                inDegree.put(prerequisites[i][0], inDegree.get(prerequisites[i][0]) + 1);
            }
            outDegree.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        for (int i = 0; i < numCourses; i++) {
            if (!inDegree.containsKey(i)) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            int course = queue.poll();
            result.add(course);
            ArrayList<Integer> outCourse = new ArrayList<>();
            if (outDegree.containsKey(course)) {
                outCourse = outDegree.get(course);
            }
            for (int i = 0; i < outCourse.size(); i++) {
                inDegree.put(outCourse.get(i), inDegree.get(outCourse.get(i)) - 1);
                if (inDegree.get(outCourse.get(i)) == 0) {
                    queue.add(outCourse.get(i));
                }
            }
        }
        for (int course : inDegree.keySet()) {
            if (inDegree.get(course) != 0) {
                return new int[]{};
            }
        }
        int[] order = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            order[i] = result.get(i);
        }
        return order;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        int maxlength = 0;
        Set<String> dict = new HashSet<>();
        for (String word : wordDict) {
            dict.add(word);
            maxlength = maxlength < word.length() ? word.length() : maxlength;
        }
        boolean[] breakable = new boolean[s.length() + 1];
        breakable[0] = true;
        for (int i = 1; i < s.length() + 1; i++) {
            int start = i;
            while (start > 0 && i - start <= maxlength) {
                start--;
                if (!breakable[start]) {
                    continue;
                }
                String str = s.substring(start, i);
                if (dict.contains(str)) {
                    breakable[i] = true;
                }
            }
        }
        return breakable[s.length()];
    }

    public void mergeSort(int[] nums) {
        mergeSortHelper(nums, 0, nums.length - 1);
    }

    private void mergeSortHelper(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = (start + end) / 2;
        mergeSortHelper(nums, start, mid);
        mergeSortHelper(nums, mid + 1, end);
        merge(nums, start, mid, end);
    }

    private void merge(int[] nums, int start, int mid, int end) {
        int leftStart = start;
        int rightStart = mid + 1;
        int index = start;
        int[] temp = new int[nums.length];
        while (leftStart <= mid || rightStart <= end) {
            int leftNum = leftStart <= mid ? nums[leftStart] : Integer.MAX_VALUE;
            int rightNum = rightStart <= end ? nums[rightStart] : Integer.MAX_VALUE;
            if (leftNum <= rightNum) {
                temp[index++] = leftNum;
                leftStart++;
            } else {
                temp[index++] = rightNum;
                rightStart++;
            }
        }
        for (int i = start; i <= end; i++) {
            nums[i] = temp[i];
        }
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode mid = findmid(head);
        ListNode rightHead = sortList(mid.next);
        mid.next = null;
        ListNode leftHead = sortList(head);
        return mergeList(leftHead, rightHead);
    }

    private ListNode findmid(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    private ListNode mergeList(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode(0);
        ListNode pointer = dummy;
        while (head1 != null && head2 != null) {
            if (head1.val <= head2.val) {
                pointer.next = head1;
                head1 = head1.next;
            } else {
                pointer.next = head2;
                head2 = head2.next;
            }
            pointer = pointer.next;
        }
        if (head1 != null) {
            pointer.next = head1;
        }
        if (head2 != null) {
            pointer.next = head2;
        }
        return dummy.next;
    }

    public int evalRPN(String[] tokens) {
        String operation = "+-*/";
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            if (operation.contains(tokens[i])) {
                int num2 = stack.pop();
                int num1 = stack.pop();
                if (tokens[i] == "+") {
                    stack.push(num1 + num2);
                } else if (tokens[i] == "-") {
                    stack.push(num1 - num2);
                } else if (tokens[i] == "*") {
                    stack.push(num1 * num2);
                } else {
                    stack.push(num1 / num2);
                }
            } else {
                stack.push(Integer.parseInt(tokens[i]));
            }
        }
        return stack.pop();
    }

    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        int[][] board1 = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board1[i][j] = getState(board, i, j);
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = board1[i][j];
            }
        }

    }

    private int getState(int[][] board, int x, int y) {
        int count = 0;
        int[] horizon = new int[]{-1, 0, 1, 1, 1, 0, -1, -1};
        int[] vertical = new int[]{-1, -1, -1, 0, 1, 1, 1, 0};
        for (int i = 0; i < 8; i++) {
            int neighborx = x + horizon[i];
            int neighbory = y + vertical[i];
            if (neighborx >= 0 && neighborx < board.length && neighbory >= 0 && neighbory < board[0].length
                    ) {
                count += board[neighborx][neighbory];
            }
        }
        if (count < 2) {
            return 0;
        } else if (count == 2) {
            return board[x][y];
        } else if (count == 3) {
            return 1;
        } else {
            return 0;
        }
    }

    public void gameOfLifeInPlace(int[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = getStateInPlace(board, i, j);
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = board[i][j] % 2;
            }
        }

    }

    // 00 dead
    // 01 live
    // 10 live to dead
    // 11 live to live
    private int getStateInPlace(int[][] board, int x, int y) {
        int count = 0;
        int[] horizon = new int[]{-1, 0, 1, 1, 1, 0, -1, -1};
        int[] vertical = new int[]{-1, -1, -1, 0, 1, 1, 1, 0};
        for (int i = 0; i < 8; i++) {
            int neighborx = x + horizon[i];
            int neighbory = y + vertical[i];
            if (neighborx >= 0 && neighborx < board.length && neighbory >= 0 && neighbory < board[0].length
                    && (board[neighborx][neighbory] == 1 || board[neighborx][neighbory] == 2)) {
                count++;
            }
        }
        if (count == 2) {
            return board[x][y];
        } else if (count == 3) {
            return board[x][y] == 1 ? 1 : 3;
        } else {
            return board[x][y] << 1;
        }
    }

    public int longestSubstring(String s, int k) {
        char[] str = s.toCharArray();
        return longestSubstringHelper(str, 0, s.length(), k);
    }

    private int longestSubstringHelper(char[] str, int start, int end, int k) {
        if (end - start < k) {
            return 0;
        }
        int[] charNum = new int[26];
        for (int i = start; i < end; i++) {
            int index = str[i] - 'a';
            charNum[index]++;
        }
        for (int i = 0; i < 26; i++) {
            if (charNum[i] < k && charNum[i] > 0) {
                for (int j = start; j < end; j++) {
                    if (str[j] == 'a' + i) {
                        int leftMax = longestSubstringHelper(str, start, j, k);
                        int rightMax = longestSubstringHelper(str, j + 1, end, k);
                        return Math.max(leftMax, rightMax);
                    }
                }
            }
        }
        return end - start;
    }

    public int longestSubstring1(String s, int k) {
        char[] str = s.toCharArray();
        return helper(str, 0, s.length(), k);
    }

    private int helper(char[] str, int start, int end, int k) {
        if (end - start < k) return 0;//substring length shorter than k.
        int[] count = new int[26];
        for (int i = start; i < end; i++) {
            int idx = str[i] - 'a';
            count[idx]++;
        }
        for (int i = 0; i < 26; i++) {
            if (count[i] < k && count[i] > 0) { //count[i]=0 => i+'a' does not exist in the string, skip it.
                for (int j = start; j < end; j++) {
                    if (str[j] == i + 'a') {
                        int left = helper(str, start, j, k);
                        int right = helper(str, j + 1, end, k);
                        return Math.max(left, right);
                    }
                }
            }
        }
        return end - start;
    }

    public boolean increasingTriplet(int[] nums) {
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= min1) {
                min1 = nums[i];
            } else if (nums[i] <= min2) {
                min2 = nums[i];
            } else {
                return true;
            }
        }
        return false;
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) {
            return new int[0];
        }
        int[] result = new int[nums.length - k + 1];
        Deque<Integer> deque = new ArrayDeque<Integer>();
        for (int i = 0; i < nums.length; i++) {
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            deque.offer(i);
            if (deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peekFirst()];
            }
        }
        return result;
    }

    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<DataPoint> heap = new PriorityQueue<>(k, new MatrixComparator());
        heap.add(new DataPoint(0, 0, matrix[0][0]));
        int[] horizon = new int[]{1, 0};
        int[] vertical = new int[]{0, 1};
        int rowNum = matrix.length;
        int colNum = matrix[0].length;
        boolean[][] travelled = new boolean[rowNum][colNum];
        while (k > 1) {
            DataPoint point = heap.poll();
            k--;
            for (int i = 0; i < 2; i++) {
                int next_x = point.x + horizon[i];
                int next_y = point.y + vertical[i];
                if (next_x < rowNum && next_y < colNum && !travelled[next_x][next_y]) {
                    DataPoint nextPoint = new DataPoint(next_x, next_y, matrix[next_x][next_y]);
                    travelled[next_x][next_y] = true;
                    heap.add(nextPoint);
                }
            }
        }
        return heap.poll().val;
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int x = m - 1;
        int y = 0;
        while (x >= 0 && y < m) {
            if (matrix[x][y] == target) {
                return true;
            } else if (matrix[x][y] < target) {
                y++;
            } else {
                x--;
            }
        }
        return false;
    }

    public int myAtoi(String str) {
        if (str == null) {
            return 0;
        }
        str = str.trim();
        if (str.length() == 0) {
            return 0;
        }
        int sign = 1;
        int index = 0;
        if (str.charAt(index) == '+') {
            index++;
        } else if (str.charAt(index) == '-') {
            sign = -1;
            index++;
        }
        long num = 0;
        for (; index < str.length(); index++) {
            if (str.charAt(index) < '0' || str.charAt(index) > '9') {
                break;
            }
            num += 10;
            num += str.charAt(index) - '0';
            if (num > Integer.MAX_VALUE) {
                break;
            }
        }
        if (num * sign >= Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else if (num * sign <= Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        return (int) num * sign;
    }

    public int closestValue(TreeNode root, double target) {
        TreeNode curr = root;
        int closest = root.val;
        while (curr != null) {
            closest = Math.abs((double)curr.val - target) < Math.abs((double)closest - target) ? curr.val : closest;
            if ((double)curr.val < target) {
                curr = curr.right;
            } else if ((double)curr.val > target) {
                curr = curr.left;
            } else {
                return curr.val;
            }
        }
        return closest;
    }
    public int closestValueRecursion(TreeNode root, double target) {
        return -1;
          }

    public boolean searchValueInBST(TreeNode root, int target){

        if(root == null){
            return false;
        }
        if(target > root.val){
            return searchValueInBST(root.right, target);
        }else if(target < root.val){
            return searchValueInBST(root.left, target);
        }else{
            return true;
        }
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> paths = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        pathSumHelper(root, sum, paths, path);
        return paths;
    }
    public void pathSumHelper(TreeNode root, int sum, List<List<Integer>> paths, List<Integer> path){
        for(int num : path){
            System.out.print(num);
        }
        System.out.print("\n");
        if(root.left == null && root.right == null && root.val == sum){
            path.add(root.val);
            paths.add(new ArrayList<>(path));
        }
        path.add(root.val);
        if(root.left != null){
            pathSumHelper(root.left, sum - root.val, paths, path);
            path.remove(path.size() - 1);
        }
        if(root.right != null){
            pathSumHelper(root.right, sum - root.val, paths, path);
            path.remove(path.size() - 1);
        }
    }
    public int pathSumIII(TreeNode root, int sum) {
        if(root == null){
            return 0;
        }
        if(root.val == sum){
            return 1;
        }
        int left = pathSumIII(root.left, sum - root.val) + pathSumIII(root.left, sum);
        int right = pathSumIII(root.right, sum - root.val) + pathSumIII(root.right, sum);
        System.out.print(root.val+ " -- " +"left: "+ left + " right: " + right + " sum: " + sum + "\n");
        return left + right;
    }

    int[] dp;
    int[] sum;
    public boolean firstWillWin(int[] values) {
        // write your code here
        if(values == null || values.length == 0){
            return false;
        }
        if(values.length < 3){
            return true;
        }
        dp = new int[values.length + 1];
        sum = new int[values.length + 1];
        for(int i = 1; i < dp.length; i++){
            dp[i] = -1;
            sum[i] = sum[i - 1] + values[i - 1];
        }
        return search(values, values.length) > sum[values.length] / 2;
    }
    int search(int[] values, int n){
        if(n == 1){
            dp[1] = values[values.length - 1];
            return values[values.length - 1];
        }else if(n == 2){
            dp[2] = values[values.length - 1] + values[values.length - 2];
            return values[values.length - 1] + values[values.length - 2];
        }
        if(dp[n] != -1){
            return dp[n];
        }
        int min = Math.min(search(values, n - 1), search(values, n - 2));
        dp[n] = sum[n] - min;
        return dp[n];
    }
    public void printStrToNum(String str){
        for(int i = 0; i < str.length(); i++){
            System.out.print(str.charAt(i) - 'a' + 1);
//            System.out.print(", ");
        }
    }

    int count = 0;
    int[] father;
    public int numIslandsII(char[][] grid) {
        // Write your code here
        int m = grid.length;
        int n = grid[0].length;
        int[] dx = new int[]{-1, 0, 1, 0};
        int[] dy = new int[]{0, 1, 0, -1};
        father = new int[m * n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                father[i * n + j] = i * n + j;
                if(grid[i][j] == '1'){
                    count++;
                }
            }
        }
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                System.out.print(i + " " + j +"/ ");
                if(grid[i][j] == '1'){
                    for(int k = 0; k < 4; k++){
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        if(nx >= 0 && nx < m && ny >= 0 && ny < n && grid[nx][ny] == '1'){
                            connect(n * i + j, n * nx + ny);

                        }
                    }
                }
            }
        }
        return count;
    }
    int find(int x){
        if(father[x] == x){
            return x;
        }
        return father[x] = find(father[x]);
    }

    void connect(int a, int b){
        int root_a = find(a);
        int root_b = find(b);
        if(root_a != root_b){
            father[root_a] = root_b;
            count--;
        }
    }

    public int countParenthesis(String s){
        Stack<Character> stack = new Stack<>();
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '('){
                stack.push(c);
            }else{
                if(stack.isEmpty()){
                    count++;
                    continue;
                }
                stack.pop();
            }
        }
        count += stack.size();
        return count;
    }
    public int count4(String s){
        int count = 0;
        int wordLen = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == ' ' || i == s.length() - 1){
                if(wordLen == 4){
                    count++;
                }
                wordLen = 0;
            }else{
                wordLen++;
            }
        }
        return count;
    }

    public int minCost(int[][] costs){ // paint house
        int houseNum = costs.length;
        int[][] cost = new int[3][houseNum];
        cost[0][0] = costs[0][0];
        cost[1][0] = costs[0][1];
        cost[2][0] = costs[0][2];
        for(int i = 1; i < houseNum; i++){
            cost[i][0] = Math.min(cost[i][1], cost[i][2]) + costs[0][i];
            cost[i][1] = Math.min(cost[i][0], cost[i][2]) + costs[1][i];
            cost[i][2] = Math.min(cost[i][0], cost[i][1]) + costs[2][i];
        }
        return Math.min(cost[0][houseNum - 1], Math.min(cost[1][houseNum - 1], cost[2][houseNum - 1]));
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0 || lists == null){
            return null;
        }
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(lists.length, new ListNodeComparator());
        for(int i = 0; i < lists.length; i++){
            if(lists[i] != null){
                queue.offer(lists[i]);
            }
        }
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while(!queue.isEmpty()){
            curr.next = queue.poll();
            curr = curr.next;
            if(curr.next != null){
                queue.offer(curr.next);
            }
        }
        return dummy.next;
    }
//    public List<String> searchForWord(char[][] board){ //有个char[][] board 找直线(横线，竖线，斜线都行)上的单 词
//        List<String> result = new ArrayList<>();
//
//    }

    public int maxDepth(TreeNode root){ // get the maximum depth of a binary tree using no recursion
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        TreeNode pre = null;
        int maxDep = 0;
        int depth = 0;
        while(!stack.isEmpty() || curr != null){
            while(curr != null){
                stack.push(curr);
                depth++;
                curr = curr.left;
            }
            curr = stack.peek();
            if(curr.right == null){
                pre = curr;
                maxDep = maxDep > depth ? maxDep : depth;
                stack.pop();
                curr = null;
            }else if(curr.right == pre){
                depth--;
                stack.pop();
                curr = null;
            }else{
                curr = curr.right;
                depth++;
            }
        }
        return maxDep;
    }

    public List<Integer> postOrderII(TreeNode root){
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        TreeNode pre = null;
        while(!stack.isEmpty() || curr != null){
            stack.push(curr);
            curr = curr.left;
        }
        curr = stack.peek();
        if(curr.right == null || curr.right == pre){
            result.add(curr.val);
            pre = curr;
            curr = null;
            stack.pop();
        }else{
            curr = curr.right;
        }
        return result;
    }

//    public boolean hasCycle(int[] arr){ //Given an array with relative indexes, determine if there is a single complete cycle or not
//        int len = arr.length;
//        boolean[] visited = new boolean[len];
//        int curr = 0;
//        int steps = arr[0];
//        visited[0] = true;
//        while(!visited[curr] && steps != 0){
//            steps = steps % ((len - 1) * 2);
//            if(steps > len - 1 - curr){
//                steps = (len - 1 - curr) * 2 - steps;
//            }
//            curr = curr + steps;
//            visited[curr] = true;
//        }
//
//    }

    public List<List<String>> workflow(String[] processes){
        HashMap<String, ArrayList<String>> outDegree = new HashMap<>();
        HashMap<String, Integer> inDegree = new HashMap<>();
        List<List<String>> result = new ArrayList<>();
        Set<String> set = new HashSet<>();
        for(int i = 0; i < processes.length; i++){
            String[] process = processes[i].split(",");
            if(!inDegree.containsKey(process[1])){
                inDegree.put(process[1], 1);
            }else{
                inDegree.put(process[1], inDegree.get(process[1]) + 1);
            }
            if(!outDegree.containsKey(process[0])){
                outDegree.put(process[0], new ArrayList<String>());
            }
            outDegree.get(process[0]).add(process[1]);
            set.add(process[0]);
            set.add(process[1]);
        }
        Queue<String>  queue = new LinkedList<>();
        for(String str : set){
            if(!inDegree.containsKey(str)){
                queue.offer(str);
            }
        }
        while(!queue.isEmpty()){
            int size = queue.size();
            List<String> resultLevel = new ArrayList<>();
            for(int i = 0; i < size; i++){
                String process = queue.poll();
                resultLevel.add(process);
                if(outDegree.containsKey(process)){
                    ArrayList<String> nextProcess = outDegree.get(process);
                    for(String str : nextProcess){
                        inDegree.put(str, inDegree.get(str) - 1);
                        if(inDegree.get(str) == 0){
                            queue.offer(str);
                        }
                    }
                }
            }
            result.add(resultLevel);
        }
        return result;
    }
    public List<List<String>> friends(String[] employes){
        List<List<String>> friendShip = new ArrayList<>();
        HashMap<String, List<String>> friendsMap = new HashMap<>();
        for(int i = 0; i < employes.length; i++){
            String[] friendPair = employes[i].split(",");
            for(int j = 0; j < friendPair.length; j++){
                if(!friendsMap.containsKey(friendPair[j])){
                    friendsMap.put(friendPair[j], new ArrayList<String>());
                }
                friendsMap.get(friendPair[j]).add(friendPair[(j + 1) % 2]);
            }
        }
        for(String emp : friendsMap.keySet()){
            friendsMap.get(emp).add(0, emp);
            friendShip.add(friendsMap.get(emp));
        }
        return friendShip;
    }
    public int[] findaRect(int[][] matrix){
        int m = matrix.length;
        int n = matrix[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == 0){
//                    return checkRect(i, j);
                }
            }
        }
        return new int[]{0, 0};
    }
//    public int[] checkRect(int[][] matrix, int x, int y){
//        int endX = x;
//        int endY = y;
//        while(endX < matrix.length && checkLineHorizontal(matrix, x, endX + 1, endY + 1) && endY < matrix[0].length && checkLineVertical(matrix, y, endY  + 1, endX + 1)){
//            endX++;
//            endY++;
//        }
//        while(endX < matrix.length && checkLineHorizontal(matrix, x, endX + 1, endY + 1)){
//            endX++;
//        }
//        while(endY < matrix[0].length && checkLineVertical(matrix, y, endY  + 1, endX + 1)){
//            endY++;
//        }
//    }
    public boolean checkLineHorizontal(int[][] matrix, int start, int end, int x){
        for(int i = start; i <= end && i < matrix[0].length; i++){
            if(matrix[x][i] == 1){
                return false;
            }
        }
        return true;
    }
    public boolean checkLineVertical(int[][] matrix, int start, int end, int y){
        for(int i = start; i <= end && i < matrix.length; i++){
            if(matrix[i][y] == 1){
                return false;
            }
        }
        return true;
    }
    public Set<String> illegalEnter(List<String> records){
        HashMap<String, String> enterExit = new HashMap<>();
        Set<String> illegals = new HashSet<>();
        for(int i = 0; i < records.size(); i++){
            String[] record = records.get(i).split(",");
            if(enterExit.containsKey(record[0])){
                if(enterExit.get(record[0]).equals("exit") || (enterExit.get(record[0]).equals("enter") && record[1].equals("enter"))){
                    illegals.add(record[0]);
                }else if(enterExit.get(record[0]).equals("enter") && record[1].equals("exit")){
                    enterExit.put(record[0], "done");
                }
            }else{
                enterExit.put(record[0], record[1]);
                if(record[1].equals("exit")){
                    illegals.add(record[0]);
                }
            }
        }
        return illegals;
    }
    public Set<String> limitEnter(List<String> records){
        HashMap<String, List<Integer>> nameToTime = new HashMap<>();
        Set<String> illegals = new HashSet<>();
        for(int i = 0; i < records.size(); i++){
            String[] visit = records.get(i).split(",");
            if(!nameToTime.containsKey(visit[0])){
                nameToTime.put(visit[0], new ArrayList<Integer>());
            }
            List<Integer> times = nameToTime.get(visit[0]);
            if(times.size() >= 2 && times.get(times.size() - 2) + 60 >= Integer.parseInt(visit[1])){
                illegals.add(visit[0]);
            }
            nameToTime.get(visit[0]).add(Integer.parseInt(visit[1]));
        }
        return illegals;
    }
    public Set<String> limitEnterwithSliding(List<String> records){ //using sliding window
        HashMap<String, Integer> nameToNumber = new HashMap<>();
        List<Enter> enters = new ArrayList<>();
        Set<String> illegals = new HashSet<>();
        for(int i = 0; i < records.size(); i++){
            String[] nameAndTime = records.get(i).split(",");
            enters.add(new Enter(nameAndTime[0], Integer.parseInt(nameAndTime[1])));
        }
        int start = 0;
        for(int i = 0; i < enters.size(); i++){
            if(!nameToNumber.containsKey(enters.get(i).name)){
                nameToNumber.put(enters.get(i).name, 1);
            }else{
                nameToNumber.put(enters.get(i).name, nameToNumber.get(enters.get(i).name) + 1);
            }
            while(enters.get(i).time - enters.get(start).time > 60){
                nameToNumber.put(enters.get(start).name, nameToNumber.get(enters.get(start).name) - 1);
                start++;
            }
            if(nameToNumber.get(enters.get(i).name)>= 3){
                illegals.add(enters.get(i).name);
            }
        }
        return illegals;
    }
    //“implement strStr”，时间复杂度的问答。以及变种：假设str的字符位置可以置换，找到index。比如 str = abc ; Str = iuhoacbioy;那么返回index = 4 Intuit
    public int strStrBianxing(String haystack, String needle){
        if(haystack.length() < needle.length()){
            return -1;
        }
        for(int i = 0; i <= haystack.length() - needle.length(); i++){
            if(sameletters(needle, haystack.substring(i, i + needle.length()))){
                return i;
            }
        }
        return -1;
    }
    boolean sameletters(String str1, String str2){
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        if(str1.length() != str2.length()){
            return false;
        }
        int[] letters = new int[26];
        for(int i = 0; i < str1.length(); i++){
            letters[str1.charAt(i) - 'a']++;
        }
        for(int i = 0; i < str2.length(); i++){
            letters[str2.charAt(i) - 'a']--;
            if(letters[str2.charAt(i) - 'a'] < 0){
                return false;
            }
        }
        return true;
    }

    //http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=296767&highlight=intuit
    public HashMap<String, Integer> clickTime(List<String> input){
        HashMap<String, Integer> count = new HashMap<>();
        for(int i = 0; i < input.size(); i++){
            String[] line = input.get(i).split(",");
            String[] domains = line[0].split("\\.");
            int countPerLine = Integer.parseInt(line[1]);
            StringBuilder subDomain = new StringBuilder();
            for(int j = domains.length - 1; j >= 0; j--){
                if(j == domains.length - 1){
                    subDomain.append(domains[domains.length - 1]);
                }else{
                    subDomain.insert(0, domains[j] + ".");
                }
                if(!count.containsKey(subDomain.toString())){
                   count.put(subDomain.toString(), countPerLine);
                }else{
                    count.put(subDomain.toString(), count.get(subDomain.toString()) + countPerLine);
                }
            }
        }
        return count;
    }

    //给每个user访问历史记录，找出两个user之间longest continuous common history
    //http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=296767&highlight=intuit
    List<String> commonHis(List<String> user1, List<String> user2){
        int m = user1.size();
        int n = user2.size();
        List<String> common = new ArrayList<>();
        int[][] dp = new int[m + 1][n + 1];
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(user1.get(i - 1).equals(user2.get(j - 1))){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else{
                    dp[i][j] = 0;
                }
            }
        }
        int max = 0;
        int x = 0;
        for(int i = 0; i <= m; i++){
            for(int j = 0; j <= n; j++){
                if(max < dp[i][j]){
                    max = dp[i][j];
                    x = i;
                }
            }
        }
            for(int i = 0; i < max; i++){
                common.add(0, user1.get(x - i - 1));
            }

        return common;
    }
    public int basicCal(String str){ //第一題是給你一個string例如"2+3-999"回傳計算結果int
        int sign = 1;
        int result = 0;
        int num = 0;
        for(int i = 0; i < str.length(); i++){
            if(Character.isDigit(str.charAt(i))){
                num = num * 10 + str.charAt(i) - '0';
            }else{
                result += num * sign;
                num = 0;
                if(str.charAt(i) == '+' ){
                    sign = 1;
                }else{
                    sign = -1;
                }
            }
        }
        result += num * sign;
        return result;
    }
    //https://instant.1point3acres.com/thread/284323
    public List<Pair> findSingRec(int[][] matrix){
        List<Pair> result = new ArrayList<>();
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    int x = i;
                    int y = j;
                    while(matrix[x][y] == 0 && x < matrix.length){
                        x++;
                    }
                    while(matrix[x - 1][y] == 0 && y < matrix[0].length){
                        y++;
                    }
                    result.add(new Pair(i, j));
                    result.add(new Pair(x - 1, y - 1));
                    return result;
                }
            }
        }
        return result;
    }

    //https://instant.1point3acres.com/thread/284323
    public List<Rect> findManyRect(int[][] matrix){
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] visited = new boolean[m][n];
        List<Rect> result = new ArrayList<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == 0 && visited[i][j] == false){
                    int x = i;
                    int y = j;
                    while(x < m && matrix[x][y] == 0 ){
                        x++;
                    }
                    while(y < n && matrix[x - 1][y] == 0){
                        y++;
                    }
                    Rect rect = new Rect(new Pair(i, j), new Pair(x - 1, y - 1));
                    result.add(rect);
                    visit(visited, rect);
                }else{
                    visited[i][j] = true;
                }
            }
        }
        return result;
    }
    void visit(boolean[][] visted, Rect rect){
        for(int i = rect.upleft.x; i <= rect.downRight.x; i++ ){
            for(int j = rect.upleft.y; j <=rect.downRight.y; j++){
                visted[i][j] = true;
            }
        }
    }
    void bubbleSort(int[] arr){
        for(int i = 0; i < arr.length - 1; i++){
            for(int j = 0; j < arr.length - 1 - i; j++){
                if(arr[j] > arr[j + 1]){
                    swap2(arr, j, j + 1);
                }
            }
        }
    }
    int levelSum;
    public int levelSum(int level, TreeNode root){
        levelSum = 0;
        dfs(root, level, 1);
        return levelSum;
    }
    public void dfs(TreeNode root, int level, int depth){
        if(root == null){
            return;
        }
        if(level == depth){
            levelSum += root.val;
        }
        depth++;
        dfs(root.left, level, depth);
        dfs(root.right, level, depth);

    }

    public List<Interval> getInterval(int[] arr1, int[] arr2){
        List<Interval> result = new ArrayList<>();
        int[] temp = new int[arr1.length + arr2.length];
        for(int i = 0; i < arr1.length; i++){
            temp[i] = arr1[i];

        }
        for(int i = 0; i < arr2.length; i++){
            temp[arr1.length + i] = arr2[i];
        }
        Arrays.sort(temp);
        for(int i = 0; i < temp.length; i++){
            Interval interval = new Interval(temp[i], temp[i]);
            if(result.size() == 0){
                result.add(interval);
            }else{
                if(result.get(result.size() - 1).end >= temp[i] - 1){
                    result.get(result.size() - 1).end = temp[i];
                }else{
                    result.add(interval);
                }
            }
        }
        return result;
    }

    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        preOrder(root, sb);
        return sb.toString();
    }
    private void preOrder(TreeNode root, StringBuilder sb){
        if(root == null){
            sb.append("N").append(",");
            return;
        }
        sb.append(root.val).append(",");
        preOrder(root.left, sb);
        preOrder(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes = strToNodes(data, nodes);
        return construct(nodes);
    }
    private Queue<TreeNode> strToNodes(String data, Queue<TreeNode> nodes){
        int val = 0;
        boolean nullNode = false;
        for(int i = 0; i < data.length(); i++){
            char c = data.charAt(i);

            if(Character.isDigit(c)){
                val = val * 10 + c - '0';
                nullNode = false;
            }else if(c == 'N'){
                nullNode = true;
                nodes.offer(null);
            }else if(c == ',' && !nullNode){
                TreeNode node = new TreeNode(val);
                val = 0;
                nodes.offer(node);
            }
        }
        return nodes;
    }
    private TreeNode construct(Queue<TreeNode> nodes){
        TreeNode node = nodes.poll();
        if(node == null){
            return null;
        }
        node.left = construct(nodes);
        node.right = construct(nodes);
        return node;
    }


    private boolean knows(int a, int b){
        return true;
    }
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if(root == null || root.left == null){
            return root;
        }
        TreeNode newRoot = upsideDownBinaryTree(root.left);
        root.left.left = root.right;
        root.left.right = root;
        root.left = null;
        root.right = null;
        return newRoot;
    }
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        helper(result, root);
        return result;
    }
    private int helper(List<List<Integer>> result, TreeNode root){
        if(root == null){
            return -1;
        }
        int level = Math.max(helper(result, root.left), helper(result, root.right)) + 1;
        if(level >= result.size()){
            result.add(new ArrayList<Integer>());
        }
        result.get(level).add(root.val);
        return level;
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> dict = new HashSet<>();
        for(String word : wordList){
            dict.add(word);
        }
        dict.add(endWord);
        dict.add(beginWord);
        List<List<String>> ladders = new ArrayList<>();
        List<String> ladder = new ArrayList<>();
        HashMap<String, Integer> distance = new HashMap<>();
        bfs(beginWord, endWord, distance, dict);
        dfs(endWord, beginWord, distance, ladders, ladder, dict);
        return ladders;
    }
    private void dfs(String beginWord, String endWord, HashMap<String, Integer> distance, List<List<String>> ladders, List<String> ladder, HashSet<String> dict){
        ladder.add(0, beginWord);
        if(beginWord.equals(endWord)){
            ladders.add(new ArrayList<>(ladder));
        }
        List<String> neighbours = findNeighbours(beginWord, dict);
        for(String neighbour : neighbours){
            if(distance.containsKey(neighbour) && distance.get(neighbour) < distance.get(beginWord)){
                dfs(neighbour, endWord, distance, ladders, ladder, dict);
            }
        }
        ladder.remove(0);
    }

    private void bfs(String beginWord, String endWord, HashMap<String, Integer> distance, HashSet<String> dict){
        Queue<String> queue = new LinkedList<>();
        int level = 0;
        queue.offer(beginWord);
        distance.put(beginWord, 0);
        while(!queue.isEmpty()){
            level++;
            int size = queue.size();
            for(int i = 0; i < size; i++){
                String word = queue.poll();
                List<String> neighbours = findNeighbours(word, dict);
                for(String neighbour : neighbours){
                    if(!distance.containsKey(neighbour)){
                        distance.put(neighbour, level);
                        queue.offer(neighbour);
                    }
                }
            }

        }
    }
    private List<String> findNeighbours(String word, HashSet<String> dict){
        List<String> result = new ArrayList<>();
        for(int i = 0; i < word.length(); i++){
            for(char c = 'a'; c < 'z'; c++){
                if(c != word.charAt(i)){
                    String newWord = replace(word, c, i);
                    if(dict.contains(newWord)){
                        result.add(newWord);
                    }
                }
            }
        }
        return result;
    }
    private String replace(String word, char c, int index){
        char[] newWord = word.toCharArray();
        newWord[index] = c;
        return new String(newWord);
    }
    public int findValley(int[][] map){
        int m = map.length;
        int n = map[0].length;
        boolean[][] visited = new boolean[m][n];
        int count = 0;
        Comparator comparator = new CoordComparator();
        PriorityQueue<Coordinate1> points = new PriorityQueue<>(m * n, comparator);
        for(int i = 0; i < map.length; i++){
            for(int j = 0; j < map[0].length; j++){
                points.offer(new Coordinate1(i, j, map[i][j]));
            }
        }
        while(!points.isEmpty()){
            Coordinate1 curr = points.poll();
            if(!visited[curr.x][curr.y]){
                count++;
                bfs1(visited, map, m, n, curr);
            }
        }
        return count;
    }
    private void bfs1(boolean[][] visited, int[][] map, int m, int n, Coordinate1 point){
        int[] horiz = new int[]{1, 0, -1, 0};
        int[] vertic = new int[]{0, 1, 0, -1};
        Queue<Coordinate1> queue = new LinkedList<>();
        queue.offer(point);
        while(!queue.isEmpty()){
            Coordinate1 curr = queue.poll();
            for(int i = 0; i < 4; i++){
                int nx = curr.x + horiz[i];
                int ny = curr.y + vertic[i];
                if(nx >= 0 && nx < m && ny >=0 && ny < n && !visited[nx][ny]){
                    if(map[nx][ny] >= map[curr.x][curr.y]){
                        visited[nx][ny] = true;
                        queue.offer(new Coordinate1(nx, ny));
                    }
                }
            }
        }
    }

    public int closestValue2ndShua(TreeNode root, double target) {
        int closest = root.val;
        while(root != null){
            closest = Math.abs(root.val - target) < Math.abs(closest - target) ? root.val : closest;
            if(root.val > target){
                root = root.left;
            }else if(root.val < target){
                root = root.right;
            }else{
                return root.val;
            }
        }
        return closest;
    }
    int closest;
    public int closestValue2ndShuaRecursion(TreeNode root, double target) {
        closest = root.val;
        closestHelper(root, target);
        return closest;
    }
    private void closestHelper(TreeNode root, double target){
        if(root == null){
            return;
        }
        closest = Math.abs(target - closest) < Math.abs(target - root.val) ? closest : root.val;
        if(root.val > target){
            closestHelper(root.left, target);
        }else if(root.val < target){
            closestHelper(root.right, target);
        }else{
            return;
        }
    }
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        Deque<Integer> closests = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while(curr != null || !stack.isEmpty()){
            while(curr != null){
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            if(closests.size() == k){
                if(Math.abs(closests.peekFirst() - target) < Math.abs(curr.val - target)){
                    return (List<Integer>) closests;
                }
                closests.pollFirst();
            }
            closests.offerLast(curr.val);
            curr = curr.right;
        }
        return (List<Integer>) closests;
    }
// 给一个array,找出里面所有的sub array,和等于某个数
    public List<List<Integer>> targetSum(List<Integer> nums, int sum){
        int[] preSum = new int[nums.size()];
        List<List<Integer>> results = new ArrayList<>();
        preSum[0] = nums.get(0);
        for(int i = 1; i < nums.size(); i++){
            preSum[i] = preSum[i - 1] + nums.get(i);
        }
        HashMap<Integer, Integer> preExist = new HashMap<>();
        for(int i = 0; i < preSum.length; i++){
            if(preExist.containsKey(preSum[i] - sum)){
                results.add(addToResult(nums, preExist.get(preSum[i] - sum) + 1, i));
            }
            preExist.put(preSum[i], i);
        }
        return results;
    }
    private List<Integer> addToResult(List<Integer> nums, int start, int end){
        List<Integer> result =  new ArrayList<>();
        for(int i = start; i <= end; i++){
            result.add(nums.get(i));
        }
        return result;
    }

    ////给一个set of integers，给一个 target number，要求找出 所有的subset，每个set里面的数字之和等于 target number。
    //先写一个subset的代码,然后在上面做一些改动,见subsetSum
    public List<List<Integer>> subset(int[] nums){
        List<Integer> subset = new ArrayList<>();
        List<List<Integer>> subsets = new ArrayList<>();
        helper(nums, 0, subset, subsets);
        return subsets;
    }
    private void helper(int[] nums, int pos, List<Integer> subset, List<List<Integer>> subsets){

        for(int i = pos; i < nums.length; i++){
            subset.add(nums[i]);
            subsets.add(new ArrayList<>(subset));
            helper(nums, i + 1, subset, subsets);
            subset.remove(subset.size() - 1);
        }

    }
    public List<List<Integer>> subsetSum(int[] nums, int sum){
        List<Integer> subset = new ArrayList<>();
        List<List<Integer>> subsets = new ArrayList<>();
        helper1(nums, 0, subset, subsets, sum);
        return subsets;
    }
    private void helper1(int[] nums, int pos, List<Integer> subset, List<List<Integer>> subsets, int sum){
        for(int i = pos; i < nums.length; i++){
            subset.add(nums[i]);
            if(sum(subset) == sum){
                subsets.add(new ArrayList<>(subset));
            }
            helper1(nums, i + 1, subset, subsets, sum);
            subset.remove(subset.size() - 1);
        }
    }
    private int sum(List<Integer> subset){
        int sum = 0;
        for(Integer num : subset){
            sum += num;
        }
        return sum;
    }
    public int depthSumInverse(List<NestedInteger> nestedList){
        Queue<List<NestedInteger>> queue = new LinkedList<>();
        queue.offer(nestedList);
        int weighted = 0;
        int unWeighted = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                List<NestedInteger> curr = queue.poll();
                for(NestedInteger child : curr){
                    if(child.isInteger()){
                        unWeighted += child.getInteger();
                    }else{
                        queue.offer(child.getList());
                    }
                }
            }
            weighted += unWeighted;
        }
        return weighted;
    }

    public List<List<Integer>> getFactors(int n){
        List<List<Integer>> results = new ArrayList<>();
        helperFactor(new ArrayList<Integer>(), results, n, 2);
        return results;
    }
    private void helperFactor(List<Integer> result, List<List<Integer>> results, int n, int factor){
        if(n == 1){
            if(result.size() > 1){
                results.add(new ArrayList<>(result));
            }
            return;
        }
        for(int i = factor; i <= n; i++){
            if(n % i == 0){
                result.add(i);
                helperFactor(result, results, n / i, i);
                result.remove(result.size() - 1);
            }
        }
    }
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int idx1 = -1;
        int idx2 = -1;
        int turn = 0;
        int increment = word1.equals(word2) ? 1 : 0;
        int dis = Integer.MAX_VALUE;
        for(int i = 0; i < words.length; i++){
            if(words[i].equals(word1) && turn % 2 == 0){
                turn += increment;
                idx1 = i;
                if(idx2 != -1){
                    dis = Math.min(dis, idx1 - idx2);
                }
            }else if(words[i].equals(word2)){
                turn += increment;
                idx2 = i;
                if(idx1 != -1){
                    dis = Math.min(dis, idx2 - idx1);
                }
            }
        }
        return dis;
    }
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        if(sum % k != 0){
            return false;
        }
        return partihelper(nums, k, new boolean[nums.length], 0, 0, sum / k);
    }
    private boolean partihelper(int[] nums, int k, boolean[] visited, int pos, int curSum, int target){
        if(k == 1){
            return true;
        }
        if(curSum == target){
            return partihelper(nums, k - 1, visited, 0, 0, target);
        }
        for(int i = pos; i < nums.length; i++){
            if(!visited[i]){
                visited[i] = true;
                if(partihelper(nums, k, visited, i + 1, curSum + nums[i], target)){
                    return true;
                }
                visited[i] = false;
            }
        }
        return false;
    }
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int place = 0;
        for(int i = 0; i < flowerbed.length; i++){
            boolean pre = i == 0 || flowerbed[i - 1] == 0;
            boolean next = i == flowerbed.length - 1 || flowerbed[i + 1] == 0;
            if(pre && next){
                count++;
                flowerbed[i] = 1;
            }
        }
        return count >= n;
    }

    public int maxPoints(Point2[] points) {
        int max = 0;
        for(int i = 0; i < points.length; i++){
            HashMap<String, Integer> count = new HashMap<>();
            Point2 p1 = points[i];
            int samePos = 0;
            for(int j = i; j < points.length; j++){
                Point2 p2 = points[j];
                int x = p1.x - p2.x;
                int y = p1.y - p2.y;
                if(x == 0 && y ==0){
                    samePos++;
                }else{
                    int gcd = gcd(x, y);
                    String slope = String.valueOf(x / gcd) + "," + String.valueOf(y / gcd);
                    count.put(slope, count.getOrDefault(slope, 0) + 1);
                }
            }
            int currMax = 0;
            for(String slope : count.keySet()){
                currMax = currMax > count.get(slope) ? currMax : count.get(slope);
            }
            currMax += samePos;
            max = max > currMax ? max : currMax;
        }
        return max;
    }
    private int gcd(int x, int y){
        if(y == 0){
            return x;
        }else{
            return gcd(y, x % y);
        }
    }
    static int[] findIsland(final int[][] a){
        boolean[][] visited = new boolean[a.length][a[0].length];
        int numOfIsland = 0;
        List<Integer> areas = new ArrayList<>();
        for(int i = 0; i < a.length; i++){
            for(int j = 0; j < a[0].length; j++){
                if(!visited[i][j] && a[i][j] == 1){
                    visited[i][j] = true;
                    numOfIsland++;
                    areas.add(bfsHelper(a, visited, new Coordination(i, j)));
                }
            }
        }
        Collections.sort(areas);
        int[] result = new int[numOfIsland + 1];
        result[0] = numOfIsland;
        for(int i = 1; i <= numOfIsland; i++){
            result[i] = areas.get(numOfIsland - i);
        }
        return result;
    }
    static int bfsHelper(final int[][] a, boolean[][] visited, Coordination c){
        int[] horizontal = new int[]{-1, 0, 1, 0};
        int[] vertical = new int[]{0, 1, 0, -1};
        int num = 0;
        Queue<Coordination> queue = new LinkedList<>();
        queue.offer(c);
        while(!queue.isEmpty()){
            Coordination curr = queue.poll();
            num++;
            for(int i = 0; i < 4; i++){
                int x = curr.x + horizontal[i];
                int y = curr.y + vertical[i];
                if(x >= 0 && x < a.length && y >= 0 && y < a[0].length && !visited[x][y] && a[x][y] == 1){
                    visited[x][y] = true;
                    queue.offer(new Coordination(x, y));
                }
            }
        }
        return num;
    }
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        int[] win = new int[desiredTotal + 1];
        boolean[] visited = new boolean[maxChoosableInteger + 1];
        return searchWin(maxChoosableInteger, desiredTotal, win, visited);
    }
    private boolean searchWin(int maxChoosableInteger, int desiredTotal, int[] win, boolean[] visited){
        System.out.println(desiredTotal);
        if(win[desiredTotal] != 0){
            return win[desiredTotal] == 2;
        }
        if(maxChoosableInteger >= desiredTotal){
            win[desiredTotal] = 2;
            return true;
        }
        if((maxChoosableInteger * (maxChoosableInteger + 1) / 2) < desiredTotal){
            return false;
        }
        for(int i = 1; i <= maxChoosableInteger; i++){
            if(!visited[i]){
                visited[i] = true;
                if(!canIWin(maxChoosableInteger, desiredTotal - i)){
                    win[desiredTotal] = 2;
                    visited[i] = false;
                    return true;
                }
                visited[i] = false;
            }

        }
        win[desiredTotal] = 1;
        return false;
    }
    int[] dp1;
    boolean[] used;
    public boolean canIWin1(int maxChoosableInteger, int desiredTotal) {
        int sum = (1 + maxChoosableInteger) * maxChoosableInteger / 2;
        if(sum < desiredTotal) {        //取完所有数，也达不到desiredTotal，无法赢得游戏
            return false;
        }
        if(desiredTotal <= maxChoosableInteger) {      //第一步就可以获得胜利
            return true;
        }
        dp1 = new int[1 << maxChoosableInteger];
        Arrays.fill(dp1 , -1);
        used = new boolean[maxChoosableInteger + 1];

        return helper(desiredTotal);
    }

    public boolean helper(int desiredTotal){
        System.out.println(desiredTotal);
        if(desiredTotal <= 0) {
            return false;
        }
        int key = format(used);         //把used数组转为十进制表示
        if(dp1[key] == -1){
            for(int i = 1; i < used.length; i++){    //枚举未选择的数
                if(!used[i]){
                    used[i] = true;

                    if(!helper(desiredTotal - i)){
                        dp1[key] = 1;
                        used[i] = false;
                        return true;
                    }
                    used[i] = false;
                }
            }
            dp1[key] = 0;
        }
        return dp1[key] == 1;
    }


    public int format(boolean[] used){
        int num = 0;
        for(boolean b: used){
            num <<= 1;
            if(b) {
                num |= 1;
            }
        }
        return num;
    }
    public int[][] multiply(int[][] A, int[][] B) {
        int m = A.length;
        int p = A[0].length;
        int q = B.length;
        int n = B[0].length;
        int[][] AB = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int k = 0; k < p; k++){
                if(A[i][k] != 0){
                    for(int j = 0; j < n; j++){
                        if(B[k][j] != 0){
                            AB[i][j] += A[i][k] * B[k][j];
                        }
                    }
                }
            }
        }
        return AB;
    }
    public ListNode mergeKLists1(ListNode[] lists) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(lists.length, new NodeComparator());
        for(int i = 0; i < lists.length; i++){
            if(lists[i] != null){
                pq.offer(lists[i]);
            }
        }
        while(!pq.isEmpty()){
            curr.next = pq.poll();
            curr = curr.next;
            if(curr.next != null){
                pq.offer(curr.next);
            }
        }
        return dummy.next;
    }
    public int maxProduct(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        int maxProduct = nums[0];
        for(int i = 1; i < nums.length; i++){
            max = Math.max(Math.max(max * nums[i], min * nums[i]), nums[i]);
            min = Math.min(Math.min(max * nums[i], min * nums[i]), nums[i]);
            maxProduct = Math.max(max, maxProduct);
        }
        return maxProduct;
    }
    public int searchrotated(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(target == nums[mid]){
                return mid;
            }
            if(nums[mid] <= nums[start]){
                if(target > nums[mid] && target < nums[start]){
                    start = mid + 1;
                }else{
                    end = mid - 1;
                }
            }else{
                if(target >= nums[start] && target < nums[mid]){
                    end = mid - 1;
                }else{
                    start = mid + 1;
                }
            }
        }
        return -1;
    }
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        ArrayList<Integer> kclosest = new ArrayList<>();
        if(arr == null || arr.length == 0){
            return kclosest;
        }
        if(k > arr.length){
            for(int i = 0; i < arr.length; i++){
                kclosest.add(arr[i]);
            }
            return kclosest;
        }
        int closest = findCloset(arr, x);
        int start = closest;
        int end = closest + 1;

        while(k > 0 && start >= 0 && end < arr.length){
            if(Math.abs(x - arr[start]) <= Math.abs(x - arr[end])){
                kclosest.add(arr[start]);
                start--;
            }else{
                kclosest.add(arr[end]);
                end++;
            }
            k--;
        }
        int from = 0;
        if(k > 0){
            if(start == 0){
                from = end;
            }else{
                from = start;
            }
        }
        while(k > 0){
            kclosest.add(arr[from++]);
            k--;
        }

        return kclosest;
    }
    public int findCloset(int[] arr, int x){
        int start = 0;
        int end = arr.length - 1;
        while(start + 1 < end){
            int mid = start +(end - start) / 2;
            if(arr[mid] == x){
                return mid;
            }
            if(arr[mid] < x){
                start = mid;
            }else{
                end = mid;
            }
        }
        if(arr[start] >= x){
            return start;
        }else{
            return end;
        }
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> sets = new ArrayList<>();
        helper(sets, new ArrayList<Integer>(), nums, 0);
        return sets;
    }
    private void helper (List<List<Integer>> sets, List<Integer> set, int[] nums, int index) {

        if (index == nums.length) {
            return;
        }
        sets.add(new ArrayList<>(set));
        for (int i = index; i < nums.length; i++) {
            set.add(nums[i]);
            System.out.println(nums[i]);
            helper(sets, set, nums, i + 1);
            set.remove(set.size() - 1);
        }
    }

    public void reverse(char[] str, int start, int end){
        while(start < end){
            char c = str[start];
            str[start] = str[end];
            str[end] = c;
            start++;
            end--;
        }
    }
    public int jump(int[] nums) {
        int[] steps = new int[nums.length];
        steps[0] = 0;
        for (int i = 1; i < nums.length; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = i - 1; j >= 0; j--) {
                if (j + nums[j] >= i) {
                    min = min < steps[j] ? min : steps[j];
                }
            }
            steps[i] = min + 1;
        }
        return steps[nums.length - 1];
    }

    public ListNode reverseLinkedListII (ListNode head) { // pair by pair
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = reverseLinkedListII(head.next.next);
        ListNode newHead = head.next;
        head.next = next;
        newHead.next = head;
        return newHead;
    }
    public int removeWhenDup(int[] nums) {
        int slow = 0;
        int fast = 0;
        while (fast < nums.length) {
            int begin = fast;
            while (fast < nums.length && nums[fast] == nums[begin]) {
                fast++;
            }
            if (fast - begin == 1) {
                nums[slow] = nums[begin];
                slow++;
            }
        }
        return slow;
    }
    public List<Integer> spiral (int[][] nums) { // N X N matrix
        List<Integer> result = new ArrayList<>();
        spiralHelper(nums, result, 0, nums.length - 1, nums.length);
        return result;
    }
    public void spiralHelper(int[][] nums, List<Integer> result, int offset, int size, int n) {
        if (size == 0) {
            result.add(nums[offset][offset]);
            return;
        }
        if (size < 0){
            return;
        }
        for (int i = 0; i < size; i++) {
            result.add(nums[offset][offset + i]);
        }
        for (int i = 0; i < size; i++) {
            result.add(nums[offset + i][n - offset - 1]);
        }
        for (int i = 0; i < size; i++) {
            result.add(nums[n - offset - 1][n - offset - i - 1]);
        }
        for (int i = 0; i < size; i++) {
            result.add(nums[n - offset - i - 1][offset]);
        }
        spiralHelper(nums, result, offset + 1, size - 2, n);
    }
    public List<Integer> spiralII (int[][] nums) { // M X N matrix
        List<Integer> result = new ArrayList<>();
        spiralHelper(nums, result, 0, nums.length - 1, nums.length);
        return result;
    }

    public void rotate(int[][] matrix) {
        if (matrix == null) {
            return;
        }
        rotatehelper(matrix, 0, matrix.length);
    }
    public void rotatehelper(int[][] matrix, int offset, int size) {
        if (size <= 1) {
            return;
        }
        int n = matrix.length;
        for (int i = offset; i < size; i++) {
            int temp = matrix[offset][i];
            matrix[offset][i] = matrix[n - i - 1][offset];
            matrix[n - i - 1][offset] = matrix[n - offset - 1][n - i - 1];
            matrix[n - offset - 1][n - i - 1] = matrix[i][n - offset - 1];
            matrix[i][n - offset - 1] = temp;
        }
        rotatehelper(matrix, offset + 1, size - 2);
    }
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> results = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return results;
        }
        Arrays.sort(nums);
        HashMap<Integer, Pair> map = new HashMap<>();
        for (int j = 1; j < nums.length; j++) {
            while ( j < nums.length - 1 && nums[j] == nums[j + 1]) {
                j++;
            }
            for (int i = 0; i < j; i++) {
                if (i != 0 && i < nums.length && nums[i] == nums[i - 1] && i != j - 1) {
                    continue;
                }
                int partialSum = nums[i] + nums[j];
                if (map.containsKey(target - partialSum) && map.get(target - partialSum).y < i) {
                    results.add(new ArrayList<>(Arrays.asList(nums[map.get(target - partialSum).x],nums[map.get(target - partialSum).y], nums[i], nums[j])));
                } else {
                    map.put(partialSum, new Pair(i, j));
                }
            }
        }
        return results;
    }
    public String removeSpace(String str) { // skip all leading and duplicate space, add only 1 space in front of every word, laioffer stringI
        int slow = 0;
        int fast = 0;
        int count = 0;
        char [] chars = str.toCharArray();
        while (fast  < str.length()) {
            while (fast  < str.length() && chars[fast] == ' ') {
                fast++;
            }
            if (count != 0 && fast != str.length()) {
                chars[slow] = ' ';
                slow++;
            }
            while (fast < str.length() && chars[fast] != ' ') {
                chars[slow] = chars[fast];
                fast++;
                slow++;
            }
            count++;
        }
        return new String(Arrays.copyOfRange(chars, 0, slow));
    }

//    public String removeDup(String str) {
//        int slow = 1;
//        char [] chars = str.toCharArray();
//        for (int i = 1; i < str.length(); i++) {
//            if (chars[slow - 1] != chars[i]) {
//                chars[slow] = chars[i];
//
//            }
//        }
//
//    }

    public void printList(List<String> list) {
        for (String str : list) {
            System.out.print(str+ " ");
        }
    }
    public String addBinary(String a, String b) {
        int carry = 0;
        StringBuilder result = new StringBuilder();
        int index1 = a.length() - 1;
        int index2 = b.length() - 1;
        while (index1 >= 0 || index2 >= 0) {
            int bit1 = index1 >= 0 ? a.charAt(index1) - '0' : 0;
            int bit2 = index2 >= 0 ? b.charAt(index2) - '0' : 0;
            System.out.println("bit1=" + bit1 + "  bit2=" + bit2 + "  carry" + carry);
            carry = (bit1 + bit2 + carry) / 2;
            result.insert(0, (bit1 + bit2 + carry) % 2);
            index1--;
            index2--;
        }
        if (carry == 1) {
            result.insert(0, "1");
        }
        return result.toString();
    }
//    public boolean isNumber(String s) {
//        // write your code here
//        int i = 0;
//        s = s.trim() + " ";    //why +" "?
//        char[] sc = s.toCharArray();
//        int len = s.length() - 1;
//
//        if (sc[i] == '+' || sc[i] == '-') {
//            i++;
//        }
//        int nDigit = 0, nPoint = 0;
//        while (Character.isDigit(sc[i]) || sc[i] == '.') {
//            if (Character.isDigit(sc[i])) {
//                nDigit++;
//            }
//            if (sc[i] == '.') {
//                nPoint++;
//            }
//            i++;
//        }
//        if (nDigit <= 0 || nPoint > 1) {
//            return false;
//        }
//
//        if (sc[i] == 'e') {
//            i++;
//            if (sc[i] == '+' || sc[i] == '-') {
//                i++;
//            }
//            if (i == len) {
//                return false;
//            }
//            for (; i < len; i++) {
//                if (!Character.isDigit(sc[i])) {
//                    return false;
//                }
//            }
//        }
//        return i == len;
//    }

    class Solution {
        public int totalFruit(int[] tree) {
            Map<Integer, Integer> counter = new HashMap<>();
            int max = 0;
            int i = 0;
            for(int j = 0; j < tree.length; j++) {
                if (!counter.containsKey(tree[j])) {
                    counter.put(tree[j], 0);
                }
                counter.put(tree[j], counter.get(tree[j]) + 1);
                while(counter.size() > 2) {
                    counter.put(tree[i], counter.get(tree[i]) - 1);
                    if (counter.get(tree[i]) == 0) {
                        counter.remove(tree[i]);
                    }
                    i++;
                }
                max = max > j - i + 1? max : j - i + 1;
            }
            return max;
        }
    }
    public static void main(String[] args) {
        Myclass mc = new Myclass();
        String temp =  "SELECT " +
                "  entityNumber as app_id, " +
                "  SUM(amount) AS total_tpv, " +
                "  SUM(totalCharge) AS assessment_fee, " +
                "  LAST_DAY(CURRENT_DATE() - INTERVAL 2 MONTH) + INTERVAL 1 DAY AS from_date, " +
                "  LAST_DAY(CURRENT_DATE() - INTERVAL 1 MONTH) AS to_date " +
                "FROM " +
                "  `chase_dfr_service_charge` s, " +
                "  `chase_dfr_header` h " +
                "WHERE " +
                "  s.reportHeaderId = h.id " +
                "  AND category = 'IA' " +
                "  AND subCategory = 'AS' " +
                "  AND EXTRACT(month FROM reportDateFrom) = EXTRACT(month FROM current_date()) - 1 " +
                "GROUP BY " +
                "  entityNumber;";

        String s = "-2.2";
        double d = Double.parseDouble(s);
        long l =(long) (d * 10l);





        System.out.println(mc.buildMarkupQuery());

    }
    private String buildMarkupQuery()   {
        return "SELECT p.sender_account_id as account_id" +
                ", p.id as payment_id" +
                ", p.type as type" +
                ", af.totalFee as act72_fee" +
                ", ai.settlementAmount as amount" +
                ", ai.method_of_payment as payment_method" +
                ", af.category as category" +
                ", af.subCategory as subCategory" +
                ", fs.id as mark_up_fee_id" +
                ", fs.fixed_fee_amount as flat_fee" +
                ", fs.basis_point as basis_rate " +
                ", ai.entityNumber as transaction_division_id " +
                "FROM " + " wepay.payments" + " AS p " +
                // Since all payments from ACT72 are credit card payment,
                // for charge payment recipient will be IC+ merchant and sender will be credit card,
                // for refund sender will be IC+ merchant and recipient will be credit card.
                "INNER JOIN " + " wepay.chase_dfr_transaction_information_detail" + " AS ai " +
                "ON ai.merchant_order_id = p.id " +
                "INNER JOIN " +  " wepay.chase_dfr_transaction_fee_detail" + " AS af " +
                "ON ai.reportRowId = af.informationReportRowId " +
                "INNER JOIN " +  " wepay.groups" + " AS g " +
                "ON g.account_id = p.`sender_account_id` " +
                "INNER JOIN " + " wepay.shadow_group_mapping" + " AS sd " +
                "ON sd.group_id = g.id " +
                "INNER JOIN " + " wepay.merchant_fee_schedule_mapping" + " AS mfs " +
                "ON mfs.merchant_id = sd.`mapping_object_id` " +
                "AND mfs.`currency` = ai.`settlementCurrency` " +
                "INNER JOIN " + " wepay.fee_schedule" + " AS fs " +
                "ON mfs.cc_ic = fs.id " +
                "INNER JOIN " + " wepay.chase_dfr_header" + " AS h " +
                "ON ai.reportHeaderId = h.id " +
                "WHERE af.category = 'IA' AND ( af.subCategory = 'IC' OR af.subCategory = 'AS') " +
                "AND sd.mapping_object_type = 'merchant_account' " +
                "AND p.fee_schedule_id = 1" + " " +
                "AND p.type = 1 " +
                "AND p.create_time >= " + getTimeStamp()[0] + " " +
                "AND p.create_time < " + getTimeStamp()[1];
    }

    private long[] getTimeStamp() {
        Calendar cal = Calendar.getInstance();
        int month = cal.get(Calendar.MONTH);
        int year = cal.get(Calendar.YEAR);
        String startDate = month + "/" + "01" + "/" + year;
        String endDate =  month + 1 + "/" + "01" + "/" + year;
        LocalDate convertedDateStart = LocalDate.parse(startDate, DateTimeFormatter.ofPattern("M/d/yyyy"));
        LocalDate convertedDateEnd = LocalDate.parse(endDate, DateTimeFormatter.ofPattern("M/d/yyyy"));
        ZoneId zoneId = ZoneId.of("UTC");
        long epochStart = convertedDateStart.atStartOfDay(zoneId).toEpochSecond();
        long epochEnd = convertedDateEnd.atStartOfDay(zoneId).toEpochSecond();
        System.out.println(epochStart);
        System.out.println(epochEnd);
        return new long[]{epochStart, epochEnd};
    }

    private String buildFIN11Query()  {
        // get total assessment_fee in app level from FIN11
        return "SELECT " +
                "  entityNumber as transaction_division_id, " +
                "  SUM(amount) AS total_tpv, " +
                "  SUM(totalCharge) AS assessment_fee, " +
                "  LAST_DAY(CURRENT_DATE() - INTERVAL 2 MONTH) + INTERVAL 1 DAY AS from_date, " +
                "  LAST_DAY(CURRENT_DATE() - INTERVAL 1 MONTH) AS to_date " +
                "FROM `chase_dfr_service_charge` s, `chase_dfr_header` h " +
                "WHERE " +
                "  s.reportHeaderId = h.id " +
                "  AND category = 'IA' " +
                "  AND subCategory = 'AS' " +
                "  AND EXTRACT(month FROM reportDateFrom) = EXTRACT(month FROM current_date()) - 1 " +
                "GROUP BY " +
                "  entityNumber;";
    }

    private String buildACT72Query() {
        // get total assessment_fee in app level from ACT72
        return "SELECT " +
                "  entityNumber as transaction_division_id, " +
                "  SUM(settlementAmount) AS monthly_tpv, " +
                "  SUM(totalFee) AS assessment_fee, " +
                "  EXTRACT(month FROM current_date()) - 1 AS from_date, " +
                "  EXTRACT(month FROM current_date()) - 1 AS to_date " +
                "FROM `chase_dfr_transaction_fee_detail` AS d, " +
                "  `chase_dfr_transaction_information_detail` AS i, " +
                "  `chase_dfr_header` h " +
                "WHERE " +
                "  i.reportHeaderId = h.id " +
                "  AND d.informationReportRowId = i.reportRowId " +
                "  AND d.category = 'IA' " +
                "  AND d.subCategory = 'AS' " +
                "  AND EXTRACT(month FROM h.reportDateFrom) = EXTRACT(month FROM current_date()) - 1 " +
                "GROUP BY " +
                "  i.entityNumber;";
    }
    static class Coordination{
        int x;
        int y;
        public Coordination(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public void doTheWork() {
        Object o = null;
        for (int i = 0; i<5; i++) {
            try {
                o = makeObj(i);
            } catch (IllegalArgumentException e) {
                System.err.println("Error: ("+ e.getMessage()+").");
                return;
            }
                System.out.println("All done");
                if (o==null)
                    System.exit(0);

            System.out.println(o);
        }
    }
    public Object makeObj(int type) throws IllegalArgumentException {
        if (type == 1)throw new IllegalArgumentException("Don't like type " + type);
        System.out.print("make object for " + type + "\n");
        return new Object();
    }
}

     class TreeLinkNode{
        int val;
        TreeLinkNode left;
        TreeLinkNode right;
        TreeLinkNode next;
        TreeLinkNode(int val){
            this.val = val;
        }
    }

    class KClosestPoint_Test{
        private  final Random rg = new Random();
        public   Point[] generateInput(int numOfPoint){
            if(numOfPoint<0){
                return null;
            }
            Point[] rtn = new Point[numOfPoint];
            for(int i=0;i<numOfPoint;i++){
                rtn[i] = new Point(rg.nextInt(20), rg.nextInt(20));
            }
            return rtn;
        }
    }

    class UnionFind{
        int[] mother;
        int count;
        public UnionFind(int numOfElement){
            mother = new int[numOfElement];
            for(int i = 0; i < numOfElement; i++){
                mother[i] = i;
            }
            count = 0;
        }
        public void connect(int m, int n){
            int a = find(m);
            int b = find(n);
            if(a != b){
                mother[a] = b;
                count--;
            }
        }
        public int find(int n){
            if(mother[n] == n){
                return n;
            }
            return(find(mother[n]));
        }
    }

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val){
        this.val = val;
    }


    public boolean equals(TreeNode t) {
        return t.val == val;
    }

    public int compareTo(TreeNode t){
        return t.val - val;
    }
}

class Position{
    int x;
    int y;
    public Position (int x, int y){
        this.x = x;
        this.y = y;
    }
}
class ListNode {
    int val;
    ListNode next, random;
    ListNode(int x) { this.val = x; }
}

class DataPoint{
    int x;
    int y;
    int val;
    public DataPoint(int x, int y, int val){
        this.x = x;
        this.y = y;
        this.val = val;
    }
}

class MatrixComparator implements Comparator<DataPoint>{
    public int compare(DataPoint d1, DataPoint d2){
        return d1.val - d2.val;
    }
}

class MyThread implements Runnable {
    String myString = "Yes ";
    public void run() {
        this.myString = "No ";
    }
}

class ListNodeComparator implements Comparator<ListNode>{
    public int compare(ListNode l1, ListNode l2){
        return l1.val - l2.val;
    }
}
class Enter{
    String name;
    Integer time;
    public Enter(String name, Integer time){
        this.name = name;
        this.time = time;
    }
}
class Pair{
    int x;
    int y;
    public Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}

class Rect{
    Pair upleft;
    Pair downRight;
    public Rect(Pair upleft, Pair downRight){
        this.upleft = upleft;
        this.downRight = downRight;
    }
}

class Interval{
    int start;
    int end;
    public Interval(int start, int end){
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return "Interval{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}
class Coordinate1{
    int x;
    int y;
    int val;
    public Coordinate1(int x, int y){
        this.x = x;
        this.y = y;
    }
    public Coordinate1(int x, int y, int val){
        this.x = x;
        this.y = y;
        this.val = val;
    }
}
class CoordComparator implements Comparator<Coordinate1>{
    public int compare(Coordinate1 c1, Coordinate1 c2){
        return c1.val - c2.val;
    }
}

 interface NestedInteger {

             // @return true if this NestedInteger holds a single integer,
           // rather than a nested list.
    public boolean isInteger();

    // @return the single integer that this NestedInteger holds,
              // if it holds a single integer
             // Return null if this NestedInteger holds a nested list
   public Integer getInteger();

              // @return the nested list that this NestedInteger holds,
              // if it holds a nested list
              // Return null if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
 }

 class Point2{
     int x;
     int y;
     public Point2(int x, int y){
         this.x = x;
         this.y = y;
     }

 }
class NodeComparator implements Comparator<ListNode>{
    public int compare(ListNode l1, ListNode l2){
        return l1.val - l2.val;
    }
}
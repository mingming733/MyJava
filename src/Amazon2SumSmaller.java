import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by mming on 9/22/18.
 */
public class Amazon2SumSmaller {
    public int smallerCloset(int[][] nums1, int[][] nums2, int sum) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return -1;
        }
        AmazonComparator ac = new AmazonComparator();
        Arrays.sort(nums1, ac);
        Arrays.sort(nums2, ac);
        int closet = nums1[0][1] + nums2[nums2.length - 1][1];
        int i = 0;
        int j = nums2.length - 1;
        while (i < nums1.length && j >= 0) {
            int temp = nums1[i][1] + nums2[j][1];
            if (temp < sum) {
                if (temp > closet) {
                    closet = temp;
                }
                i++;
            } else if (temp > sum) {
                j--;
            } else{
                return sum;
            }
        }
        return closet <= sum ? closet : -1;
    }
    public int[][] solution(int[][] nums1, int[][] nums2, int sum) {
        ArrayList<int[]> tempResult = new ArrayList<>();
        int closet = smallerCloset(nums1, nums2, sum);
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                int temp = nums1[i][1] + nums2[j][1];
                if (temp == closet) {
                    tempResult.add(new int[]{i, j});
                }
            }
        }
        int[][] result = new int[tempResult.size()][2];
        for (int i = 0; i < tempResult.size(); i++) {
            result[i] = new int[]{nums1[tempResult.get(i)[0]][0], nums2[tempResult.get(i)[1]][0]};
        }
        return result;
    }
}
class AmazonComparator implements Comparator<int[]> {
    @Override
    public int compare(int[] o1, int[] o2) {
        if (o1[1] > o2[1]) {
            return 1;
        } else if (o1[1] < o2[1]) {
            return -1;
        } else {
            return 0;
        }
    }
}
// test case
//Amazon2SumSmaller as = new Amazon2SumSmaller();
//    int[][] nums1 = new int[][]{{1, 3000}, {2, 5000}, {3, 7000}, {4, 10000}};
//    int[][] nums2 = new int[][]{{1, 2000}, {2, 3000}, {3, 4000}, {4, 5000}};
//    int[][] result = as.solution(nums1, nums2, 10000);
//        System.out.print(result);
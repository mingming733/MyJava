import java.util.Random;

/**
 * Created by mming on 3/20/17.
 */
public class Solution {
    private int[] nums;
    private Random random;
    public Solution(int[] nums){
        this.nums = nums;
        random = new Random();
    }
    public int[] reset(){
        return nums;
    }
    public int[] shuffle(){
        int[] numsShuffle = nums.clone();
        for(int i = 0; i < nums.length; i++){
            int r = random.nextInt(i + 1);
            int temp = numsShuffle[i];
            numsShuffle[i] = numsShuffle[r];
            numsShuffle[r] = temp;
        }
        return numsShuffle;
    }
}

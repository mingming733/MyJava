/**
 * Created by mming on 1/28/17.
 */
import java.util.*;
public class WindowSum {
    public List<Integer> GetSum(List<Integer> A, int k) {
        ArrayList<Integer> result  = new ArrayList<>();
        if(A == null || A.size() == 0){
            return result;
        }
        int sum = 0;
        for(int i = 0; i < A.size(); i++){
            if(i < k - 1){
                sum = sum + A.get(i);
            }else if(i == k - 1){
                sum = sum + A.get(i);
                result.add(sum);
            }else{
                sum -= A.get(i - k);
                sum +=  A.get(i);
                result.add(sum);
            }

        }
        return result;
    }
}

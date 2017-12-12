import java.util.HashMap;

/**
 * Created by mming on 11/25/17.
 */
public class TwoSumIII {
    private HashMap<Integer, Integer> map = new HashMap<>();
    public void add(int num){
        if(map.containsKey(num)){
            map.put(num, map.get(num) + 1);
        }else{
            map.put(num, 1);
        }
    }
    public boolean find(int sum){
        for(Integer num : map.keySet()){
            if(map.containsKey(sum - num) &&(sum - num != num || (sum - num == num && map.get(num) > 1))){
                return true;
            }
        }
        return false;
    }
}

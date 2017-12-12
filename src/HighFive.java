/**
 * Created by mming on 1/27/17.
 */
import java.util.*;
public class HighFive {
    public static Map<Integer, Double> getHighFive(Result[] results){
        Map<Integer, List<Integer>> idToValues = new HashMap<>();
        Map<Integer, Double> average = new HashMap<>();
        for(Result result : results){
            List<Integer> values = new ArrayList<>();
            if(idToValues.containsKey(result.id)){
                values = idToValues.get(result.id);
            }
            values.add(result.value);
            idToValues.put(result.id, values);
        }
        for(Integer id : idToValues.keySet()){
            List<Integer> values = idToValues.get(id);
            Collections.sort(values);
            int sum = 0;
            for(int i = values.size() - 1; i >= values.size() - 5; i--){
                sum = sum + values.get(i);
            }
            average.put(id, sum / 5.0);
        }
        return average;
    }

}
class Result{
    int id;
    int value;
    public Result(int id, int value){
        this.id = id;
        this.value = value;
    }
}
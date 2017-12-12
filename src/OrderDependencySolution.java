/**
 * Created by mming on 1/26/17.
 */
import java.util.*;
public class OrderDependencySolution {
    public static List<Order> solution(List<OrderDependency> orderDependencies){
        List<Order> result = new ArrayList<>();
        Map<String, Integer> inMap = new HashMap<>();
        Map<String, List<String>> outMap = new HashMap<>();
        Map<String, Order> orderName = new HashMap<>();
        Queue<String> bst = new LinkedList<>();
        Set<String> set = new HashSet<>();
        for(OrderDependency orderDependency : orderDependencies){
            String curOrder = orderDependency.cur.orderName;
            String preOrder = orderDependency.pre.orderName;
            if(!orderName.containsKey(curOrder)){
                orderName.put(curOrder, orderDependency.cur);
            }
            if(!orderName.containsKey(preOrder)){
                orderName.put(preOrder, orderDependency.pre);
            }
            if(inMap.containsKey(curOrder)){
                inMap.put(curOrder, inMap.get(curOrder) + 1);
            }else{
                inMap.put(curOrder, 1);
            }
            List<String> outList = new ArrayList<>();
            if(outMap.containsKey(preOrder)) {
                outList = outMap.get(preOrder);
            }
            outList.add(curOrder);
            outMap.put(preOrder, outList);
            set.add(preOrder);
            set.add(curOrder);
            if(!outMap.containsKey(curOrder)){
                outMap.put(curOrder, new ArrayList<String>());
            }
        }
        for(String name : set){
            if(!inMap.containsKey(name)){
                bst.offer(name);
            }
        }
        while(!bst.isEmpty()){
            String priority = bst.poll();
            result.add(orderName.get(priority));
            List<String> outList = outMap.get(priority);
            for(String outOrder : outList){
                inMap.put(outOrder, inMap.get(outOrder) - 1);
                if(inMap.get(outOrder) == 0){
                    bst.offer(outOrder);
                }
            }
        }
        if(set.size() != result.size()){
            return null;
        }
        return result;
    }

}
class Order{
    String orderName;
    public Order(String string){
        this.orderName = string;
    }
}
class OrderDependency{
    Order cur;
    Order pre;
    public OrderDependency(Order pre, Order cur){
        this.pre = pre;
        this.cur = cur;
    }
}
import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by mming on 3/14/17.
 */
public class InsiderTrader {

    private int getCurrentPrice(HashMap<Integer, Integer> price, int day){
        while(day >= 0){
            if(price.containsKey(day)){
                return price.get(day);
            }
            day--;
        }
        return 0;
    }
    public String[] catchInsideTrader(String[] datafeed){
        HashMap<Integer, Integer> price = new HashMap<>();
        ArrayList<Transaction> transactions = new ArrayList<>();
        ArrayList<CaughtTrader> caughtTraders = new ArrayList();
        for(String data : datafeed){
            String[] splitted = data.split("\\|");
            if(splitted.length == 2){
                price.put(Integer.parseInt(splitted[0]), Integer.parseInt(splitted[1]));
            }else{
                boolean isSell = false;
                if(splitted[2].toLowerCase().equals("sell")){
                    isSell = true;
                }
                Transaction transaction = new Transaction(Integer.parseInt(splitted[0]), splitted[1], isSell, Integer.parseInt(splitted[3]));
                transactions.add(transaction);
            }
        }
        Collections.sort(transactions, new Comparator<Transaction>() {
            @Override
            public int compare(Transaction o1, Transaction o2) {
                return o1.day - o2.day;
            }
        });
        for(Transaction transaction : transactions){

            int day = transaction.day;
            int currentPrice = getCurrentPrice(price, day);
            if(transaction.isSell){
                for(int i = 1; i <= 3; i++){
                    if(price.containsKey(day + i) && (currentPrice - getCurrentPrice(price, day + i)) * transaction.amount >= 5000000){
                        CaughtTrader caughtTrader = new CaughtTrader(transaction.day, transaction.name);
                        caughtTraders.add(caughtTrader);
                        break;
                    }
                }
            }else{
                for(int i = 1; i <= 3; i++){
                    if(price.containsKey(day + i) && (getCurrentPrice(price, day + i) - currentPrice) * transaction.amount >= 5000000){
                        CaughtTrader caughtTrader = new CaughtTrader(transaction.day, transaction.name);
                        caughtTraders.add(caughtTrader);
                        break;
                    }
                }
            }
        }
        String[] result = new String[caughtTraders.size()];

        Collections.sort(caughtTraders, new Comparator<CaughtTrader>() {
            @Override
            public int compare(CaughtTrader o1, CaughtTrader o2) {
                if(o1.day == o2.day){
                    return o1.name.compareTo(o2.name);
                }else{
                    return o1.day - o2.day;
                }
            }
        });
        for(int i = 1; i < caughtTraders.size(); i++){
            CaughtTrader pre = caughtTraders.get(i - 1);
            CaughtTrader curr = caughtTraders.get(i);
            if(curr.day == pre.day && curr.name.equals(pre.name)){
                caughtTraders.remove(i);
            }
        }
        for(int i = 0; i < caughtTraders.size(); i++){
            CaughtTrader c = caughtTraders.get(i);
            result[i] = String.valueOf(c.day) + "|" + c.name;
        }
        return result;
    }

}
class CaughtTrader{
    int day;
    String name;
    public CaughtTrader(int day, String name){
        this.day = day;
        this.name = name;
    }
}
class Transaction{
    int day;
    String name;
    boolean isSell;
    int amount;
    public Transaction(int day, String name, boolean isSell, int amount){
        this.day = day;
        this.name = name;
        this.isSell = isSell;
        this.amount = amount;
    }
}

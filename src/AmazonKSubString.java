import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by mming on 9/22/18.
 */
public class AmazonKSubString {
    public List<String> findKsubString(String str, int k) {
        List<String> list = new ArrayList<>();
        HashSet<String> set = new HashSet<>();
        if (str == null || str.length() == 0 || k <=0) {
            return list;
        }
        if (k >= str.length()) {
            list.add(str);
            return list;
        }
        for (int i = 0; i <= str.length() - k; i++) {
            set.add(str.substring(i, i + k));
        }
        list.addAll(set);
        return list;
    }
}

import java.util.*;

/**
 * Created by mming on 9/19/18.
 */
public class AmazonFreq {
    public List<String> maxFreq(String word, String[] exclude) {
        List<String> strs =split(word);
        HashSet<String> excludeSet = new HashSet<>();
        for (String str : exclude) {
            excludeSet.add(str);
        }
        int maxFreq = 0;
        HashMap<String, Integer> map = new HashMap<>();
        for (String str : strs) {
            if (excludeSet.contains(str)) {
                continue;
            }
            if (map.containsKey(str)) {
                int count = map.get(str) + 1;
                map.put(str, count);
                maxFreq = maxFreq >= count ? maxFreq : count;
            } else {
                map.put(str, 1);
            }
        }
        List<String> result = new ArrayList<>();
        for (Map.Entry<String, Integer> entry: map.entrySet()) {
            if (entry.getValue() == maxFreq) {
                result.add(entry.getKey());
            }
        }
        return result;
    }
    public List<String> split(String word) {
        List<String> list = new ArrayList<>();
        int start = 0;
        word = word.trim();
        word = word + "#";
        for (int i = 1; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!Character.isLetter(c)) {
                if (start != i) {
                    list.add(word.substring(start, i));
                }
                start = i + 1;
            }
        }
        return list;
    }
}
/*yclass mc = new Myclass();
        List<String> strs = new ArrayList<>();
        strs.add("a1 9 2 3 1");
        String str = "I am Jack and my father is Jimmy. I like wearing Jack and Jone's";
        AmazonFreq af = new AmazonFreq();
        mc.printList(af.split(str));*/
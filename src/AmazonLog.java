import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by mming on 9/19/18.
 */
public class AmazonLog {
    public List<String> reorder (int logFileSize, List<String> logLines) {
        List<String> letterOnly = new ArrayList<>();
        List<String> numberOnly = new ArrayList<>();
        for (String str : logLines) {
            String[] splitted = str.split(" ");
            if (Character.isLetter(splitted[2].charAt(0))) {
                letterOnly.add(str);
            } else {
                numberOnly.add(str);
            }
        }
        Collections.sort(letterOnly, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String content1 = o1.substring(findIndex(o1), o1.length());
                String content2 = o2.substring(findIndex(o2), o2.length());
                if (content1.compareTo(content2) == 0) {
                    return o1.split(" ")[0].compareTo(o2.split(" ")[0]);
                }
                return content1.compareTo(content2);
            }
        });
        for (String str: numberOnly) {
            letterOnly.add(str);
        }
        return letterOnly;
    }
    private int findIndex(String str) {
        int i = 0;
        while (i < str.length() && (str.charAt(i) != ' ')) {
            i++;
        }
        while (i < str.length() && str.charAt(i) == ' ') {
            i++;
        }
        return i;
    }
    List<List<Integer>> list = new ArrayList<>();
}
/*
* AmazonLog al = new AmazonLog();
    List<String> list = new ArrayList<String>();
    list.add("a1 3 5 7 4");
    list.add("A1c Act car");
    list.add("zo4 4 7");
    list.add("a01 off KEY dog");
    list.add("a1b act car");
    al.reorder(5,list);*/

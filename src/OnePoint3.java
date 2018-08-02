import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class OnePoint3 {
    private static final String link = "https://instant.1point3acres.com/v2/api/tag/google/threads?pg=1&ps=10";

    public Set<String> parseResult(String fileName) throws Exception {
        Object obj = null;
        Set<String> pages = new HashSet<>();
        try {
            obj = new JSONParser().parse(new FileReader(fileName));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        JSONObject jo = (JSONObject) obj;
        JSONArray threads = (JSONArray) jo.get("threads");
        Iterator itr1 = threads.iterator();

        while (itr1.hasNext())
        {
            Iterator itr2 = ((Map) itr1.next()).entrySet().iterator();
            while (itr2.hasNext()) {
                Map.Entry next = (Map.Entry)itr2.next();
                if (next.getKey().equals("id")) {
                    pages.add(next.getValue().toString());
                }
            }
        }
        printSet(pages);
        return pages;
    }
    public void printSet(Set<String> set) {
        for (String str : set) {
            System.out.println("https://instant.1point3acres.com/thread/" + str);
        }
        System.out.println(set.size());
    }
    public void findInterSec (String file1, String  file2) throws Exception {
        Set<String> set1 = parseResult(file1);
        Set<String> set2 = parseResult(file2);
        set1.retainAll(set2);
        printSet(set1);
    }
}

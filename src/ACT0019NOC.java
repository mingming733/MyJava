import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class ACT0019NOC {

    public static void main (String[] args) throws Exception {
        String path = "/Users/mingm/files/ACT0019Sep/DEVOPS-269323/";
        File folder = new File(path);
        File[] listOfFiles = folder.listFiles();
        Map<String, String> map = new TreeMap<>();
        for (int i = 0; i < listOfFiles.length; i++) {
            String fileName = listOfFiles[i].getName();
            String key = "";
            String content = "";
            if (fileName.endsWith("clear")) {
                BufferedReader br = new BufferedReader(new FileReader(path + fileName));
                String line;
                while ((line = br.readLine()) != null) {
                    if (line.startsWith("HACT0019")) {
                        key = line.split(",")[2];
                        content += line.split(",")[2];
                        content += "\n";
                        content += line;
                    } else if (line.startsWith("RACT0019")) {
                        content += "\n";
                        content +=line;
                    }
                }
            }
            map.put(key, content);
        }
        for (String str : map.values()) {
            System.out.println(str);
        }
    }
}

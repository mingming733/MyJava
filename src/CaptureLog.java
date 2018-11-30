import java.io.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by mming on 7/27/18.
 */
public class CaptureLog {
    public void findFailed (String path) throws Exception {
        File file = new File(path);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String str;
        int count = 0;
        while ((str = br.readLine()) != null) {
            if (str.contains("success=false")) {
                String[] failedLine = str.split(" ");
                System.out.println(failedLine[3].substring(14));
                count++;
            }
        }
        System.out.println("total number=" + count);
    }
    public void findExceptions (String path) throws Exception {

        File file = new File(path);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String str;
        String last = "";

        // output
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintStream out = new PrintStream(new FileOutputStream("output.txt"));

        while ((str = br.readLine()) != null) {
            if (str.trim().contains("com.braintreegateway.exceptions.UnexpectedException: api.braintreegateway.com")) {
                String[] failedLine = last.split(" ");
                out.println(failedLine[3].substring(14, failedLine[3].length() - 1));
            }
            last = str;
        }
        System.setOut(out);
    }
    public void findSuccess (String path) throws Exception {
        File file = new File(path);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String str;
        int count = 0;
        Set<String> set = new HashSet<>();
        while ((str = br.readLine()) != null) {
            if (str.contains("success=true")) {
                String[] failedLine = str.split(" ");
                set.add(failedLine[3].substring(14));
                count++;
            }
        }
        // output
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintStream out = new PrintStream(new FileOutputStream(getTimeStamp() + ".txt"));
        for (String referenceNum : set) {
            out.println(referenceNum);
        }
        System.setOut(out);
        System.out.println("total number=" + count);
    }
    public void findJacoco (String path) throws Exception {
        File file = new File(path);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String str;
        int count = 0;
        Set<String> set = new HashSet<>();
        while ((str = br.readLine()) != null) {
            if (str.contains("jacoco")) {
                String[] failedLine = str.split(" ");
                set.add(str);
                count++;
            }
        }
        // output
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintStream out = new PrintStream(new FileOutputStream(getTimeStamp() + ".txt"));
        for (String referenceNum : set) {
            out.println(referenceNum);
        }
        System.setOut(out);
        System.out.println("total number=" + count);
    }
    public void createSql (String path) throws Exception {
        File file = new File(path);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String str = " ";
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintStream out = new PrintStream(new FileOutputStream("sql.txt"));
        int total = 0;
        while (str != null) {
            int count = 999;
            StringBuilder sb = new StringBuilder();
            sb.append("select buyer_order_id, date_added, CC_SYSTEM from cc_trans where id in (");
            while (count > 0 && (str = br.readLine()) != null) {
                sb.append("'").append(str).append("'").append(", ");
                count--;
                total++;
            }
            sb.setLength(sb.length() - 2);
            sb.append(")");
            out.println(sb.toString());
            out.println("####################");
            System.out.println("total number=" + total);
        }
        System.setOut(out);
    }
    public void findDulicate (String path) throws Exception {
        File file = new File(path);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String str;
        int count = 0;
        Set<String> set = new HashSet<>();
        while ((str = br.readLine()) != null) {
            set.add(str);
        }
        System.out.print(set.size());
    }
    public void deduplicate (String path1, String path2, String path3) throws Exception {
        File file = new File(path1);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String str;
        Set<String> set = new HashSet<>();
        while ((str = br.readLine()) != null) {
            set.add(str);
        }

        File file2 = new File(path2);
        BufferedReader br2 = new BufferedReader(new FileReader(file2));
        while ((str = br2.readLine()) != null) {
            set.remove(str);
        }

        File file3 = new File(path3);
        BufferedReader br3 = new BufferedReader(new FileReader(file3));
        while ((str = br3.readLine()) != null) {
            set.remove(str);
        }
        for (String num : set) {
            System.out.println(num);
        }
    }
    public void deduplicate2() throws Exception{
        File file = new File("/Users/mming/Downloads/tidlackR1");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String str;
        Set<String> set = new HashSet<>();
        while ((str = br.readLine()) != null) {
            set.add(str);
        }

        File file2 = new File("/Users/mming/Downloads/tid_voided");
        BufferedReader br2 = new BufferedReader(new FileReader(file2));
        while ((str = br2.readLine()) != null) {
            if(!set.contains(str)){
                System.out.println(str);
            }
            set.remove(str);
        }
        System.out.println("######################");
        for (String num : set) {
            System.out.println(num);
        }
    }
    private String getTimeStamp() {
        Date date = new Date();
        return date.getTime() + "";
    }
}

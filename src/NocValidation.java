import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.sql.SQLOutput;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class NocValidation {
    private static final String insertSql = "Insert  `mythic-crane-708.mingm.notification_of_change_record`\n" +
            "(id ,\n" +
            "  row_id ,\n" +
            "  corrected_account_type,\n" +
            "  corrected_account_number_hash ,\n" +
            "  corrected_routing_hash,\n" +
            "  currency,\n" +
            "  payment_id,\n" +
            "  report_type,\n" +
            "  report_date,\n" +
            "  reason_code,\n" +
            "  verified,\n" +
            "  ts_create_time,\n" +
            "  ts_modify_time)";

    public void insertNocRecord() throws Exception {
        File file = new File("/Users/mingm/Downloads/book2.csv" );
        BufferedReader br = new BufferedReader(new FileReader(file));
        String str;
        while ((str = br.readLine()) != null) {
            String[] strs = str.split(",");
            StringBuffer sb = new StringBuffer();
            HashSet<Integer> set = new HashSet<>();
            set.add(1);
            set.add(2);
            set.add(3);
            set.add(4);
            set.add(5);
            set.add(8);
            set.add(9);
            set.add(11);
            set.add(12);
            sb.append("(");
            for (int i = 0; i < strs.length; i++) {
                if (set.contains(i) && !strs[i].trim().equals("NULL")){
                    sb.append("\"");
                    sb.append(strs[i].trim());
                    sb.append("\"");
                } else {
                    sb.append(strs[i].trim());
                }
                sb.append(",");
            }
            sb.deleteCharAt(sb.length() - 1);
            sb.append("),");
            System.out.println(sb);
        }
    }
    public void insertMockingbirdValidation() throws Exception {
        File file = new File("/Users/mingm/Downloads/test_mockingbird.txt" );
        BufferedReader br = new BufferedReader(new FileReader(file));
        String str;
        while ((str = br.readLine()) != null) {
            String[] strs = str.split("\\|");
            StringBuffer sb = new StringBuffer();
            HashSet<Integer> set = new HashSet<>();
            set.add(0);
            set.add(2);
            set.add(3);
            set.add(11);
            sb.append("(");
            strs[1] = "xxx";
//            strs[9] = strs[6];
//            strs[10] = strs[7];
//            strs[11] = "1";
            for (int i = 0; i < strs.length; i++) {
                if (set.contains(i) || strs[i].trim().equals("NULL")){
                    sb.append(strs[i].trim());
                } else {
                    sb.append("\"");
                    sb.append(strs[i].trim());
                    sb.append("\"");
                }
                sb.append(",");
            }
            sb.deleteCharAt(sb.length() - 1);
            sb.append("),");
            System.out.println(sb);
        }
    }
    public void dedupe() throws Exception {
        File file = new File("/Users/mingm/Downloads/noc_payments.csv" );
        BufferedReader br = new BufferedReader(new FileReader(file));
        String str;
        HashSet<String> set = new HashSet<>();
        while ((str = br.readLine()) != null) {
            String[] data = str.split(",");
            if (set.contains(data[1])) {
                System.out.println(str);
            } else {
                set.add(data[1]);
            }
        }
    }
}

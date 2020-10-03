import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.sql.SQLOutput;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class AML {
    public static final String FILE_NAME = "AML0814";
    public void generateCommands() throws Exception {
        File file = new File("/Users/mingm/Downloads/" +
                FILE_NAME +
                "/csv_list");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String str;
        int count = 0;
        String result = "";
        // make new dir
        String newDir = "csv" ;
        File dirFile = new File("/Users/mingm/Downloads/AML/" + newDir);
        dirFile.mkdir();
        while ((str = br.readLine()) != null) {
            System.out.println("php content/index.php upgrade/exportChaseAMLReport/payment_id_" +
                    str +
                    ".csv/" +
                    str +
                    "/1/1");
            result += str + ".csv.asc \n";
            String newPath = "/Users/mingm/Downloads/" +
                    FILE_NAME +
                    "/paymentId/" +
                    "/payment_id_" +
                    str +
                    ".csv";
            FileWriter myWriter = new FileWriter(newPath);
            myWriter.write("123,123");
            myWriter.close();
            count++;
        }

        System.out.println("total count " + count);
        System.out.println(result + "will be generated");
    }
    public void dedupe() throws Exception {
        File file = new File("/Users/mingm/Downloads/" +
                FILE_NAME +
                "/csv_list");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String str;
        while ((str = br.readLine()) != null) {
            String fileName = "/Users/mingm/Downloads/" +
                    FILE_NAME +
                    "/paymentId_OLD/" +
                    "/payment_id_" +
                    str +
                    ".csv";
            File csvFile = new File(fileName);
            BufferedReader csvBr = new BufferedReader(new FileReader(csvFile));
            String paymentId;
            Set<String> set = new HashSet<>();
            while ((paymentId = csvBr.readLine()) != null) {
                if (set.contains(paymentId)) {
                    System.out.println(fileName + " has duplicates!!!!!Please check");
                } else {
                    set.add(paymentId);
                }
            }
            System.out.println(fileName + " has no duplicate");
        }
        System.out.printf("finish dedupe.");
    }


}

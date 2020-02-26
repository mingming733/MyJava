import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class ReadFile {
    public void replaceSlash() {
        File file = new File("AmexGsmfResponseFileDetail2Event.avsc");
        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader(file));
            String st;
            int count = 0;
            while ((st = br.readLine()) != null){
                if (st.contains("doc")) {
                    st = st.replace("_", " ");
                    count++;
                }
                System.out.println(st);
            }
            System.out.println(count);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void camelCase() {
        File file = new File("AmexGsmfResponseFileDetail2Event.avsc");
        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader(file));
            String st;
            while ((st = br.readLine()) != null){
                StringBuilder sb = new StringBuilder();
                if (st.contains("name")) {
                    char[] chars = st.toCharArray();
                    int index = 0;
                    while(index < st.length()) {
                        if(chars[index] == '_') {
                            sb.append(Character.toUpperCase(chars[index + 1]));
                            index++;
                        } else {
                            sb.append(chars[index]);
                        }
                        index++;
                    }
                } else {
                    sb = new StringBuilder(st);
                }
                System.out.println(sb.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void errorFlag() {
        File file = new File("AmexGsmfResponseFileDetailEvent.avsc");
        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader(file));
            String st;
            int count = 0;
            while ((st = br.readLine()) != null){
                System.out.println(st);
                if (st.contains("ErrorFlag")) {
                    System.out.println("      \"doc\": \"Participant will enter a space in this field on the incoming Sponsored Merchant file. In response to your file, American Express will pass back the original file and populate this specific field with a value of either a Y or N. If Y is populated, then the data record passed and will be updated. If N is populated, then the data record failed and will not be updated.\",");
                    br.readLine();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

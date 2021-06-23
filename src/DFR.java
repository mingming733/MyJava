import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;

public class DFR {

    public void scanDFR() throws Exception {
        File folder = new File("/Users/mingm/Downloads/DEVOPS-271100/decrypted");
        File[] listOfFiles = folder.listFiles();
        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                File dfrFile = new File("/Users/mingm/Downloads/DEVOPS-271100/decrypted/" + listOfFiles[i].getName());
//                File dfrFile = new File("/Users/mingm/Downloads/DEVOPS-271100/decrypted/3a9db0e1-1557-41d1-ae71-342529376f12.clear");
                BufferedReader br = new BufferedReader(new FileReader(dfrFile));
                String str = "";
                while ((str = br.readLine()) != null) {
                    if (str.contains("RPDE0017D")) {
//                String[] strArr = str.split(",");
//                for (int i = 0; i < strArr.length; i++) {
//                    if(strArr[i].equals("MC") || strArr[i].equals("VI")) {
//                        System.out.println(i + " " + str);
//                        if (i != 19) {
//                            System.out.println("not match");
//                        }
//                    }
                        System.out.println(str);

                    }

                }

            } else if (listOfFiles[i].isDirectory()) {
                System.out.println("Directory " + listOfFiles[i].getName());
            }
        }

    }
}

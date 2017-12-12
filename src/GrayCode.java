import java.util.ArrayList;
import java.util.List;

/**
 * Created by mming on 7/24/17.
 */
public class GrayCode {
    public List<Integer> grayCode(int n) {
        List<String> codes = new ArrayList<>();
        dfs(codes, "", n, true);
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < codes.size(); i++){
            String str = codes.get(i);
            int num = 0;
            for(int j = 0; j < str.length(); j++){
                num = (num << 1) + str.charAt(j) - '0';
            }
            result.add(num);
        }
        return result;
    }
    private void dfs(List<String> codes, String str, int n, boolean flag){
        if(str.length() == n){
            codes.add(str);
            return;
        }
        if(flag){
            for(int i = 0; i < 2; i++){
                str += i + "";
                if(i == 1){
                    flag = false;
                }else{
                    flag = true;
                }
                dfs(codes, str, n, flag);
                str = str.substring(0, str.length() - 1);
            }
        }else{
            for(int i = 1; i >= 0; i--){
                str += i + "";
                if(i == 0){
                    flag = false;
                }else{
                    flag = true;
                }
                dfs(codes, str, n, flag);
                str = str.substring(0, str.length() - 1);
            }
        }

    }
}
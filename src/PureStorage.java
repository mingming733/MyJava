import java.util.ArrayList;
import java.util.Stack;

public class PureStorage {

    public int computre_number_score(int number) {
        int score = 0;

        String strNum = "";
        //+4 if the entire number is a multiple of 3
        if (number % 3 == 0) {
            score += 4;
            System.out.println("adding 4 for a multiple of 3");
        }
        while (number > 0 ) {
            strNum = number % 10 + strNum;
            number /= 10;
        }
        int consecutive2 = 0;
        int max = 1;
        for (int i = 0; i < strNum.length(); i++) {
            // + 5 for every 7
            if (strNum.charAt(i) == '7') {
                score += 5;
                System.out.println("adding 5 for every 7");
            }
            // +6 for each pair of consecutive 2
            if (i != 0 && strNum.charAt(i -1) == strNum.charAt(i) && strNum.charAt(i) == ('0' + 2)) {
                score += 6;
                System.out.println("adding 6 for consecutive 2");
            }
            // N^2 points for descending sequence
            if (i != 0) {
                if (strNum.charAt(i - 1) - strNum.charAt(i) == 1) {
                    max++;
                }else{
                    score += max * max;
                    System.out.println("adding " + max * max + " for descending sequence");
                    max = 1;
                }
            }
            // +3 for each even digit (note that 0 is even)
            if ((strNum.charAt(i) - '0') % 2 == 0) {
                score += 3;
                System.out.println("adding 3 for even digit");
            }
        }
        score += max * max;
        System.out.println("adding " + max * max + " for descending sequence");
        return score;
    }
    public int lockUseAnalyzer(String[] events) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < events.length; i++) {
            String[] lock = events[i].split(" ");
            int lockNum = Integer.parseInt(lock[1]);
            if (lock[0].equals("ACQUIRE")) {
                if (stack.contains(lockNum)) {
                    return i + 1;
                } else {
                    stack.push(lockNum);
                }
            } else {
                if (stack.isEmpty() || stack.peek() != lockNum) {
                    return i + 1;
                } else {
                    stack.pop();
                }
            }
        }
        if (!stack.isEmpty()) {
            return events.length + 1;
        } else {
            return 0;
        }
    }
}

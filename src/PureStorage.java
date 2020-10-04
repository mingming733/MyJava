
import java.util.ArrayList;
import java.util.List;
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

    public List<List<TextBox>> arrangeTextBox(List<TextBox> textBoxes, int width) throws Exception{
        List<List<TextBox>> result = new ArrayList<>();
        int layer = 0;
        for (int i = 0; i < textBoxes.size(); i++) {
            int leftWidth = width;
            int line = 0;
            List<TextBox> row = new ArrayList<>();
            result.add(row);
            layer++;
            while (i < textBoxes.size() && leftWidth - textBoxes.get(i).width >= 0) {
                if (width < textBoxes.get(i).width) {
                    throw new IllegalArgumentException("TextBox too big.");
                } else {
                    TextBox textBox = textBoxes.get(i);
                    textBox.x = width - leftWidth;
                    textBox.y = getY(result, textBox.x, layer, textBox.width);
                    line = line > textBox.y + textBox.line ? line : textBox.y + textBox.line;
                    row.add(textBox);
                    leftWidth = leftWidth - textBox.width;
                    i++;
                }
            }
            i--;
            align(row, line);
        }
        return result;
    }
    static class TextBox {
        int x;
        int y;
        int line;
        int high;
        int width;
        public TextBox(int x, int y, int line, int high, int width) {
            this.x = x;
            this.y = y;
            this.line = line;
            this.high = high;
            this.width = width;
        }
    }
    private void align (List<TextBox> textBoxes, int line) {
        for (TextBox textBox : textBoxes) {
            textBox.y = line - textBox.line;
        }
    }
//    private int getY(List<List<TextBox>> result, int x, int layer) {
//        if (layer <= 1) {
//            return 0;
//        }
//        List<TextBox> lastLine = result.get(layer - 2);
//        int totalWidth = 0;
//        for(int i = 0; i < lastLine.size(); i++) {
//            totalWidth += lastLine.get(i).x;
//            if (totalWidth < x) {
//                continue;
//            } else if (totalWidth > x || i == result.size() - 1) {
//                return lastLine.get(i).y + lastLine.get(i).high;
//            } else {
//                return Math.max(lastLine.get(i).y + lastLine.get(i).high, lastLine.get(i).y + lastLine.get(i).high);
//            }
//        }
//        if (totalWidth < x) {
//            return getY(result, x, layer - 1);
//        }
//        return 0;
//    }

    public List<List<TextBox>> arrangeTextBox2(List<TextBox> textBoxes, int width){
        List<List<TextBox>> result = new ArrayList<>();
        int layer = 0;
        for (int i = 0; i < textBoxes.size(); i++) {
            int leftWidth = width;
            int line = 0;
            List<TextBox> row = new ArrayList<>();
            result.add(row);
            layer++;
            while (i < textBoxes.size() && leftWidth - textBoxes.get(i).width >= 0) {
                TextBox textBox = textBoxes.get(i);
                textBox.x = width - leftWidth;
                textBox.y = Math.max(getY(result, textBox.x, layer, textBox.width), getY(result, textBox.x + textBox.width, layer, textBox.width));
                line = line > textBox.y + textBox.line ? line : textBox.y + textBox.line;
                row.add(textBox);
                leftWidth -= textBox.width;
                i++;
            }
            i--;
            align(row, line);
        }
        return result;
    }

    private int getY(List<List<TextBox>> result, int x, int layer, int width) {
        if (layer <= 1) {
            return 0;
        }
        List<TextBox> lastLine = result.get(layer - 2);
        int totalWidth = 0;
        int y_start = 0;
        for(int i = 0; i < lastLine.size(); i++) {
            totalWidth += lastLine.get(i).x;
            if (totalWidth < x && totalWidth != 0) {
                continue;
            } else if ((totalWidth == 0 && x == 0 ) ||totalWidth > x && totalWidth <= x + width)  {
                y_start = Math.max(y_start, lastLine.get(i).y + lastLine.get(i).high);
            } else {
                return y_start;
            }
        }
        return y_start;
    }
}

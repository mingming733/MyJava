/**
 * Created by mming on 12/8/16.
 */
public class NumberToWord {
    static private String[] oneToNine = new String[]{"one","two", "three", "four", "five", "six", "seven", "eight", "nine"};
    static private String[] tenToNineteen = new String[]{"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen" };
    static private String[] tweentyToHundred = new String[]{"tweenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};

    public String toWord(int num){
        if(num == 0){
            return "";
        }
        if(num > 0 && num < 10){
            return oneToNine[num - 1];
        }
        if(num >= 10 && num <20){
            return tenToNineteen[num - 10];
        }
        if(num >= 20 && num < 100){
            return tweentyToHundred[num / 10 - 2] + toWord(num % 10);
        }
        if(num >= 100 && num < 1000){
            return oneToNine[num / 100 - 1] + " hundred and " + toWord(num % 100);
        }
        return "one thousand";
    }

}

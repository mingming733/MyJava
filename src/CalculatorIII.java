//import java.util.Stack;
//
///**
// * Created by mming on 11/16/17.
// */
//public class CalculatorIII {
//
////    public int calculator(String str){
////        Stack<Integer> nums = new Stack<>();
////        Stack<Character> operators = new Stack<>();
////        int num = 0;
////        for(int i = 0; i < str.length(); i++){
////            char c = str.charAt(i);
////            if(c >= '0' && c <= '9'){
////                num = num * 10 + c - '0';
////            }else if(isOps(c)){
////                char c2 = operators.isEmpty()? '%' : operators.peek();
////                if(isPrio(c, c2)){
////                    operators.push(c);
////                }else{
////                    while(!operators.isEmpty() && isPrio(c,operators.peek())){
////                        int num1 = nums.pop();
////                        int num2 = nums.pop();
////                        int result = ()
////                    }
////                }
////            }
////        }
////    }
//    private boolean isOps(char c){
//        String ops = "+-*/";
//        return ops.contains(Character.toString(c));
//    }
//    private boolean isPrio(char c1, char c2){
//        if(c1 == '*' || c1 == '/' || c2 == '%'){
//            return true;
//        }
//        if(c1 == '+' || c1 == '-'){
//            if(c2 == '+' || c2 == '-'){
//                return true;
//            }else{
//                return false;
//            }
//        }
//    }
//    private int cal(int num1, int num2, char op){
//        if(op == '+'){
//            return num1 + num2;
//        }else if(op == '-'){
//            return num1 - num2;
//        }else if(op == '*'){
//            return num1 * num2;
//        }else{
//            return num1 / num2;
//        }
//    }
//}

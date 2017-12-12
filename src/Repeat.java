/**
 * Created by mming on 5/10/17.
 */
public class Repeat {
    public Repeat(){

    }
    public void sortIntegers2(int[] arr) {
        int len = arr.length;
        int[]temp = new int[len];
        helper(0, len - 1, arr, temp);
    }
    public void helper(int start, int end, int[] arr, int[] temp){
        if(start >= end){
            return;
        }
        int mid = (start + end) / 2;
        helper(start, mid, arr, temp);
        helper(mid + 1, end, arr, temp);
        merge(start, mid, end, arr, temp);
    }

    public void merge(int start, int mid, int end, int[] arr, int[] temp){
        int leftStart = start;
        int rightStart = mid + 1;
        int pointer = start;
        while(leftStart <= mid || rightStart <= end){
            int leftNum = leftStart <= mid ? arr[leftStart] : Integer.MAX_VALUE;
            int rightNum = rightStart <= end ? arr[rightStart] : Integer.MAX_VALUE;
            if(leftNum <= rightNum){
                temp[pointer++] = leftNum;
                leftStart++;
            }else{
                temp[pointer++] = rightNum;
                rightStart++;
            }
        }
        for(int i = start; i <= end; i++){
            arr[i] = temp[i];
        }
    }


    public static void main(String [] args){
        Repeat rp = new Repeat();
        Myclass mc = new Myclass();
        int[] arr = new int[]{2,1,3,5,4};
//        mc.mergeSort(arr);
        rp.sortIntegers2(arr);
        System.out.print(arr);
    }
}

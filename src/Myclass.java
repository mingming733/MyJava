import java.util.*;


/**
 * Created by mming on 9/9/16.
 */
public class Myclass {

    public class findMedianFromDataStream{
        PriorityQueue<Integer> smaller = new PriorityQueue<>();
        PriorityQueue<Integer> larger = new PriorityQueue<>();
        public void add(int num){
            larger.offer(-num);
            smaller.offer(-larger.poll());
            if(larger.size() < smaller.size()){
                larger.offer(-smaller.poll());
            }
        }
        public double findMedian(){
            if(larger.size() > smaller.size()){
                return (double)larger.peek();
            }else{
                return ((double)smaller.peek() - (double)larger.peek()) / 2;
            }
        }
    }

    public void partitionArray(int[] arr, int pivot){
        int left = 0;
        int right = arr.length - 1;
        while(left < right){
            while(arr[left] < pivot && left < right){
                left++;
            }
            while(arr[right] > pivot && left < right){
                right--;
            }
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
        }
        return;
    }

    public int lastWord(String str){
        if(str == null || str.length() == 0){
            return 0;
        }
        str = str.trim();
        int count = 0;
        for(int i = str.length() - 1; i >= 0; i--){
            if(str.charAt(i) == 32){
                return count;
            }else{
                count++;
            }
        }
        return count;
    }

    public void quickSort(int[] nums){
        quickSortHelper(nums, 0, nums.length - 1);
    }

    public void quickSortHelper(int[] nums, int left, int right){
        if(left >= right){
            return;
        }
        int start = left;
        int end = right;
        int pivot = nums[(left + right) / 2];
        while(left <= right){
            while(left <= right && nums[right] > pivot){
                right--;
            }
            while(left <= right && nums[left] < pivot){
                left++;
            }
            if(left <= right){
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        }
        quickSortHelper(nums, start, right);
        quickSortHelper(nums, left, end);
        return;
    }

    public String resolveComflict(String str) {
        // Process input, get employee name
        String[] strs = str.split(",");
        String employeeName1 = strs[strs.length - 2];
        String employeeName2 = strs[strs.length - 1];
        // Get nmanagement relationship hashmap, put manager as key and employee as value
        HashMap<String, String> relationship = new HashMap<>();
        for (int i = 0; i < strs.length - 2; i++) {
            String[] mngerToEmp = strs[i].split("->");
            relationship.put(mngerToEmp[1], mngerToEmp[0]);
        }
        // Use linkedList to present all the managers upper than the concerning employee
        Stack<String> downToUp1 = buildDownToUp(employeeName1, relationship);
        Stack<String> downToUp2 = buildDownToUp(employeeName2, relationship);
        String commanManager = "";
        while(!downToUp1.isEmpty() && !downToUp2.isEmpty() && downToUp1.peek().equals(downToUp2.peek())){
            commanManager = downToUp1.peek();
            downToUp1.pop();
            downToUp2.pop();
        }
        return commanManager;
    }

    public Stack<String> buildDownToUp(String name, HashMap<String, String> relationship){
        Stack<String> downToUp = new Stack<>();
        downToUp.push(name);
        while (relationship.containsKey(name)){
            name = relationship.get(name);
            downToUp.push(name);
        }
        return downToUp;
    }


    public int[] generateArray(int length){
        int[] result = new int[length];
        for(int i = 0; i < length; i++){
            result[i] = (int)(Math.random() * 20);
        }
        return result;
    }
    public static void main(String [] args){
        Myclass mc = new Myclass();
        int[] arr = mc.generateArray(10);
        String s = "28, 29, 35, 37 ,34, 35, 36 14, 15, 30, 31";
        int[] arr1 = new int[]{28, 29, 35, 37 ,34, 35, 36, 14, 15, 30, 31};
        mc.quickSort(arr1);
        System.out.println(Arrays.toString(arr1));

    }

}

import com.sun.javaws.exceptions.InvalidArgumentException;
import com.sun.tools.corba.se.idl.InvalidArgument;
import com.sun.tools.internal.ws.wsdl.document.jaxws.Exception;

import java.util.ArrayList;

/**
 * Created by mming on 11/11/17.
 */
public class MyHeap {
    ArrayList<Integer> elements = new ArrayList<>();
    public void push(int num){
        elements.add(num);
        shiftUp(elements.size() - 1);
    }
    public Integer top() throws IllegalArgumentException{
        if(!isEmpty()){
            return elements.get(0);
        }else{
            return null;
        }
    }
    public int pop(){
        int result = top();
        elements.set(0, elements.get(size() - 1));
        elements.remove((size() - 1));
        shiftDown();
        return result;
    }
    public boolean isEmpty(){
        return elements.size() < 0;
    }
    public int size(){
        return elements.size();
    }
    private void shiftUp(int k){
        int father = (k - 1) / 2;
        while(k > 0){
            if(elements.get(father) > elements.get(k)){
                exchange(father, k);
                k = father;
            }else{
                break;
            }
        }
    }
    private void shiftDown(){
        int k = 0;
        while(k < (elements.size() - 1 ) / 2){
            int left = k * 2 + 1;
            int right = k * 2 + 2;
            if(elements.get(left) < elements.get(k)){
                exchange(left, k);
                k = left;
            }else if(elements.get(right) < elements.get(k)){
                exchange(right, k);
                k = right;
            }else{
                break;
            }
        }

    }
    private void exchange(int a, int b){
        int temp = elements.get(a);
        elements.set(a, elements.get(b));
        elements.set(b, temp);
    }

    public static void main(String[] args){
        MyHeap mh = new MyHeap();
        mh.push(3);
        mh.push(7);
        mh.push(0);
        mh.push(1);
        mh.push(8);
        System.out.print(mh.pop());
        System.out.print(mh.pop());
        System.out.print(mh.pop());
        System.out.print(mh.pop());

    }
}

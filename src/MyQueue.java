/**
 * Created by mming on 9/28/17.
 */
public class MyQueue<T> {
    QueueListNode head;
    QueueListNode tail;
    public MyQueue(){
    }
    public void add(T obj){
        if(head == null){
            head = new QueueListNode(obj);
            tail = head;
        }else{
            tail.next = new QueueListNode(obj);
            tail = tail.next;
        }
    }
    public T poll(){
        T result = null;
        if(!isEmpty()){
            result = (T)head;
            head = head.next;
        }
        return result;
    }
    public boolean isEmpty(){
        return head.next == null;
    }
}
class QueueListNode<T>{
    T obj;
    QueueListNode next;
    public QueueListNode(T obj){
        this.obj = obj;
    }

}
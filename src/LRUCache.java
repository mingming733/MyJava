import java.util.HashMap;

/**
 * Created by mming on 10/21/17.
 */
public class LRUCache {
    HashMap<Integer, Node> hashMap = new HashMap<>();
    Node head;
    Node tail;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if(!hashMap.containsKey(key)){
            return -1;
        }else{
            Node hit= hashMap.get(key);
            hit.prev.next = hit.next;
            hit.next.prev = hit.prev;
            moveToTail(hit);
            return hashMap.get(key).value;
        }
    }

    public void put(int key, int value) {
        Node newNode;
        if(hashMap.containsKey(key)){
            newNode = hashMap.get(key);
            newNode.value = value;
            newNode.prev.next = newNode.next;
            newNode.next.prev = newNode.prev;
        }else{
            if(hashMap.size() == capacity){
                hashMap.remove(head.next.key);
                Node temp = head.next.next;
                head.next = temp;
                temp.prev = head;
            }
            newNode = new Node(key, value);
            hashMap.put(key, newNode);
        }
        moveToTail(newNode);
    }

    private void moveToTail(Node newNode){
        Node pre = tail.prev;
        pre.next = newNode;
        newNode.prev = pre;
        newNode.next = tail;
        tail.prev = newNode;
    }


    class Node{
        Node prev;
        Node next;
        int key;
        int value;
        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
}


/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
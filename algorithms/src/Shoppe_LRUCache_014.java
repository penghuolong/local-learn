import java.util.HashMap;
import java.util.Map;

public class Shoppe_LRUCache_014 {
    private int capacity;
    private int size;
    private ListNode head;
    private ListNode tail;
    private Map<Integer, ListNode> map;
    public Shoppe_LRUCache_014(int capacity) {
        this.capacity = capacity;
        head = new ListNode();
        tail = new ListNode();
        head.next = tail;
        tail.pre = head;
        map = new HashMap<>();
    }

    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        ListNode listNode = map.get(key);
        remove(listNode);
        addHead(listNode);
        return listNode.value;
    }

    private void addHead(ListNode node) {
        ListNode next = head.next;
        head.next = node;
        node.pre = head;
        node.next = next;
        next.pre = node;
    }

    public void remove(ListNode node){
        ListNode pre = node.pre;
        ListNode next = node.next;
        pre.next = next;
        next.pre = pre;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            ListNode listNode = map.get(key);
            listNode.value = value;
            get(key);
        }else {
            if(size >= capacity){
                removeTail();
            }
            ListNode add = new ListNode(key, value);
            map.put(key, add);
            addHead(add);
            size++;
        }

    }

    private void removeTail() {
        ListNode pre1 = tail.pre;
        map.remove(pre1.key);
        ListNode pre = pre1.pre;
        pre.next = tail;
        tail.pre = pre;
        size--;
    }

    class ListNode{
        int key;
        int value;
        ListNode pre;
        ListNode next;

        public ListNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
        public ListNode() {
        }
    }
}

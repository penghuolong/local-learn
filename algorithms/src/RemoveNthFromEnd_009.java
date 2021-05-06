import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RemoveNthFromEnd_009 {

    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode start = head;
        Map<Integer, ListNode> map = new HashMap<>();
        calculate(start, map, n);
        ListNode next = map.getOrDefault(n-1, null);
        ListNode pre = map.getOrDefault(n+1, null);
        if(pre == null){
            return next;
        }else{
            pre.next = next;
        }
        return head;
    }

    private int calculate(ListNode start, Map<Integer, ListNode> map, int n) {
        if(start == null){
            return 0;
        }
        int val = calculate(start.next, map, n);
        int count = val+1;
        if((n-1)==count){
            map.put(n-1, start);
        }
        if(n==count){
            map.put(n,start);
        }
        if((n+1)==count){
            map.put(n+1, start);
        }

        return val+1;
    }
}

import java.util.LinkedList;
import java.util.Queue;

/**
 * 445. 两数相加 II
 * 给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 *
 *
 *
 * 进阶：
 *
 * 如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。
 *
 *
 *
 * 示例：
 *
 * 输入：(7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 8 -> 0 -> 7
 * 通过次数69,541提交次数119,186
 */
public class Shoppe_Add_Two_Numbers_022 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Queue<Integer> queue = new LinkedList<>();
        reverse(l1,queue);
        reverse(l2,queue);
        ListNode head = null;
        ListNode pre = null;
        int temp = 0;
        while (l1!=null||l2!=null||temp>0){
            int first = 0;
            if(l1 != null){
                first = l1.val;
                l1=l1.next;
            }
            int second = 0;
            if(l2!=null){
                second = l2.val;
                l2=l2.next;
            }
            int sum = first+second+temp;
            int val = sum%10;
            temp = sum/10;
            ListNode node = new ListNode(val);
            if(head == null){
                head = node;
                pre = node;
            }else {
                pre.next = node;
                pre = node;
            }
        }
        reverse(head, queue);
        return head;
    }



    public void reverse(ListNode node, Queue<Integer> queue){
       if(node == null){
           return;
       }
       queue.add(node.val);
       reverse(node.next, queue);
       Integer poll = queue.poll();
       node.val=poll;
    }
}

import java.util.Deque;
import java.util.LinkedList;

/**
 * 143. 重排链表
 * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 * 示例 1:
 * <p>
 * 给定链表 1->2->3->4, 重新排列为 1->4->2->3.
 * 示例 2:
 * <p>
 * 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
 */
public class BitDance_ReorderList_002 {
    public void reorderList(ListNode head) {
        Deque<ListNode> deque = new LinkedList<>();
        ListNode temp = head;
        while (temp != null) {
            ListNode node = temp.next;
            temp.next = null;
            deque.addLast(temp);
            temp = node;
        }
        ListNode p = new ListNode();
        ListNode pre = p;
        int i = 1;
        while (!deque.isEmpty()) {
            if (i % 2 == 1) {
                ListNode node = deque.pollFirst();
                pre.next = node;
                pre = node;
                i++;
            } else {
                ListNode node = deque.pollLast();
                pre.next = node;
                pre = node;
                i++;
            }

        }

    }


}

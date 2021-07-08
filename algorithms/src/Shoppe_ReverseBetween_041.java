import java.util.LinkedList;
import java.util.Queue;

/**
 * 92. 反转链表 II
 * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [1,2,3,4,5], left = 2, right = 4
 * 输出：[1,4,3,2,5]
 * 示例 2：
 * <p>
 * 输入：head = [5], left = 1, right = 1
 * 输出：[5]
 */
public class Shoppe_ReverseBetween_041 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        Queue<Integer> queue = new LinkedList<>();
        reverse(head, left, right, 1, queue);
        return head;
    }

    private void reverse(ListNode node, int left, int right, int len, Queue<Integer> queue) {
        if (node == null) {
            return;
        }
        if (len < left) {
            reverse(node.next, left, right, len + 1, queue);
        } else if (len <= right) {
            queue.offer(node.val);
            reverse(node.next, left, right, len + 1, queue);
            node.val = queue.poll();
        }

    }
}

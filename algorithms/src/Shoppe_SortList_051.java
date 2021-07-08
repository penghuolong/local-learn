/**
 * 148. 排序链表
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 * <p>
 * 进阶：
 * <p>
 * 你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [4,2,1,3]
 * 输出：[1,2,3,4]
 * 示例 2：
 * <p>
 * <p>
 * 输入：head = [-1,5,3,4,0]
 * 输出：[-1,0,3,4,5]
 * 示例 3：
 * <p>
 * 输入：head = []
 * 输出：[]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 链表中节点的数目在范围 [0, 5 * 104] 内
 * -105 <= Node.val <= 105
 */
public class Shoppe_SortList_051 {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow.next;
        slow.next = null;
        ListNode first = sortList(head);
        ListNode second = sortList(mid);
        // 合并
        ListNode result = new ListNode(0);
        ListNode temp = result;
        while (first != null || second != null) {
            if (first == null) {
                temp.next = second;
                temp = second;
                second = second.next;
            } else if (second == null) {
                temp.next = first;
                temp = first;
                first = first.next;
            } else if (first.val < second.val) {
                temp.next = first;
                temp = first;
                first = first.next;
            } else {
                temp.next = second;
                temp = second;
                second = second.next;
            }
        }
        return result.next;
    }
}

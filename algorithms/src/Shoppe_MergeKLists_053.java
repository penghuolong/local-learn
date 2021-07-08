import java.util.Arrays;

/**
 * 23. 合并K个升序链表
 * 给你一个链表数组，每个链表都已经按升序排列。
 * <p>
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 * 示例 2：
 * <p>
 * 输入：lists = []
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：lists = [[]]
 * 输出：[]
 * <p>
 * <p>
 * 提示：
 * <p>
 * k == lists.length
 * 0 <= k <= 10^4
 * 0 <= lists[i].length <= 500
 * -10^4 <= lists[i][j] <= 10^4
 * lists[i] 按 升序 排列
 * lists[i].length 的总和不超过 10^4
 */
public class Shoppe_MergeKLists_053 {
    public ListNode mergeKLists(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);

    }

    private ListNode merge(ListNode[] lists, int left, int right) {
        if (left == right) {
            return lists[left];
        }
        if (left > right) {
            return null;
        }
        int mid = left + (right - left) / 2;
        ListNode lef = merge(lists, left, mid);
        ListNode rig = merge(lists, mid + 1, right);
        ListNode head = new ListNode(0);
        ListNode pre = head;
        while (lef != null || rig != null) {
            if (lef == null) {
                pre.next = rig;
                pre = rig;
                rig = rig.next;
            } else if (rig == null) {
                pre.next = lef;
                pre = lef;
                lef = lef.next;
            } else if (lef.val <= rig.val) {
                pre.next = lef;
                pre = lef;
                lef = lef.next;
            } else {
                pre.next = rig;
                pre = rig;
                rig = rig.next;
            }
        }
        return head.next;
    }

}

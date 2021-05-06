/**
 * 面试题 02.05. 链表求和
 * 给定两个用链表表示的整数，每个节点包含一个数位。
 *
 * 这些数位是反向存放的，也就是个位排在链表首部。
 *
 * 编写函数对这两个整数求和，并用链表形式返回结果。
 *
 *
 *
 * 示例：
 *
 * 输入：(7 -> 1 -> 6) + (5 -> 9 -> 2)，即617 + 295
 * 输出：2 -> 1 -> 9，即912
 * 进阶：思考一下，假设这些数位是正向存放的，又该如何解决呢?
 *
 * 示例：
 *
 * 输入：(6 -> 1 -> 7) + (2 -> 9 -> 5)，即617 + 295
 * 输出：9 -> 1 -> 2，即912
 */
public class Shoppe_Add_Two_Numbers_021 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
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
        return head;
    }
}

/**
 * 234. 回文链表
 * 请判断一个链表是否为回文链表。
 *
 * 示例 1:
 *
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 *
 * 输入: 1->2->2->1
 * 输出: true
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 */
public class Shoppe_Is_Palindrome_030 {
    ListNode pre;
    public boolean isPalindrome(ListNode head) {
//        if(head == null){
//            return false;
//        }
//        StringBuilder s = new StringBuilder();
//        while (head!=null){
//            s.append(head.val);
//            head=head.next;
//        }
//        String s1 = s.toString();
//        int left = 0;
//        int right = s1.length()-1;
//        while (left<right){
//            if(s1.charAt(left)!=s1.charAt(right)){
//                return false;
//            }
//            left++;
//            right--;
//        }
//        return true;
         pre = head;
        return calculate(head);
    }

    private boolean calculate(ListNode node) {
        if(node!=null){
            boolean calculate = calculate(node.next);
            if(!calculate){
                return false;
            }
//            if(pre == node){
//                return true;
//            }
            if(pre.val != node.val){
                return false;
            }
            pre = pre.next;
        }

        return true;
    }
}

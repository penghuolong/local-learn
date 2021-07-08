import java.util.HashMap;
import java.util.Map;

/**
 * 560. 和为K的子数组
 * 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
 *
 * 示例 1 :
 *
 * 输入:nums = [1,1,1], k = 2
 * 输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
 * 说明 :
 *
 * 数组的长度为 [1, 20,000]。
 * 数组中元素的范围是 [-1000, 1000] ，且整数 k 的范围是 [-1e7, 1e7]。
 */
public class Shoppe_SubarraySum_040 {
    public int subarraySum(int[] nums, int k) {
        int[] sum = new int[nums.length+1];
        int sumV = 0;
        sum[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            sum[i+1]=nums[i]+sum[i];
        }
        int result = 0;
        for (int i = 0; i < sum.length-1; i++) {
            int j = sum.length-1;
            while (i<j){
                if(sum[j]-sum[i]<k){
                    break;
                }
                if(sum[j]-sum[i]==k){
                    result++;
                }
                j--;
            }
        }
        return result;
    }
    public ListNode detectCycle(ListNode head) {
        Map<ListNode, Integer> map = new HashMap<>();
        int index = 0;
        while(head != null){
            if(!map.containsKey(head)){
                map.put(head, index);
                index++;
                head = head.next;
            }else {
                return head;
            }

        }
        return null;

    }

}

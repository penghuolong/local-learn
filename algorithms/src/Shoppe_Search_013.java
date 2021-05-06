import java.util.List;

/**
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [-1,0,3,5,9,12], target = 9
 * 输出: 4
 * 解释: 9 出现在 nums 中并且下标为 4
 * 示例 2:
 * <p>
 * 输入: nums = [-1,0,3,5,9,12], target = 2
 * 输出: -1
 * 解释: 2 不存在 nums 中因此返回 -1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-search
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Shoppe_Search_013 {
    public int search(int[] nums, int target) {
        return find(0, nums.length - 1, nums, target);
    }

    private int find(int left, int right, int[] nums, int target) {
        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        if (nums[mid] == target) {
            return mid;
        }
        if (nums[mid] < target) {
            return find(mid + 1, right, nums, target);
        } else {
            return find(left, mid - 1, nums, target);
        }
    }

//    public List<List<Integer>> permute(int[] nums) {
//        int len = nums.length;
//        int result = 1;
//        for (int i = 1; i <= len; i++) {
//            result *= i;
//        }
//        return result;
//    }

}

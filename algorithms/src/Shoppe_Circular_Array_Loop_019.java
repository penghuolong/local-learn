import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 457. 环形数组是否存在循环
 * 存在一个不含 0 的 环形 数组 nums ，每个 nums[i] 都表示位于下标 i 的角色应该向前或向后移动的下标个数：
 * <p>
 * 如果 nums[i] 是正数，向前 移动 nums[i] 步
 * 如果 nums[i] 是负数，向后 移动 nums[i] 步
 * 因为数组是 环形 的，所以可以假设从最后一个元素向前移动一步会到达第一个元素，而第一个元素向后移动一步会到达最后一个元素。
 * <p>
 * 数组中的 循环 由长度为 k 的下标序列 seq ：
 * <p>
 * 遵循上述移动规则将导致重复下标序列 seq[0] -> seq[1] -> ... -> seq[k - 1] -> seq[0] -> ...
 * 所有 nums[seq[j]] 应当不是 全正 就是 全负
 * k > 1
 * 如果 nums 中存在循环，返回 true ；否则，返回 false 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,-1,1,2,2]
 * 输出：true
 * 解释：存在循环，按下标 0 -> 2 -> 3 -> 0 。循环长度为 3 。
 * 示例 2：
 * <p>
 * 输入：nums = [-1,2]
 * 输出：false
 * 解释：按下标 1 -> 1 -> 1 ... 的运动无法构成循环，因为循环的长度为 1 。根据定义，循环的长度必须大于 1 。
 * 示例 3:
 * <p>
 * 输入：nums = [-2,1,-1,-2,-2]
 * 输出：false
 * 解释：按下标 1 -> 2 -> 1 -> ... 的运动无法构成循环，因为 nums[1] 是正数，而 nums[2] 是负数。
 * 所有 nums[seq[j]] 应当不是全正就是全负。
 */
public class Shoppe_Circular_Array_Loop_019 {

    public boolean circularArrayLoop(int[] nums) {
        Set<Integer> set = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        int len = nums.length;
        for (int i = 0; i < nums.length; i++) {
            int flag = nums[i]>0?1:-1;
            boolean flag1 = true;
            int next = i;
            do {
                set.add(next);
                queue.offer(next);
                next = (format(next + nums[next], len)) % len;
                if (flag * nums[next] < 0) {
                    flag1 = false;
                    break;
                }
            } while (!set.contains(next));
            if (flag1 && set.size() > 1 && queue.element() == next) {
                return true;
            }
            queue.clear();
            set.clear();
        }
        return false;
    }

    public Integer format(int value, int len) {
        if (value < 0) {
            int temp = -value;
            int k = temp / len + 1;
            value = k * len + value;
        }
        return value;

    }
}

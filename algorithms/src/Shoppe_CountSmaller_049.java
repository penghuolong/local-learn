import java.util.ArrayList;
import java.util.List;

/**
 * 315. 计算右侧小于当前元素的个数
 * 给定一个整数数组 nums，按要求返回一个新数组 counts。数组 counts 有该性质： counts[i] 的值是  nums[i] 右侧小于 nums[i] 的元素的数量。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：nums = [5,2,6,1]
 * 输出：[2,1,1,0]
 * 解释：
 * 5 的右侧有 2 个更小的元素 (2 和 1)
 * 2 的右侧仅有 1 个更小的元素 (1)
 * 6 的右侧有 1 个更小的元素 (1)
 * 1 的右侧有 0 个更小的元素
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= nums.length <= 10^5
 * -10^4 <= nums[i] <= 10^4
 */
public class Shoppe_CountSmaller_049 {
    public List<Integer> countSmaller(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        int[] temp = new int[len];
        int[] index = new int[len];
        for (int i = 0; i < len; i++) {
            index[i] = i;
        }
        partation(nums, 0, len - 1, temp, index, res);
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < res.length; i++) {
            result.add(res[i]);
        }
        return result;
    }

    private void partation(int[] nums, int left, int right, int[] temp, int[] index, int[] res) {
        if (left == right) {
            return;
        }
        int mid = left + (right - left) / 2;
        partation(nums, left, mid, temp, index, res);
        partation(nums, mid + 1, right, temp, index, res);
        if (nums[index[mid]] <= nums[index[mid + 1]]) {
            return;
        }
        calculate(nums, left, mid, right, temp, index, res);
    }

    private void calculate(int[] nums, int left, int mid, int right, int[] temp, int[] index, int[] res) {
        for (int i = left; i <= right; i++) {
            temp[i] = index[i];
        }
        int first = left;
        int second = mid + 1;
        for (int k = left; k <= right; k++) {
            if (first > mid) {
                index[k] = temp[second];
                second++;
            } else if (second > right) {
                index[k] = temp[first];
                first++;
                res[index[k]] +=(right - mid);
            } else if (nums[temp[first]] <= nums[temp[second]]) {
                index[k] = temp[first];
                first++;
                res[index[k]] += (second - mid - 1);
            } else {
                index[k] = temp[second];
                second++;
            }
        }
    }
}

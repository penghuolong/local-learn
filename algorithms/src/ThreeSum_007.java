import java.util.ArrayList;
import java.util.List;

public class ThreeSum_007 {
    public List<List<Integer>> threeSum(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int target = -nums[i];
            int k = nums.length - 1;
            for (int j = i + 1; j < nums.length; j++) {
                if ((j > (i + 1)) && nums[j] == nums[j - 1]) {
                    continue;
                }
                while (j < k && ((nums[k] + nums[j]) > target)) {
                    k--;
                }
                if (j == k) {
                    break;
                }
                if ((nums[k] + nums[j]) == target) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    result.add(list);
                }
            }
        }
        return result;
    }

    private void quickSort(int[] nums, int left, int right) {
        if (left < right) {
            int index = partation(nums, left, right);
            quickSort(nums, left, index - 1);
            quickSort(nums, index + 1, right);
        }
    }

    private int partation(int[] nums, int left, int right) {
        int value = nums[right];
        while (left < right) {
            while (nums[left] < value && left < right) {
                left++;
            }
            nums[right] = nums[left];
            while (nums[right] >= value && left < right) {
                right--;
            }
            nums[left] = nums[right];
        }
        nums[left] = value;
        return left;
    }

}

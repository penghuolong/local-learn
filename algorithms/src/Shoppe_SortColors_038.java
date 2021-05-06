/**
 * 75. 颜色分类
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 *
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [2,0,2,1,1,0]
 * 输出：[0,0,1,1,2,2]
 * 示例 2：
 *
 * 输入：nums = [2,0,1]
 * 输出：[0,1,2]
 * 示例 3：
 *
 * 输入：nums = [0]
 * 输出：[0]
 * 示例 4：
 *
 * 输入：nums = [1]
 * 输出：[1]
 */
public class Shoppe_SortColors_038 {
    public void sortColors(int[] nums) {
        quickSort(nums, 0 ,nums.length-1);

    }

    private void quickSort(int[] nums, int left, int right) {
        int index = partation(nums, left, right);
        quickSort(nums, left, index-1);
        quickSort(nums, index+1, right);
    }

    private int partation(int[] nums, int left, int right) {
        int val = nums[right];
        while (left<right){
            while (left<right &&nums[left]<=val){
                left++;
            }
            nums[right]=nums[left];
            while (left<right &&nums[right]>=val){
                right--;
            }
            nums[left]=nums[right];
        }
        return left;
    }
}

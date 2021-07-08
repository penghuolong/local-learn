/**
 * 1262. 可被三整除的最大和
 * 给你一个整数数组 nums，请你找出并返回能被三整除的元素最大和。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [3,6,5,1,8]
 * 输出：18
 * 解释：选出数字 3, 6, 1 和 8，它们的和是 18（可被 3 整除的最大和）。
 * 示例 2：
 * <p>
 * 输入：nums = [4]
 * 输出：0
 * 解释：4 不能被 3 整除，所以无法选出数字，返回 0。
 * 示例 3：
 * <p>
 * 输入：nums = [1,2,3,4,4]
 * 输出：12
 * 解释：选出数字 1, 3, 4 以及 4，它们的和是 12（可被 3 整除的最大和）。
 */
public class Shoppe_MaxSumDivThree_043 {
    public int maxSumDivThree(int[] nums) {
        int[] status = new int[3];
        for (int i = 0; i < nums.length; i++) {
            int v1 = 0, v2 = 0, v3 = 0;
            if (nums[i] % 3 == 0) {
                v1 = status[0] + nums[i];
                if (status[1] != 0) {
                    v2 = status[1] + nums[i];
                }
                if (status[2] != 0) {
                    v3 = status[2] + nums[i];
                }

            } else if (nums[i] % 3 == 1) {
                if (status[2] != 0) {
                    v1 = Math.max((status[2] + nums[i]), status[0]);
                } else {
                    v1 = status[0];
                }
                v2 = Math.max((status[0] + nums[i]), status[1]);
                if (status[1] != 0) {
                    v3 = Math.max(status[1] + nums[i], status[2]);
                } else {
                    v3 = status[2];
                }
            } else {
                if (status[1] != 0) {
                    v1 = Math.max((status[1] + nums[i]), status[0]);
                } else {
                    v1 = status[0];
                }
                if (status[2] != 0) {
                    v2 = Math.max((status[2] + nums[i]), status[1]);
                } else {
                    v2 = status[1];
                }
                v3 = Math.max((status[0] + nums[i]), status[2]);
            }
            status[0] = v1;
            status[1] = v2;
            status[2] = v3;
        }
        return status[0];
    }
}

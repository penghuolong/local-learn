import java.util.*;

/**
 * 494. 目标和
 * 给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号 + 和 -。对于数组中的任意一个整数，你都可以从 + 或 -中选择一个符号添加在前面。
 * <p>
 * 返回可以使最终数组和为目标数 S 的所有添加符号的方法数。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：nums: [1, 1, 1, 1, 1], S: 3
 * 输出：5
 * 解释：
 * <p>
 * -1+1+1+1+1 = 3
 * +1-1+1+1+1 = 3
 * +1+1-1+1+1 = 3
 * +1+1+1-1+1 = 3
 * +1+1+1+1-1 = 3
 * <p>
 * 一共有5种方法让最终目标和为3。
 *
 * 提示：
 *
 * 数组非空，且长度不会超过 20 。
 * 初始的数组的和不会超过 1000 。
 * 保证返回的最终结果能被 32 位整数存下。
 */
public class Shoppe_FindTargetSumWays_047 {
    public int findTargetSumWays(int[] nums, int target) {
        int[][] temp = new int[nums.length][2001];
        temp[0][nums[0] + 1000] = 1;
        // 易错点
        temp[0][1000 - nums[0]] += 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j <= 2000; j++) {
                if (temp[i - 1][j] > 0) {
                    temp[i][j + nums[i]] += temp[i - 1][j];
                    temp[i][j - nums[i]] += temp[i - 1][j];
                }
            }
        }
        return temp[nums.length - 1][target];
    }
}

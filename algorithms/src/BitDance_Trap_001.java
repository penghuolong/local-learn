/**
 * 42. 接雨水
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 * 示例 2：
 * <p>
 * 输入：height = [4,2,0,3,2,5]
 * 输出：9
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == height.length
 * 0 <= n <= 3 * 104
 * 0 <= height[i] <= 105
 */
public class BitDance_Trap_001 {
    public int trap(int[] height) {
        int len = height.length;
        int indexL = 0;
        int indexR = len - 1;
        int maxLeft = 0;
        int maxRight = 0;
        int res = 0;
        while (indexL < indexR) {
            if (height[indexL] <= height[indexR]) {
                if (height[indexL] > maxLeft) {
                    maxLeft = height[indexL];
                }
                res += maxLeft - height[indexL];
                indexL++;
            } else {
                if (height[indexR] > maxRight) {
                    maxRight = height[indexR];
                }
                res += maxRight - height[indexR];
                indexR--;
            }
        }
        return res;
    }
}

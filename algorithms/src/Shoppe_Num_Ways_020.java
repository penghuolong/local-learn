/**
 * 276. 栅栏涂色
 * 有 k 种颜色的涂料和一个包含 n 个栅栏柱的栅栏，请你按下述规则为栅栏设计涂色方案：
 * <p>
 * 每个栅栏柱可以用其中 一种 颜色进行上色。
 * 相邻的栅栏柱 最多连续两个 颜色相同。
 * 给你两个整数 k 和 n ，返回所有有效的涂色 方案数 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：n = 3, k = 2
 * 输出：6
 * 解释：所有的可能涂色方案如上图所示。注意，全涂红或者全涂绿的方案属于无效方案，因为相邻的栅栏柱 最多连续两个 颜色相同。
 * 示例 2：
 * <p>
 * 输入：n = 1, k = 1
 * 输出：1
 * 示例 3：
 * <p>
 * 输入：n = 7, k = 2
 * 输出：42
 */
// f(x)=n*(f(x-1)*(n-1)+f(x-2)*(n-1))
public class Shoppe_Num_Ways_020 {
    public int numWays(int n, int k) {
//        int pre = 0;
//        int now = 1;
//        int next = 0;
//        boolean first = true;
//        for (int i = 0; i < n; i++) {
//            if (first) {
//                next = (pre + now) * k;
//                first = false;
//            } else {
//                next = (pre + now) * (k - 1);
//            }
//            pre = now;
//            now = next;
//        }
//        return (k - 1) * now;
        int[] temp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                temp[i] = k;
            } else if (i == 2) {
                temp[i] = k * k;
            } else {
                temp[i] = (k - 1) * (temp[i - 1] + temp[i - 2]);
            }
        }
        return temp[n];
    }
}

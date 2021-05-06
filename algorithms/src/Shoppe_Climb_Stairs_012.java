/**
 * 70. 爬楼梯
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * <p>
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * <p>
 * 注意：给定 n 是一个正整数。
 * <p>
 * 示例 1：
 * <p>
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 示例 2：
 * <p>
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 */
// 假定 f(n)代表n阶楼梯有多少种方式，那么第一步只能跨过 1或2阶 那么有 f(n)=f(n-1)+f(n-2)
public class Shoppe_Climb_Stairs_012 {

    public int climbStairs(int n) {
        // 递归超出时间限制
//        if (n == 0) {
//            return 0;
//        }
//        if (n == 1) {
//            return 1;
//        }
//        return climbStairs(n - 1) + climbStairs(n - 2);
        int first,second=0;
        int result = 1;
        for (int i = 1; i <= n; i++) {
             first = second;
             second = result;
             result = first + second;
        }
        return result;
    }
}

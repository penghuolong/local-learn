/**
 * 322. 零钱兑换
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 *
 * 你可以认为每种硬币的数量是无限的。
 *
 *
 *
 * 示例 1：
 *
 * 输入：coins = [1, 2, 5], amount = 11
 * 输出：3
 * 解释：11 = 5 + 5 + 1
 * 示例 2：
 *
 * 输入：coins = [2], amount = 3
 * 输出：-1
 * 示例 3：
 *
 * 输入：coins = [1], amount = 0
 * 输出：0
 * 示例 4：
 *
 * 输入：coins = [1], amount = 1
 * 输出：1
 * 示例 5：
 *
 * 输入：coins = [1], amount = 2
 * 输出：2
 *
 */
public class Shoppe_Coin_Change_023 {
    public int coinChange(int[] coins, int amount) {
        if(amount < 1){
            return 0;
        }
        int[] temp = new int[amount];
        return calculate(coins, amount, temp);

    }

    private int calculate(int[] coins, int amount, int[] temp) {
        if(amount < 0){
            return -1;
        }
        if(amount == 0){
            return 0;
        }
        if(temp[amount-1]!=0){
            return temp[amount-1];
        }
        Integer mix = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int calculate = calculate(coins, amount - coins[i], temp);
            if(calculate != -1 && (calculate+1)<mix){
                mix = calculate+1;
            }
        }
        temp[amount-1]=mix==Integer.MAX_VALUE?-1:mix;
        return temp[amount-1];
    }
}

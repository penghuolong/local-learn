/**
 * 剑指 Offer 43. 1～n 整数中 1 出现的次数
 * 输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数。
 * <p>
 * 例如，输入12，1～12这些整数中包含1 的数字有1、10、11和12，1一共出现了5次。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 12
 * 输出：5
 * 示例 2：
 * <p>
 * 输入：n = 13
 * 输出：6
 */
public class Shoppe_CountDigitOne_054 {
    public int countDigitOne(int n) {
        int result = 0;
        int m = n / 10;
        int k = n % 10;
        int cusr = 1;
        int low =0;
        while (k != 0 || m != 0) {
            int temp = m;
            if (k == 0) {
                result += (m * cusr);
            } else if (k == 1) {
                result += (m * cusr) + low + 1;
            } else {
                result += (m + 1) * cusr;
            }
            low+=cusr*k;
            m = temp / 10;
            k = temp % 10;
            cusr *= 10;
        }
        return result;
    }
}


import java.util.*;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 给你一个正整数 n ，请你找出符合条件的最小整数，其由重新排列 n 中存在的每位数字组成，并且其值大于 n 。如果不存在这样的正整数，则返回 -1 。
 * <p>
 * 注意 ，返回的整数应当是一个 32 位整数 ，如果存在满足题意的答案，但不是 32 位整数 ，同样返回 -1 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 12
 * 输出：21
 * 示例 2：
 * <p>
 * 输入：n = 21
 * 输出：-1
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 231 - 1
 */
public class Shoppe_MavValue_057 {
    public static void main(String[] args) {
//        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor();
    }
    public int nextGreaterElement(int n) {
        String s = String.valueOf(n);
        char[] chars = s.toCharArray();
        boolean flag = false;
        for (int i = chars.length - 1; i >= 1; i--) {
            for (int j = i - 1; j >= 0; j--) {
                if (chars[i] > chars[j]) {
                    char temp = chars[i];
                    chars[i] = chars[j];
                    chars[j] = temp;
                    flag = true;
                    break;
                }
            }
            if (flag) {
                break;
            }
        }
        String s1 = String.valueOf(chars);
        Long value = Long.valueOf(s1);
        if (value > Integer.MAX_VALUE || value == n) {
            return -1;
        }
        return Integer.valueOf(s1);
    }


}

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 402. 移掉K位数字
 * 给定一个以字符串表示的非负整数 num，移除这个数中的 k 位数字，使得剩下的数字最小。
 * <p>
 * 注意:
 * <p>
 * num 的长度小于 10002 且 ≥ k。
 * num 不会包含任何前导零。
 * 示例 1 :
 * <p>
 * 输入: num = "1432219", k = 3
 * 输出: "1219"
 * 解释: 移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219。
 * 示例 2 :
 * <p>
 * 输入: num = "10200", k = 1
 * 输出: "200"
 * 解释: 移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。
 * 示例 3 :
 * <p>
 * 输入: num = "10", k = 2
 * 输出: "0"
 * 解释: 从原数字移除所有的数字，剩余为空就是0。
 */
public class Shoppe_RemoveKdigits_055 {
    public String removeKdigits(String num, int k) {
        char[] chars = num.toCharArray();
        Deque<Character> deque = new LinkedList<>();
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            while (!deque.isEmpty() && deque.peekLast() > aChar && k > 0) {
                deque.pollLast();
                k--;
            }
            deque.add(aChar);
        }
        while (k > 0) {
            deque.pollLast();
            k--;
        }
        if (deque.isEmpty()) {
            return "0";
        }
        StringBuilder builder = new StringBuilder();
        boolean leadZero = true;
        while (!deque.isEmpty()) {
            Character pop = deque.pollFirst();
            if (leadZero && pop == '0') {
                continue;
            }
            leadZero = false;
            builder.append(pop);
        }
        String s = builder.toString();
        if (s.isEmpty()) {
            return "0";
        }
        return s;
    }
}

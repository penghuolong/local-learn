import java.util.HashSet;

/**
 * 剑指 Offer 48. 最长不含重复字符的子字符串
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * <p>
 * <p>
 * 提示：
 * <p>
 * s.length <= 40000
 */
public class BitDance_LengthOfLongestSubstring_004 {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int length = s.length();
        HashSet<Character> set = new HashSet<>();
        for (int i = 0, j = i; i < length; i++) {
            while (i < length && !set.contains(s.charAt(i))) {
                set.add(s.charAt(i));
                i++;
            }
            int size = set.size();
            if (max < size) {
                max = size;
            }
            if (i == length) {
                break;
            }
            while (j < i && s.charAt(j) != s.charAt(i)) {
                set.remove(s.charAt(j));
                j++;
            }
            j++;
        }
        return max;
    }
}

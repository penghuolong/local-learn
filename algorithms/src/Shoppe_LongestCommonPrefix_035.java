/**
 * 14. 最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 * 示例 2：
 * <p>
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 */
public class Shoppe_LongestCommonPrefix_035 {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length < 2) {
            return "";
        }
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            prefix = calculate(strs[i], prefix);
        }
        return prefix;
    }

    private String calculate(String str, String prefix) {
        int length = str.length();
        int i;
        for (i = 0; i < prefix.length(); i++) {
            if (i < length && str.charAt(i) == prefix.charAt(i)) {
                continue;
            } else {
                break;
            }
        }
        return prefix.substring(0, i);
    }
}

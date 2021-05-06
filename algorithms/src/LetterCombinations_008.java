import java.util.*;

/**
 * 17. 电话号码的字母组合
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * <p>
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * 示例 2：
 * <p>
 * 输入：digits = ""
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：digits = "2"
 * 输出：["a","b","c"]
 */
public class LetterCombinations_008 {
    public List<String> letterCombinations(String digits) {
        if(digits.isEmpty()){
            return Collections.emptyList();
        }
        List<String> result = new ArrayList<>();

        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        StringBuffer buffer = new StringBuffer();
        calculate(result, 0, buffer, phoneMap, digits);
        return result;
    }

    private void calculate(List<String> result, int i, StringBuffer buffer, Map<Character, String> phoneMap, String digits) {
        char[] chars = digits.toCharArray();
        if (i == chars.length) {
            result.add(buffer.toString());
            return;
        }
        Character c = chars[i];
        String s = phoneMap.get(c);
        char[] chars1 = s.toCharArray();
        for (int i1 = 0; i1 < chars1.length; i1++) {
            buffer.append(chars1[i1]);
            calculate(result, i + 1, buffer, phoneMap, digits);
            buffer.deleteCharAt(i);
        }
    }
}

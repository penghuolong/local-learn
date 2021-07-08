import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 394. 字符串解码
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 * <p>
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 * <p>
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 * <p>
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "3[a]2[bc]"
 * 输出："aaabcbc"
 * 示例 2：
 * <p>
 * 输入：s = "3[a2[c]]"
 * 输出："accaccacc"
 * 示例 3：
 * <p>
 * 输入：s = "2[abc]3[cd]ef"
 * 输出："abcabccdcdcdef"
 * 示例 4：
 * <p>
 * 输入：s = "abc3[cd]xyz"
 * 输出："abccdcdcdxyz"
 */
public class Shoppe_DecodeString_045 {
    int i=0;
    public String decodeString(String s) {
        LinkedList<String> str = new LinkedList<>();
        while (i<s.length()){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                String digit = getDigit(s);
                str.addLast(digit);
            }else if(Character.isLetter(c) || c=='['){
                str.addLast(String.valueOf(s.charAt(i++)));
            }else {
                i++;
                LinkedList<String> str1 = new LinkedList<>();
                while (!"[".equals(str.peekLast())){
                    str1.add(str.removeLast());
                }
                str.removeLast();
                Collections.reverse(str1);
                String string = getStr1(str1);
                int temp = Integer.valueOf(str.removeLast());
                StringBuilder builder = new StringBuilder();
                for (int i1 = 0; i1 < temp; i1++) {
                    builder.append(string);
                }
                str.addLast(builder.toString());
            }
        }
        return getStr1(str);
    }

    private String getStr1(LinkedList<String> str1) {
        StringBuilder builder = new StringBuilder();
        str1.forEach(o->builder.append(str1.poll()));
        return str1.toString();
    }

    private String getDigit(String s) {
        int start = i;
        while (Character.isDigit(s.charAt(i))){
            i++;
        }
        return s.substring(start, i);
    }

    private String function1(String s, int j, int k, int i) {
        StringBuilder builder = new StringBuilder();
        String temp = s.substring(k + 1, j);
        int temp2 = Integer.valueOf(s.substring(i, k));
        for (int i1 = 0; i1 < temp2; i1++) {
            builder.append(temp);
        }
        return builder.toString();

    }
}

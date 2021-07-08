import java.util.LinkedList;
import java.util.Stack;

/**
 * 给定两个字符串, A 和 B。
 *
 * A 的旋转操作就是将 A 最左边的字符移动到最右边。 例如, 若 A = 'abcde'，在移动一次之后结果就是'bcdea' 。如果在若干次旋转操作之后，A 能变成B，那么返回True。
 *
 * 示例 1:
 * 输入: A = 'abcde', B = 'cdeab'
 * 输出: true
 *
 * 示例 2:
 * 输入: A = 'abcde', B = 'abced'
 * 输出: false
 * 注意：
 *
 * A 和 B 长度不超过 100。
 */
public class RotateString {
    public boolean rotateString(String s, String goal) {
        if(s.length() != goal.length()){
            return false;
        }
        char c = goal.charAt(0);
        LinkedList<Character> temp = new LinkedList<Character>();
        LinkedList<Character> characters = new LinkedList<Character>();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            if(s.charAt(i) == c){
                int j = i;
                while (j<length){
                    characters.addLast(s.charAt(j++));
                }
                for (int k = 0; k < i; k++) {
                    characters.addLast(s.charAt(k));
                }
                if(check(characters, goal)){
                    return true;
                }
                characters.clear();
            }
        }
        return false;
    }

    private boolean check(LinkedList<Character> characters, String goal) {
        int length = goal.length();
        for (int i = 0; i < length; i++) {
            if(characters.pollFirst() != goal.charAt(i)){
                return false;
            }
        }
        return true;
    }
}

/**
 * 171. Excel表列序号
 * 给定一个Excel表格中的列名称，返回其相应的列序号。
 *
 * 例如，
 *
 *     A -> 1
 *     B -> 2
 *     C -> 3
 *     ...
 *     Z -> 26
 *     AA -> 27
 *     AB -> 28
 *     ...
 * 示例 1:
 *
 * 输入: "A"
 * 输出: 1
 * 示例 2:
 *
 * 输入: "AB"
 * 输出: 28
 * 示例 3:
 *
 * 输入: "ZY"
 * 输出: 701
 */
public class Shoppe_TitleToNumber_033 {
    public int titleToNumber(String columnTitle) {
        int multiple = 1;
        int result = 0;
        for (int i = columnTitle.length()-1; i > 0 ; i--) {
            char c = columnTitle.charAt(i);
            int val = (c-'A'+1)*multiple;
            multiple=multiple*26;
            result+=val;
        }
        return result;
    }
}

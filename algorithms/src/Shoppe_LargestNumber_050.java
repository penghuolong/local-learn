import java.util.Arrays;

/**
 * 179. 最大数
 * 给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
 * <p>
 * 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [10,2]
 * 输出："210"
 * 示例 2：
 * <p>
 * 输入：nums = [3,30,34,5,9]
 * 输出："9534330"
 * 示例 3：
 * <p>
 * 输入：nums = [1]
 * 输出："1"
 * 示例 4：
 * <p>
 * 输入：nums = [10]
 * 输出："10"
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 109
 */
public class Shoppe_LargestNumber_050 {
    public String largestNumber(int[] nums) {
        int len = nums.length;
        Integer[] temp = new Integer[len];
        for (int i = 0; i < nums.length; i++) {
            temp[i] = nums[i];
        }
        Arrays.sort(temp, (v1,v2)->{
            long ln1 = 10;
            long ln2 = 10;
            while (ln1<=v1){
                ln1*=10;
            }
            while (ln2<=v2){
                ln2*=10;
            }
            return (int)(ln1*v2+v1-ln2*v1-v2);
        });
        if(temp[0]==0){
            return "0";
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < temp.length; i++) {
            builder.append(temp[i]);
        }
        return builder.toString();
    }
}

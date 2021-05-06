import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 46. 全排列
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 *
 * 示例:
 *
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 * 通过次数
 */
public class Shoppe_Permute_016 {
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> temp = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            temp.add(nums[i]);
        }
        List<List<Integer>> result =  new ArrayList<>();
        calculate(result, temp, 0);
        return result;
    }

    private void calculate(List<List<Integer>> result, List<Integer> temp, int len) {
        if(len == temp.size()){
            result.add(new ArrayList<>(temp));
        }
        for (int i = len; i < temp.size(); i++) {
            Collections.swap(temp, len, i);
            calculate(result, temp, len+1);
            Collections.swap(temp, len, i);
        }
    }
}

import java.util.ArrayList;
import java.util.List;

/**
 * 113. 路径总和 II
 * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
 *
 * 叶子节点 是指没有子节点的节点。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
 * 输出：[[5,4,11,2],[5,8,4,5]]
 */
public class Shoppe_PathSum_042 {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<Integer> temp = new ArrayList<>();
        int val = 0;
        calculate(root, targetSum, temp, val);
        return result;
    }

    private void calculate(TreeNode node, int targetSum, List<Integer> temp, int val) {
         if(node == null){
             return;
         }
         int value = val+node.val;
         temp.add(node.val);
        calculate(node.left, targetSum, temp, value);
        calculate(node.right,targetSum,temp,value);
        if(value == targetSum && node.left==null && node.right==null){
             List<Integer> list = new ArrayList<>(temp);
             result.add(list);
         }
         temp.remove(temp.size()-1);
    }
}

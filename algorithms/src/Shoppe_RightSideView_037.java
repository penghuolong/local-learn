import java.util.*;

/**
 * 199. 二叉树的右视图
 * 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,3,null,5,null,4]
 * 输出: [1, 3, 4]
 * 解释:
 * <p>
 * 1            <---
 * /   \
 * 2     3         <---
 * \     \
 * 5     4       <---
 * 通过次数104,359提交次数160,758
 */
public class Shoppe_RightSideView_037 {
    // BFS
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null){
            return Collections.emptyList();
        }
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (i == (size - 1)) {
                    result.add(poll.val);
                }
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
        }
        return result;
    }

    // DFS
    List<Integer> result1 = new ArrayList<>();
    public List<Integer> rightSideView1(TreeNode root) {
       dfs(root,0);
       return result1;
    }

    private void dfs(TreeNode root, int i) {
        if(root == null){
            return;
        }
        if(result1.size() == i){
            result1.add(root.val);
        }
        i++;
        dfs(root.right, i);
        dfs(root.left, i);
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}



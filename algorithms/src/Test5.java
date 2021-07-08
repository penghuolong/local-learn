import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Test5 {
    static List<Integer> result = new ArrayList<>();
    public static List<Integer> findLeft(TreeNode node){

        if(node == null){
            return result;
        }
        List<TreeNode> list = new ArrayList<>();
        List<TreeNode> temp = new ArrayList<>();
        list.add(node);
        while (!list.isEmpty()){
           result.add(list.get(0).value);
            for (int i = 0; i < list.size(); i++) {
                TreeNode treeNode = list.get(i);
                if(treeNode.left!=null){
                    temp.add(treeNode.left);
                }
                if(treeNode.right!=null){
                    temp.add(treeNode.right);
                }
            }
            list.clear();
            list.addAll(temp);
            temp.clear();
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(7);
        TreeNode node5 = new TreeNode(8);

        node1.left = node2;
        node1.right = node3;
        node3.right =node4;
        node4.right = node5;
        List<Integer> left = findLeft(node1);
        for (int i = 0; i < left.size(); i++) {
            System.out.println(left.get(i));
        }

    }


    static class TreeNode{
        int value;
        TreeNode left;
        TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }
    }
}


import java.util.*;

/**
 * 336. 回文对
 * 给定一组 互不相同 的单词， 找出所有 不同 的索引对 (i, j)，使得列表中的两个单词， words[i] + words[j] ，可拼接成回文串。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：words = ["abcd","dcba","lls","s","sssll"]
 * 输出：[[0,1],[1,0],[3,2],[2,4]]
 * 解释：可拼接成的回文串为 ["dcbaabcd","abcddcba","slls","llssssll"]
 * 示例 2：
 * <p>
 * 输入：words = ["bat","tab","cat"]
 * 输出：[[0,1],[1,0]]
 * 解释：可拼接成的回文串为 ["battab","tabbat"]
 * 示例 3：
 * <p>
 * 输入：words = ["a",""]
 * 输出：[[0,1],[1,0]]
 * <p>
 * 提示：
 * <p>
 * 1 <= words.length <= 5000
 * 0 <= words[i].length <= 300
 * words[i] 由小写英文字母组成
 */
public class Shoppe_PalindromePairs_057 {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> result = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            String s = new StringBuffer(words[i]).reverse().toString();
            map.put(s, i);
        }
        for (int i = 0; i < words.length; i++) {
            String s = words[i];
            int len = s.length();
            if (len == 0) {
                continue;
            }
            for (int j = 0; j <= len; j++) {
                if (isPalindrome(s, j, len - 1)) {
                    int index = find(s, 0, j - 1, map);
                    if (index != -1 && index != i) {
                        result.add(Arrays.asList(i, index));
                    }
                }
                if (j != 0 && isPalindrome(s, 0, j - 1)) {
                    int index = find(s, j, len - 1, map);
                    if (index != -1 && index != i) {
                        result.add(Arrays.asList(index, i));
                    }
                }
            }
        }
        return result;
    }

    public boolean isPalindrome(String s, int left, int right) {
        if (left >= right) {
            return true;
        }
        int len = right - left + 1;
        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(left + i) != s.charAt(right - i)) {
                return false;
            }
        }
        return true;
    }

    public int find(String s, int left, int right, Map<String, Integer> map) {
        return map.getOrDefault(s.substring(left, right + 1), -1);
    }

//    List<List<Integer>> result = new ArrayList<>();
//
//    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
//        if(root == null){
//            return Collections.emptyList();
//        }
//        List<Integer> tempList = new ArrayList<>();
//        int sum = 0;
//        find(tempList, sum, root, targetSum);
//        return result;
//    }
//
//    public void find(List<Integer> tempList, int sum, TreeNode node, int targetSum) {
//        sum += node.val;
//        tempList.add(node.val);
//        if (node.left == null && node.right == null) {
//            if (sum == targetSum) {
//                List<Integer> list = new ArrayList<>(tempList);
//                result.add(list);
//                tempList.remove(tempList.size() - 1);
//                return;
//            }
//        }
//
//        if (node.left != null) {
//            find(tempList, sum, node.left, targetSum);
//        }
//        if (node.right != null) {
//            find(tempList, sum, node.right, targetSum);
//        }
//        tempList.remove(tempList.size() - 1);
//    }
}

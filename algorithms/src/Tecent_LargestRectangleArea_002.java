import java.util.Deque;
import java.util.LinkedList;

/**
 * 84. 柱状图中最大的矩形
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * <p>
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。
 * <p>
 * <p>
 * <p>
 * 示例:
 * <p>
 * 输入: [2,1,5,6,2,3]
 * 输出: 10
 */
public class Tecent_LargestRectangleArea_002 {
    public int largestRectangleArea(int[] heights) {
        int result = 0;
        int len = heights.length;
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            while (!deque.isEmpty() && heights[deque.peekLast()] > heights[i]) {
                int res = 0;
                int height = heights[deque.pollLast()];
                while (!deque.isEmpty() && heights[deque.peekLast()] == height) {
                    deque.pollLast();
                }
                if (deque.isEmpty()) {
                    res = height * i;
                } else {
                    res = height * (i - deque.peekLast() - 1);
                }
                result = Math.max(res, result);
            }
            deque.addLast(i);
        }
        while (!deque.isEmpty()) {
            int res = 0;
            int height = heights[deque.pollLast()];
            while (!deque.isEmpty() && heights[deque.peekLast()] == height) {
                deque.pollLast();
            }
            if (deque.isEmpty()) {
                res = height * len;
            } else {
                res = height * (len - deque.peekLast() - 1);
            }
            result = Math.max(res, result);
        }
        return result;
    }

    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int result = 0;
        int[] temp = new int[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    temp[j]++;
                }else {
                    temp[j]=0;
                }
            }
            result = Math.max(result, largestRectangleArea(temp));
        }
        return result;
    }
}

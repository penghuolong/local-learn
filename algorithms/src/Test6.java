import java.util.Stack;

/**
 * 3. 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 ,  [7,6,4,3,1] 返回0； [7,1,5,3,6,4] 返回 6-1=5。
 */
public class Test6 {
    public static int max(int[] arr) {
        int result = 0;
        if(arr.length<=1){
            return result;
        }
        Stack<Integer> stack = new Stack<>();
        for (int i = 1; i < arr.length; i++) {
            if (stack.isEmpty()) {
                stack.add(arr[i]);
            } else {
                if (stack.peek() < arr[i]) {
                    int temp = arr[i] - stack.peek();
                    if (temp > result) {
                        result = temp;
                    }
                } else {
                    stack.add(arr[i]);
                }

            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{7,1,5,3,6,4};
        System.out.println(max(arr));
        int[] arr1 = new int[]{7,6,4,3,1};
        System.out.println(max(arr1));


    }
}

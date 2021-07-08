import java.util.Stack;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 */
public class Test8 {
    public static int[] calculate(int[] input) {
        Stack<Integer> stack = new Stack<>();
        int temp = 1;
        for (int i = input.length - 1; i >= 0; i--) {
            int value = input[i] + temp;
            int v1 = value % 10;
            temp = value / 10;
            stack.add(v1);
        }
        if (temp > 0) {
            stack.add(temp);
        }
        int[] result = new int[stack.size()];
        int i = 0;
        while (!stack.isEmpty()) {
            result[i++] = stack.pop();
        }
        return result;
    }

    public static void main(String[] args) {
//        int[] input1 = new int[]{9, 9,9};
//        int[] calculate = calculate(input1);
//        for (int i = 0; i < calculate.length; i++) {
//            System.out.print(calculate[i]);
//        }
        //2126753390
        //1702766719
        int left = 2126753390;
        int right = 1702766719;
        System.out.println((left+right)/2);
        System.out.println(left+(right-left)/2);

    }
//    ThreadPoolExecutor
//    FutureTask
}

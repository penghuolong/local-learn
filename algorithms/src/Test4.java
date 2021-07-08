import java.util.Stack;

public class Test4 {
    public int[] calculate(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int max = -1;
        for (int i = 0; i < arr.length; i++) {
            int value = arr[i];
            if (value > max) {
                max = value;
                stack.add(value);
            } else {
                while (!stack.isEmpty() && stack.peek() > value) {
                    stack.pop();
                }
            }
        }
        int[] result = new int[stack.size()];
        int i = 0;
        while (!stack.isEmpty()) {
            result[i++] = stack.pop();
        }
        return result;
    }
}

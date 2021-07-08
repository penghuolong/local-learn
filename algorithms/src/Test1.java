import java.util.Scanner;
import java.util.Stack;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int[] result = new int[a];
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < a; i++) {
            int v =1;
            for (int j = 0; j < 10; j++) {
                int k = in.nextInt();
                v=v*2;
                for (int l = 0; l < k; l++) {
                    stack.add(v);
                }
            }
            int count = calculate(stack);
            result[i] = count;
            stack.clear();
        }
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    private static int calculate(Stack<Integer> stack) {
        Stack<Integer> temp = new Stack<>();
        int sum = 0;
        int count = 0;
        while (!stack.isEmpty() && sum != 2048) {
            int pop = stack.pop();
            if (temp.isEmpty()) {
                temp.add(pop);
                continue;
            }
            while (!temp.isEmpty() && temp.peek() == pop && sum != 2048) {
                pop = temp.pop() + pop;
                count++;
                sum = pop;
            }
            temp.add(pop);
        }
        Lock lock = new ReentrantLock();
        lock.lock();
        return sum == 2048 ? count : -1;

    }
}

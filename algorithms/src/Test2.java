import java.util.Scanner;

public class Test2 {
    static int m = 0;
    static int n = 0;
    static int k = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            m = in.nextInt();
            n = in.nextInt();
            k = in.nextInt();
        }
        long v = Math.min((calculate(m, m, n, k)), (calculate(n, m, n, k) + 1));
        if(v>=Integer.MAX_VALUE){
            System.out.println(-1);
        }else {
            System.out.println(v);

        }

    }

    private static long calculate(int temp, int m, int n, int k) {
        if (temp == k) {
            return 0;
        }
        if (temp < k) {
            return Integer.MAX_VALUE;
        }
        return calculate(temp - n, m, n, k) + 2;
    }
}

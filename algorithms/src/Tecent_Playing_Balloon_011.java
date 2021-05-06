import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 气球游戏-2019腾讯笔试
 * 小Q在进行射击气球的游戏，如果小Q在连续T枪中打爆了所有颜色的气球，将得到一只QQ公仔作为奖励。（每种颜色的球至少被打爆一只）。
 * <p>
 * 这个游戏中有m种不同颜色的气球，编号1到m。
 * <p>
 * 小Q一共有n发子弹，然后连续开了n枪。
 * <p>
 * 小Q想知道在这n枪中，打爆所有颜色的气球最少用了连续几枪？
 * <p>
 * 输入格式
 * 第一行包含两个整数n和m。
 * <p>
 * 第二行包含n个整数，分别表示每一枪打中的气球的颜色，0表示没打中任何颜色的气球。
 * <p>
 * 输出格式
 * 一个整数表示小Q打爆所有颜色气球用的最少枪数。
 * <p>
 * 如果小Q无法在这n枪打爆所有颜色的气球，则输出-1。
 * <p>
 * 数据范围
 * 1≤n≤106,
 * 1≤m≤2000
 * <p>
 * 输入样例：
 * 12 5
 * 2 5 3 1 3 2 4 1 0 5 4 3
 * 输出样例：
 * 6
 * 样例解释
 * 有五种颜色的气球，编号1到5。
 * <p>
 * 游客从第二枪开始直到第七枪，这连续六枪打爆了5 3 1 3 2 4这几种颜色的气球，包含了从1到5的所有颜色，所以最少枪数为6。
 */

/**
 * 12
 * 5
 * 2 5 3 1 3 2 4 1 0 5 4 3
 */
public class Tecent_Playing_Balloon_011 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println("输入n="+n);
        System.out.println("输入n="+m);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        int result = calculate(n, m, arr);
        System.out.println("结果为："+result);
    }

    private static int calculate(int n, int m, int[] arr) {
        // 统计不同颜色气球的个数
        int[] temp = new int[m];
        int left = 0;
        int right = 0;
        Set<Integer> set = new HashSet<>();
        int result = -1;
        while (left <= right && right < n) {
            if (arr[right] != 0) {
                set.add(arr[right]);
                temp[arr[right]]++;
            }
            // 如果目前左右指针范围内的集合满足条件，进一步尝试缩小区间以期望达到最优解
            if (set.size() >= m) {
                while (left < right) {
                    // 如果左节点值不为0 或者左节点值的统计值小于2，那么久不能删除，即不能继续尝试缩短长度
                    if (arr[left] != 0 && temp[arr[left]] < 2) {
                        break;
                    }
                    temp[arr[left]]--;
                    left++;
                }
                if (result == -1 || (right - left + 1) < result) {
                    result = right - left + 1;
                }
            }
            right++;
        }
        return result;
    }

}

/**
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 * 示例 2：
 * <p>
 * 输入：nums1 = [1,2], nums2 = [3,4]
 * 输出：2.50000
 * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 * 示例 3：
 * <p>
 * 输入：nums1 = [0,0], nums2 = [0,0]
 * 输出：0.00000
 * 示例 4：
 * <p>
 * 输入：nums1 = [], nums2 = [1]
 * 输出：1.00000
 * 示例 5：
 * <p>
 * 输入：nums1 = [2], nums2 = []
 * 输出：2.00000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindMedianSortedArrays_004 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        int[] all = new int[len];
        int count = 0;
        int firstPoint = 0;
        int secendPoint = 0;
        while (count < len){
            if(firstPoint >= nums1.length){
                all[count]=nums2[secendPoint];
                secendPoint++;

            }else if(secendPoint >= nums2.length){
                all[count] = nums1[firstPoint];
                firstPoint++;
            }else if(nums1[firstPoint] > nums2[secendPoint]){
                all[count]=nums2[secendPoint];
                secendPoint++;
            }else {
                all[count] = nums1[firstPoint];
                firstPoint++;
            }
            count++;
        }
        if(len %2==0){
            return ((double)all[len/2-1]+all[len/2])/2.0;
        }else {
            return all[(len+1)/2-1];
        }
    }
}

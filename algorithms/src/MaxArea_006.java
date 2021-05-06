public class MaxArea_006 {
    public int maxArea(int[] height) {
        int result = 0;
        int len = height.length;
        int left = 0;
        int right = len -1;
        while(left < right){
            if(height[left] < height[right]){
                int value = (right-left)*height[left];
                if(value > result){
                    result = value;
                }
                left++;
            }else {
                int value = (right-left)*height[right];
                if(value > result){
                    result = value;
                }
                right--;
            }
        }
        return result;
    }
}

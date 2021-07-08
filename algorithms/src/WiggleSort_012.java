public class WiggleSort_012 {
    public void wiggleSort(int[] nums) {
        quickSort(nums, 0, nums.length-1);
        int mid = (nums.length-1)/2 +1;
        int[] temp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            temp[i] = nums[i];
        }
        for (int i = 0,j=0; i < nums.length; i=i+2) {
            nums[i] = temp[j];
            j++;
        }
        for(int i=1,j=mid; j<nums.length;j=j+2){
            nums[i]=temp[j];
        }
    }
    public void quickSort(int[] nums, int left, int right){
        if(left >= right){
            return;
        }
        int index = partation(nums, left, right);
        quickSort(nums, left, index-1);
        quickSort(nums, index+1, right);
    }

    private int partation(int[] nums, int left, int right) {
        int temp = nums[left];
        while (left < right){
            while (left < right && nums[right]>temp){
                right--;
            }
            nums[left] = nums[right];
            while (left<right && nums[left]<temp){
                left++;
            }
            nums[right]=nums[left];
        }
        nums[left] = temp;
        return left;
    }
}

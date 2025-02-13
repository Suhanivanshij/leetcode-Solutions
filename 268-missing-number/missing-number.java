class Solution {
    public int missingNumber(int[] nums) {
        int i=0;
        while(i<nums.length){
            int correct_index=nums[i];
            if(nums[i]<nums.length && nums[i]!=nums[correct_index]){
                swap(nums,i,correct_index);
            }else{
                i++;
            }
        }
        for(int j=0;j<nums.length;j++){
            if(nums[j]!=j){
                return j;
            }
        }
        return nums.length;
    }
    static void swap(int[] arr,int a,int b){
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }
}
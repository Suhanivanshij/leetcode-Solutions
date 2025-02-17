class Solution {
    public int firstMissingPositive(int[] nums) {
        int i=0;
        while(i<nums.length){
            int correct_index=nums[i]-1;
            if(nums[i] > 0 && nums[i]<=nums.length && nums[i]!=nums[correct_index]){
                swap(nums,i,correct_index);
            }else{
                i++;
            }
        }

        // search for first missing number
        for(int j=0;j<nums.length;j++){
            if(nums[j]!=j+1){
                return j+1;
            }
        }
        return nums.length+1;
    }
    static void swap(int[] arr,int a,int b){
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }
}
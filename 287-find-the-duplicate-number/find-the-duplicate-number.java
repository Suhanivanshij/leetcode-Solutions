class Solution {
    public int findDuplicate(int[] nums) {
        int i=0;
        while(i<nums.length){
            int correct_index=nums[i]-1;
            if(nums[i]!=nums[correct_index]){
                swap(nums,i,correct_index);
            }else{
                i++;
            }
        }
        int ans=0;
        for(int j=0;j<nums.length;j++){
            if(nums[j]!=j+1){
                ans=nums[j];
            }
        }
        return ans;
    }
    public void swap(int[] arr,int a,int b){
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }
}
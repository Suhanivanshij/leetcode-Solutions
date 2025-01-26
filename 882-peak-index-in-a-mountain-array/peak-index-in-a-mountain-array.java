class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int start=0;
        int end=arr.length-1;
        while(start<end){
//          int mid=(start+end)/2;  //might be possible that (start+end) exceeds the range of int in java
            int mid = start +(end-start)/2;
            if(arr[mid]>arr[mid+1]){
                // you are in desc part of array
                // this may be the ans, but look at left
                // this is why end != mid -1
                end=mid;
            }
            else{
                // you are in asc part of array
                start=mid+1; // because we know that mid+1 element > mid element
            }
        }
        // In the end, start == end and pointing to the largest number because of the 2 checks above
        // start and end are always trying to find max element in the above 2 checks
        // hence, when they are pointing to just one element, that is the max one because that is what the checks say
        return start;
        
    }
}
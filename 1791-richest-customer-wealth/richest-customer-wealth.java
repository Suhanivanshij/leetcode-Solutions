class Solution {
    public int maximumWealth(int[][] accounts) {
        int ans=Integer.MIN_VALUE;
        for (int person = 0; person < accounts.length; person++) {
            // whenever starting a new column, take a new sum for that row
            int sum=0;
            for (int account = 0; account <accounts[person].length ; account++) {
                sum+=accounts[person][account];
            }
            // now checking with overall ans
            if(sum>ans){
                ans=sum;
            }
        }
        return ans; 
    }
}
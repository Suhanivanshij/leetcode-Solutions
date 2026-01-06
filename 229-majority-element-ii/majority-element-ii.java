// import java.util.ArrayList;
class Solution {
    public List<Integer> majorityElement(int[] nums) {

        List<Integer> list = new ArrayList<>();

        int el1 = 0, el2 = 0;
        int cnt1 = 0, cnt2 = 0;

        for (int n : nums) {

            if (n == el1) {
                cnt1++;
            }
            else if (n == el2) {
                cnt2++;
            }
            else if (cnt1 == 0) {
                el1 = n;
                cnt1 = 1;
            }
            else if (cnt2 == 0) {
                el2 = n;
                cnt2 = 1;
            }
            else {
                cnt1--;
                cnt2--;
            }
        }

        // verify
        cnt1 = cnt2 = 0;
        for (int n : nums) {
            if (n == el1) cnt1++;
            else if (n == el2) cnt2++;
        }

        int threshold = nums.length / 3;

        if (cnt1 > threshold) list.add(el1);
        if (cnt2 > threshold) list.add(el2);

        return list;
    }
}

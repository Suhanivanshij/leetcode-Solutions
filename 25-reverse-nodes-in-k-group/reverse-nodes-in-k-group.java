/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k<=1 || head == null){
            return head;
        }
        ListNode present = head;
        ListNode prev = null;
        while(true){
            ListNode check = present;
            int count=0;
            while(check != null && count <k){
                check=check.next;
                count++;
            }
            if (count<k){
                break;   // Not enough nodes to reverse
            }
            ListNode last = prev;
            ListNode newEnd=present;

            // reverse between left and right
            ListNode next=present.next;
            for (int i = 0;present != null && i < k ; i++) {
                present.next=prev;
                prev=present;
                present=next;
                if(next != null){
                    next=next.next;
                }
            }
            if(last != null){
                last.next=prev;
            } else{
                head = prev;
            }

            newEnd.next=present;
            if (present==null){
                break;
            }
            prev=newEnd;
        }
        return head;
    }
}
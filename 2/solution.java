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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l3head = new ListNode(0);
        ListNode l3 = l3head;
        int j = 0;
        while(l1 != null || l2 != null){
            if(l1 == null){
                l3.next = new ListNode((l2.val + j) % 10);
                j = (l2.val + j) / 10;
                l2 = l2.next;
            }else if(l2 == null){
                l3.next = new ListNode((l1.val + j) % 10);
                j = (l1.val + j) / 10;
                l1 = l1.next;
            }else{
                l3.next = new ListNode((l1.val + l2.val + j) % 10);
                j = (l1.val + l2.val + j) / 10;
                l1 = l1.next;
                l2 = l2.next;
            }
            l3 = l3.next;
        }
        if(j != 0){
            l3.next = new ListNode(1);
        }
        return l3head.next;
    }
}
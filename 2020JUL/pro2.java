/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int temp = l1.val+l2.val;
        boolean f = temp>9;
        temp = temp % 10;
        ListNode result = new ListNode(temp);
        ListNode cur = result;
        while(l1.next != null || l2.next!= null){
            temp = 0;
            if(f) temp += 1;
            if(l1.next!= null){
                l1 = l1.next;
                temp += l1.val;
            }
            if(l2.next!= null){
                l2 = l2.next;
                temp += l2.val;
            }
            f = temp > 9;
            temp = temp % 10;
            ListNode nextnode = new ListNode(temp);
            cur.next = nextnode;
            cur = nextnode;   
        }
        if(f){
            cur.next = new ListNode(1);
        }
        return result;
    }
}

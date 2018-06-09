/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Problem160IntersectionOfTwoLinkedList {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int aLength = 0;
        int bLength = 0;
        ListNode a = headA;
        ListNode b = headB;
        
        while (a != null) {
            a = a.next;
            aLength += 1;
        }
        
        while (b != null) {
            b = b.next;
            bLength += 1;
        }
        
        int lengthDiff = Math.abs(bLength - aLength);
        boolean isBLonger = bLength > aLength;
        ListNode l1 = !isBLonger ? headA : headB;
        ListNode l2 = !isBLonger ? headB : headA;
        for (int i = 0; i < lengthDiff; i ++) {
            l1 = l1.next;
        }
        
        while (l1 != null && l2 != null) {
            if (l1.equals(l2)) return l1;
            l1 = l1.next;
            l2 = l2.next;
        }
        
        return null;
    }
}

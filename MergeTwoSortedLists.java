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
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    	if(l1==null){
    		return l2;
    	}else if(l2==null){
    		return l1;
    	}

        ListNode head = null;
        if(l1.val<l2.val){
        	head = l1;
        	l1 = l1.next;
        }else{
        	head = l2;
        	l2 = l2.next;
        }

        ListNode runner = head;

    	while(l1!=null||l2!=null){
    		if(l1==null){
    			runner.next = l2;
    			l2 = l2.next;
    			runner = runner.next;
    			continue;
    		}
    		if(l2==null){
    			runner.next = l1;
    			l1 = l1.next;
    			runner = runner.next;
    			continue;
    		}

    		if(l1.val<l2.val){
    			runner.next = l1;
    			l1 = l1.next;
    		}else{
    			runner.next = l2;
    			l2 = l2.next;
    		}
    		runner = runner.next;
    	}
    	return head;
    }
}
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
    	if(head==null) return head;

    	ListNode runner = head;
    	int count = 0;
    	ListNode target = null;


    	while(runner!=null){
    		if(target!=null){
    			target = target.next;
    		}
    		if(count==n){
    			target = head;
    		}
    		runner = runner.next;
    		count++;
    	}
    	if(target==null){
    		//target haven't been assigned value, target not found or the list 
    		// size is only one.?
    		// According to question description, n will always be valid, meaning that
    		// if list size is only one then value of n will also be one, thus we should just
    		// 	return a null object, which is head.next;
    		return head.next;
    	}

    	target.next = target.next.next;

    	return head;
    }
}
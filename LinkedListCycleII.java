public class Solution {
    public ListNode detectCycle(ListNode head) {
    	if(head==null||head.next==null){
    		return null;
    	}

    	ListNode slow = head;
    	ListNode fast = head;

    	while(fast!=null&&fast.next!=null){
    		fast = fast.next.next;
    		slow = slow.next;
    		if(fast==slow){
    			slow = head;
    			while(fast!=slow){
    				fast = fast.next;
    				slow = slow.next;
    			}
    			return fast;
    		}
    	}

    	return null;
    }
}
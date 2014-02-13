/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode sortList(ListNode head) {
    	if(head == null || head.next==null){
    		return head;
    	}

    	ListNode runner = head;
    	int len = 0;

    	while(runner!=null){
    		len++;
    		runner = runner.next;
    	}

    	// one index before mid, need to split one list into two.
    	int mid = len/2 -1;

    	runner = head;

    	int count = 0;
    	while(count!=mid){
    		runner = runner.next;
    		count++;
    	}
    	ListNode rest = runner.next;

    	//split old list.
    	runner.next = null;

    	ListNode firstHalf = sortList(head);
    	ListNode secondHalf = sortList(rest);

    	ListNode resultHead = null;
    	ListNode resultTail = null;

    	while(firstHalf!=null||secondHalf!=null){
    		if(firstHalf==null){
    			// do need to check if tail is null, since sortList will return at list one non-null node, so 
    			//the first two if conditionals wont be executed at first iteration.
				resultTail.next = secondHalf;
				resultTail = resultTail.next;
    			secondHalf = secondHalf.next;
    			continue;
    		}
    		if(secondHalf==null){
				resultTail.next = firstHalf;
				resultTail = resultTail.next;
    			firstHalf = firstHalf.next;
    			continue;
    		}
    		if(firstHalf.val<secondHalf.val){
    			if(resultHead==null){
    				resultHead = firstHalf;
    				resultTail = resultHead;
    			}else{
    				resultTail.next = firstHalf;
    				resultTail = resultTail.next;
    			}
    			firstHalf = firstHalf.next;
    		}else{
    			if(resultHead==null){
    				resultHead = secondHalf;
    				resultTail = resultHead;
    			}else{
    				resultTail.next = secondHalf;
    				resultTail = resultTail.next;
    			}
    			secondHalf = secondHalf.next;
    		}
    	}

    	return resultHead;
    }
}

// Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

// For example,
// Given 1->2->3->3->4->4->5, return 1->2->5.
// Given 1->1->1->2->3, return 2->3.
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
 	 public ListNode deleteDuplicates(ListNode head){
 	 	if(head==null){
 	 		return head;
 	 	}

 	 	ListNode dummpy = new ListNode(0);
 	 	dummpy.next = head;
 	 	ListNode previous = dummpy;

 	 	while(previous.next!=null){
 	 		ListNode current = previous.next;
 	 		while(current.next!=null&&current.val==current.next.val){
 	 			current = current.next;
 	 		}

 	 		//If current is not the next node of previous, meaning there is duplicates after previous node, need to change the next reference of previous to skip all the duplicates.
 	 		if(current!=previous.next){
 	 			previous.next = current.next;
 	 		}else{
 	 			//Otherwise, need to keep the link between previous and current.
 	 			previous = current;
 	 		}
 	 	}
 	 	return dummpy.next;
 	 }
}
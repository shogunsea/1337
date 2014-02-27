public class Solution {
   	   public void reorderList(ListNode head) {
   	   	// check if list is valid
   	   	if(head==null||head.next==null){
   	   		return;
   	   	}
   	   	int length = 0;
   	   	ListNode runner = head;
   	   	// Count the lenght of the list, to get the middle node.
   	   	while(runner!=null){
   	   		length++;
   	   		runner = runner.next;
		}

   	   	ListNode previous = head;
   	   	for(int i = 0; i<length/2; i++){
   	   		previous = previous.next;
   	   	}

   	   	ListNode current = previous.next;
   	   	previous.next = null;
   	   	// Reverse the rest half of the list
   	   	ListNode next = null;
   	   	while(current!=null){
   	   		next = current.next;
   	   		current.next = previous;
   	   		previous = current;
   	   		current = next;
   	   	}

   	   	//now previous is the last node, merge two sublists into one
   	   	ListNode headRunner = head;
   	   	ListNode tailRunner = previous;
   	   	ListNode tempHead, tempTail;
   	   	while(headRunner!=tailRunner&&headRunner.next!=tailRunner){
   	   		tempHead = headRunner.next;
   	   		tempTail = tailRunner.next;
   	   		headRunner.next = tailRunner;
   	   		tailRunner.next = tempHead;
   	   		headRunner = tempHead;
   	   		tailRunner = tempTail;
   	   	}
   	   	return;
	}
}
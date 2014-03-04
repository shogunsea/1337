//Given a singly linked list L: L0→L1→…→Ln-1→Ln,
// reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

// You must do this in-place without altering the nodes' values.

// For example,
// Given {1,2,3,4}, reorder it to {1,4,2,3}.
public class Solution{
    public void reorderList(ListNode head){
        if(head==null||head.next==null){
            return;
        }
        
        int len = 0;
        ListNode runner = head;
        while(runner!=null){
            len++;
            runner = runner.next;
        }
        
        runner = head;
        for(int i = 0; i<len/2; i++){
            runner = runner.next;
        }
        
        ListNode previous = runner;
        ListNode current = previous.next;
        previous.next = null;
        while(current!=null){
            ListNode next = current.next;
            current.next = previous;
            previous = current;
            current = next;           
        }
        
        // Now previous is the head of the later half.
        ListNode headRunner = head;
        ListNode tailRunner = previous;
        
        while(headRunner!=tailRunner&&headRunner.next!=tailRunner){
            ListNode headTemp = headRunner.next;
            ListNode tailTemp = tailRunner.next;
            
            headRunner.next = tailRunner;
            tailRunner.next = headTemp;
            
            headRunner = headTemp;
            tailRunner = tailTemp;
        
        }
        
        return;
        
        }


}


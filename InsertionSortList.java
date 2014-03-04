// Sort a list using insertion sort.
public class Solution{
    public ListNode insertionSortList(ListNode head){
        if(head==null||head.next==null){
            return head;
        }
        
        ListNode fakeHead = new ListNode(Integer.MIN_VALUE);
        ListNode temp = null;
        ListNode next = null;
        ListNode runner = head;
        while(runner!=null){
            temp = getPrevious(fakeHead, runner);
            next = runner.next;
            runner.next = temp.next;
            temp.next = runner;
            runner = next;
        }
        return fakeHead.next;
    }
    
    public ListNode getPrevious(ListNode fakeHead, ListNode node){
        ListNode pre = null;
        ListNode runner = fakeHead;
        while(runner!=null&&runner.val<=node.val){
            pre = runner;
            runner = runner.next;
        }
        return pre;
    }
}
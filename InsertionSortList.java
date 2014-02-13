public class Solution{
	public static ListNode insertionSortList(ListNode head){
		if(head==null || head.next==null){
			return head;
		}

		ListNode fakeHead = new ListNode(Integer.MIN_VALUE);
		ListNode node = head;
		ListNode temp, next;
		while(node!=null){
			temp = prev(fakeHead, node);
			next = node.next;
			node.next = temp.next;
			temp.next = node;
			node = next;
		}
		return fakeHead.next;
	}

	public static ListNode prev(ListNode fakeHead, ListNode node){
		ListNode start = fakeHead;
		ListNode pre = null;
		while(start!=null&&start.val<=node.val){
			pre = start;
			start = start.next;
		}
		return pre;
	}
}

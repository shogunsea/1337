// Given a linked list, determine if it has a cycle in it.

// Follow up:
// Can you solve it without using extra space?
// Solution One: use a HashMap
// public class Solution {
//     public boolean hasCycle(ListNode head) {
//     	if(head==null||head.next==null){
//     		return false;
//     	} 

//     	HashMap<ListNode,Integer> map = new HashMap<ListNode,Integer>();

//     	while(head!=null){
//     		if(map.containsKey(head)){
//     			return true;
//     		}else{
//     			map.put(head,1);
//     		}

//     		head = head.next;
//     	}

//     	return false;
// 	}
// }

// Solution without using extra space
public class Solution {
    public boolean hasCycle(ListNode head) {
    	if(head==null||head.next==null){
    		return false;
    	}
    	ListNode fast = head;
    	ListNode slow = head;

    	while(fast!=null&&fast.next!=null){
    		fast = fast.next.next;
    		slow = slow.next;
    		if(fast==slow){
    			return true;
    		}
    	}
    	return false;
    }
}
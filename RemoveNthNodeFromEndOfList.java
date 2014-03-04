// Given a linked list, remove the nth node from the end of list and return its head.

// For example,

//    Given linked list: 1->2->3->4->5, and n = 2.

//    After removing the second node from the end, the linked list becomes 1->2->3->5.
// Note:
// Given n will always be valid.
// Try to do this in one pass.



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
 
 public class Solution{
     public ListNode removeNthFromEnd(ListNode head, int n){
         if(head==null){
             return null;
         }
         
         ListNode runner = head;
         ListNode target = null;
         int count = 0;
         
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
             // removing the head;
           return head.next;
         }
         
         target.next = target.next.next;
         
         return head;
         
     
     }
 
 
 }
 
 
 
 
 
 
 
 
 
 
 
 
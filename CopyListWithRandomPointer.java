/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
    	if(head==null){
    		return null;
    	}
    	
    	// Use a map to keep track of original nodes and copyed nodes.
    	// key is the original node,value is the copyed node, first loop just
    	// copy the node value, 
    	HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();

    	RandomListNode runner = head;

    	while(runner!=null){
    		map.put(runner, new RandomListNode(runner.label));
    		runner = runner.next;
    	}

    	runner = head;

    	while(runner!=null){
    		RandomListNode copyNode = map.get(runner);
    		if(runner.next!=null){
    			copyNode.next = map.get(runner.next);
    		}
    		if(runner.random!=null){
    			copyNode.random = map.get(runner.random);
    		}
    		runner = runner.next;
    	}

    	return map.get(head);
    }
}
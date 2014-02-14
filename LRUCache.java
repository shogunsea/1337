// Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.
// get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
// set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

public class LRUCache{
		private class Node{
			int value, key;
			Node next, prev;
			Node(int key, int value){
				this.key = key;
				this.value = value;
			}
		}
		private Node head, tail;
		private static int capacity = 0;
		private HashMap<Integer, Node> cache = new HashMap<Integer, Node>();
		public LRUCache(int capacity){
			this.capacity = capacity;
		}

		public int get(int key){
			if(cache.containsKey(key)){
				Node current = cache.get(key);
				int val = current.value;
				Node next = current.next;
				Node prev = current.prev;
				if(next!=null){
					if(prev==null){
						head = next;
					}else{
						prev.next = next;
					}
					next.prev = prev;
					current.prev = tail;
					current.next = null;
					tail.next = current;
					tail = tail.next;
				}
				return val;
			}
			return -1;
		}

		public void set(int key, int value){
			// update the node
			if(cache.containsKey(key)){
				Node current = cache.get(key);
				current.value = value;
				Node next = current.next;
				Node prev = current.prev;
				// if next is null, current is tail, no need to update queue.
				if(next!=null){
					if(prev==null){
						head = next;
					}else{
						prev.next = next;
					}
					next.prev = prev;
					current.prev = tail;
					current.next = null;
					tail.next = current;
					tail = tail.next;
				}
			// invalidate head node, remove head, insert new node
			}else if(cache.size()==capacity){
				Node newNode= new Node(key, value);
				int oldKey = head.key;
				cache.remove(oldKey);
				cache.put(key, newNode);
				if(head.next==null){
					head = newNode;
					tail = head;
				}else{
					head = head.next;
					head.prev = null;
					tail.next = newNode;
					newNode.prev = tail;
					tail = tail.next;
				}
			// insert new node, append to tail.
			}else{
				Node newNode = new Node(key, value);
				cache.put(key, newNode);
				if(tail==null){
					head = newNode;
					tail = head;
				}else{
					tail.next = newNode;
					newNode.prev = tail;
					tail = tail.next;
				}

			}
		}
}
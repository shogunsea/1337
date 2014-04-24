// Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

// For example,
// Given [100, 4, 200, 1, 3, 2],
// The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

// Your algorithm should run in O(n) complexity.




public class Solution{
	public static int longestConsecutive(int[] num){
		Set<Integer> set = new HashSet<Integer>();

		for(int i: num){
			set.add(i);
		}

		int max = 0;

		for(int i = 0; i< num.length; i++){
			if(set.contains(num[i])){
				int next = num[i] - 1;
				int count = 1;
				set.remove(num[i]);
				while(set.contains(next)){
					next--;
					count++;
					set.remove(next);
				}
				previous = num[i] + 1;
				while(set.contains(previous)){
					previous++;
					count++;
					set.remove(previous);
				}
				max = Math.max(max, count);
			}
		}

		return max;
	}
}
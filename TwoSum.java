// Given an array of integers, find two numbers such that they add up to a specific target number.

// The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

// You may assume that each input would have exactly one solution.

// Input: numbers={2, 7, 11, 15}, target=9
// Output: index1=1, index2=2


// O(n2) solution won't pass.
public class Solution {
    public int[] twoSum(int[] numbers, int target) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i = 0; i< numbers.length; i++){
			map.put(numbers[i], i);
		}

		int i1 = -1, i2 = -1;
		for(int j = 0; j< numbers.length; j++){
			i1 = j;
			int temp = target - numbers[j];
			
			if(map.containsKey(temp)){
				i2 = map.get(temp);
				if(i2!=i1){
    				break;
				}
			}
		}
		int[] result = {i1+1, i2+1};
		return result;
    }
}
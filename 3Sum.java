// Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

// Note:
// Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
// The solution set must not contain duplicate triplets.
//     For example, given array S = {-1 0 1 2 -1 -4},

//     A solution set is:
//     (-1, 0, 1)
//     (-1, -1, 2)


public class Solution {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
    	int len = num.length;
    	ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
    	ArrayList<Integer> temp = new ArrayList<Integer>();
    	Arrays.sort(num);

    	for(int i = 0; i < len - 2; i++){
    		if(i==0 || num[i]!=num[i-1]){
    			int j = i + 1;
				int k = len - 1;
				while(j < k){
					if(num[i] + num[j] + num[k] == 0){
						temp.add(num[i]);
						temp.add(num[j]);
						temp.add(num[k]);
						res.add(temp);
						temp = new ArrayList<Integer>();
						j++;
						k--;
						while(j < k && num[j] == num[j-1]){
							j++;
						}
						while(j < k && num[k] == num[k+1]){
							k--;
						}
					}else if(num[i] + num[j] + num[k] > 0){
						// k should be smaller.
						k--;
						while(j < k && num[k] == num[k+1]){
							k--;
						}
					}else{
						// j should be bigger.
						j++;
						while(j < k && num[j] == num[j-1]){
							j++;
						}
					}
				}
    		}
    	}

    	return res;
    }
}
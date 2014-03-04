// Given an array of integers, every element appears three times except for one. Find that single one.

// Note:
// Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

public class Solution {
    public int singleNumber(int[] A) {
        int ones = 0;
        int twos = 0;
        int threes = 0;
        
        for(int i:A){
            twos |= i&ones;
            ones = i^ones;
            threes= ~(ones&twos);
            ones &= threes;
            twos &= threes;
        }
        return ones;
    }
}
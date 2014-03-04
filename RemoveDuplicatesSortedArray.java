// Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

// Do not allocate extra space for another array, you must do this in place with constant memory.

// For example,
// Given input array A = [1,1,2],

// Your function should return length = 2, and A is now [1,2].


public class Solution{
    public int removeDuplicates(int[] nums){
        int len = nums.length;
        if(len==0){
            return len;
        }
        
        int fast = 0;
        int slow = 0;
        
        while(fast<=len-1){
            if(nums[fast]==nums[slow]){
                fast++;
                continue;
            }
            slow++;
            nums[slow] = nums[fast];

        }
        
        return slow+1;
    
    
    }


}

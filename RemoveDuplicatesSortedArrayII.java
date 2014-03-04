// Follow up for "Remove Duplicates":
// What if duplicates are allowed at most twice?

// For example,
// Given sorted array A = [1,1,1,2,2,3],

// Your function should return length = 5, and A is now [1,1,2,2,3].


public class Solution{
    public int removeDuplicates(int[] nums){
        int len = nums.length;
        if(len==0){
            return len;
        }    
        
        int slow = 0;
        int fast = 0;
        int count = 0;
        while(fast<=len-1){
            if(nums[slow]==nums[fast]){
                if(count==1){
                    slow++;
                    nums[slow] = nums[fast];
                    fast++;
                    count++;
                }else if(count>=2){
                    fast++;
                    count++;
                    continue;
                }else if(count==0){
                    count = 1;
                    fast++;
                    continue;
                }
            
            }else{
                count = 1;
                slow++;
                nums[slow] = nums[fast];
                fast++;
            }
        }
        
        return slow+1;
    
    }
}
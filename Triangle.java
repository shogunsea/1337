// Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

// For example, given the following triangle
// [
//      [2],
//     [3,4],
//    [6,5,7],
//   [4,1,8,3]
// ]
// The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

// Note:
// Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.

// Bottom up solution.
public class Solution {
   public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
    int row = triangle.size();
    int[] dp = new int[row];
    for(int i = row-1; i>=0; i--){
        int col = triangle.get(i).size();
        for(int j = 0; j<col; j++){
            if(i==row-1){
                dp[j] = triangle.get(i).get(j);
                continue;
            }
            dp[j] = triangle.get(i).get(j) + Math.min(dp[j], dp[j+1]);
        }
    }
    return dp[0];
}
}


// Top down solution.
// public class Solution {
//    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
//         int level = triangle.size();
//         for(int i = 1; i< level; i++){
//             ArrayList<Integer> prevList = triangle.get(i-1);
//             ArrayList<Integer> currList = triangle.get(i);
//             for(int j =0; j< currList.size(); j++){
//                if(j==0 || j==currList.size()-1){
//                   int update = j==currList.size()-1? currList.get(j) + prevList.get(j-1) : currList.get(j) +prevList.get(j);
//                   currList.set(j, update);
//                   continue;
//                }
//                int update = currList.get(j) + Math.min(prevList.get(j), prevList.get(j-1));
//                currList.set(j, update);
//             }
//          }
//          int min = Integer.MAX_VALUE;
//          for(int i : triangle.get(triangle.size()-1)){
//             if(min>i){
//                min = i;
//             }
//          }
//          return min;
//    }
// }
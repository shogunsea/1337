// Given numRows, generate the first numRows of Pascal's triangle.
// For example, given numRows = 5,
// Return
// [
//      [1],
//     [1,1],
//    [1,2,1],
//   [1,3,3,1],
//  [1,4,6,4,1]
// ]
// [
//  [1],
//  [1,1],
//  [1,2,1],
//  [1,3,3,1],
//  [1,4,6,4,1]
// ]
public class Solution {
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i<numRows; i++){
        	ArrayList<Integer> tempList = new ArrayList<Integer>();
        	tempList.add(1);
        	int size = result.size();
        	for(int j = 1; j<=size; j++){
        		ArrayList<Integer> last = result.get(i-1);
        		if(last.size()>j){
        			int sum = last.get(j-1) + last.get(j);
        			tempList.add(sum);
        		}else{
        			tempList.add(1);
        		}
        		
        	}
        	result.add(tempList);
        }
        return result;
    }
}
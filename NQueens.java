// Given an integer n, return all distinct solutions to the n-queens puzzle.

// Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.

// For example,
// There exist two distinct solutions to the 4-queens puzzle:

// [
//  [".Q..",  // Solution 1
//   "...Q",
//   "Q...",
//   "..Q."],

//  ["..Q.",  // Solution 2
//   "Q...",
//   "...Q",
//   ".Q.."]
// ]
public class Solution {
    public ArrayList<String[]> solveNQueens(int n) {
        ArrayList<String[]> result = new ArrayList<String[]>();
        int[] cols = new int[n];
        helper(result, 0, cols);
        return result;
    }

    public void helper(ArrayList<String[]> result, int row, int[] cols){
        if(row==cols.length){
            // Find a valid assignment.
            String[] qs = new String[cols.length];
            for(int i = 0; i<cols.length; i++){
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j<cols.length; j++){
                    if(cols[i]==j){
                        sb.append('Q');
                    }else{
                        sb.append('.');
                    }
                }
                qs[i] = sb.toString();
            }
            result.add(qs);
            return;
        }

        for(int col = 0; col<cols.length; col++){
            if(isValid(cols,row,col)){
                cols[row] = col;
                helper(result, row+1, cols);
            }
        }
    }

    public boolean isValid(int[] cols, int row, int col){
        if(row==0){
            return true;
        }

        for(int preRow = 0; preRow<row; preRow++){
            int preCol = cols[preRow];
            if(preCol==col){
                return false;
            }
            if(preCol - col == preRow - row){
                return false;
            }
            if(preCol+preRow==col+row){
                return false;
            }
        }

        return true;
    }
}
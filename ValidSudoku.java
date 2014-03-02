// Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.

// The Sudoku board could be partially filled, where empty cells are filled with the character '.'.


// A partially filled sudoku which is valid.

// Note:
// A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.

public class Solution {
    public boolean isValidSudoku(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        if(m<1){
        	return false;
        }
        // Check if all rows and cols are valid.
        for(int i = 0; i<m; i++){
        	int[] row_flag = new int[m];
        	int[] col_flag = new int[n];
        	for(int j = 0; j<n; j++){
        		if(board[i][j]!='.'){
        			int row_num = (board[i][j]-'0')-1;
        			if(row_flag[row_num]>=1){
        				return false;
        			}
        			row_flag[row_num]++;
        		}

        		if(board[j][i]!='.'){
        			int col_num = (board[j][i]-'0')-1;
        			if(col_flag[col_num]>=1){
	        			return false;
	        		}
        			col_flag[col_num]++;
        		}
        		// int col_num = board[j][i]-1;
        		// if(row_flag[row_num]>1){
        		// 	return false;
        		// }else if(col_flag[col_num]>1){
        		// 	return false;
        		// }
        		// col_flag[col_num]++;
        	}
        }

        // Check 9-neighbours area.
        for(int i = 0; i<3; i++){
        	for(int j = 0; j<3; j++){
        		// flag for each element in the 3*3 area.
        		int[] flag = new int [9];
        		for(int k= 0; k<3; k++){
        			for(int l = 0; l<3; l++){
        				int x = i*3+k;
        				int y = j*3+l;
        				if(board[x][y]=='.'){
        					continue;
        				}
        				int num = (board[x][y]-'0')-1;
        				if(flag[num]>=1){
        					return false;
        				}else{
        					flag[num]++;
        				}
        			}
        		}
        	}
        }

        return true;

    }
}
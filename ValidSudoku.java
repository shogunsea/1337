// Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.

// The Sudoku board could be partially filled, where empty cells are filled with the character '.'.


// A partially filled sudoku which is valid.

// Note:
// A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.

public class Solution{
    public boolean isValidSudoku(char[][] board){
        int n = 9;
        
        // Check rows and cols.
        for(int i = 0; i<n; i++){
            int[] rowCount = new int[n];
            int[] colCount = new int[n];
            for(int j = 0; j<n; j++){
                if(board[i][j]!='.'){
                    int row = board[i][j] - '0'-1;
                    if(rowCount[row]==1){
                        return false;
                    }else{
                        rowCount[row]++;
                    }                  
                }
                if(board[j][i]!='.'){
                    int col = board[j][i] - '0'-1;
                    if(colCount[col]==1){
                        return false;
                    }else{
                        colCount[col]++;
                    }
                }       
            }
        }
        
        // Check 3*3 neighbours.
        for(int i = 0; i<3; i++){
            for(int j = 0; j<3; j++){
                int[] count = new int[n];
                for(int k = 0;k<3; k++){
                    for(int l = 0; l<3; l++){
                        int x = i*3 + k;
                        int y = j*3 + l;
                        if(board[x][y]!='.'){
                            int num = board[x][y]-'0'-1;
                            if(count[num]==1){
                                return false;
                            }
                            count[num]++;                      
                        }
                    }
                }
            }
        }
        return true;
    }
}
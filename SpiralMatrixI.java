// Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

// For example,
// Given the following matrix:

// [
//  [ 1, 2, 3 ],
//  [ 4, 5, 6 ],
//  [ 7, 8, 9 ]
// ]
// You should return [1,2,3,6,9,8,7,4,5].
public class Solution {
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        if(matrix.length%2==0){        // no zuo no die.
        ArrayList<Integer> order = new ArrayList<Integer>(); 
        
        if (matrix.length == 0 || matrix[0].length == 0) return order;
        
        int xMin = 0;
        int yMin = 0;
        int xMax = matrix[0].length - 1;
        int yMax = matrix.length - 1;
        order.add(matrix[0][0]);
        int i = 0, j = 0;

        while (true) {
            while (i < xMax){
                i++;
                order.add(matrix[j][i]);
            }

            yMin++;

            if (yMin > yMax){
                break;
            }   

            while (j < yMax){
                j++;
                order.add(matrix[j][i]);
            }    

            xMax--;

            if (xMin > xMax){
                break;
            }    
            
            while (i > xMin){
                i--;
                order.add(matrix[j][i]);
            }    

            yMax--;

            if (yMin > yMax){
                break;
            }
            
            while (j > yMin){
                j--;
                order.add(matrix[j][i]);
            }

            xMin++;

            if (xMin > xMax){
                break;
            }
        }

        return order;
        }else{
        ArrayList<Integer> rst = new ArrayList<Integer>();
        if(matrix == null || matrix.length == 0) 
            return rst;
        
        int rows = matrix.length;
        int cols = matrix[0].length;
        // each layer contains 2 rows and 2 cols.
        int coveredLayer = 0;
        while(coveredLayer * 2 < rows && coveredLayer * 2 < cols){
            for(int i = coveredLayer; i < cols-coveredLayer; i++)
                rst.add(matrix[coveredLayer][i]);
            
            
            for(int i = coveredLayer+1; i< rows-coveredLayer; i++)
                rst.add(matrix[i][cols-coveredLayer-1]);
            
            if(rows - 2 * coveredLayer == 1 || cols - 2 * coveredLayer == 1)  // if only one row /col remains
                break;
                
            for(int i = cols-coveredLayer-2; i>=coveredLayer; i--)
                rst.add(matrix[rows-coveredLayer-1][i]);
                
            for(int i = rows-coveredLayer-2; i>= coveredLayer+1; i--)
                rst.add(matrix[i][coveredLayer]);
            
            coveredLayer++;
        }
        return rst;

        }
    }

    // another version
    // public ArrayList<Integer> spiralOrder(int[][] matrix) {
    //     ArrayList<Integer> rst = new ArrayList<Integer>();
    //     if(matrix == null || matrix.length == 0) 
    //         return rst;
        
    //     int rows = matrix.length;
    //     int cols = matrix[0].length;
    //     // each layer contains 2 rows and 2 cols.
    //     int coveredLayer = 0;
    //     while(coveredLayer * 2 < rows && coveredLayer * 2 < cols){
    //         for(int i = coveredLayer; i < cols-coveredLayer; i++)
    //             rst.add(matrix[coveredLayer][i]);
            
            
    //         for(int i = coveredLayer+1; i< rows-coveredLayer; i++)
    //             rst.add(matrix[i][cols-coveredLayer-1]);
            
    //         if(rows - 2 * coveredLayer == 1 || cols - 2 * coveredLayer == 1)  // if only one row /col remains
    //             break;
                
    //         for(int i = cols-coveredLayer-2; i>=coveredLayer; i--)
    //             rst.add(matrix[rows-coveredLayer-1][i]);
                
    //         for(int i = rows-coveredLayer-2; i>= coveredLayer+1; i--)
    //             rst.add(matrix[i][coveredLayer]);
            
    //         coveredLayer++;
    //     }
    //     return rst;
    // }
}   
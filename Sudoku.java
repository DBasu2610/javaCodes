package javaCodes;

public class Sudoku {
        public static void main(String[] args) {
            int[][] board = new  int[][]{
                     {3, 0, 6, 5, 0, 8, 4, 0, 0},
                     {5, 2, 0, 0, 0, 0, 0, 0, 0},
                     {0, 8, 7, 0, 0, 0, 0, 3, 1},
                     {0, 0, 3, 0, 1, 0, 0, 8, 0},
                     {9, 0, 0, 8, 6, 3, 0, 0, 5},
                     {0, 5, 0, 0, 9, 0, 6, 0, 0},
                     {1, 3, 0, 0, 0, 0, 2, 5, 0},
                     {0, 0, 0, 0, 0, 0, 0, 7, 4},
                     {0, 0, 5, 2, 0, 6, 3, 0, 0}
            };
    
            if(solve(board)) {
                display(board);
            } else {
                System.out.println("Cannot solve! Please try again!");
            }
    
        }
        static boolean solve(int[][] board) {
            int row = -1;
            int col = -1;
            boolean left = true;
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board.length; j++) {
                    if(board[i][j]==0) {
                        row = i;
                        col = j;
                        left= false;
                        break;
                    }
                }
                if(left==false) {
                    break;
                }
            }
            if(left == true) {
                return  true;
            }
            for (int n = 0; n <= 9 ; n++) {
                if(valid(board,row,col,n)) {
                    board[row][col] = n;
                    if(solve(board)) {
                        return  true;
                    } else {
                        board[row][col] = 0;
                    }
                }
            }
            return false;
        }
    
        private static void display(int[][] board) {
            for(int[] row : board) {
                for(int num : row) {
                    System.out.print(num + " ");
                }
                System.out.println();
            }
        }
    
        static  boolean valid(int board[][], int row, int col, int num) {
            for (int i = 0; i < board.length ; i++) {
                if(board[row][col]== num) {
                    return  false;
                }
            }
            for (int[] number : board) {
                if(number[col] == num) {
                    return  false;
                }
            }
            int sqrt = (int)(Math.sqrt(board.length));
            int rstart = row - row%sqrt;
            int cstart = col - col%sqrt;
    
            for(int r=rstart ; r< rstart + sqrt; r++) {
                for (int c = cstart; c < cstart+sqrt ; c++) {
                    if(board[r][c]==num) {
                        return  false;
                    }
                }
            }
            return  true;
        }
     
    
}

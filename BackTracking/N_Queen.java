package BackTracking;

import java.util.Scanner;


public class N_Queen {

    static Scanner sc = new Scanner(System.in);
    public static void placeNQueens(int n) {
        int[][] board = new int[n][n];
        placeQueen(board, 0, n);
    }

    private static void placeQueen(int[][] board, int row, int n) {
        if(row == n) {
            // We have reached some solution 
            // Print the board matrix and return 
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    System.out.print(board[i][j] + " ");
                }
            }
            System.out.println();
        }
        // Place at all possible positions and move to smaller problem
        for(int j = 0; j < n; j++) {
            if(isBoardSafe(board, row, j)) {
                board[row][j] = 1;
                placeQueen(board, row + 1, n);
                board[row][j] = 0;
            }
        }
    }

    private static boolean isBoardSafe(int board[][], int row, int col) {
        int n = board.length;
        // Same Column
        for(int i = row-1; i >= 0; i--) {
            if(board[i][col] == 1) {
                return false;
            }
        }
        // Upper Left Diagonal
        for(int i = row-1, j = col-1; i >= 0 && j >= 0; i--, j--) {
            if(board[i][j] == 1) {
                return false;
            }
        }
        // Upper Right Diagonal
        for(int i = row-1, j = col+1; i >= 0 && j < n; i--, j++) {
            if(board[i][j] == 1) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.print("Enter Number of Queens N: ");
        int N = sc.nextInt();
        placeNQueens(N);
    }
    
}

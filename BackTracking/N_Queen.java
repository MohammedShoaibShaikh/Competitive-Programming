/* // +++++++++++++++++++++++++++++++++++++++++++++++++++++++ N-Queen Problem +++++++++++++++++++++++++++++++++++++++++++++++++++++++ //

You are given N, and for a given N x N chessboard, find a way to place N queens such that no queen can attack any other queen on the chess board. 
A queen can be killed when it lies in the same row, or same column, or the same diagonal of any of the other queens. You have to print all such configurations.
Note: Don't print anything if there isn't any valid configuration.

Input Format:
The first line of input contains an integer, that denotes the value of N.  

Output Format :
In the output, you have to print every board configuration in a new line. Every configuration will have N*N board elements printed row wise and are separated by space.
The cells where queens are safe and placed, are denoted by value 1 and remaining all cells are denoted by value 0. Please refer to sample test cases for more clarity.

Constraints :
1 <= N <= 10
Time Limit: 1 second

Sample Input 1:
4
Sample Output 1 :
0 1 0 0 0 0 0 1 1 0 0 0 0 0 1 0 
0 0 1 0 1 0 0 0 0 0 0 1 0 1 0 0 

Explanation:
The first and second configuration are shown in the image below. Here, 1 denotes the placement of a queen and 0 denotes an empty cell. 
Please note that in both the configurations, no pair of queens can kill each other. 
*/

/* ----------- Time Complexity: O(M*(log(M) + log(N))) -----------
   ----------- Space Complexity: O(M+N) -----------
   Where M is the number of roads
   and N is the number of cities
*/

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
/* // ++++++++++++++++++++++++++++++++++++++++++++++++++++++++ Rat In A Maze Problem ++++++++++++++++++++++++++++++++++++++++++++++++++++++++ //

You are given an integer N and a binary 2D array of size N*N. The given binary matrix represents a maze and a rat starts from the top left cell 
and has to reach to the bottom right cell of the maze. The rat can move in all the four directions: up, down, left and right.

In the given binary matrix, 0 signifies the cell is a dead end and 1 signifies the cell can be used to move from source to destination cell.
You have to print all the paths, following which rat can move from the top left cell to the bottom right cell of the given binary matrix.

Input Format
The first line of input contains an integer, that denotes the value of N.
Each of the following N lines denote rows of the binary matrix and contains either 0 or 1. Each row of the binary matrix contains N elements. 

Output Format :
Every possible solution has to be printed on a separate line. Each of the possible solution will have N*N elements, printed row wise and separated by space. 
The cells that are part of the path should be 1 and remaining all cells should be 0. Please refer to sample test cases for more clarity.

Constraints
1 <= N <= 18
0 <= Number of cells with value 1 <= 15
Time Limit: 1 second

Sample Input 1 :
3
1 0 1
1 0 1
1 1 1
Sample Output 1 :
1 0 0 1 0 0 1 1 1 
Explanation :
Only 1 path is possible. The path is shown in the image below.

Sample Input 2 :
3
1 0 1
1 1 1
1 1 1
Sample Output 2 :
1 0 0 1 1 1 1 1 1 
1 0 0 1 0 0 1 1 1 
1 0 0 1 1 0 0 1 1 
1 0 0 1 1 1 0 0 1 
Explanation:
 As described in the Sample Output 2, four paths are possible.
*/

/* ----------- Time Complexity: O(2^k) -----------
   ----------- Space Complexity: O(N^2) -----------
   Where N is the size of maze
   and k is the number of cells in maze with value equal to one(1)
*/

/*
	Note:
	To get all the test cases accepted, make recursive calls in following order: Top, Down, Left, Right.
	This means that if the current cell is (x, y), then order of calls should be: top cell (x-1, y), 
	down cell (x+1, y), left cell (x, y-1) and right cell (x, y+1).
*/

package BackTracking;

import java.util.Scanner;

public class Rat_In_Maze {

    static Scanner sc = new Scanner(System.in);

    static void printMaze(int[][] solution, int n) {
        System.out.print("Solution: ");
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                System.out.print(solution[i][j] + " ");
            }
        }
        System.out.println();
    }

    private static void solveMaze(int[][] maze, int n, int[][] solution, int x, int y) {
        if(x == n-1 && y == n-1) {
            solution[x][y] = 1;
            printMaze(solution, n);
            return;
        }
        if(x < 0 || y < 0 || maze[x][y] == 0 || solution[x][y] == 1 || x >= n || y >= n) {
            return;
        }
        solution[x][y] = 1;
        solveMaze(maze, n, solution, x-1, y);
        solveMaze(maze, n, solution, x+1, y);
        solveMaze(maze, n, solution, x, y-1);
        solveMaze(maze, n, solution, x, y+1);
        solution[x][y] = 0;
    }
    
    public static void ratInAMaze(int[][] maze, int n) {
        int[][] solution = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                solution[i][j] = 0;
            }
        }
        solveMaze(maze, n, solution, 0, 0);
    }

    public static void main(String[] args) {
        System.out.print("Enter Value of Matrix Size N: ");
        int N = sc.nextInt();
        int[][] maze = new int[20][20];
        System.out.print("Enter Values of Maze: ");
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                maze[i][j] = sc.nextInt();
            }
        }
        ratInAMaze(maze, N);
    }
}
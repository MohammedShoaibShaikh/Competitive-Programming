package Intro_To_DSA.CharaArrays_And_2dArrays;
import java.util.Scanner;

public class Print2dArray {
    static void print2dArray(int input[][]) {
        int k = input.length;
        for(int i = 0; i < input.length; i++) {
            for(int x = k; x > 0; x--) {
                for(int j = 0; j < input[i].length; j++) {
                    System.out.print(input[i][j] + " ");
                }
                System.out.println();
            }
            k -= 1;
        }
    }
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter Value of row: ");
            int row = sc.nextInt();
            System.out.print("Enter Value of col: ");
            int col = sc.nextInt();
            int [][] arr = new int[row][col];
            System.out.println("Enter Values: ");
            for(int i = 0; i < row; i++) {
                for(int j = 0; j < col; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            System.out.println("Output: ");
            print2dArray(arr);
        }
    }
}

package Competitive_Programming.Recursion;
import java.util.Scanner;

public class SumOfArray {
    static Scanner sc = new Scanner(System.in);
    static int sumOfArray(int[] arr, int n) {
        if(n < 0) return 0;
        return arr[n] + sumOfArray(arr, n-1);
    }
    public static void main(String[] args) {
        System.out.print("Enter the Size Array N: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter Elements of Array: ");
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int sum = sumOfArray(arr, n-1);
        System.out.print("Sum of Array: " + sum);
    }
}
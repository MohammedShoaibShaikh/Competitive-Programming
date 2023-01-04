package Competitive_Programming.Recursion;
import java.util.Scanner;

public class AllIndicesOfNumber {
    static Scanner sc = new Scanner(System.in);
    static void findIndex(int[] arr, int k, int index) {
        if(index >= arr.length) {
            return;
        }
        if(arr[index] == k) {
            System.out.print(index + " ");
        }
        findIndex(arr, k, index+1);
        return;
    }
    public static void main(String[] args) {
        System.out.print("Enter size of Array N: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter Elements of Array: ");
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.print("Enter Value of K: ");
        int k = sc.nextInt();
        findIndex(arr, k, 0);
    }
}
package DP_1;
import java.util.Scanner;

public class Fibonacci_Using_Dp {
    static Scanner sc = new Scanner(System.in);
    // 3. Dynamic Programming (Bottom-up approach) [Iterative], Best approach. Time Complexity - O(n)
    static int fib_1(int n) {
        int[] arr = new int[n+1];
        arr[0] = 0;
        arr[1] = 1;
        for(int i = 2; i <= n; i++) {
            arr[i] = arr[i-1] + arr[i-2];
        }
        return arr[n];
    }

    // 2. Memorization (Top-down approach) [Recursive], but more funtion calls than DP approach. Time Complexity - O(n)
    static int fib_helper(int n, int[] arr) {
        if(n <= 1) {
            return n;
        }

        // Checks if ans already exixts
        if(arr[n] != -1) {
            return arr[n];
        }

        // Calculate the Output
        int a = fib_helper(n-1, arr);
        int b = fib_helper(n-2, arr);

        // Save the Output for Further Use
        arr[n] = a + b;

        // Return the final Output
        return arr[n];
    }
    static int fib(int n) {
        int[] arr = new int[n+1];
        for(int i = 0; i <= n; i++) {
            arr[i] = -1;
        }
        return fib_helper(n, arr);
    }

    // 1. Brute Force Approach Time Complexity - O(2^n)
    static int fibo(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;
        int next = fib(n-1) + fib(n-2);
        return next;
    }
    public static void main(String[] args) {
        System.out.print("Enter Value of N: ");
        int n = sc.nextInt();
        int ans = fib(n);
        int ans1 = fib_1(n);
        int ans2 = fibo(n);
        System.out.println("The nth Fibonacci Number using Brute-Force is " + ans2);
        System.out.println("The nth Fibonacci Number using Memorizaton-tech is " + ans);
        System.out.println("The nth Fibonacci Number using DP-tech is " + ans1);
    }
}

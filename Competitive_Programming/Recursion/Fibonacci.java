package Competitive_Programming.Recursion;
import java.util.Scanner;

public class Fibonacci {
    static Scanner sc = new Scanner(System.in);
    static int fib(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;
        int next = fib(n-1) + fib(n-2);
        return next;
    }
    public static void main(String[] args) {
        System.out.print("Enter the Value of N: ");
        int n = sc.nextInt();
        int ans = fib(n);
        System.out.println(n + "th fibonacci number is " + ans);
    }
}
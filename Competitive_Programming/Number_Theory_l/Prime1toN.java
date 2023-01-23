package Competitive_Programming.Number_Theory_l;
import java.util.Scanner;

public class Prime1toN {
    static Scanner sc = new Scanner(System.in);
    static boolean isPrime(int n) {
        if(n == 1) return false;
        for(int i = 2; i*i <= n; i++) {
            if(n % i == 0) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.print("Enter Value of N: ");
        int n = sc.nextInt();
        for(int i = 1; i <= n; i++) {
            if(isPrime(i) == true) System.out.print(i + " ");
        }
    }
   
}

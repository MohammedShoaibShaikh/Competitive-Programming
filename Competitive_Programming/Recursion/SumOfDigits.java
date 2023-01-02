package Competitive_Programming.Recursion;
import java.util.Scanner;

public class SumOfDigits {
    static Scanner sc = new Scanner(System.in);
    static int sumOfDigit(int n){
        if(n == 0) return 0;
        int mod = n % 10;
        int div = n / 10;
        return mod + sumOfDigit(div);
    }
    public static void main(String[] args) {
        System.out.print("Enter the Number N: ");
        int n = sc.nextInt();
        int sum = sumOfDigit(n);
        System.out.println("Sum of Digit: " + sum);
    }
}
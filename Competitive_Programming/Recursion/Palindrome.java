package Competitive_Programming.Recursion;
import java.util.Scanner;

public class Palindrome {
    static Scanner sc = new Scanner(System.in);
    public static boolean checkPalindrome(String input) {
        int start = 0;
        int last = input.length() - 1;
        if(start >= last) {
            return true;
        }
        if(input.charAt(start) != input.charAt(last)) return false;
        return checkPalindrome(input.substring(1, input.length()-1));
    }
    public static void main(String[] args) {
        System.out.print("Enter the String: ");
        String n = sc.next();
        System.out.print("Palindrome: " + checkPalindrome(n));
    }
}
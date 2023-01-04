package Competitive_Programming.Recursion;
import java.util.Scanner;

public class StringToInt {
    static Scanner sc = new Scanner(System.in);
    static int strToInt(String n) {
        if(n.length() == 1) {
            return n.charAt(0) - '0';
        }
        int smallProb = strToInt(n.substring(0, n.length()-1));
        int lastDigit = n.charAt(n.length()-1) - '0';
        return smallProb * 10 + lastDigit;
    }
    public static void main(String[] args) {
        System.out.print("Enter String: ");
        String n = sc.next();
        System.out.print("The Integer: " + strToInt(n));
    }
}

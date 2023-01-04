package Competitive_Programming.Recursion;
import java.util.Scanner;

public class RemoveConsecutiveDuplicate {
    static Scanner sc = new Scanner(System.in);
    static String removeDuplicate(String input) {
        if(input.length() <= 1) {
            return input;
        }
        if(input.charAt(0) == input.charAt(1)) {
            return removeDuplicate(input.substring(1));
        }
        return input.charAt(0) + removeDuplicate(input.substring(1));
    }
    public static void main(String[] args) {
        System.out.print("Enter String: ");
        String input = sc.next();
        System.out.print("Output: " + removeDuplicate(input));
    }   
}

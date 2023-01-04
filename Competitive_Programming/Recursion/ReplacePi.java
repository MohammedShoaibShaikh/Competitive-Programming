package Competitive_Programming.Recursion;
import java.util.Scanner;

public class ReplacePi {
    static Scanner sc = new Scanner(System.in);
    static String replacePi(String input) {
        if(input.length() <= 1) {
            return input;
        }
        if(input.charAt(0) == 'p' && input.charAt(1) == 'i') {
            return "3.14" + replacePi(input.substring(2));
        }
        return  input.charAt(0) + replacePi(input.substring(1));
    }
    public static void main(String[] args) {
        System.out.print("Enter String: "); // abcpippied - 10
        String input = sc.next();
        System.out.print("Output: " + replacePi(input));
    }
    
}

package Intro_To_DSA.CharaArrays_And_2dArrays;
import java.util.Scanner;

public class ReplaceCharacter {
    static Scanner sc = new Scanner(System.in);
    static String replaceChar(String str, char c1, char c2) {
        String ans = str.replace(c1, c2);
        return ans;
    }
    public static void main(String[] args) {
        System.out.print("Enter String: ");
        String str = sc.nextLine();
        System.out.print("Enter to Char1 and Char2: ");
        char c1 = sc.next().charAt(0);
        char c2 = sc.next().charAt(0);
        String output = replaceChar(str, c1, c2);
        System.out.print("Output String: " + output);
    }  
}
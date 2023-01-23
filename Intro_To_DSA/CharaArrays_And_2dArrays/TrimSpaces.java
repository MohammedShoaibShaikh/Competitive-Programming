package Intro_To_DSA.CharaArrays_And_2dArrays;
import java.util.Scanner;
public class TrimSpaces {
    static Scanner sc = new Scanner(System.in);
    static String trimSpaces(String input) {
        String ans = "";
        for(int i = 0; i < input.length(); i++) {
            if(input.charAt(i) != ' '){
                ans += input.charAt(i);
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.print("Enter String: ");
        String str = sc.nextLine();
        String output = trimSpaces(str);
        System.out.print("Output String: " + output);
    }
}
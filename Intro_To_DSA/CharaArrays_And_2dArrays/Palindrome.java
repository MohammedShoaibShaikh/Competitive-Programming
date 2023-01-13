package Intro_To_DSA.CharaArrays_And_2dArrays;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Palindrome {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static boolean Palindrome_Check(String input) {
        int left = 0;
        int right = input.length() - 1;
        boolean flag = true;
        while(left <= right) {
            if(input.charAt(left) != input.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return flag;
    }
    public static void main(String[] args) throws NumberFormatException, IOException{
        System.out.print("Enter String: ");
        String str = br.readLine();
        if(str != null) str = str.trim();
        else str = "";

        boolean ans = Palindrome_Check(str);
        System.out.print(ans);
    }
}

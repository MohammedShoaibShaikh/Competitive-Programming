package Intro_To_DSA.CharaArrays_And_2dArrays;
import java.util.Scanner;

public class MinimumLengthWord {

    static String minlengthWord(String input) {
        int minStart = -1;
        int minLength = Integer.MAX_VALUE;
        int currentStart = 0;
        int i = 0;
        for(; i < input.length(); i++) {
            if(input.charAt(i) == ' ') {
                int currentWordLength = i - currentStart;
                if(currentWordLength < minLength) {
                    minStart = currentStart;
                    minLength = currentWordLength;
                }
                currentStart = i + 1;
            }
        }
        if(minStart == -1) return input;
        else {
            int currentWordLength = i - currentStart;
            if(currentWordLength < minLength) {
                minStart = currentStart;
                minLength = currentWordLength;
            }
            return input.substring(minStart, minStart + minLength);
        }
    }
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter the String: ");
            String str = sc.nextLine();
            String output = minlengthWord(str);
            System.out.print("Smallest Word is: " + output);
        }
    }
}

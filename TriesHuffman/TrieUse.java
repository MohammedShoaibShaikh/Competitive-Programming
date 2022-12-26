package TriesHuffman;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;

public class TrieUse {

    public static void main(String[] args) throws IOException {
        Trie T = new Trie();
        // Adding Word in Trie
        T.add("and");
        T.add("are");
        T.add("dot");
        T.add("an");
        // Searching Word In Trie
        System.out.println("Word And: " + T.search("and"));
        // Remove Word from Trie
        T.remove("and");
        // Searching Word After Removing
        System.out.println("word And: " + T.search("and"));

        // ---------------------------- Questions ---------------------------- //
        try (
        Scanner sc = new Scanner(System.in)) {

            // Q.1 +++++++++++++++++++++++++++++ Pattern Maching +++++++++++++++++++++++++++++ //
            Trie T1 = new Trie();
            System.out.print("Enter Value of N: ");
            int N = sc.nextInt();
            ArrayList<String> vect = new ArrayList<String>();
            System.out.print("Enter " + N + " Words: ");
            for(int i = 0; i < N; i++) {
                vect.add(sc.next());
            }
            System.out.print("Enter Pattern: ");
            String pattern = sc.next();

            System.out.println("Pattern Present: " + T1.patternMaching(vect, pattern));

            // Q.2 +++++++++++++++++++++++++++++ Plaindrom Pair +++++++++++++++++++++++++++++ //
            Trie T2 = new Trie();
            System.out.print("Enter Value of N1: ");
            int N1 = sc.nextInt();
            ArrayList<String> vect1 = new ArrayList<String>();
            System.out.print("Enter " + N1 + " Words: ");
            for(int i = 0; i < N1; i++) {
                vect1.add(sc.next());
            }
            
            System.out.println("Palindrome Word: " + T2.isPalindromePair(vect1));

            // Q.3 +++++++++++++++++++++++++++++ Auto Complete +++++++++++++++++++++++++++++ //
            Trie T3 = new Trie();
            System.out.print("Enter Value of N2: ");
            int N2 = sc.nextInt();
            ArrayList<String> vect2 = new ArrayList<String>();
            System.out.print("Enter " + N2 + " Words: ");
            for(int i = 0; i < N2; i++) {
                vect2.add(sc.next());
            }
            System.out.print("Enter Pattern: ");
            String pattern1 = sc.next();

            System.out.println("Auto Complete Words: ");
            T3.autoComplete(vect2, pattern1);
        }
  
    }
}

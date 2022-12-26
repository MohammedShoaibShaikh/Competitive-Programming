package TriesHuffman;
import java.util.ArrayList;
class TrieNode {
    char data;
    TrieNode children[];
    boolean isTerminal;
    int childCount;

    public TrieNode(char data) {
        this.data = data;
        children = new TrieNode[26];
        childCount = 0;
        isTerminal = false;
    }    
}

public class Trie {
    private TrieNode root;
    public int count;

    public Trie() {
        root = new TrieNode('\0');
    }

    // ---------------------------------- Questions Start ---------------------------------- //

    // Q.1 +++++++++++++++++++++++++++++ Pattern Maching +++++++++++++++++++++++++++++ //
    public boolean patternMaching(ArrayList<String> vect, String pattern) {
        for(int i = 0; i < vect.size(); i++) {
            String word = vect.get(i);
            for(int j = 0; j < word.length(); j++) {
                add(word.substring(j));
            }
        }
        return search(pattern);
    }

    // Q.2 +++++++++++++++++++++++++++++ Palindrome Pair +++++++++++++++++++++++++++++ //
    public boolean isPalindromePair(ArrayList<String> words) {
        for(String word : words) {
            this.add(reverseWord(word));
        }

        return isPalindromePair(this.root, words);
    }

    private static String reverseWord(String word) {
        String reverse = "";
        for(int i = word.length() - 1; i >= 0; i--) {
            reverse += word.charAt(i);
        }

        return reverse;
    }

    private boolean isPalindromePair(TrieNode root, ArrayList<String> words) {
        if(words == null || words.size() == 0) {
            return false;
        }

        for(String word : words) {
            if(doesPairExistFor(root, word, 0)) {
                return true;
            }
        }

        return false;
    }

    private boolean doesPairExistFor(TrieNode root, String word, int startIndex) {
        /* Since an empty string is always a palindrome, we return 'true' */
        if(word == "") {
            return true;
        }

        if(startIndex == word.length()) {
            if(root.isTerminal) {
                return true;
            }

            return checkRemainingBranchesInTrie(root, "");
        }

        int charIndex = word.charAt(startIndex) - 'a';
        TrieNode correspondingChild = root.children[charIndex];

        if(correspondingChild == null) {
            if(root.isTerminal) {
                return checkWordForPalindrome(word.substring(startIndex));
            }

            return false;
        }

        return doesPairExistFor(correspondingChild, word, (startIndex + 1));
    }

    private boolean checkRemainingBranchesInTrie(TrieNode root, String word) {
        if(root.isTerminal) {
            if(checkWordForPalindrome(word)) {
                return true;
            }
        }

        for(TrieNode childNode : root.children) {
            if(childNode == null) {
                continue;
            }

            String fwd = word + childNode.data;
            if(checkRemainingBranchesInTrie(childNode, fwd)) {
                return true;
            }
        }

        return false;
    }

    private static boolean checkWordForPalindrome(String word) {
        int startIndex = 0;
        int endIndex = word.length() - 1;

        while(startIndex < endIndex) {
            if(word.charAt(startIndex) != word.charAt(endIndex)) {
                return false;
            }

            startIndex += 1;
            endIndex -= 1;
        }

        return true;
    }

    // Q.3 +++++++++++++++++++++++++++++ Auto Complete +++++++++++++++++++++++++++++ //
    public TrieNode findRoot(TrieNode root, String word) {
        if(word.length() == 0) {
            return root;
        }
        int childIndex = word.charAt(0) - 'a';
        TrieNode child = root.children[childIndex];
        if(child == null) {
            return null;
        }

        return findRoot(child, word.substring(1));
    }

    public void autoComplete(ArrayList<String> input, String word) {
        for(String w : input) {
            add(w);
        }
        TrieNode node = findRoot(root, word);
        if(node == null || node.childCount == 0) {
            return;
        }
        String output = "";
        allRootToLeafPaths(node, output, word);
    }

    private void allRootToLeafPaths(TrieNode node, String output, String word) {
        if(node.childCount == 0) {
            if(output.length() > 0) {
                System.out.println(word + output);
            }
            return;
        }
        if(node.isTerminal == true) {
            System.out.println(word + output);
        }
        for(int i = 0; i < node.children.length; i++) {
            if(node.children[i] != null) {
                String ans = output + node.children[i].data;
                allRootToLeafPaths(node.children[i], ans, word);
            }
        }
    }

    // ------------------------------------- Questions End ------------------------------------ //

    private void add(TrieNode root, String word) {
        // Base Case
        if(word.length() == 0) {
            root.isTerminal = true;
            return;
        }

        // Small Calculation
        int childIndex = word.charAt(0) - 'a';
        TrieNode child = root.children[childIndex];
        if(child == null) {
            child = new TrieNode(word.charAt(0));
            root.children[childIndex] = child;
            root.childCount++;
        }
        // Recursive Call
        add(child, word.substring(1));
    }

    // For User (Inserting Word)
    public void add(String word) {
        add(root, word);
    }

    boolean search(TrieNode root, String word) {
        // Base Case
        if(word.length() == 0) {
            return root.isTerminal;
        }

        // Small Calculation
        int childIndex = word.charAt(0) - 'a';
        TrieNode child = root.children[childIndex];
        if(child == null) {
            return false;
        }

        // Recursive Call
        return search(child, word.substring(1));
    }

    // For User
    public boolean search(String word) {
        return search(root, word);
    }

    private void remove(TrieNode root, String word) {
        // Base Case
        if(word.length() == 0) {
            root.isTerminal = false;
            return;
        }

        // Small Calculation
        int childIndex = word.charAt(0) - 'a';
        TrieNode child = root.children[childIndex];
        if(child == null){
            return;
        }

        // Recursive Call 
        remove(child, word.substring(1));

    }

    // For User
    public void remove(String word) {
        remove(root, word);
    }
}
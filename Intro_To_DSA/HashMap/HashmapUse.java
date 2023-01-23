package Intro_To_DSA.HashMap;
import java.util.HashMap;
public class HashmapUse {
    public static void main(String[] args) {
        HashMap<String, Integer> ourmap = new HashMap<>();
        ourmap.put("abc", 10);
        ourmap.put("bcd", 20);
        ourmap.put("cd", 20);
        // Find or Access
        System.out.println(ourmap.get("abc"));
        System.out.println(ourmap.get("bcd"));
        System.out.println(ourmap.size());
    }
}

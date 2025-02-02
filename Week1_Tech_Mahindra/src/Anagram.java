import java.util.*;

public class Anagram {
    
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s.length() < p.length()) return result;
        
        int[] pCount = new int[26];
        for (char c : p.toCharArray()) {
            pCount[c - 'a']++;
        }
        
        int[] sCount = new int[26];
        for (int i = 0; i < p.length(); i++) {
            sCount[s.charAt(i) - 'a']++;
        }
        
        if (Arrays.equals(sCount, pCount)) {
            result.add(0);
        }
        
        for (int i = p.length(); i < s.length(); i++) {
            sCount[s.charAt(i) - 'a']++;
            sCount[s.charAt(i - p.length()) - 'a']--;
            
            if (Arrays.equals(sCount, pCount)) {
                result.add(i - p.length() + 1);
            }
        }
        
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter string s ******: ");
        String s = sc.next();
        
        System.out.println("Enter string p *****: ");
        String p = sc.next();
        
        List<Integer> anagramIndices = findAnagrams(s, p);
        System.out.println("Anagram indices ******: " + anagramIndices);
        
        sc.close();
    }
}

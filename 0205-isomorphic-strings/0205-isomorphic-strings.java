import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false; // Strings of different lengths can't be isomorphic
        }

        Map<Character, Character> mapST = new HashMap<>(); // Maps characters from s to t
        Map<Character, Character> mapTS = new HashMap<>(); // Maps characters from t to s

        for (int i = 0; i < s.length(); i++) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);

            // Check if mapping for charS exists and is consistent
            if (mapST.containsKey(charS)) {
                if (mapST.get(charS) != charT) {
                    return false;
                }
            } else {
                mapST.put(charS, charT);
            }

            // Check if mapping for charT exists and is consistent
            if (mapTS.containsKey(charT)) {
                if (mapTS.get(charT) != charS) {
                    return false;
                }
            } else {
                mapTS.put(charT, charS);
            }
        }

        return true;
    }
}

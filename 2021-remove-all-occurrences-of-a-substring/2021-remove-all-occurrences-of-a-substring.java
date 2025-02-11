class Solution {
    public String removeOccurrences(String s, String part) {
        
        while(s.contains(part)){// This is for finding the part in the string
            s = s.replaceFirst(part, "");//this is using for remove the parts from string and store the remaining string insise the s
        }
        return s; // return the String
    }
}
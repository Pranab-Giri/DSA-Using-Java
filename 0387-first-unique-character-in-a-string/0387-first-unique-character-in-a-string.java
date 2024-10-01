class Solution {
    public int firstUniqChar(String s) {
        Map<Character, Integer> freqMap = new HashMap<>();

        // Count the Occurance of each character
        for(char ch : s.toCharArray()){
            freqMap.put(ch, freqMap.getOrDefault(ch, 0)+1);
        }
        //Find the first character with frequency 1
        for(int i=0; i<s.length(); i++){
            if(freqMap.get(s.charAt(i)) == 1){
                return i;
            }
        }
        return -1;
    }
}
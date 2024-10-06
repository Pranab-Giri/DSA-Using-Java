class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        String[] words1 = sentence1.split(" ");
        String[] words2 = sentence2.split(" ");
        
        // If sentence1 is shorter, swap them to ensure that sentence1 is the longer one.
        if (words1.length < words2.length) {
            return areSentencesSimilar(sentence2, sentence1);
        }
        
        int i = 0, j = 0;
        // Check for the longest matching prefix
        while (i < words2.length && words1[i].equals(words2[i])) {
            i++;
        }
        
        // Check for the longest matching suffix
        while (j < words2.length && words1[words1.length - 1 - j].equals(words2[words2.length - 1 - j])) {
            j++;
        }
        
        // After removing the matching prefix and suffix, the middle part should be empty in sentence2
        return i + j >= words2.length;
    }
}

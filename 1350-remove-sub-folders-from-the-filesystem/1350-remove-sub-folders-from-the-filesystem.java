import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<String> removeSubfolders(String[] folder) {
        // Step 1: Sort the folder paths lexicographically
        Arrays.sort(folder);
        
        List<String> result = new ArrayList<>();
        
        // Step 2: Traverse the sorted list and filter out sub-folders
        String lastFolder = "";  // Tracks the last added folder in the result list
        
        for (String f : folder) {
            // Check if `f` is a sub-folder of `lastFolder`
            if (lastFolder.isEmpty() || !f.startsWith(lastFolder + "/")) {
                result.add(f);  // Add `f` to the result list
                lastFolder = f; // Update `lastFolder` to the current folder `f`
            }
        }
        
        return result;
    }
}

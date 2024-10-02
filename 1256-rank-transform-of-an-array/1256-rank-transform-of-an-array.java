import java.util.HashMap;
class Solution {
    public int[] arrayRankTransform(int[] arr) {
        if(arr.length == 0){ // If array length is zero then return empty array
            return new int[0];
        }
        // Step:1 Create a sorted copy of the array

        int sortedArr[] = arr.clone();
        Arrays.sort(sortedArr);
        // create a rank mapping for unique elements
        HashMap<Integer, Integer> rankMap = new HashMap<>();
        int rank = 1;
        //Assign the rank to each unique element
        for(int num : sortedArr){
            if(!rankMap.containsKey(num)){
                rankMap.put(num, rank++);
            }
        }
        // replace element to the original array with their rank
        int[] result = new int[arr.length];
        for(int i=0; i<arr.length; i++){
            result[i] = rankMap.get(arr[i]);
        }
        return result;
    }
}
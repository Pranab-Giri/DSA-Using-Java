import java.util.*;

class NumberContainers {
    private Map<Integer, Integer> indexToNumber;  // Maps index to number
    private Map<Integer, PriorityQueue<Integer>> numberToIndices; // Maps number to min heap of indices

    public NumberContainers() {
        indexToNumber = new HashMap<>();
        numberToIndices = new HashMap<>();
    }
    
    public void change(int index, int number) {
        if (indexToNumber.containsKey(index)) {
            int oldNumber = indexToNumber.get(index);
            if (oldNumber != number) {
                numberToIndices.get(oldNumber).remove(index); // Remove old index
            }
        }
        
        indexToNumber.put(index, number); // Update index to new number
        numberToIndices.putIfAbsent(number, new PriorityQueue<>());
        numberToIndices.get(number).offer(index);
    }
    
    public int find(int number) {
        if (!numberToIndices.containsKey(number) || numberToIndices.get(number).isEmpty()) {
            return -1;
        }

        PriorityQueue<Integer> minHeap = numberToIndices.get(number);

        // Remove stale indices (ensuring index-to-number consistency)
        while (!minHeap.isEmpty() && indexToNumber.get(minHeap.peek()) != number) {
            minHeap.poll();
        }

        return minHeap.isEmpty() ? -1 : minHeap.peek();
    }

   
}


/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */
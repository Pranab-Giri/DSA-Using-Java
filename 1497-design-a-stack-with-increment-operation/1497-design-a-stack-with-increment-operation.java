class CustomStack {
  private int[] stack; // Array to store stack elements
  private int[] increment; // Array to store increment values for bottm k elements
  private int maxSize; // Maximu size of the stack;
  private int size; // current size of the stack
    public CustomStack(int maxSize) {
        this.stack = new int[maxSize];
        this.increment = new int[maxSize];
        this.maxSize = maxSize;
        this.size = 0; // Stck is initially empt
    }
    
    //Push operation: adds element x if stak is not full
    public void push(int x) {
        if(size < maxSize){
            stack[size] = x;
            size++;  //Increse the size
        }
    }
    
    // Pop operation: remobves and returns the top elements pr -1 if stack is empty
    public int pop() {
        if(size == 0){
            return -1;
        }
        size--; // decrease size
        int result = stack[size] + increment[size]; // Apply incement
        if(size > 0){
            increment[size-1] += increment[size]; // carry over the increment to the previous element
        }
        increment[size] = 0;
        return result;

    }
    
    public void increment(int k, int val) {
        int limit = Math.min(k, size); // Ensure we don't go beyond the  number of elements in the stack
        if(limit > 0){
            increment[limit-1] += val;
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */
import java.util.LinkedList;
import java.util.Queue;

class MyStack {
    Queue<Integer> q1;  // Primary queue holding stack elements
    Queue<Integer> q2;  // Auxiliary queue for push operation

    // Constructor to initialize the queues.
    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }
    
    // Push element x to the top of the stack.
    public void push(int x) {
        // Push the new element into q2
        q2.add(x);

        // Move all elements from q1 to q2
        while (!q1.isEmpty()) {
            q2.add(q1.remove());
        }

        // Swap the names of q1 and q2
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }
    
    // Removes the element on the top of the stack and returns it.
    public int pop() {
        if (!q1.isEmpty()) {
            return q1.remove();
        }
        return -1;  // Shouldn't happen as per problem statement
    }
    
    // Get the top element without removing it.
    public int top() {
        if (!q1.isEmpty()) {
            return q1.peek();
        }
        return -1;  // Shouldn't happen as per problem statement
    }
    
    // Return whether the stack is empty.
    public boolean empty() {
        return q1.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */

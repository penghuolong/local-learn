import java.util.Stack;

public class Shoppe_MyQueue_032 {
    /**
     * Initialize your data structure here.
     */
    Stack<Integer> first;
    Stack<Integer> second;
    int size;

    public Shoppe_MyQueue_032() {
        first = new Stack<>();
        second = new Stack<>();
        size = 0;
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        first.push(x);
        size++;
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        if(second.empty()){
            while (!first.empty()) {
                second.push(first.pop());
            }
        }
        Integer pop = second.pop();
        size--;
        return pop;
    }

    /**
     * Get the front element.
     */
    public int peek() {
        if(second.empty()){
            while (!first.empty()) {
                second.push(first.pop());
            }
        }
        return second.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return size==0;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */

package challenges.datastructures.queues;

import java.util.Stack;

class MyQueue<T> {
    Stack<T> stackNewestOnTop = new Stack<>();
    Stack<T> stackOldestOnTop = new Stack<>();

    void enqueue(T value) { // Push onto newest stack
        stackNewestOnTop.push(value);
    }

    T peek() {
        shift();
        return stackOldestOnTop.peek();
    }

    T dequeue() {
        shift();
        return stackOldestOnTop.pop();
    }

    private void shift() {
        T elem;
        if(stackOldestOnTop.empty() && !stackNewestOnTop.empty()) {
            while(!stackNewestOnTop.empty()) {
                elem = stackNewestOnTop.peek();
                stackNewestOnTop.pop();
                stackOldestOnTop.push(elem);
            }
        }
    }
}

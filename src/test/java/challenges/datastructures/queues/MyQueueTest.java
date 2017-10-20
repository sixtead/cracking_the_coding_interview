package challenges.datastructures.queues;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyQueueTest {
    @Test
    void enqueue() {
        MyQueue<Integer> queue = new MyQueue<>();
        queue.enqueue(5);
        assertEquals((Integer) 5, queue.stackNewestOnTop.peek());
        queue.enqueue(4);
        assertEquals((Integer) 4, queue.stackNewestOnTop.peek());
        assertEquals(2, queue.stackNewestOnTop.size());
        assertEquals(0, queue.stackOldestOnTop.size());
    }

    @Test
    void peek() {
        MyQueue<Integer> queue = new MyQueue<>();
        queue.enqueue(5);
        assertEquals((Integer) 5, queue.stackNewestOnTop.peek());
        queue.enqueue(4);
        assertEquals((Integer) 4, queue.stackNewestOnTop.peek());
        assertEquals(2, queue.stackNewestOnTop.size());
        assertEquals(0, queue.stackOldestOnTop.size());
        assertEquals((Integer) 5 ,queue.peek());
        assertEquals(0, queue.stackNewestOnTop.size());
        assertEquals(2, queue.stackOldestOnTop.size());
        queue.enqueue(6);
        assertEquals((Integer) 6, queue.stackNewestOnTop.peek());
        assertEquals(1, queue.stackNewestOnTop.size());
        assertEquals(2, queue.stackOldestOnTop.size());
    }

    @Test
    void dequeue() {
        MyQueue<Integer> queue = new MyQueue<>();
        queue.enqueue(5);
        assertEquals((Integer) 5, queue.stackNewestOnTop.peek());
        queue.enqueue(4);
        assertEquals((Integer) 4, queue.stackNewestOnTop.peek());
        assertEquals(2, queue.stackNewestOnTop.size());
        assertEquals(0, queue.stackOldestOnTop.size());
        assertEquals((Integer) 5 ,queue.dequeue());
        assertEquals(0, queue.stackNewestOnTop.size());
        assertEquals(1, queue.stackOldestOnTop.size());
        queue.enqueue(6);
        assertEquals((Integer) 6, queue.stackNewestOnTop.peek());
        assertEquals(1, queue.stackNewestOnTop.size());
        assertEquals(1, queue.stackOldestOnTop.size());
    }

}
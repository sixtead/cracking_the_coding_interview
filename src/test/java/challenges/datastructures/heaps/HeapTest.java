package challenges.datastructures.heaps;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HeapTest {
    @Test
    void getParent() {
        Heap heap = new MinHeap();
        for(int i = 0; i < 15; i++) {
            heap.add(i+1);
        }
        assertEquals(-1, heap.getParent(0));
        assertEquals(0, heap.getParent(1));
        assertEquals(0, heap.getParent(2));
        assertEquals(1, heap.getParent(3));
        assertEquals(1, heap.getParent(4));
        assertEquals(2, heap.getParent(5));
        assertEquals(2, heap.getParent(6));
        assertEquals(3, heap.getParent(7));
        assertEquals(3, heap.getParent(8));
        assertEquals(4, heap.getParent(9));
        assertEquals(4, heap.getParent(10));
        assertEquals(5, heap.getParent(11));
        assertEquals(5, heap.getParent(12));
        assertEquals(6, heap.getParent(13));
        assertEquals(6, heap.getParent(14));
    }

    @Test
    void getLeftChild() {
        Heap heap = new MinHeap();
        for(int i = 0; i < 15; i++) {
            heap.add(i+1);
        }
        assertEquals(1, heap.getLeftChild(0));
        assertEquals(3, heap.getLeftChild(1));
        assertEquals(5, heap.getLeftChild(2));
        assertEquals(7, heap.getLeftChild(3));
        assertEquals(9, heap.getLeftChild(4));
        assertEquals(11, heap.getLeftChild(5));
        assertEquals(13, heap.getLeftChild(6));
        assertEquals(-1, heap.getLeftChild(7));
        assertEquals(-1, heap.getLeftChild(8));
        assertEquals(-1, heap.getLeftChild(9));
        assertEquals(-1, heap.getLeftChild(10));
        assertEquals(-1, heap.getLeftChild(11));
        assertEquals(-1, heap.getLeftChild(12));
        assertEquals(-1, heap.getLeftChild(13));
        assertEquals(-1, heap.getLeftChild(14));
    }

    @Test
    void getRightChild() {
        Heap heap = new MinHeap();
        for(int i = 0; i < 15; i++) {
            heap.add(i+1);
        }
        assertEquals(2, heap.getRightChild(0));
        assertEquals(4, heap.getRightChild(1));
        assertEquals(6, heap.getRightChild(2));
        assertEquals(8, heap.getRightChild(3));
        assertEquals(10, heap.getRightChild(4));
        assertEquals(12, heap.getRightChild(5));
        assertEquals(14, heap.getRightChild(6));
        assertEquals(-1, heap.getRightChild(7));
        assertEquals(-1, heap.getRightChild(8));
        assertEquals(-1, heap.getRightChild(9));
        assertEquals(-1, heap.getRightChild(10));
        assertEquals(-1, heap.getRightChild(11));
        assertEquals(-1, heap.getRightChild(12));
        assertEquals(-1, heap.getRightChild(13));
        assertEquals(-1, heap.getRightChild(14));
    }

    @Test
    void swap() {
        Heap heap = new MinHeap();
        for(int i = 0; i < 15; i++) {
            heap.add(i);
        }
        assertEquals(1, heap.getAt(1));
        assertEquals(2, heap.getAt(2));
        heap.swap(14, heap.getParent(14));
        assertEquals(14, heap.getAt(6));
        assertEquals(6, heap.getAt(14));
    }

    @Test
    void addMinHeap() {
        int[] elems = new int[] {13, 18, 8, 20, 7, 14, 16, 12, 5};
        int[] expected = new int[] {5, 7, 13, 8, 18, 14, 16, 20, 12};
        Heap heap = new MinHeap();
        for(int e: elems) {
            heap.add(e);
        }
        assertArrayEquals(expected, heap.getData());
    }

    @Test
    void addMaxHeap() {
        int[] elems = new int[] {13, 18, 8, 20, 7, 14, 16, 12, 5};
        int[] expected = new int[] {20, 18, 16, 13, 7, 8, 14, 12, 5};
        Heap heap = new MaxHeap();
        for(int e: elems) {
            heap.add(e);
        }
        assertArrayEquals(expected, heap.getData());
    }

    @Test
    void popMinHeap() {
        int[] elems = new int[] {13, 18, 8, 20, 7, 14, 16, 12, 5};
        int[] expected = new int[] {7, 8, 13, 12, 18, 14, 16, 20};
        Heap heap = new MinHeap();
        for(int e: elems) {
            heap.add(e);
        }
        assertEquals(5, heap.pop());
        assertArrayEquals(expected, heap.getData());
    }

    @Test
    void popMaxHeap() {
        int[] elems = new int[] {13, 18, 8, 20, 7, 14, 16, 12, 5};
        int[] expected = new int[] {18, 13, 16, 12, 7, 8, 14, 5};
        Heap heap = new MaxHeap();
        for(int e: elems) {
            heap.add(e);
        }
        assertEquals(20, heap.pop());
        assertArrayEquals(expected, heap.getData());
    }

}
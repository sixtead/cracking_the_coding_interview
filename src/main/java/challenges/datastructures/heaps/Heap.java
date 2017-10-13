package challenges.datastructures.heaps;

import java.util.ArrayList;

abstract class Heap {
    ArrayList<Integer> data;
    int size;

    int getSize() {
        return size;
    }

    int getAt(int index) throws ArrayIndexOutOfBoundsException {
        return data.get(index);
    }

    int[] getData() {
        return data.stream().mapToInt(i -> i).toArray();
    }

    void add(int e) {
        data.add(e);
        size++;
        heapifyUp();
    }

    int pop() {
        int e = data.get(0);
        swap(0, size - 1);
        data.remove(size - 1);
        size--;
        heapifyDown();
        return e;
    }

    int peek() {
        return getAt(0);
    }

    void move(Heap dest) {
        int e = pop();
        dest.add(e);
    }

    private void heapifyUp() {
        heapifyUp(size - 1);
    }

    abstract void heapifyUp(int index);

    private void heapifyDown() {
        heapifyDown(0);
    }

    abstract void heapifyDown(int index);

    int getParent(int index) {
        if(index > 0) return (index - 1) / 2;
        return -1;
    }

    int getLeftChild(int index) {
        int leftChild = index * 2 + 1;
        return (leftChild < size) ? leftChild : -1;
    }

    int getRightChild(int index) {
        int rightChild = index * 2 + 2;
        return (rightChild < size) ? rightChild : -1;
    }

    int getSmallestChild(int index) {
        int leftChildIndex = getLeftChild(index);
        int rightChildIndex = getRightChild(index);
        if(leftChildIndex > 0) {
            if(rightChildIndex > 0) {
                return (getAt(leftChildIndex) < getAt(rightChildIndex)) ? leftChildIndex : rightChildIndex;
            }
            return leftChildIndex;
        }
        return -1;
    }

    int getLargestChild(int index) {
        int leftChildIndex = getLeftChild(index);
        int rightChildIndex = getRightChild(index);
        if(leftChildIndex > 0) {
            if(rightChildIndex > 0) {
                return (getAt(leftChildIndex) > getAt(rightChildIndex)) ? leftChildIndex : rightChildIndex;
            }
            return leftChildIndex;
        }
        return -1;
    }

    void swap(int index1, int index2) {
        int tmp1 = data.get(index1);
        int tmp2 = data.get(index2);
        data.set(index1, tmp2);
        data.set(index2, tmp1);
    }
}

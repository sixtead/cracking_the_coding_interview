package challenges.datastructures.heaps;

import java.util.ArrayList;

class MinHeap extends Heap {

    MinHeap() {
        this.data = new ArrayList<>();
        this.size = 0;
    }

    @Override
    void heapifyUp(int index) {
        if(index > 0) {
            int parentIndex = getParent(index);
            if(data.get(index) < data.get(parentIndex)) {
                swap(index, parentIndex);
            }
            heapifyUp(parentIndex);
        }
    }

    @Override
    void heapifyDown(int index) {
        int childIndex = getSmallestChild(index);
        if(childIndex > 0) {
            if(getAt(childIndex) < getAt(index)) {
                swap(childIndex, index);
            }
            heapifyDown(childIndex);
        }
    }
}

package challenges.datastructures.heaps;

import java.util.Scanner;

public class Solution {

    public void main(String[] args) {
        solve();
    }

    static void solve() {
        Heap minHeap = new MinHeap();
        Heap maxHeap = new MaxHeap();
        float median = 0;
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        for(int i = 0; i < n; i++) {
            int elem = sc.nextInt();
            add(elem, median, minHeap, maxHeap);
            balance(minHeap, maxHeap);
            median = findMedian(minHeap, maxHeap);
            System.out.println(median);
        }
    }

    private static void add(int e, float m, Heap minHeap, Heap maxHeap) {
        if(e > m) {
            minHeap.add(e);
        } else {
            maxHeap.add(e);
        }
    }

    private static float findMedian(Heap minHeap, Heap maxHeap) {
        if(minHeap.getSize() > maxHeap.getSize()) {
            return (float) minHeap.peek();
        } else if(minHeap.getSize() < maxHeap.getSize()) {
            return (float) maxHeap.peek();
        } else {
            return (float) (minHeap.peek() + maxHeap.peek()) / 2;
        }
    }

    private static void balance(Heap minHeap, Heap maxHeap) {
        if(minHeap.getSize() - maxHeap.getSize() > 1) {
            minHeap.move(maxHeap);
        }
        if(maxHeap.getSize() - minHeap.getSize() > 1) {
            maxHeap.move(minHeap);
        }
    }
}

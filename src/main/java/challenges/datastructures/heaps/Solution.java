//  ** Heaps: Find the Running Median
//
// The median of a dataset of integers is the midpoint value of the dataset for which an equal number of integers are
// less than and greater than the value. To find the median, you must first sort your dataset of integers in
// non-decreasing order, then:
//
// - If your dataset contains an odd number of elements, the median is the middle element of the sorted sample. In the
// sorted dataset `{1, 2, 3}`, `2` is the median.
// - If your dataset contains an even number of elements, the median is the average of the two middle elements of the
// sorted sample. In the sorted dataset `{1, 2, 3, 4}`, `(2+3)/2 = 2.5` is the median.
//
// Given an input stream of `n` integers, you must perform the following task for each `i`-th integer:
//
// 1. Add the `i`-th integer to a running list of integers.
// 2. Find the median of the updated list (i.e., for the first element through the `i`-th element).
// 3. Print the list's updated median on a new line. The printed value must be a double-precision number
// scaled to 1 decimal place (i.e., 12.3 format).
//
//  *Input Format
//
// The first line contains a single integer, `n`, denoting the number of integers in the data stream.
// Each line `i` of the `n` subsequent lines contains an integer, `a_i`, to be added to your list.
//
//  *Constraints
//
// 1 <= n <= 10^5
// 0 <= a_i <= 10^5
//
//  *Output Format
//
// After each new integer is added to the list, print the list's updated median on a new line as a single
// double-precision number scaled to  decimal place (i.e., 12.3 format).
//
//  *Sample Input
//
// 6
// 12
// 4
// 5
// 3
// 8
// 7
//
//  *Sample Output
//
// 12.0
// 8.0
// 5.0
// 4.5
// 5.0
// 6.0
//
//  *Explanation
//
// There are `n=6` integers, so we must print the new median on a new line as each integer is added to the list:
// 1. list = {12}, median = 12.0
// 2. list = {12, 4} -> {4, 12}, median = 8.0
// 3. list = {12, 4, 5} -> {4, 5, 12}, median = 5.0
// 4. list = {12, 4, 5, 3} -> {3, 4, 5, 12}, median = 4.5
// 5. list = {12, 4, 5, 3, 8} -> {3, 4, 5, 8, 12}, median = 5.0
// 6. list = {12, 4, 5, 3, 8, 7} -> {3, 4, 5, 7, 8, 12}, median = 6.0
//
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

package challenges.algorithms.mergesort;

import java.util.Scanner;

public class Solution {

    static void solve() {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int[] arr = new int[n];
            for(int arr_i = 0; arr_i < n; arr_i++){
                arr[arr_i] = in.nextInt();
            }
            long result = countInversions(arr);
            System.out.println(result);
        }
        in.close();
    }

    static long countInversions(int[] arr) {
        int[] aux = arr.clone();
        return mergeSort(arr, aux, 0, arr.length - 1);
    }

    static long mergeSort(int[] arr, int[] aux, int left, int right) {
        long count = 0;
        int middle = (left + right) / 2;
        if(left < right) {
            count += mergeSort(aux, arr, left, middle);
            count += mergeSort(aux, arr, middle + 1, right);
            count += merge(arr, aux, left, middle, right);
        }
        return count;
    }

    private static long merge(int[] arr, int[] aux, int left, int middle, int right) {
        long count = 0;
        int index = left;
        int leftIndex = left;
        int rightIndex = middle + 1;

        while(leftIndex <= middle || rightIndex <= right) {
            if(leftIndex > middle) {
                arr[index] = aux[rightIndex];
                rightIndex++;
            } else if(rightIndex > right) {
                arr[index] = aux[leftIndex];
                leftIndex++;
            } else if(aux[leftIndex] <= aux[rightIndex]) {
                arr[index] = aux[leftIndex];
                leftIndex++;
            } else {
                arr[index] = aux[rightIndex];
                rightIndex++;
                count += middle + 1 - leftIndex;
            }
            index++;
        }
        return count;
    }
}

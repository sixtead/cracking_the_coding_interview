package challenges.algorithms.binarysearch;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    static void solve() {
        int t;
        int n, m;

        Scanner in = new Scanner(System.in);
        t = in.nextInt();
        for(int test = 0; test < t; test++) {

            m = in.nextInt();
            n = in.nextInt();
            IceCream[] arr = new IceCream[n];

            for (int i = 0; i < n; i++)
                arr[i] = new IceCream(i + 1, in.nextInt());

            Arrays.sort(arr);
            for(int i = 0; i < n - 1 ; i++) {
                int search = m - arr[i].price;
                if(search >= arr[i].price) {
                    int index = binarySearch( i + 1, n - 1, arr, search);
                    if( index != -1 ) {
                        System.out.println( Math.min(arr[i].id, index) + " " + Math.max(arr[i].id, index));
                        break;
                    }
                }
            }
        }
        in.close();
    }

    static int binarySearch(int first, int last, IceCream[] arr, int search) {
        if(first > last) return -1;
        int mid = (first + last) / 2;
        if(search < arr[mid].price) {
            return binarySearch(first, mid - 1, arr, search);
        } else if(search > arr[mid].price) {
            return binarySearch(mid + 1, last, arr, search);
        }
        return arr[mid].id;
    }
}

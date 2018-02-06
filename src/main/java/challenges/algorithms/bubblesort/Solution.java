package challenges.algorithms.bubblesort;

import java.util.Scanner;

public class Solution {

    static void solve() {
        int totalSwaps = 0;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = sc.nextInt();
        }
        sc.close();

        for (int i = 0; i < n; i++) {
            int swaps = 0;

            for (int j = 0; j < n - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int tmp = a[j + 1];
                    a[j + 1] = a[j];
                    a[j] = tmp;
                    swaps++;
                    totalSwaps++;
                }
            }

            if (swaps == 0) {
                break;
            }
        }
        System.out.println("Array is sorted in " + totalSwaps + " swaps.");
        System.out.println("First Element: " + a[0]);
        System.out.println("Last Element: " + a[a.length - 1]);
    }
}

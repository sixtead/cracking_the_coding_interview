package challenges.datastructures.arrays;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Solution {

    public static void solve() {
        solve(System.in, System.out);
    }

    static void solve(InputStream input, PrintStream output) {
        Scanner sc = new Scanner(input);
        System.setOut(output);
        int n = sc.nextInt();
        int d = sc.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        sc.close();
        rotateLeftTimes(a, d);
        printArray(a);
    }

    private static void rotateLeftOnce(int[] a) {
        int tmp = a[0];

        System.arraycopy(a, 1, a, 0, a.length - 1);
        a[a.length-1] = tmp;
    }

    private static void rotateLeftTimes(int[] a, int d) {
        for(int i = 0; i < d; i++) {
            rotateLeftOnce(a);
        }
    }

    private static void printArray(int[] a) {
        for(int e: a) {
            System.out.print(e + " ");
        }
    }
}

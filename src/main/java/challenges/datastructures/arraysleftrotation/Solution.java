// A left rotation operation on an array of size `n` shifts each of the array's elements 1 unit to the left. For example,
// if 2 left rotations are performed on array [1, 2, 3, 4, 5], then the array would become [2, 3, 4, 5, 1].
//
// Given an array of `n` integers and a number, `d`, perform `d` left rotations on the array. Then print the updated
// array as a single line of space-separated integers.
//
//  *Input Format
//
// The first line contains two space-separated integers denoting the respective values of `n` (the number of integers)
// and `d` (the number of left rotations you must perform).
// The second line contains `n` space-separated integers describing the respective elements of the array's initial state.
//
//  *Constraints
//
// 1 <= n <= 10^5
// 1 <= d <= n
// 1 <= a_i <= 10^6
//
//  *Output Format
//
// Print a single line of `n` space-separated integers denoting the final state of the array after performing `d` left
// rotations.
//
//  *Sample Input
//
// 5 4
// 1 2 3 4 5
//
//  *Sample Output
//
// 5 1 2 3 4
//
//  *Explanation
//
// When we perform `d=4` left rotations, the array undergoes the following sequence of changes:
//  [1, 2, 3, 4 ,5] -> [2, 3, 4, 5, 1] -> [3, 4, 5, 1, 2] -> [4, 5, 1, 2, 3] -> [5, 1, 2, 3, 4]
// Thus, we print the array's final state as a single line of space-separated values, which is `5 1 2 3 4`.

package challenges.datastructures.arraysleftrotation;

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

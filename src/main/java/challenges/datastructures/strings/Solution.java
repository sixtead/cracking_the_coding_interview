package challenges.datastructures.strings;

import java.util.Scanner;

public class Solution {

    static void solve() {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();
        System.out.println(numberNeeded(a, b));
        sc.close();
    }

    static int numberNeeded(String a, String b) {
        int count = 0;
        char[] charArrayA = a.toCharArray();
        char[] charArrayB = b.toCharArray();
        for (char charAtCharArrayA : charArrayA) {
            for (int j = 0; j < charArrayB.length; j++) {
                if (charAtCharArrayA == charArrayB[j]) {
                    count++;
                    charArrayB[j] = '_';
                    break;
                }
            }
        }
        return charArrayA.length + charArrayB.length - count * 2;
    }
}

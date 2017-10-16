package challenges.datastructures.stacks;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.Stack;

public class Solution {
    public static void solve() {
        solve(System.in, System.out);
    }

    static void solve(InputStream input, PrintStream output) {
        Scanner sc = new Scanner(input);
        System.setOut(output);
        int n = sc.nextInt();

        for(int i = 0; i < n; i++) {
            String expression = sc.next();
            System.out.println( (isBalanced(expression)) ? "YES" : "NO" );
        }
        sc.close();
    }

    static boolean isBalanced(String str) {
        if ((str.length() % 2) != 0) {
            return false;
        } else {
            Stack<Character> stc = new Stack<>();
            for (char ch : str.toCharArray())
                switch (ch) {
                    case '{': stc.push('}');
                              break;
                    case '(': stc.push(')');
                              break;
                    case '[': stc.push(']');
                              break;
                    default :
                        if (stc.empty() || ch != stc.pop())
                            return false;
                }
            return stc.empty();
        }
    }
}

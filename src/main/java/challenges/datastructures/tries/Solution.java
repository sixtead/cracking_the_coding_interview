package challenges.datastructures.tries;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Solution {

    public static void solve() {
        solve(System.in, System.out);
    }

    static void solve(InputStream input, PrintStream output) {
        Node trie = new Node();
        String[] inputPattern;
        Scanner sc = new Scanner(input);
        System.setOut(output);
        int n = sc.nextInt();
        sc.nextLine();

        for(int i = 0; i < n; i++) {
            inputPattern = sc.nextLine().split(" ");
            if(inputPattern[0].equals("add")) trie.addWord(inputPattern[1]);
            if(inputPattern[0].equals("find")) System.out.println(trie.countWords(inputPattern[1]));
        }
    }
}

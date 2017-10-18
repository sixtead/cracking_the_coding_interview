package challenges.datastructures.hashtables;

import java.util.Scanner;

public class Solution {

    static void solve() {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        HashTable ht = new HashTable(m);
        String result = "Yes";

        for(int i = 0; i < m; i++){
            String key = sc.next();
            if(ht.contains(key)) {
                int value = ht.get(key);
                ht.put(key, value + 1);
            } else {
                ht.put(key, 1);
            }
        }

        for(int i = 0; i < n; i++){
            String key = sc.next();
            if(!ht.contains(key) || ht.get(key) < 1) {
                result = "No";
                break;
            } else {
                int value = ht.get(key);
                ht.put(key, value - 1);
            }
        }

        sc.close();

        System.out.println(result);
    }
}

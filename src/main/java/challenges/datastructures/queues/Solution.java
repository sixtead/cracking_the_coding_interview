package challenges.datastructures.queues;

import java.util.Scanner;

public class Solution {

    static void solve() {
        MyQueue<Integer> queue = new MyQueue<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int operation = sc.nextInt();
            if (operation == 1) { // enqueue
                queue.enqueue(sc.nextInt());
            } else if (operation == 2) { // dequeue
                queue.dequeue();
            } else if (operation == 3) { // print/peek
                System.out.println(queue.peek());
            }
        }
        sc.close();
    }
}

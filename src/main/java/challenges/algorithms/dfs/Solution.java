package challenges.algorithms.dfs;

import java.util.Scanner;

public class Solution {

    static void solve() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int grid[][] = new int[n][m];
        for(int grid_i=0; grid_i < n; grid_i++){
            for(int grid_j=0; grid_j < m; grid_j++){
                grid[grid_i][grid_j] = in.nextInt();
            }
        }
        in.close();
        System.out.println(getBiggestRegion(grid));
    }

    static int getBiggestRegion(int[][] arr) {
        return 0;
    }
}

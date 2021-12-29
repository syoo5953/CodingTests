package Programmers;

import java.util.*;

public class GPS {
    public static void main(String[] args) {
        Solution38 solution38 = new Solution38();
        int n = 7;
        int m = 10;
        int[][] edge_list = {{1,2}, {1,3}, {2,3}, {2,4}, {3,4}, {3,5}, {4,6}, {5,6}, {5,7}, {6,7}};
        int k = 6;
        int[] gps_log = {1,2,3,3,6,7};
        solution38.solution(n,m,edge_list,k,gps_log);
    }
}

class Solution38 {

        public int solution ( int n, int m, int[][] edge_list, int k, int[] gps_log){
            ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
            // node는 1부터 시작. 0은 dummy
            for (int i = 0; i <= n; i++) {
                adjList.add(new ArrayList<>());
            }

            for (int[] node : edge_list) {
                adjList.get(node[0]).add(node[1]);
                adjList.get(node[1]).add(node[0]);
            }

            // node 및 시간 모두 1부터 시작
            int[][] dp = new int[k + 1][n + 1];
            for (int j = 0; j < k + 1; j++) {
                for (int i = 0; i < n + 1; i++) {
                    dp[j][i] = 300;
                }
            }

            dp[1][gps_log[0]] = 0;
            for (int t = 1; t <= k - 1; t++) {
                for (int i = 1; i <= n; i++) {
                    if (dp[t][i] != Integer.MAX_VALUE) {
                        for (int neigh : adjList.get(i)) {
                            if (neigh != gps_log[t]) {
                                dp[t + 1][neigh] = Math.min(dp[t + 1][neigh], dp[t][i] + 1);
                            } else {
                                dp[t + 1][neigh] = Math.min(dp[t + 1][neigh], dp[t][i]);
                            }
                        }
                    }
                }
            }

        for ( int j=0; j<k+1; j++ ) {
            for ( int i=0; i<n+1; i++ ) {
                System.out.print(dp[j][i] + " ");
            }
            System.out.println();
        }


            return (dp[k][gps_log[k - 1]] == Integer.MAX_VALUE) ? -1 : dp[k][gps_log[k - 1]];
        }
    }

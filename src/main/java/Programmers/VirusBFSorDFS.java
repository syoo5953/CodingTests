package Programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class VirusBFSorDFS {
    public static int[][] arr;
    public static boolean[] visited;
    public static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String firstLine = bf.readLine();
        String secondLine = bf.readLine();

        int nodeCount = Integer.parseInt(firstLine);
        int lineCount = Integer.parseInt(secondLine);
        int startNode = 1;

        arr = new int[nodeCount+1][nodeCount+1];

        for(int i=0; i < lineCount; i++) {
            String[] nums = bf.readLine().split(" ");
            int a = Integer.parseInt(nums[0]);
            int b = Integer.parseInt(nums[1]);
            arr[a][b] = 1;
            arr[b][a] = 1;
        }

        visited = new boolean[nodeCount+1];
        dfs(startNode);
        System.out.println(count);
    }
    public static void dfs(int start) {
        visited[start] = true;

        if(start == arr.length) {
            return;
        }

        for(int a=1;a<arr.length;a++) {
            if(arr[start][a] == 1 && !visited[a]) {
                count++;
                dfs(a);
            }
        }
    }
}
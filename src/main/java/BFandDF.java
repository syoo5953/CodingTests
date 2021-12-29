import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BFandDF {
    public static int[][] arr;
    public static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] firstLine = bf.readLine().split(" ");

        int nodeCount = Integer.parseInt(firstLine[0]);
        int lineCount = Integer.parseInt(firstLine[1]);
        int startNode = Integer.parseInt(firstLine[2]);

        arr = new int[nodeCount+1][nodeCount+1];

        for(int i=0; i < lineCount; i++) {
            String[] nums = bf.readLine().split(" ");
            int a = Integer.parseInt(nums[0]);
            int b = Integer.parseInt(nums[1]);
            arr[a][b] = 1;
            arr[b][a] = 1;
        }

        for (int[] ints : arr) { //행렬보기
            for (int j = 0; j < arr.length; j++) {
                System.out.print(ints[j]);
            }
            System.out.println();
        }

        // 깊이우선탐색
        visited = new boolean[nodeCount+1];
        dfs(startNode);

        System.out.println();

        // 너비우선탐색
        visited = new boolean[nodeCount+1];
        bfs(startNode);


    }
    public static void dfs(int curr) {
        visited[curr] = true;
        System.out.print(curr+ " ");

        if(curr == arr.length) {
            return;
        }

        for(int i=1;i<arr.length;i++) {
            if(arr[curr][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }

    }
    public static void bfs(int start) {
        Queue<Integer> que = new LinkedList<>();

        que.add(start);
        visited[start] = true;
        System.out.print(start+ " ");

        while(!que.isEmpty()) {

            int curr = que.poll();
            for(int i=1; i<arr.length;i++) {
                if(arr[curr][i] == 1 && !visited[i]) {
                    que.add(i);
                    visited[i] = true;
                    System.out.print(i+ " ");
                }
            }
        }
    }
}
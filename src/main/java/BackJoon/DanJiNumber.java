package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class DanJiNumber {
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int[][] array = new int[n][n];
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for(int i = 0; i < n; i++) {
           String str = bf.readLine();
           String[] strArray = str.split("");
           for(int j = 0; j < n; j++) {
               array[i][j] = Integer.parseInt(strArray[j]);
           }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(array[i][j] != -1) {
                    if(array[i][j] > 0)
                    {
                        floodFill(array, array[i][j], i, j);
                        priorityQueue.add(count);
                    }
                }
                count = 0;
            }
        }
        System.out.println(priorityQueue.size());
        while(!priorityQueue.isEmpty()) {
            System.out.println(priorityQueue.poll());
        }
    }

    public static void floodFill(int[][] array, int c, int i, int j) {
        if(array[i][j] != c) {
            return;
        }
        array[i][j] = -1;
        count++;
        if(i - 1 >= 0) {
            floodFill(array, c, i - 1, j);
        }
        if(j - 1 >= 0) {
            floodFill(array, c, i, j-1);
        }
        if(i + 1 < array.length) {
            floodFill(array, c, i+1, j);
        }
        if(j + 1 < array[i].length) {
            floodFill(array, c, i, j+1);
        }
    }
}

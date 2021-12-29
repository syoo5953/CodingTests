import java.util.Collections;
import java.util.PriorityQueue;

public class FloodFill {
    public static void main(String[] args) {
        Solution44 solution44 = new Solution44();
        int m = 6;
        int n = 4;
        int[][] picture = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};
        int[] answer = solution44.solution(m, n, picture);
        for (int i : answer) {
            System.out.print(i + " ");
        }
    }
}

class Solution44 {
    int count = 0;

    public int[] solution(int m, int n, int[][] picture) {
        int[][] cpic = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                cpic[i][j] = picture[i][j];
            }
        }
        int numberOfArea;
        int maxSizeOfOneArea;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (cpic[i][j] != -1) {
                    if (cpic[i][j] > 0) {
                        fill(cpic, cpic[i][j], i, j);
                        priorityQueue.add(count);
                        System.out.println(priorityQueue);
                    }
                }
                count = 0;
            }
        }
        numberOfArea = priorityQueue.size();
        maxSizeOfOneArea = priorityQueue.poll();
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

    private void fill(int[][] picture, int c, int i, int j) {
        if (picture[i][j] != c) {
            return;
        }
        picture[i][j] = -1;
        count++;
        if (i - 1 >= 0) {
            fill(picture, c, i - 1, j);
        }
        if (j - 1 >= 0) {
            fill(picture, c, i, j - 1);
        }
        if (i + 1 < picture.length) {
            fill(picture, c, i + 1, j);
        }
        if (j + 1 < picture[i].length) {
            fill(picture, c, i, j + 1);
        }
    }
}
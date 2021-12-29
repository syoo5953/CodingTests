package CJCodingTest;

import java.io.IOException;

public class CharacterCount {
    public static void main(String[] args) throws IOException {
        Solution solution = new Solution();
        System.out.println(solution.solution(6, 5, 4));
    }
}

class Solution {
    public long solution(int n, int r, int c) {
        int[][] array = new int[n][n];
        int count = 1;

        int x = 0, y = -1;
        boolean direction = true;

        int total = n * n;

        while (count <= total) {
            if (x == n - 1 && count <= total) {
                array[++y][x] = count++;
                direction = false;
            }
            if (y == n - 1 && count <= total) {
                array[y][++x] = count++;
                direction = true;
            }
            if (y == 0 && count <= total) {
                array[y][++x] = count++;
                direction = false;
            }
            if (x == 0 && count <= total) {
                array[++y][x] = count++;
                direction = true;
            }
            if (direction && x != n - 1 && y != 0 && count <= total) {
                array[--y][++x] = count++;
            }
            if (!direction && y != n - 1 && x != 0 && count <= total) {
                array[++y][--x] = count++;
            }
        }
        return array[r - 1][c - 1];
    }
}

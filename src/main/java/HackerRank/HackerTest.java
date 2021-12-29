package HackerRank;

import java.util.Vector;

public class HackerTest {

    public static void main(String[] args) {
        System.out.println(minMoves(7, 6, 6, 1, 0));
    }

    static class Position {
        int x, y;
        int dis;

        public Position(int x, int y, int dis) {
            this.x = x;
            this.y = y;
            this.dis = dis;
        }
    }

    public static int minMoves(int n, int startRow, int startCol, int endRow, int endCol) {
        int dx[] = {-2, -1, 1, 2, -2, -1, 1, 2};
        int dy[] = {-1, -2, -2, -1, 1, 2, 2, 1};
        int move = Integer.MAX_VALUE;
        Vector<Position> q = new Vector<>();
        q.add(new Position(startRow, startCol, 0));
        Position pos;
        int x, y;
        boolean isValidPath[][] = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                isValidPath[i][j] = false;
            }
        }

        isValidPath[startRow][startCol] = true;

        while (!q.isEmpty()) {
            pos = q.firstElement();
            q.remove(0);
            if (pos.x == endRow && pos.y == endCol) {
                if (move > pos.dis)
                    move = pos.dis;
            }
            for (int i = 0; i < 8; i++) {
                x = pos.x + dx[i];
                y = pos.y + dy[i];

                boolean isBool = false;
                if (x >= 0 && x < n && y >= 0 && y < n) {
                    isBool = true;
                }
                if (isBool && !isValidPath[x][y]) {
                    isValidPath[x][y] = true;
                    q.add(new Position(x, y, pos.dis + 1));
                }
            }
        }
        if (move == Integer.MAX_VALUE) {
            return -1;
        } else {
            return move;
        }
    }
}


package Programmers;

public class OneandZeroBoard {
    public static void main(String[] args){
        Solution43 solution43 = new Solution43();
        int[][] board = {{0,1,1,1},{1,1,1,1}, {1,1,1,1},{0,0,1,0}};
        solution43.solution(board);
    }
}

class Solution43
{
    public int solution(int [][]board)
    {
        int answer = 0, row = board.length, col = board[0].length;
        int[][] map = new int[row+1][col+1];
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                map[i+1][j+1] = board[i][j];
                System.out.print(map[i+1][j+1] + " ");
            }
            System.out.println();
        }
        System.out.println();
        for(int i =1 ; i <= row; i++) {
            for(int j = 1; j <= col; j++) {
                if(map[i][j] != 0) {
                    map[i][j] = Math.min(Math.min(map[i-1][j], map[i][j-1]), map[i-1][j-1]) + 1;
                    answer = Math.max(answer, map[i][j]);
                }
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        return answer * answer;
    }
}
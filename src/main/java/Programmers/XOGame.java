package Programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class XOGame {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        List<String> list = new ArrayList<>();
        while(!(line = br.readLine()).equals("end")) {
            list.add(line);
        }
        Solution40 solution40 = new Solution40();
        solution40.solution(list);
    }
}

class Solution40 {
    public void solution(List<String> list) {
        for(String str : list) {

            char[] charArray = str.toCharArray();

            if(str.length() != 9) {
                System.out.println("invalid");
            } else if(charArray[0] != 'X') {
                System.out.println("invalid");
            } else {
                System.out.println(IsGameEnd(charArray, str));
            }
        }
    }

    private String IsGameEnd(char[] charArray, String str) {
        char[][] game_board = new char[3][3];
        int cnt = 0;
        boolean XBingo = false, OBingo = false, fullValid = false;
        int XCnt = 0;
        int OCnt = 0;
        for(int i = 0; i < game_board.length; i++) {
            for(int j = 0; j < game_board[0].length; j++) {
                game_board[i][j] = charArray[cnt++];
            }
        }
        for(int i = 0; i < game_board.length; i++) {
            for(int j = 0; j < game_board[0].length; j++) {
                if(game_board[i][j] != 'O' && game_board[i][j] != 'X' && game_board[i][j] != '.') {
                    return "invalid";
                }
                if(game_board[i][j] == 'X') {
                    XCnt++;
                } else if(game_board[i][j] == 'O') {
                    OCnt++;
                }
                if((game_board[i][0] == 'X' && game_board[i][1] == 'X' && game_board[i][2] == 'X') ||
                        (game_board[0][i] == 'X' && game_board[1][i] == 'X' && game_board[2][i] == 'X') ||
                        (game_board[0][0] == 'X' && game_board[1][1] == 'X' && game_board[2][2] == 'X') ||
                        (game_board[0][2] == 'X' && game_board[1][1] == 'X' && game_board[2][0] == 'X')) {
                    XBingo = true;
                } else if((game_board[i][0] == 'O' && game_board[i][1] == 'O' && game_board[i][2] == 'O') ||
                        (game_board[0][i] == 'O' && game_board[1][i] == 'O' && game_board[2][i] == 'O') ||
                        (game_board[0][2] == 'O' && game_board[1][1] == 'O' && game_board[2][0] == 'O') ||
                        (game_board[0][2] == 'O' && game_board[1][1] == 'O' && game_board[2][0] == 'O')) {
                    OBingo = true;
                } else if(!str.contains(".")) {
                    fullValid = true;
                }
            }
        }
        System.out.print(XCnt + " " + OCnt + " " + XBingo + " " + OBingo + " ");
        if(XBingo && XCnt-1 == OCnt) {
            return "valid";
        } else if(OBingo && XCnt == OCnt) {
            return "valid";
        } else if(fullValid) {
            return "valid";
        }
        return "invalid";
    }
}
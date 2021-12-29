package Programmers;

import java.util.Arrays;

public class LottoNums {
    public static void main(String[] args) {
        Solution19 solution19 = new Solution19();
        int[] lottos = {0, 0, 0, 0, 0, 0};
        int[] win_nums = {38, 19, 20, 40, 15, 25};
        int[] answer = solution19.solution(lottos, win_nums);
        for(int i : answer) {
            System.out.println(i);
        }
    }
}

class Solution19 {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int first_count = 0;
        int second_count = 0;

        for(int i = 0; i < win_nums.length; i++) {
            for (int j = 0; j < lottos.length; j++) {
                if (win_nums[i] == lottos[j]) {
                    first_count++;
                    second_count++;
                }
            }
            if(lottos[i] == 0) {
                second_count++;
            }
        }
        first_count = rank(first_count);
        second_count = rank(second_count);
        answer[0] = second_count;
        answer[1] = first_count;

        return answer;
    }

    private static int rank(int num) {
        int rank = 0;

        switch (num) {
            case 0:
                rank = 6;
                break;
            case 1:
                rank = 6;
                break;
            case 2:
                rank = 5;
                break;
            case 3:
                rank = 4;
                break;
            case 4:
                rank = 3;
                break;
            case 5:
                rank = 2;
                break;
            case 6:
                rank = 1;
                break;
            default :

        }
        return rank;
    }
}
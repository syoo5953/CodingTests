package Programmers;

import java.util.Arrays;
import java.util.Collections;

public class KthNumber {
    public static void main(String[] args) {
        int[] array = {1, 5};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        Solution34 solution34 = new Solution34();
        int[] answer = solution34.solution(array, commands);
        for(int num : answer)
        System.out.println(num);
    }

}

class Solution34 {
    public int[] solution(int[] array, int[][] commands) {
        int[] ans = new int[commands.length];
        int i = 0;
        for(int[] coms : commands) {
            int[] temp = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
            Arrays.sort(temp);
            ans[i] = temp[commands[i][2]-1];
            i++;
        }

        return ans;
    }
}
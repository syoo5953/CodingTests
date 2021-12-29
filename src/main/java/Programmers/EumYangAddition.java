package Programmers;

public class EumYangAddition {
    public static void main(String[] args) {
        int[] ab = {4, 7, 12};
        boolean[] bool = {true, false, true};
        Solution20 solution20 = new Solution20();
        System.out.println(solution20.solution(ab, bool));
    }
}

class Solution20 {
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;

        for(int i = 0; i < absolutes.length; i++) {
            if(signs[i]) {
                absolutes[i] *= 1;
            } else {
                absolutes[i] *= -1;
            }
        }

        for(int i : absolutes) {
            answer += i;
        }
        return answer;
    }
}
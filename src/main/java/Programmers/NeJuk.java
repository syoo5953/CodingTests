package Programmers;

public class NeJuk {
    public static void main(String[] args) {
        Solution32 solution32 = new Solution32();
        int[] a = {1, 2, 3, 4};
        int[] b = {-3, -1, 0, 2};
        System.out.println(solution32.solution(a, b));
    }
}

class Solution32 {
    public int solution(int[] a, int[] b) {
        int answer = 0;

        for(int i = 0; i < a.length; i++) {
            answer += a[i] * b[i];
        }
        return answer;
    }
}
package Programmers;

public class LongRun {
    public static void main(String[] args) {
        int n = 5;
        Solution30 solution30 = new Solution30();
        System.out.println(solution30.solution(n));
    }
}

class Solution30 {
    public long solution(int n) {
        long answer = 0;
        if(n == 1) {
            return 1;
        }
        long[] arr = new long[n+1];
        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 3;
        for(int i = 4; i <= n; i++) {
            arr[i] = (arr[i-3] + arr[i-1] + arr[i-2]) % 1234567;
        }
        answer = arr[n];
        return answer;
    }
}
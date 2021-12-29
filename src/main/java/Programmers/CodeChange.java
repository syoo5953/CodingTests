package Programmers;

import java.util.Arrays;

class CodeChange {
    public int change(int n, int[] coins) {
        int[] answer = new int[100001];
        answer[0] = 1;
        for(int i : coins) {
            for(int j = i; j <= n; j++) {
                answer[j] += answer[j-i];
            }
        }
        return answer[n] % 1000000007;
    }


    // 아래는 테스트로 출력해 보기 위한 코드입니다.
    public static void main(String[] args) {
        CodeChange c = new CodeChange();
        int[] coins = { 1, 2, 5 };
        System.out.println(c.change(5, coins));
    }
}

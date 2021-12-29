package Programmers;

public class NextBigNumber {
    public static void main(String[] args) {
        Solution50 solution = new Solution50();
        solution.solution(110);
    }
}

class Solution50 {
    public int solution(int n) {
        int answer;
        int bitCnt = Integer.bitCount(n);
        int compare = n + 1;
        while(true) {
            if(Integer.bitCount(compare) == bitCnt) {
                break;
            }
            compare+=1;
        }
        answer = compare;
        return answer;
    }
}
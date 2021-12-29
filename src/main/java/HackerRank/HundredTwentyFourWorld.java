package HackerRank;

public class HundredTwentyFourWorld {
    public static void main(String[] args) {
        Solution23 solution23 = new Solution23();
        System.out.println(solution23.solution(11)); // 12 = 44
    }
}

class Solution23 {
    public String solution(int n) {
        String[] num = {"4", "1", "2"};
        String answer = "";

        while (n > 0) {
            System.out.println("n = " + n);
            System.out.println("n%3 = " + n%3);
            answer = num[n % 3] + answer;
            n = (n-1) / 3;
        }
        return answer;
    }
}
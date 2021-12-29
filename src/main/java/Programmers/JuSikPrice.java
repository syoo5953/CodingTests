package Programmers;

public class JuSikPrice {
    public static void main(String[] args) {
        Solution46 solution46 = new Solution46();
        solution46.solution(new int[]{1,2,3,2,3});
    }
}

class Solution46 {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        for(int i = 0; i < prices.length; i++) {
            int count = 0;
            for(int j = i+1; j < prices.length; j++) {
                System.out.print(prices[i] + " ");
                if(prices[i] <= prices[j]) {
                    count++;
                } else if(prices[i] > prices[j]) {
                    count++;
                    break;
                }
            }
            answer[i] = count;
            System.out.println();
        }
        return answer;
    }
}
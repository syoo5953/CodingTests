package Programmers;

import java.util.PriorityQueue;

public class Schoville {
    public static void main(String[] args) {
        Solution24 solution24 = new Solution24();
        int[] schoville = {1, 2, 3, 9, 10, 12};
        int k = 7;
        System.out.println(solution24.solution(schoville, k));
    }

}

class Solution24 {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> q = new PriorityQueue<>();

        for (int i = 0; i < scoville.length; i++)
            q.add(scoville[i]);

        int count = 0;
        while (q.size() > 1 && q.peek() < K) {
            int weakHot = q.poll();
            int secondWeakHot = q.poll();

            int mixHot = weakHot + (secondWeakHot * 2);
            q.add(mixHot);
            count++;
        }

        if (q.size() <= 1 && q.peek() < K)
            count = -1;

        return count;
    }
}
